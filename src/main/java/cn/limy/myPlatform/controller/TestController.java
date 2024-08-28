package cn.limy.myPlatform.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/start")
@OpenAPIDefinition(info = @Info(title = "TestControllerOpenApi", version = "v1"))
@Tag(name = "TestControllerTag")
public class TestController {

    private RestTemplate rest;

    @Resource(name = "mytaskExecutor")
    private  ThreadPoolTaskExecutor executor;

    public TestController() {
        HttpComponentsClientHttpRequestFactory componentsFactory = new HttpComponentsClientHttpRequestFactory();
        this.rest = new RestTemplate();
        this.rest.setRequestFactory(componentsFactory);
    }

    @Operation(summary = "http2Test1-operation")
    @GetMapping(value = "/http2Test1")
    public String healthCheck() {
        String forObject = rest.getForObject("http://localhost:8080/test/demo1", String.class);
        System.out.println(forObject);
        return forObject;
    }

    @GetMapping(value = "/testThread")
    public void testThread() {

        ArrayList<CompletableFuture<Void>> completableFutures = new ArrayList<>();
        for (int i = 0; i < 400; i++) {
            Map<String, String> params = new HashMap<String, String>();
            params.put("s", "" + i);
            System.out.println(i +"===启动" + LocalDateTime.now());
            CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> rest.getForObject("http://localhost:8090/test2/testController/threadTest?s={s}", String.class,params),executor);
            CompletableFuture<String> completableFuture2 = completableFuture1.thenApplyAsync(cc -> cc);
            CompletableFuture<Void> voidCompletableFuture = completableFuture2.thenAcceptAsync(ss -> System.out.println(ss + "===回调" + LocalDateTime.now()));
            completableFutures.add(voidCompletableFuture);
        }

        completableFutures.forEach(aa->aa.join());
    }

    @Operation(summary = "testNginx-operation")
    @GetMapping(value = "/testNginx")
    public String testNginx() {
        return "come on";
    }

    @GetMapping(value = "/testStream")
    public void testStream(HttpServletResponse response) {
        // 下载本地文件
        String fileName = "test.txt"; // 文件的默认保存名
        // 读到流中
        InputStream inStream = null;// 文件的存放路径
        try {
            inStream = new FileInputStream("e:/test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 设置输出的格式
        response.reset();
        response.setContentType("text/plain");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        // 循环取出流中的数据
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("abc".substring(0,1));
    }
}

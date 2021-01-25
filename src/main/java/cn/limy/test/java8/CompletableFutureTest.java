package cn.limy.test.java8;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest {

    private volatile  long id;
    @Test
    public void test1(){
        System.out.println("本机cpu核心数" + Runtime.getRuntime().availableProcessors());
        List<Integer> integers = Arrays.asList(3000, 4000, 5000, 6000, 6500, 7000, 7500,8000,8500);
        long start = System.currentTimeMillis();
        integers.parallelStream().forEach(ss->{
            System.out.println("==="+ Thread.currentThread().getName()+"==start" +(System.currentTimeMillis()-start));
            try {
                Thread.sleep(ss);
                System.out.println("==="+ Thread.currentThread().getName()+"==end"+(System.currentTimeMillis()-start));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }


    @Test
    public void test2() throws Exception {
        ExecutorService pool = Executors.newSingleThreadExecutor(
                r -> new Thread(r, "dead-pool"));
        System.out.println("主线程id" + Thread.currentThread().getId());
        System.out.println("主线程id" + Thread.currentThread());
        CompletableFuture<String> supplyAsyncCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync线程id" + Thread.currentThread().getId());
            System.out.println("supplyAsync线程id" + Thread.currentThread());
            id = Thread.currentThread().getId();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "111a";
        },pool);

        System.out.println("supplyAsync后" + id);
//        Thread s = findThread(id);
//        s.wait(3000);

//        pool.execute(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });

        CompletableFuture<String>  thenApplyAsyncCompletableFuture1 = supplyAsyncCompletableFuture.thenApplyAsync(cc -> {
            System.out.println("thenApplyAsync1线程id" + Thread.currentThread().getId());
            System.out.println("thenApplyAsync1线程id" + Thread.currentThread());
            ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
            ThreadInfo info = tmx.getThreadInfo(id);
            System.out.println("supplyAsync线程线程状态" + info.getThreadState());
            System.out.println("supplyAsync线程线程名称" + info.getThreadName());
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("supplyAsync线程线程状态" + info.getThreadState());
            return cc + "b";
        });


        CompletableFuture<String> thenApplyAsync2CompletableFuture = thenApplyAsyncCompletableFuture1.thenApplyAsync(cc -> {
            System.out.println("thenApplyAsync1线程id" + Thread.currentThread().getId());
            System.out.println("thenApplyAsync1线程id" + Thread.currentThread());
            return cc + "c";
        });

        System.out.println(thenApplyAsync2CompletableFuture.get());
    }

    @Test
    public void test3() throws Exception {
//       https://blog.csdn.net/weixin_39445733/article/details/99302634

        //thenApply和thenApplyAsync的区别
        System.out.println("-------------");
        CompletableFuture<String> supplyAsyncWithSleep = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "supplyAsyncWithSleep Thread Id : " + Thread.currentThread();
        });
        CompletableFuture<String> thenApply = supplyAsyncWithSleep
                .thenApply(name -> name + "------thenApply Thread Id : " + Thread.currentThread());
        CompletableFuture<String> thenApplyAsync = supplyAsyncWithSleep
                .thenApplyAsync(name -> name + "------thenApplyAsync Thread Id : " + Thread.currentThread());
        System.out.println("Main Thread Id: "+ Thread.currentThread());
        System.out.println(thenApply.get());
        System.out.println(thenApplyAsync.get());
        System.out.println("-------------No Sleep");
        CompletableFuture<String> supplyAsyncNoSleep = CompletableFuture.supplyAsync(()->{
            return "supplyAsyncNoSleep Thread Id : " + Thread.currentThread();
        });
        CompletableFuture<String> thenApplyNoSleep = supplyAsyncNoSleep
                .thenApply(name -> name + "------thenApply Thread Id : " + Thread.currentThread());
        CompletableFuture<String> thenApplyAsyncNoSleep = supplyAsyncNoSleep
                .thenApplyAsync(name -> name + "------thenApplyAsync Thread Id : " + Thread.currentThread());
        System.out.println("Main Thread Id: "+ Thread.currentThread());
        System.out.println(thenApplyNoSleep.get());
        System.out.println(thenApplyAsyncNoSleep.get());

    }


    /**
     * 通过线程组获得线程
     *
     * @param threadId
     * @return
     */
    public static Thread findThread(long threadId) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        while(group != null) {
            Thread[] threads = new Thread[(int)(group.activeCount() * 1.2)];
            int count = group.enumerate(threads, true);
            for(int i = 0; i < count; i++) {
                if(threadId == threads[i].getId()) {
                    return threads[i];
                }
            }
            group = group.getParent();
        }
        return null;
    }

}

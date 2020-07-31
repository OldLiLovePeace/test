package cn.limy.myPlatform.controller;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class testController {

    private RestTemplate rest;

    public testController() {
        HttpComponentsClientHttpRequestFactory componentsFactory = new HttpComponentsClientHttpRequestFactory();
        this.rest = new RestTemplate();
        this.rest.setRequestFactory(componentsFactory);
    }

    @GetMapping(value = "/http2Test1")
    public String healthCheck() {
        String forObject = rest.getForObject("http://localhost:8080/test/demo1", String.class);
        System.out.println(forObject);
        return forObject;
    }
}

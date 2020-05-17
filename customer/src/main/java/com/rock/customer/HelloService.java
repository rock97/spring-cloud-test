package com.rock.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private HelloFeign helloFeign;
    @Autowired
    private Hello2Feign hello2Feign;
    public String hiService(String name) {
        String home = helloFeign.home(name);
        return home;

    }
    public String hello(String name){
        String hello = hello2Feign.hello(name);
        return hello;
    }
}

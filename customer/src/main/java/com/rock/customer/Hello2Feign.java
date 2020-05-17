package com.rock.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE-PRODUCER2")
public interface Hello2Feign {
    @RequestMapping("/hello")
    String hello(@RequestParam String name);
}

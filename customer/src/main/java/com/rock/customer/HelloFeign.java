package com.rock.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "SERVICE-PRODUCER")
public interface HelloFeign {
    @RequestMapping("/hi")
    public String home(@RequestParam String name);
}

package com.springexample.springboot_web_demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(String name) {
        System.out.println("Hello" + name);
        return "Hello" + name + "~";
    }
}

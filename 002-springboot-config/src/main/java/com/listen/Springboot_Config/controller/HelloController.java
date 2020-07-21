package com.listen.Springboot_Config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 李松
 * 2020/7/19
 */
@RestController
public class HelloController {
    @Value("${person.last-name}")
    private String name;

    @RequestMapping("/hello")
    public String hello() {
        return name + "hello yaml!";
    }
}

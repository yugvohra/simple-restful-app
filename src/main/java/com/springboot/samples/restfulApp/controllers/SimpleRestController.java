package com.springboot.samples.restfulApp.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {
    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot";
    }

}

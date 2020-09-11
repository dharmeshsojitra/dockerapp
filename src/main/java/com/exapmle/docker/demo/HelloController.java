package com.exapmle.docker.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        return "Hi " + name + " !";
    }

    @RequestMapping("/world/{name}")
    String sayHelloWorld(@PathVariable String name) {
        return "Hello " + name + ", welcome to the world !";
    }
}
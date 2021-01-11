package com.exapmle.docker.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hi/{name}")
    String sayHelloWorld(@PathVariable String name) {
        return "Hi, " + name + " !!! !";
    }

    @RequestMapping("/docker/{name}")
    String sayHelloDocker(@PathVariable String name) {
        return "Hello " + name + ", welcome to the docker world !";
    }
    
    @RequestMapping("/openshift/{name}")
    String sayHelloOpenshift(@PathVariable String name) {
        return "Hello " + name + ", welcome to the Openshitf world !";
    }
}

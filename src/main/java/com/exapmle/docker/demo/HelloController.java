package com.exapmle.docker.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @RequestMapping("/hello/{name}")
    String sayHelloWorld(@PathVariable String name) {

        return "Hello, " + name + "!";
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

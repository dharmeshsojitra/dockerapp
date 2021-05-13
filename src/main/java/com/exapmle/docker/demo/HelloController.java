package com.exapmle.docker.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello/{name}")
    String sayHelloWorld(@PathVariable String name) {
        System.out.println("Serving hello request");
        return "Hello " + name + ", welcome to Demo! Hurray!!!";
    }

    //hello Docker method
    @RequestMapping("/docker/{name}")
    String sayHelloDocker(@PathVariable String name) {
        return "Hello " + name + ", welcome to the docker world!";
    }
    
    //hello Openshift method
    @RequestMapping("/openshift/{name}")
    String sayHelloOpenshift(@PathVariable String name) {
        return "Hello " + name + ", welcome to the Openshitf world!";
    }
}

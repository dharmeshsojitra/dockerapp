package com.exapmle.docker.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @RequestMapping("/hello/{name}")
    String sayHelloWorld(@PathVariable String name) {
        log.info("called sayHelloWorld with path variable:"+ name);
        return "Hello " + name + ", welcome to Demo! Hurray!!!";
    }

    //hello Docker method
    @RequestMapping("/docker/{name}")
    String sayHelloDocker(@PathVariable String name) {
        log.info("called sayHelloDocker with path variable:"+ name);
        return "Hello " + name + ", welcome to the docker world!";
    }
    
    //hello Openshift method
    @RequestMapping("/openshift/{name}")
    String sayHelloOpenshift(@PathVariable String name) {
        log.info("called sayHelloOpenshift with path variable:"+ name);
        return "Hello " + name + ", welcome to the Openshitf world!";
    }
}

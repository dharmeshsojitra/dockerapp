package com.exapmle.docker.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello/{name}")
    String sayHelloWorld(@PathVariable String name) {
        LOG.info("Original name:"+name);
        LOG.debug("Original name:"+name);
        LOG.error("Original name:"+name);
        LOG.trace("Original name:"+name);
        name = StringUtils.capitalize(name);
        LOG.info("Name after capitalise:"+name);
        LOG.debug("Name after capitalise:"+name);
        LOG.error("Name after capitalise:"+name);
        LOG.trace("Name after capitalise:"+name);
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

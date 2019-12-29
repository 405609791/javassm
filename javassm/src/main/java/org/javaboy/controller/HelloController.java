package org.javaboy.controller;

import org.javaboy.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
    @GetMapping("/hello1")
    public String hello1(){
        return helloService.sayHello();
    }

    @GetMapping("/getData")
    public List<String> getData(){
        List<String> list  = new ArrayList<String>();
        for (int i=0;i<10;i++){
            list.add("www.justdojava.com>>"+i);
        }
        return list;
    }
}

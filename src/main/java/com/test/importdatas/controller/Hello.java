package com.test.importdatas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld(){
        return "hello world";
    }
    @GetMapping("/login")
    public String login(){
        return "Hello";
    }
}

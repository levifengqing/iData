package com.test.importdatas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("hello")
public class Hello {

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld(){
        return "hello world";
    }
    @GetMapping("/login")
    @ResponseBody//不带这个，如果是jsp，就会跳转到hello.jsp页面
    public String login(){
        return "Hello";
    }
}

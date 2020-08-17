package com.test.importdatas.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @GetMapping("login")
    public String login(){
        return "login";
    }
    @PostMapping("login")
    public String welcome(HttpServletRequest request, HttpServletResponse response){
        redisTemplate.boundValueOps("cName").set("123");
        Cookie cookie = new Cookie("cName", "123");
        Object cName = redisTemplate.boundValueOps("cName").get();
        System.out.println(cName.toString());
        stringRedisTemplate.boundValueOps("cc").set("dd");
        String cc = stringRedisTemplate.boundValueOps("cc").get();
        System.out.println(cc);
        response.addCookie(cookie);
        return "welcome";
    }
}

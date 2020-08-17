package com.test.importdatas.controller;

import com.sun.deploy.net.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("cookie")
@RestController
public class CookieController {
    @GetMapping("set")
    public Map setCookie(HttpServletRequest request, HttpServletResponse response){
        HashMap<String, String> map = new HashMap<>();
        map.put("msg","addCookie");
        Cookie cookie = new Cookie("cName", "10086");
        cookie.setPath("/");
        response.addCookie(cookie);
        return map;
    }
    @GetMapping("get")
    public Map getCookie(HttpServletRequest request, HttpServletResponse response){
        HashMap<String, String> map = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if(ArrayUtils.isEmpty(cookies)){
            map.put("msg","noCookie");
            return map;
        }
        for(Cookie cookie: cookies){
            map.put(cookie.getName(),cookie.getValue());
        }
        return map;
    }
}

package com.test.importdatas.controller;

import com.test.importdatas.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("register")
public class RegisterController {
    @Autowired
    private UserInfoService userInfoService;
    @PostMapping("create")
    public String register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        boolean flag = userInfoService.create(userName,password);
        if(flag){
            return "login";
        }else {
            return "register_error";
        }
    }
    @GetMapping("login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registerLogin");
        return modelAndView;
    }
}

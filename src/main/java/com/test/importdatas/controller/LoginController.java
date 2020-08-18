package com.test.importdatas.controller;

import com.test.importdatas.dao.UserInfoDao;
import com.test.importdatas.pojo.UserInfo;
import com.test.importdatas.util.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserInfoDao userInfoDao;
    @GetMapping("login")
    public String login(){
        return "login";
    }
    @PostMapping("login")
    public String welcome(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String md5Password = Md5Utils.md5(password, "cmd");
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPassword(password);
        userInfo.setMd5Password(md5Password);
        Example<UserInfo> example = Example.of(userInfo);
        Optional<UserInfo> one = userInfoDao.findOne(example);
        if(one.isPresent()){
            stringRedisTemplate.boundValueOps("cName").set(md5Password);
            Cookie cookie = new Cookie("cName", md5Password);
            response.addCookie(cookie);
            return "welcome";
        }else {
            return "login";
        }
    }
}

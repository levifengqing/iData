package com.test.importdatas.controller;
 
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
/**
 * Created by yanshao on 2019-10-09.
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {
 
//    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
//    private final Logger logger = LoggerFactory.getLogger(this.getClass()); //采用this.getClass()，不能加static

    @PostMapping("select_user_info")
    public String selectUserInfo(@RequestParam("name") String name,@RequestParam("age") int age) {
        try {
//            logger.info("查询用户信息 name:{},age:{}", name, age); //自己实现的logger
            log.info("查询用户信息 name:{},age:{}", name, age); // @Slf4j实现的log
            if (age % 2 == 0) {
                throw new RuntimeException("年龄不正确");
            }
            return "select_user_info >>> " + name + age;
        } catch (Exception e) {
//            logger.error("查询用户信息异常 name:{} ", name, e); //自己实现的logger
            log.error("查询用户信息异常 name:{} ", name, e);// @Slf4j实现的log
        }
        return "select_user_info >>> error";
    }
 
}
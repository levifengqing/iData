package com.test.importdatas.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.info("pre do..");
        Cookie[] cookies = request.getCookies();
        String password = stringRedisTemplate.boundValueOps("cName").get();
        if(!ArrayUtils.isEmpty(cookies)){
            for(Cookie cookie:cookies){
                String value = cookie.getValue();
                if(StringUtils.isNotEmpty(password)&&StringUtils.isNotEmpty(value)&& "cName".equals(cookie.getName())&&value.equals(password)){
                    //从新设置过期时间
                    return true;//放行
                }
            }
        }
        response.sendRedirect(request.getContextPath()+"/login");
//        log.info("redi..");
        return false;//拦截
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.info("post do..");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        log.info("after do..");
    }
}

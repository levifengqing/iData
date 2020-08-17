package com.test.importdatas.config;

import com.test.importdatas.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login");//跳转到/login请求，不是直接跳到某个页面
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LoginInterceptor());
        interceptorRegistration.addPathPatterns("/**");
        interceptorRegistration.excludePathPatterns("/", //这个保证直接用域名加端口，可以直接跳转到登录页面，否则会被拦截
                                                    "/login",                //登录
                                                    "/**/*.html",            //html静态资源
                                                    "/**/*.js",              //js静态资源
                                                    "/**/*.css",             //css静态资源
                                                    "/**/*.woff",
                                                    "/**/*.ttf"
                                                    );
                                        }
}

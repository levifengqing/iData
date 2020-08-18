package com.test.importdatas.config;

import com.test.importdatas.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class LoginConfig implements WebMvcConfigurer {
//public class LoginConfig extends WebMvcConfigurerAdapter {
    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //处理favicon.ico图标
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login");//跳转到/login请求，不是直接跳到某个页面
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginInterceptor());//这里注册刚才实例化的LoginInterceptor，这样就可以使用Redistemplate了
        interceptorRegistration.addPathPatterns("/**");
        interceptorRegistration.excludePathPatterns("/", //这个保证直接用域名加端口，可以直接跳转到登录页面，否则会被拦截
                                                    "/login",                //登录
                                                    "/register/**",          //注册
//                "/favicon.ico",        //好像不需要在这里添加，只需要在上面添加addResourceHandlers，即可
                                                    "/**/*.html",            //html静态资源
                                                    "/**/*.js",              //js静态资源
                                                    "/**/*.css",             //css静态资源
                                                    "/**/*.woff",
                                                    "/**/*.ttf"
                                                    );
                                        }
}

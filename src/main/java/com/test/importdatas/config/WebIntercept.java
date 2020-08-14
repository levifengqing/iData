package com.test.importdatas.config;
 
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
 
/**
 * Created by yanshao on 2019-10-09.
 */
@SpringBootConfiguration
public class WebIntercept {
 
    /**
     * web 链路跟踪
     * */
    @Bean(name = "webTraceFilter")
    public WebTraceFilter getWebTraceFilter(){
        return new WebTraceFilter();
    }
 
}
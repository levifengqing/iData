package com.test.importdatas.logback.converter;
 
import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
 
/**
 * Created by yanshao on 2019-10-09.
 */
public class EnvConverter extends ClassicConverter {
 
    @Override
    public String convert(ILoggingEvent event) {
        /**
         * 这里应该动态获取当前环境
         * */
        return "pro";
    }
}
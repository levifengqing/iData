package com.test.importdatas.logback;
 
import ch.qos.logback.classic.PatternLayout;
import com.test.importdatas.logback.converter.EnvConverter;
import com.test.importdatas.logback.converter.ExceptionConverter;
import com.test.importdatas.logback.converter.MessageConverter;
import com.test.importdatas.logback.converter.TraceIdConverter;

/**
 * Created by yanshao on 2019-10-09.
 */
    public class MyPatternLayout extends PatternLayout {
 
    static {
        defaultConverterMap.put("traceId", TraceIdConverter.class.getName());
        defaultConverterMap.put("message", MessageConverter.class.getName());
        defaultConverterMap.put("exception", ExceptionConverter.class.getName());
        defaultConverterMap.put("environment", EnvConverter.class.getName());
    }
 
}
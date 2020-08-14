package com.test.importdatas.logback.converter;
 
import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.slf4j.MDC;
 
import static com.test.importdatas.config.ConstantConfig.TRACE_ID;

/**
 * Created by yanshao on 2019-10-09.
 */
public class TraceIdConverter extends ClassicConverter {
 
    @Override
    public String convert(ILoggingEvent event) {
        return MDC.get(TRACE_ID) == null? "null": MDC.get(TRACE_ID);
    }
}
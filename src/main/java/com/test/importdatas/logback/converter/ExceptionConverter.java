package com.test.importdatas.logback.converter;
 
import ch.qos.logback.classic.pattern.ThrowableProxyConverter;
import ch.qos.logback.classic.spi.IThrowableProxy;
 
/**
 * Created by yanshao on 2019-10-09.
 */
public class ExceptionConverter extends ThrowableProxyConverter {
    @Override
    protected String throwableProxyToString(IThrowableProxy tp) {
        return super.throwableProxyToString(tp);
    }
}
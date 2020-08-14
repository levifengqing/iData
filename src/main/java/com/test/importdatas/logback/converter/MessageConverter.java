package com.test.importdatas.logback.converter;
 
import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
 
/**
 * Created by yanshao on 2019-10-09.
 */
public class MessageConverter extends  ClassicConverter {
 
    public MessageConverter(){
 
    }
 
    @Override
    public String convert(ILoggingEvent event) {
      return event.getFormattedMessage();
    }
}
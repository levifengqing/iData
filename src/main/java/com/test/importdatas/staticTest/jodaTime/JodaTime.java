package com.test.importdatas.staticTest.jodaTime;

import org.apache.poi.hwpf.usermodel.DateAndTime;
import org.joda.time.DateTime;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class JodaTime {
    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
        System.out.println(dateTime);
        DateTime dateTime1 = dateTime.plusDays(5);
        System.out.println(dateTime1);
    }
}

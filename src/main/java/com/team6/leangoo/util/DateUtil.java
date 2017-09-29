package com.team6.leangoo.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by AgZou on 2017/9/14.
 */
public class DateUtil {
    public static Date LocalDateToDate(LocalDate localDate){
        ZoneId zoneId=ZoneId.systemDefault();
        ZonedDateTime zdt=localDate.atStartOfDay(zoneId);
        return Date.from(zdt.toInstant());
    }
    public static LocalDate DateToLocalDate(Date date){
        Instant instant=date.toInstant();
        ZoneId zoneId=ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }
}

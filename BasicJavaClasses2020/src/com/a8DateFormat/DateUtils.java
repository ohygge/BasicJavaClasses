package com.a8DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private DateUtils() {}

    public static String DateToString(Date dateTime ,String dateFormate){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
        String timeString = sdf.format(dateTime);
        return timeString;
    }

    public static Date timeStrToDate(String timeStr ,String dateFormate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
        Date d = sdf.parse(timeStr);
        return d;
    }
}

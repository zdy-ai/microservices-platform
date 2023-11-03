package com.sdk.tms.dsf.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author zdy
 * @ClassName DateUtil
 * @description: TODO
 * @date 2023年11月02日
 * @version: 1.0
 */
public class DateUtil {
    public static final String SIMPLE_DATE_STRING = "yyyy-MM-dd";

    public static final String FULL_DATE_STRING = "yyyy-MM-dd HH:mm:ss";

    public static final String FULL_DATE_STRING1 = "yyyy-MM-dd H:mm:ss";

    public static final String FULL_DATE_STRING2 = "yyyy-MM-dd 23:59:59";

    public static final String FULL_DATE_STRING3 = "yyyy-MM-dd 00:00:00";

    public static Date parse2Date(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date spliceDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String formatStr = sdf.format(date);
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(formatStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date spliceDate2(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String formatStr = sdf.format(date);
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(formatStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String parse2String(Date date, String format) {
        if (date == null)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String parse2StringByTimeZone(Date date, String format, TimeZone toTimeZone) {
        if (date == null)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(toTimeZone);
        return sdf.format(date);
    }

    public static int dayOfWeek(Date date) {
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(date);
        int weekDay = aCalendar.get(7);
        return weekDay - 1;
    }

    public static Date getNextDate(Date date, int index, boolean flag) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (flag) {
            cal.set(11, 0);
            cal.set(12, 0);
            cal.set(13, 0);
        }
        cal.set(5, cal.get(5) + index);
        return cal.getTime();
    }

    public static Date getDate(Date currentDate, int days) {
        Date date = currentDate;
        for (int i = 0; i < days + 1; i++) {
            Date nextDate = getNextDate(date, 1, false);
            int weekDay = dayOfWeek(nextDate);
            if (weekDay == 1) {
                date = getNextDate(date, 2, false);
            } else if (weekDay == 6) {
                date = getNextDate(date, 3, false);
            } else {
                date = nextDate;
            }
        }
        return date;
    }

    public static Date convertDateOnTimeZone(long time, TimeZone from, TimeZone to) {
        return new Date(time - from.getOffset(time) + to.getOffset(time));
    }

    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
        Date date = new Date();
        return dateFormat.format(date);
    }
}

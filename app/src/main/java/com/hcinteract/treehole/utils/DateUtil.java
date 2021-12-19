package com.hcinteract.treehole.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static Calendar calendar = Calendar.getInstance();
    private static final long MINUTE = 60;
    private static final long HOUR = 3600;
    private static final long DAY = 86400;
    private static final long MONTH = 2592000;
    private static final long YEAR = 31104000;

    public static String getDate() {
        return getYear() + "-" + getMonth() + "-" + getDay();
    }

    public static String getDate(String format) {
        SimpleDateFormat simple = new SimpleDateFormat(format);
        return simple.format(calendar.getTime());
    }

    public static int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    public static int getMonth() {
        int month = calendar.get(Calendar.MONTH) + 1;
        return month;
    }

    public static int getDay() {
        return calendar.get(Calendar.DATE);
    }

    public static int get24Hour() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinute() {
        return calendar.get(Calendar.MINUTE);
    }

    public static int getSecond() {
        return calendar.get(Calendar.SECOND);
    }

    public static long getMilliSecond() {
        return calendar.get(Calendar.MILLISECOND);
    }

    public static long getCurrentTimeMillis() {
        return calendar.getTimeInMillis();
    }

    public static String fromNow(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        long time = date.getTime() / 1000;
        long now = new Date().getTime() / 1000;
        long elapsed = now - time;
        if (elapsed <= HOUR) return elapsed / MINUTE + "分钟前";
        else if (elapsed <= DAY) return elapsed / HOUR + "小时" + (elapsed % HOUR / MINUTE) + "分钟前";
        else if (elapsed <= DAY * 2) return "昨天" + calendar.get(Calendar.HOUR_OF_DAY) + "点";
        else if (elapsed <= MONTH) return elapsed / MONTH + "天前" + calendar.get(Calendar.HOUR_OF_DAY) + "点" + calendar.get(Calendar.MINUTE) + "分";
        else {
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simple.format(date);
        }
    }
}

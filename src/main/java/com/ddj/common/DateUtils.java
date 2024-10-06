package com.ddj.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: icho
 * @Date: 2024/10/4 15:11
 * @Describe:
 */
public class DateUtils {

    private static final String yyyyMMdd = "yyyy-MM-dd HH:mm:ss";
    private static final String yyyy = "yyyy";


    public static Date StringToDate(String str) throws ParseException {
        SimpleDateFormat formatter1  = new SimpleDateFormat(yyyyMMdd);
        return formatter1.parse(str);
    }

    public static String DateToString(Date date) {
        if (date == null) date = new Date();
        SimpleDateFormat formatter2  = new SimpleDateFormat(yyyyMMdd);
        return formatter2.format(date);
    }

    public static String cleaning(String date) {
        if (date.contains(".")) date = date.replace(".", "");
        if (date.contains("-")) date = date.replace("-", "");
        return date;
    }

    public static String getYearAndMonth(String date) {
        return date.substring(0, 6);
    }

    public static String fixYear(String date) {
        if (date.contains("月")) date = date.replace("月", "");
        if (Integer.parseInt(date)<10) date = "0" + date;
        return new SimpleDateFormat(yyyy).format(new Date()) + date;
    }

}

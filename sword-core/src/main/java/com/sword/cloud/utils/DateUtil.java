package com.sword.cloud.utils;

import java.text.DateFormat;
import java.util.Date;

public class DateUtil {

    public static   String format(Date date){
        DateFormat df2 = DateFormat.getDateTimeInstance();
        return df2.format(date);
    }
}

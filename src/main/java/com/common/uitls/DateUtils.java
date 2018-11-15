package com.common.uitls;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/11/7
 */
public class DateUtils {

    public static SimpleDateFormat sdf;

    public static String toString(Date date, String pattern){
        if(pattern == null || pattern.equals("")){
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}

package com.abraham.utils;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 获取当前时间的工具类
 *
 * @author: Long
 * @date Create in 11:28 2020/12/4
 */
public class CurrentDateUtils {
    public String getCurrentDate(){
        Date date = new Date();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        return format;
    }
}

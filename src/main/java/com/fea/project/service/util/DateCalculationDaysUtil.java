package com.fea.project.service.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Administrator
 * 计算两日期之间日期间隔（天数）
 */
public class DateCalculationDaysUtil {

    public static Long getCalculationDays(Date timeOne , Date timeTwo){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timeOne);
        long timeInMillis1 = calendar.getTimeInMillis();
        calendar.setTime(timeTwo);
        long timeInMillis2 = calendar.getTimeInMillis();
        long betweenDays =  (timeInMillis2 - timeInMillis1) / (1000L*3600L*24L);
        //System.out.println(betweenDays);
        return betweenDays;
    }


}

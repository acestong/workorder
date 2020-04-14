package com.fea.project.util;

import com.fea.project.configure.exception.SystemParamCheckException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/8/21 14:38
 * 时间工具类
 **/
public class DateUtil {

    public static String getTimeQuarter(Date date) {
        int month = Integer.valueOf(new SimpleDateFormat("MM").format(date));
        return getQuarterByMonth(month);
    }

    public static String getTimeStrByDateAndDateFormate(Date date, String formateStr) {
        return new SimpleDateFormat(formateStr).format(date);
    }


    private static String getQuarterByMonth(int month) {
        if (month >= 1 && month <= 3) {
            return "1";
        }
        if (month >= 4 && month <= 6) {
            return "2";
        }
        if (month >= 7 && month <= 9) {
            return "3";
        }
        if (month >= 10 && month <= 12) {
            return "4";
        }
        throw new SystemParamCheckException("当前季度数据异常").appendAlaramMsg(month + "");
    }

    private static final long day_time = 1000 * 60 * 60 * 24;
    private static final long hour_time = 1000 * 60 * 60;
    private static final long minutes_time = 1000 * 60;

    public static String getStopTime(Date startTime, Date endTime) {
        long stopTimeStamp = endTime.getTime() - startTime.getTime();
        long day = stopTimeStamp / day_time;
        long hour = (stopTimeStamp % day_time) / hour_time;
        long minutes = (stopTimeStamp % hour_time) / minutes_time;
        String dayStr = day == 0 ? "" : day + "天";
        String hourStr = hour == 0 ? "" : hour + "小时";
        String minutesStr = minutes == 0 ? "" : minutes + "分";
        return new StringBuffer().append(dayStr).append(hourStr).append(minutesStr).toString();
    }
}

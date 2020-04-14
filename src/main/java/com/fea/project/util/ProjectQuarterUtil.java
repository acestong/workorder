package com.fea.project.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/29 10:13
 **/
public class ProjectQuarterUtil {

    public static String getQuarterStr(String year, String quarter) {
        return year + "-" + quarter;
    }

    public static String getQuarterStr(Date currentTime) {
        String year = new SimpleDateFormat("yyyy").format(currentTime);
        String quarter = DateUtil.getTimeQuarter(currentTime);
        return getQuarterStr(year, quarter);
    }
}

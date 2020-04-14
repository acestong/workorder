package com.fea.project.util;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/27 18:00
 **/
public class StringUtil {

    public static String getNextCodeByCurrentStr(String str) {
        int number = Integer.valueOf(str);
        number += 1;
        return leftAppendZero(number, str.length());
    }

    private static String leftAppendZero(int number, int length) {
        String currentStr = number + "";
        int currentLength = currentStr.length();
        if (currentStr.length() > length) {
            return currentStr.substring(currentLength - length, length);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length - currentLength; i++) {
            sb = sb.append("0");
        }
        return sb.append(currentStr).toString();
    }


    public static String getInitStartCodeByLength(Integer length) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append("0");
        }
        return sb.toString();
    }

    public static String getNextCodeByCurrentStr(String str, Integer length) {
        int number = Integer.valueOf(str);
        number += 1;
        return leftAppendZero(number, length);
    }
}

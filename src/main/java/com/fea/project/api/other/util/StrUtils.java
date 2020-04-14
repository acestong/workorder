package com.fea.project.api.other.util;

/**
 * 字符串的帮助类，提供静态方法，不可以实例化。
 */
public final class StrUtils {

    /**
     * 把一个数字转化为特定长度的字符串，长度不够，前面加0
     *
     * @param num
     * @param len
     * @return
     */
    public static String convertNum2String(Long num, Integer len) {
        String strNo = num.toString();
        while (strNo.length() < len) {
            strNo = "0" + strNo;
        }

        return strNo;
    }

}
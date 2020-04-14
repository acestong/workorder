package com.fea.project.util;

import java.math.BigDecimal;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/8/21 17:28
 **/
public class FileSizeUtil {

    private static final BigDecimal TRANSLATE_ELEMENT = new BigDecimal(1024);

    /**
     * 将文件字节大小转为K或是M
     *
     * @param fileSize
     * @return
     */
    public static String translateFileSizeToFitableUnit(long fileSize) {
        BigDecimal bigDecimal = new BigDecimal(fileSize);
        bigDecimal = bigDecimal.divide(TRANSLATE_ELEMENT).setScale(2, BigDecimal.ROUND_HALF_UP);
        String sizeStr = null;
        if (bigDecimal.compareTo(TRANSLATE_ELEMENT) >= 0) {
            bigDecimal = bigDecimal.divide(TRANSLATE_ELEMENT).setScale(2, BigDecimal.ROUND_HALF_UP);
            sizeStr = bigDecimal.toPlainString() + "M";
        } else {
            sizeStr = bigDecimal.toPlainString() + "K";
        }
        return sizeStr;
    }
}

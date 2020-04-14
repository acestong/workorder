package com.fea.project.util;

import com.fea.project.configure.annotations.base.SortKeyQueryAnno;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/5/30 18:02
 **/
public class SortKeyReplaceUtil {

    public static String replaceSortKeyByStrAndTargetClass(String replaceStr, Class targetClass) {
        Field[] fields = targetClass.getDeclaredFields();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < fields.length; i++) {
            SortKeyQueryAnno targetAnno = fields[i].getDeclaredAnnotation(SortKeyQueryAnno.class);
            if (targetAnno != null) {
                map.put(fields[i].getName(), targetAnno.field());
            }
        }
        if (map.get(replaceStr) != null) {
            return map.get(replaceStr);
        }
        return replaceStr;
    }
}

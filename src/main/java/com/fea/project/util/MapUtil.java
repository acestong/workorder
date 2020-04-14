package com.fea.project.util;

import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/29 15:19
 **/
public class MapUtil {

    public static <T, S> boolean containsKey(Map<T, S> map, T t) {
        if (map == null || t == null) {
            return false;
        }
        return map.get(t) != null;
    }
}

package com.fea.project.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wuqi
 * @since 2019/5/7 17:25
 **/
public class ListUtil {


    private static final String LIST_TO_STRING_SEPERATOR = ",";

    public static <T> List<List<T>> getSubList(List<T> models, int divideSize) {
        List list = new ArrayList();
        List innerList = null;
        for (int i = 0; i < models.size(); i++) {
            if (i % divideSize == 0) {
                if (innerList != null) {
                    list.add(innerList);
                }
                innerList = new ArrayList();
            }
            innerList.add(models.get(i));
        }
        if (innerList != null) {
            list.add(innerList);
        }
        return list;

    }

    public static boolean isNullOrEmpty(List list) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        return false;
    }

    public static String translateListToString(List ids) {
        if (isNullOrEmpty(ids)) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i) == null) {
                continue;
            }
            if (i == ids.size() - 1) {
                sb = sb.append(ids.get(i));
                continue;
            }
            sb = sb.append(ids.get(i)).append(LIST_TO_STRING_SEPERATOR);
        }
        return sb.toString();
    }

    public static Set<Long> translateStringListTolist(List<String> strList) {
        if (isNullOrEmpty(strList)) {
            return new HashSet<>();
        }
        Set<Long> infringerIds = new HashSet<>();
        for (int i = 0; i < strList.size(); i++) {
            String[] tmpIds = strList.get(i).split(LIST_TO_STRING_SEPERATOR);
            for (int j = 0; j < tmpIds.length; j++) {
                infringerIds.add(Long.parseLong(tmpIds[j]));
            }
        }
        return infringerIds;
    }

    public static List<Long> translateStringToLonglist(String targetStr) {
        if (StringUtils.isEmpty(targetStr)) {
            return new ArrayList<>();
        }
        String[] tmpIds = targetStr.split(LIST_TO_STRING_SEPERATOR);
        List<Long> ids = new ArrayList<>();
        for (int i = 0; i < tmpIds.length; i++) {
            ids.add(Long.parseLong(tmpIds[i]));
        }
        return ids;
    }

    public static List<String> translateStringToStringlist(String targetStr) {
        if (StringUtils.isEmpty(targetStr)) {
            return new ArrayList<>();
        }
        String[] tmpIds = targetStr.split(LIST_TO_STRING_SEPERATOR);
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < tmpIds.length; i++) {
            ids.add(tmpIds[i]);
        }
        return ids;
    }

    public static <T> void addWithNull(Set<T> list, T element) {
        if (element == null) {
            return;
        }
        list.add(element);
    }

    public static <T> void addAllWithNull(Set<T> list, Set<T> element) {
        if (element == null || element.size() == 0) {
            return;
        }
        list.addAll(element);
    }
    /**
     * 截取list的一部分数据
     */
    public static <T> List<T> getSubList(List<T> list, int fromIndex, int toIndex) {
        if (toIndex > list.size()) {
        }
        List listClone = list;
        List sub = listClone.subList(fromIndex, toIndex);
        List two = new ArrayList(sub);
        sub.clear();
        return two;
    }
}

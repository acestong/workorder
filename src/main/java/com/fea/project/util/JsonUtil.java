package com.fea.project.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/5 15:06
 **/
public class JsonUtil {

    private JsonUtil() {
    }

    /**
     * 将父类集合转换为子类集合
     *
     * @param fatherList
     * @param typeReference
     * @param <T>
     * @param <S>
     * @return
     */
    public static <T, S extends T> List<S> translateFathersToChildren(List<T> fatherList, TypeReference<List<S>> typeReference) {
        return JSON.parseObject(JSON.toJSONString(fatherList), typeReference);
    }

    /**
     * 将父类转换为子类
     *
     * @param father
     * @param typeReference
     * @param <T>
     * @param <S>
     * @return
     */
    public static <T, S extends T> S translateFatherToChild(T father, TypeReference<S> typeReference) {
        return JSON.parseObject(JSON.toJSONString(father), typeReference);
    }

}

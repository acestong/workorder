package com.fea.project.service.util;

import com.fea.project.configure.annotations.base.SortKeyQueryAnno;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.BasePageInfo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/23 11:01
 **/
public class AopFieldSortService {

    public static <T> void sortFieldTranslateToTargetFieldName(BasePageInfo<T> model) throws SystemParamCheckException {
        if (model == null || model.getModel() == null) {
            return;
        }
        Class targetClass = model.getModel().getClass();
        Field[] fields = targetClass.getDeclaredFields();
        Map<String, SortKeyQueryAnno> map = new HashMap<>();
        for (int i = 0; i < fields.length; i++) {
            SortKeyQueryAnno sortKeyQueryAnno = fields[i].getAnnotation(SortKeyQueryAnno.class);
            if (sortKeyQueryAnno != null) {
                map.put(fields[i].getName(), sortKeyQueryAnno);
            }
        }
        SortKeyQueryAnno tmp = map.get(model.getSortKey());
        model.setSortKey(tmp == null ? null : tmp.field());
    }
}

package com.fea.project.service.util;

import com.fea.project.configure.annotations.base.*;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.util.ConditionParamModel;
import com.fea.project.model.util.FieldValueTypeModel;
import com.fea.project.model.util.UniqueCheckModel;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/20 16:22
 **/
public class AopParamCheckService {

    public static <T> void insertOrUpdateParamCheck(T model, UniqueCheckService uniqueCheckService) throws Exception {
        if (model == null) {
            throw new SystemParamCheckException("传入的参数无效");
        }
        //字段-数值-----非空校验使用
        Map<Field, String> mapValue = new HashMap<>();
        //字段-字段中文名称-------返回信息使用
        Map<Field, String> fieldMap = new HashMap<>();
        //字段名-字段中文名------返回信息使用
        Map<String, String> fieldNameMap = new HashMap<>();
        List<UniqueCheckModel> uniqueCheckModels = new ArrayList<>();
        Class targetClass = model.getClass();
        TableNameAnno tableName = ((TableNameAnno) targetClass.getAnnotation(TableNameAnno.class));
        PrimaryKey primaryKey = null;
        Field pkField = null;
        Field[] fields = FieldUtils.getAllFields(model.getClass());
        Map<Field, ConditionStatusAnno> map = new HashMap<>(16);
        List<Field> regAutoFields = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            NotNullAnno notNullAnno = fields[i].getAnnotation(NotNullAnno.class);
            UniqueCheckAnno uniqueCheckAnno = fields[i].getAnnotation(UniqueCheckAnno.class);
            PrimaryKey tmpPk = fields[i].getAnnotation(PrimaryKey.class);
            ConditionStatusAnno tmpCondition = fields[i].getAnnotation(ConditionStatusAnno.class);
            RegAutoSetAnno regAutoSetAnno = fields[i].getAnnotation(RegAutoSetAnno.class);
            FieldValueTypeModel fieldValueTypeModel = null;
            if (regAutoSetAnno != null) {
                regAutoFields.add(fields[i]);
            }
            if (notNullAnno != null) {
                fieldValueTypeModel = getFieldValueTypeModel(fields[i], targetClass, model);
                mapValue.put(fields[i], fieldValueTypeModel.getFieldValue() == null ? null : String.valueOf(fieldValueTypeModel.getFieldValue()));
                fieldMap.put(fields[i], notNullAnno.value());
            }
            if (uniqueCheckAnno != null) {
                if (fieldValueTypeModel == null) {
                    fieldValueTypeModel = getFieldValueTypeModel(fields[i], targetClass, model);
                }
                fieldNameMap.put(fields[i].getName(), uniqueCheckAnno.value());
                fieldMap.put(fields[i], uniqueCheckAnno.value());
                uniqueCheckModels.add(createUniqueCheckModel(fields[i], uniqueCheckAnno.field(), fieldValueTypeModel));
            }
            if (primaryKey != null && tmpPk != null) {
                throw new SystemParamCheckException("该类型上定义了两个主键标识");
            } else if (primaryKey == null) {
                primaryKey = tmpPk;
                pkField = fields[i];
            }
            if (tmpCondition != null) {
                map.put(fields[i], tmpCondition);
            }

        }
        if (regAutoFields.size() > 1) {
            throw new SystemParamCheckException(model.getClass().getSimpleName() + "标识了说个组织设置注解");
        } else {
            for (Field field : regAutoFields) {
                setFieldValue(field, model.getClass(), model);
            }
        }
        if (mapValue.isEmpty() && uniqueCheckModels.isEmpty()) {
            return;
        }
        if (tableName == null || StringUtils.isEmpty(tableName.value())) {
            throw new SystemParamCheckException("数据表信息未进行对应");
        }
        PrimaryKey finalKey = primaryKey;
        Long pkValue = (Long) getFieldValue(pkField, targetClass, model);
        List<ConditionParamModel> list = new ArrayList<>();
        for (Map.Entry<Field, ConditionStatusAnno> tmp : map.entrySet()) {
            list.add(new ConditionParamModel(tmp.getValue().field(), (Long) getFieldValue(tmp.getKey(), targetClass, model)));
        }
        uniqueCheckModels.forEach(tmp -> {
            tmp.setTableName(tableName.value());
            if (finalKey != null) {
                tmp.setPkValue(pkValue);
                tmp.setPrimaryName(finalKey.field());
            }
            if (!ListUtil.isNullOrEmpty(list)) {
                tmp.setConditionParamModelList(list);
            }
        });
        notNullParamCheck(mapValue, fieldMap);
        uniqueParamCheck(uniqueCheckModels, fieldNameMap, uniqueCheckService);
    }

    private static UniqueCheckModel createUniqueCheckModel(Field field, String fieldName, FieldValueTypeModel fieldValueTypeModel) throws Exception {
        Class fieldClass = field.getType();
        Object obj = fieldValueTypeModel.getFieldValue();
        if (fieldClass.equals(Integer.class)) {
            return new UniqueCheckModel<>(fieldName, (Integer) obj);
        } else if (fieldClass.equals(Long.class)) {
            return new UniqueCheckModel<>(fieldName, (Long) obj);
        } else if (fieldClass.equals(String.class)) {
            return new UniqueCheckModel<>(fieldName, (String) obj);
        }
        throw new SystemParamCheckException(fieldClass.getName() + "类型在校验时候未定义");
    }

    private static <T> Object getFieldValue(Field field, Class targetClass, T model) throws Exception {
        Method method = null;
        try {
            method = targetClass.getMethod("get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
        } catch (Exception e) {
            method = targetClass.getMethod("get" + field.getName());
        }
        return method.invoke(model);
    }

    private static <T> void setFieldValue(Field field, Class targetClass, T model) throws Exception {
        Method method = null;
        try {
            method = targetClass.getMethod("set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1), field.getType());
        } catch (Exception e) {
            method = targetClass.getMethod("set" + field.getName(), field.getType());
        }
        method.invoke(model, UserUtil.getUserRegId());
    }

    private static <T> FieldValueTypeModel getFieldValueTypeModel(Field field, Class targetClass, T model) throws Exception {
        Object obj = getFieldValue(field, targetClass, model);
        Class fieldClass = field.getType();
        if (fieldClass.equals(Integer.class)) {
            return new FieldValueTypeModel<>(Integer.class, (Integer) obj);
        } else if (fieldClass.equals(Long.class)) {
            return new FieldValueTypeModel<>(Long.class, (Long) obj);
        } else if (fieldClass.equals(String.class)) {
            return new FieldValueTypeModel<>(String.class, (String) obj);
        } else if (fieldClass.equals(List.class)) {
            return new FieldValueTypeModel<>(List.class, (List) obj);
        } else if (fieldClass.equals(Date.class)) {
            return new FieldValueTypeModel<>(Date.class, (Date) obj);
        }else if (fieldClass.equals(BigDecimal.class)) {
            return new FieldValueTypeModel<>(BigDecimal.class, (BigDecimal) obj);
        }
        throw new SystemParamCheckException(fieldClass.getName() + "类型在校验时候未定义");
    }


    /**
     * 参数非空校验
     *
     * @param mapValue
     * @param fieldMap
     * @throws SystemParamCheckException
     */
    private static void notNullParamCheck(Map<Field, String> mapValue, Map<Field, String> fieldMap) throws SystemParamCheckException {
        if (mapValue.isEmpty()) {
            return;
        }
        for (Map.Entry<Field, String> tmp : mapValue.entrySet()) {
            if (StringUtils.isEmpty(tmp.getValue())) {
                String msg = fieldMap.get(tmp.getKey()) + "参数为必填项";
                throw new SystemParamCheckException(msg);
            }
        }
    }

    /**
     * 参数唯一性校验
     *
     * @param list
     * @param fieldNameMap
     * @throws SystemParamCheckException
     */
    private static void uniqueParamCheck(List<UniqueCheckModel> list, Map<String, String> fieldNameMap, UniqueCheckService uniqueCheckService) throws SystemParamCheckException {
        if (list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!uniqueCheckService.checkCurrentParamIsUnique(list.get(i))) {
                String msg = fieldNameMap.get(list.get(i).getCheckFieldName().replaceAll("`", "")) + "参数不唯一";
                throw new SystemParamCheckException(msg);
            }
        }
    }
}

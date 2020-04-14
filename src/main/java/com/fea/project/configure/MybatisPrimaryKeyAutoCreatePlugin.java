package com.fea.project.configure;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/4/23 13:50
 * mybatis数据插入时，主键采用雪花算法生成
 **/
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class MybatisPrimaryKeyAutoCreatePlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        Object parameter = invocation.getArgs()[1];
        if (SqlCommandType.INSERT.equals(sqlCommandType)) {
            String[] keyProperties = mappedStatement.getKeyProperties();
            //唯一主键，所以只能有一个识别
            if (keyProperties == null || keyProperties.length != 1) {
                throw new Exception(mappedStatement.getId() + "方法中keyProperty，要求存在且唯一标示主键id");
            }
            String keyProperty = keyProperties[0];
            if (parameter instanceof Map) {
                List list = (List) ((Map) parameter).get("list");
                if (!list.isEmpty()) {
                    Class targetClass = list.get(0).getClass();
                    Method method = targetClass.getMethod("set" + keyProperty.substring(0, 1).toUpperCase() + keyProperty.substring(1), Long.class);
                    for (int i = 0; i < list.size(); i++) {
                        method.invoke(list.get(i), SnowFlakeGenerator.generateId());
                    }
                }
            } else {
                Class targetClass = parameter.getClass();
                Method method = targetClass.getMethod("set" + keyProperty.substring(0, 1).toUpperCase() + keyProperty.substring(1), Long.class);
                method.invoke(parameter, SnowFlakeGenerator.generateId());
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
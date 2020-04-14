package com.fea.project.enums.base;

import com.fea.project.api.other.model.base.SysDictionaryItemModel;
import com.fea.project.api.other.service.base.SysDictionaryItemService;
import com.fea.project.configure.SpringContextHelper;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.project.ProjectViewFieldEnum;
import com.fea.project.model.project.ProjectViewSelfConfigModel;
import com.fea.project.service.flow.ProjectFlowListService;
import com.fea.project.util.UserUtil;
import com.fea.project.util.ViewActionUtil;
import io.netty.util.internal.StringUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * 项目视图操作码枚举
 * @since 2019/10/21 12:14
 **/
public enum ProjectActionCodeEnum {

    /**
     * 文本类型
     */
    TYPE_VARCHAR(1, "文本类型") {
        @Override
        public List<Map<String, Object>> getViewActionList() {
            return ViewActionUtil.getProjectViewListActionList();
        }

        @Override
        public String getTargetActionEnumExplain(Integer type, String fieldName, String str) {
            return ProjectListActionEnum.getTargetViewExplain(type, fieldName, str);
        }

        @Override
        public String getFilterName(Integer filterType) {
            return ProjectListActionEnum.getCodeKeyStrValueMap().get(filterType);
        }

        @Override
        public List<Map<String, Object>> getMoneyType() {
            return Collections.emptyList();
        }

        @Override
        public Map<Integer, String> getNameMap() {
            return ProjectListActionEnum.getCodeKeyStrValueMap();
        }
    },
    /**
     * 数值类型
     */
    TYPE_NUMBER(2, "数值类型") {
        @Override
        public List<Map<String, Object>> getViewActionList() {
            return ViewActionUtil.getProjectViewNumberActionList();
        }

        @Override
        public String getTargetActionEnumExplain(Integer type, String fieldName, String str) {
            return ProjectNumberActionEnum.getTargetViewExplain(type, fieldName, str);
        }

        @Override
        public String getFilterName(Integer filterType) {
            return ProjectNumberActionEnum.getCodeKeyStrValueMap().get(filterType);
        }

        @Override
        public List<Map<String, Object>> getMoneyType() {
            List<SysDictionaryItemModel> list = SpringContextHelper.getBean(SysDictionaryItemService.class).selectByShortNameAndRegId(ProjectFlowListService.CURRENCY_CODE, UserUtil.getUserRegId());
            return list.stream().map(x -> new HashMap<String, Object>() {{
                put("value", x.getITEMID() + "");
                put("text", x.getDICVALUE());
            }}).collect(Collectors.toList());
        }

        @Override
        public Map<Integer, String> getNameMap() {
            return ProjectNumberActionEnum.getCodeKeyStrValueMap();
        }
    };

    private Integer value;
    private String text;

    ProjectActionCodeEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static Map<Integer, String> getMap() {
        return Stream.of(ProjectActionCodeEnum.values())
                .collect(Collectors.toMap(ProjectActionCodeEnum::getValue, ProjectActionCodeEnum::getText));
    }

    public static Map<Integer, ProjectActionCodeEnum> getEnumMap() {
        return Stream.of(ProjectActionCodeEnum.values())
                .collect(Collectors.toMap(ProjectActionCodeEnum::getValue, x -> x));
    }

    public static String getActionStr(Integer actionCode, Integer filterType) {
        ProjectActionCodeEnum targetEnum = ProjectActionCodeEnum.getEnumMap().get(actionCode);
        if (targetEnum == null) {
            throw new SystemParamCheckException("当前操作类型未定义");
        }
        return targetEnum.getFilterName(filterType);
    }

    public static String getExplainStr(ProjectViewSelfConfigModel model) {
        if (model == null || model.getActionCode() == null) {
            throw new SystemParamCheckException("传入的参数异常，无法进行模型转换");
        }
        ProjectActionCodeEnum targetEnum = getEnumMap().get(model.getActionCode());
        if (targetEnum == null) {
            throw new SystemParamCheckException("当前传入得操作类型编码异常，无法进行解析");
        }
        String fieldName = ProjectViewFieldEnum.getFieldNameMap().get(model.getFieldType());
        if (StringUtil.isNullOrEmpty(fieldName)) {
            throw new SystemParamCheckException("字段名称未定义，无法进行解析");
        }
        return targetEnum.getTargetActionEnumExplain(model.getFilterType(), fieldName, model.getFilterValue());
    }

    public static Map<Integer, Map<Integer, String>> getActionMap() {
        Map<Integer, Map<Integer, String>> map = new HashMap<>();
        Stream.of(ProjectActionCodeEnum.values()).forEach(x -> {
            map.put(x.value, x.getNameMap());
        });
        return map;
    }

    public abstract Map<Integer, String> getNameMap();

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    /**
     * 获取视图操作list
     *
     * @return
     */
    public abstract List<Map<String, Object>> getViewActionList();

    public abstract String getTargetActionEnumExplain(Integer type, String fieldName, String str);

    public abstract String getFilterName(Integer filterType);


    public abstract List<Map<String, Object>> getMoneyType();
}

package com.fea.project.enums.baseconfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/27 10:58
 **/
public enum ProjectCodeDateStrEnum {

    TYPE_YEAR_MONTH_DAY(1, "年月日(YYYYMMDD)", "yyyyMMdd"),
    TYPE_YEAR_MONTH(2, "年月(YYYYMM)", "yyyyMM"),
    TYPE_YEAR(3, "年(YYYY)", "yyyy"),
    TYPE_NULL(4, "无", null);

    private Integer value;
    private String text;
    private String dateFormat;

    ProjectCodeDateStrEnum(Integer value, String text, String dateFormat) {
        this.value = value;
        this.text = text;
        this.dateFormat = dateFormat;
    }

    public static List<Map<String, Object>> getProjectCodeNeedDateStr() {
        return Stream.of(new HashMap<String, Object>() {{
            put("value", TYPE_YEAR_MONTH_DAY.value);
            put("text", TYPE_YEAR_MONTH_DAY.getText());
        }}).collect(Collectors.toList());
    }

    /**
     * 获取当前枚举的所有信息
     *
     * @return
     */
    public static Map<Integer, ProjectCodeDateStrEnum> getFullMap() {
        ProjectCodeDateStrEnum[] projectCodeDateStrEnums = ProjectCodeDateStrEnum.values();
        return Stream.of(projectCodeDateStrEnums).collect(Collectors.toMap(ProjectCodeDateStrEnum::getValue, projectCodeDateStrEnum -> projectCodeDateStrEnum));
    }

    /**
     * 获取当前类型码下的时间模型
     *
     * @param value
     * @return
     */
    public static String getTargetDateFormat(Integer value) {
        if (value == null) {
            return null;
        }
        return getFullMap().get(value) == null ? null : getFullMap().get(value).getDateFormat();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

}

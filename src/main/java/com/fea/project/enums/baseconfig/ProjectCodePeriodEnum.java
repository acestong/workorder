package com.fea.project.enums.baseconfig;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.util.DateUtil;
import com.fea.project.util.ProjectQuarterUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/27 10:50
 **/
public enum ProjectCodePeriodEnum {

    TYPE_YEAR(1, "年") {
        @Override
        public boolean isNeedRefreshCode(Date currentTime, Date lastCreateTime) {
            if (lastCreateTime == null) {
                return true;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            String currentYear = sdf.format(currentTime);
            String lastYear = sdf.format(lastCreateTime);
            return !currentYear.equals(lastYear);
        }
    },
    YEAR_QUARTER(2, "季") {
        @Override
        public boolean isNeedRefreshCode(Date currentTime, Date lastCreateTime) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            String currentYear = sdf.format(currentTime);
            String lastYear = sdf.format(lastCreateTime);
            String currentQuarter = DateUtil.getTimeQuarter(currentTime);
            String lastQuarter = DateUtil.getTimeQuarter(lastCreateTime);
            return !ProjectQuarterUtil.getQuarterStr(currentYear, currentQuarter).equals(ProjectQuarterUtil.getQuarterStr(lastYear, lastQuarter));
        }
    },
    TYPE_MONTH(3, "月") {
        @Override
        public boolean isNeedRefreshCode(Date currentTime, Date lastCreateTime) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            String currentYearMonth = sdf.format(currentTime);
            String lastYearMonth = sdf.format(lastCreateTime);
            return !currentYearMonth.equals(lastYearMonth);
        }
    },
    TYPE_DAY(4, "日") {
        @Override
        public boolean isNeedRefreshCode(Date currentTime, Date lastCreateTime) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String currentYearMonthDay = sdf.format(currentTime);
            String lastYearMonthDay = sdf.format(lastCreateTime);
            return !currentYearMonthDay.equals(lastYearMonthDay);
        }
    };

    private Integer value;
    private String text;

    ProjectCodePeriodEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static Map<Integer, ProjectCodePeriodEnum> getMap() {
        Map<Integer, ProjectCodePeriodEnum> map = new HashMap<>();
        ProjectCodePeriodEnum[] enums = ProjectCodePeriodEnum.values();
        for (int i = 0; i < enums.length; i++) {
            map.put(enums[i].value, enums[i]);
        }
        return map;
    }

    public static ProjectCodePeriodEnum getTargetEnum(Integer value) {
        ProjectCodePeriodEnum targetEnum = (value == null ? null : getMap().get(value));
        if (targetEnum == null) {
            throw new SystemParamCheckException("当前的周期类型不存在").appendAlaramMsg(value + "");
        }
        return targetEnum;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public abstract boolean isNeedRefreshCode(Date currentTime, Date lastCreateTime);
}

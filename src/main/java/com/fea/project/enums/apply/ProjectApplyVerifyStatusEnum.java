package com.fea.project.enums.apply;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.plan.PlanAppendixTypeEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/30 15:09
 **/
public enum ProjectApplyVerifyStatusEnum {

    TYPE_APPLY(0, "申请", "") {
        @Override
        public String getVerifyExplainName() {
            return "申请人";
        }

        @Override
        public Integer getColorStatusType() {
            return ProjectApplyFlowStatusColorTypeEnum.TYPE_HAVING_ACTION.getValue();
        }
    },
    TYPE_UNCOMMIT(1, "未提交", "") {
        @Override
        public String getVerifyExplainName() {
            return null;
        }

        @Override
        public Integer getColorStatusType() {
            return ProjectApplyFlowStatusColorTypeEnum.TYPE_WAITING_ACTION.getValue();
        }
    },
    TYPE_VERIFYING(2, "审核中", "") {
        @Override
        public String getVerifyExplainName() {
            return "";
        }

        @Override
        public Integer getColorStatusType() {
            return ProjectApplyFlowStatusColorTypeEnum.TYPE_ACTING.getValue();
        }
    },
    TYPE_HAS_VERIFY(3, "已审核", "同意") {
        @Override
        public String getVerifyExplainName() {
            return "审核人";
        }

        @Override
        public Integer getColorStatusType() {
            return ProjectApplyFlowStatusColorTypeEnum.TYPE_HAVING_ACTION.getValue();
        }
    },
    TYPE_HAS_REPULSE(4, "已驳回", "申请不合格") {
        @Override
        public String getVerifyExplainName() {
            return "审核人";
        }

        @Override
        public Integer getColorStatusType() {
            return ProjectApplyFlowStatusColorTypeEnum.TYPE_HAVING_BEATBACK.getValue();
        }
    },
    TYPE_HAS_REFUSE(5, "已拒绝", "不同意") {
        @Override
        public String getVerifyExplainName() {
            return "审核人";
        }

        @Override
        public Integer getColorStatusType() {
            return ProjectApplyFlowStatusColorTypeEnum.TYPE_HAVING_REFUSE.getValue();
        }
    },
    TYPE_HAS_REVERT(6, "已撤销", "申请人撤销") {
        @Override
        public String getVerifyExplainName() {
            return "";
        }

        @Override
        public Integer getColorStatusType() {
            return ProjectApplyFlowStatusColorTypeEnum.TYPE_REVERT.getValue();
        }
    };

    private Integer value;
    private String text;
    private String msg;

    public static List<Integer> getCanSubmitStatus() {
        List<Integer> list = new ArrayList<>();
        list.add(TYPE_UNCOMMIT.getValue());
        list.add(TYPE_HAS_REFUSE.getValue());
        list.add(TYPE_HAS_REVERT.getValue());
        return list;
    }

    ProjectApplyVerifyStatusEnum(Integer value, String text, String msg) {
        this.value = value;
        this.text = text;
        this.msg = msg;
    }

    public static String getValueNum(Integer value) {  
    	ProjectApplyVerifyStatusEnum[] enums = values();  
        for (ProjectApplyVerifyStatusEnum e : enums) {  
            if (e.getValue().equals(value)) {  
                return e.getText();  
            }  
        }  
        return null;  
    }  
    
    public static ProjectApplyVerifyStatusEnum getTargetEnum(Integer type) {
        return Stream.of(ProjectApplyVerifyStatusEnum.values()).collect(Collectors.toMap(ProjectApplyVerifyStatusEnum::getValue, x -> x)).get(type);
    }

    public static Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        ProjectApplyVerifyStatusEnum[] enums = ProjectApplyVerifyStatusEnum.values();
        for (ProjectApplyVerifyStatusEnum tmp : enums) {
            map.put(tmp.getValue(), tmp.getText());
        }
        return map;
    }

    public static List<Integer> getRunningStatusList() {
        return new ArrayList<Integer>() {{
            add(TYPE_UNCOMMIT.value);
            add(TYPE_VERIFYING.value);
        }};
    }

    public static List<Map<String, Object>> getApplyStatus() {
        return Stream.of(ProjectApplyVerifyStatusEnum.values()).map(x -> new HashMap<String, Object>() {{
            put("value", x.getValue());
            put("text", x.getText());
        }}).collect(Collectors.toList());
    }

    public static String getVerifyTypeName(Integer verifyStatus) {
        ProjectApplyVerifyStatusEnum targetEnum = getTargetEnum(verifyStatus);
        if (targetEnum == null) {
            throw new SystemParamCheckException("传入的流程状态未定义");
        }
        return targetEnum.getVerifyExplainName();
    }

	

    public abstract String getVerifyExplainName();

    public abstract Integer getColorStatusType();

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public String getMsg() {
        return msg;
    }


}

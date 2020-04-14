package com.fea.project.enums.apply;

import com.fea.project.configure.SpringContextHelper;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.apply.pojo.ProjectApplyFlowVerifyPojo;
import com.fea.project.model.apply.vo.ProjectApplyFlowInfoVo;
import com.fea.project.model.apply.vo.ProjectApplyFlowVerifyVo;
import com.fea.project.service.apply.action.ActionAgreeService;
import com.fea.project.service.apply.action.ActionBeatBackService;
import com.fea.project.service.apply.action.ActionRefuseService;
import com.fea.project.service.apply.action.ActionRevertService;
import com.fea.project.util.UserUtil;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/18 12:27
 **/
public enum ProjectApplyVerifyActionStatusEnum {

    /**
     * 同意
     */
    TYPE_AGREE(1, "同意") {
        @Override
        public void checkUserStatus(Map<Long, ProjectApplyFlowVerifyVo> applyFlowVerifyVoMap, Long applyerId, Boolean isFinish) {
            this.checkCurrentUserAndStatusSatisfied(applyFlowVerifyVoMap, isFinish);
        }

        @Override
        public boolean updateInfoByStatus(ProjectApplyFlowVerifyPojo model, ProjectApplyFlowInfoVo projectApplyFlowInfoVo) {
            return SpringContextHelper.getBean(ActionAgreeService.class).updateInfoByStatus(model, projectApplyFlowInfoVo);
        }
    },
    /**
     * 拒绝
     */
    TYPE_REFUSE(2, "拒绝") {
        @Override
        public void checkUserStatus(Map<Long, ProjectApplyFlowVerifyVo> applyFlowVerifyVoMap, Long applyerId, Boolean isFinish) {
            this.checkCurrentUserAndStatusSatisfied(applyFlowVerifyVoMap, isFinish);
        }

        @Override
        public boolean updateInfoByStatus(ProjectApplyFlowVerifyPojo model, ProjectApplyFlowInfoVo projectApplyFlowInfoVo) {
            return SpringContextHelper.getBean(ActionRefuseService.class).updateInfoByStatus(model, projectApplyFlowInfoVo);
        }
    },
    /**
     * 打回
     */
    TYPE_BEATBACK(3, "驳回") {
        @Override
        public void checkUserStatus(Map<Long, ProjectApplyFlowVerifyVo> applyFlowVerifyVoMap, Long applyerId, Boolean isFinish) {
            this.checkCurrentUserAndStatusSatisfied(applyFlowVerifyVoMap, isFinish);
        }

        @Override
        public boolean updateInfoByStatus(ProjectApplyFlowVerifyPojo model, ProjectApplyFlowInfoVo projectApplyFlowInfoVo) {
            return SpringContextHelper.getBean(ActionBeatBackService.class).updateInfoByStatus(model, projectApplyFlowInfoVo);
        }
    },

    TYPE_REVERT(4, "撤销") {
        @Override
        public void checkUserStatus(Map<Long, ProjectApplyFlowVerifyVo> applyFlowVerifyVoMap, Long applyerId, Boolean isFinish) {
            if (isFinish) {
                throw new SystemParamCheckException("当前流程已经结束，无法进行撤销");
            }
            if (!Objects.equals(applyerId, UserUtil.getUserId())) {
                throw new SystemParamCheckException("当前流程的申请人与操作人不一致，无法进行撤销");
            }
        }

        @Override
        public boolean updateInfoByStatus(ProjectApplyFlowVerifyPojo model, ProjectApplyFlowInfoVo projectApplyFlowInfoVo) {
            return SpringContextHelper.getBean(ActionRevertService.class).updateInfoByStatus(model, projectApplyFlowInfoVo);
        }
    };

    private Integer value;
    private String text;

    public static Map<Integer, String> getMap() {
        return Stream.of(ProjectApplyVerifyActionStatusEnum.values()).collect(Collectors.toMap(ProjectApplyVerifyActionStatusEnum::getValue, ProjectApplyVerifyActionStatusEnum::getText));
    }


    public static List<Integer> getVerifyStatusList() {
        return Stream.of(ProjectApplyVerifyActionStatusEnum.values()).map(ProjectApplyVerifyActionStatusEnum::getValue)
                .filter(x -> !Objects.equals(x, TYPE_REVERT.getValue())).collect(Collectors.toList());
    }

    ProjectApplyVerifyActionStatusEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static Map<Integer, ProjectApplyVerifyActionStatusEnum> getEnumMap() {
        return Stream.of(ProjectApplyVerifyActionStatusEnum.values()).collect(Collectors.toMap(ProjectApplyVerifyActionStatusEnum::getValue, x -> x));
    }

    public static ProjectApplyVerifyActionStatusEnum getTargetMap(Integer verifyStatus) {
        ProjectApplyVerifyActionStatusEnum targetEnum = getEnumMap().get(verifyStatus);
        if (targetEnum == null) {
            throw new SystemParamCheckException("存在未定义的操作类型");
        }
        return targetEnum;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public abstract void checkUserStatus(Map<Long, ProjectApplyFlowVerifyVo> applyFlowVerifyVoMap, Long applyerId, Boolean isFinish);

    public void checkCurrentUserAndStatusSatisfied(Map<Long, ProjectApplyFlowVerifyVo> applyFlowVerifyVoMap, Boolean isFinish) {
        if (isFinish) {
            throw new SystemParamCheckException("当前流程已经结束，无法进行审批");
        }
        ProjectApplyFlowVerifyVo model = applyFlowVerifyVoMap.get(UserUtil.getUserId());
        if (model == null) {
            throw new SystemParamCheckException("当前人员无具备审核流程的权限");
        }
        if (!Objects.isNull(model.getActionTime())) {
            throw new SystemParamCheckException("当前人员已经进行了审核，无法重复审核");
        }
    }

    public abstract boolean updateInfoByStatus(ProjectApplyFlowVerifyPojo model, ProjectApplyFlowInfoVo projectApplyFlowInfoVo);
}

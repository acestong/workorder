package com.fea.project.enums.flow.base;

import com.fea.project.api.other.model.base.SysRoleModel;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysRoleService;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.SpringContextHelper;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.flow.pojo.ProjectFlowPersonTypePojo;
import com.fea.project.model.role.ProjectRoleModel;
import com.fea.project.model.team.pojo.ProjectTeamPojo;
import com.fea.project.service.role.ProjectRoleService;
import com.fea.project.service.team.ProjectTeamService;
import com.fea.project.service.team.ProjectTeamUserService;
import com.fea.project.service.user.ProjectUserService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/10 10:21
 * 项目审批人类型
 **/
public enum ProjectPersonTypeEnum {

    TYPE_SUPERIOR(1, "上级") {
        @Override
        public Object getPersonCanSelectList(ProjectFlowPersonTypePojo model) {
            return ProjectSuperiorTypeEnum.getMap();
        }

        @Override
        public List<Map<String, Object>> getSignatureTypes() {
            return null;
        }

        @Override
        public List<Long> getPersonTypeUsers(List<Long> ids, Long applyer) {
            if (ids.size() > 1) {
                throw new SystemParamCheckException("当前人员类型选择上级传入的类型异常");
            }
            return SpringContextHelper.getBean(SysUserService.class).selectCurrentUsersAdminUsers(ids.get(0), applyer);
        }

        @Override
        public Map<Long, String> getPersonTypeNameMap(Set<Long> y) {
            return ProjectSuperiorTypeEnum.getPersonTypeNameMap();
        }
    },
    TYPE_ROLE(2, "角色") {
        @Override
        public Object getPersonCanSelectList(ProjectFlowPersonTypePojo model) {
            return SpringContextHelper.getBean(SysRoleService.class).selectModelsByUserReg();
        }

        @Override
        public List<Map<String, Object>> getSignatureTypes() {
            return ProjectSignTypeEnum.getMap();
        }

        @Override
        public List<Long> getPersonTypeUsers(List<Long> ids, Long applyer) {
            return SpringContextHelper.getBean(SysRoleService.class).selectSysUserIdsByRoleIds(ids);
        }

        @Override
        public Map<Long, String> getPersonTypeNameMap(Set<Long> y) {
            return SpringContextHelper.getBean(SysRoleService.class).selectByRoleIds(new ArrayList<>(y))
                    .stream().collect(Collectors.toMap(SysRoleModel::getROLEID, SysRoleModel::getROLENAME));
        }
    },
    TYPE_TEAM_ROLE(3, "项目团队角色") {
        @Override
        public Object getPersonCanSelectList(ProjectFlowPersonTypePojo model) {
            return SpringContextHelper.getBean(ProjectRoleService.class).selectByProjectId(model.getProjectId());
        }

        @Override
        public List<Map<String, Object>> getSignatureTypes() {
            return ProjectSignTypeEnum.getMap();
        }

        @Override
        public List<Long> getPersonTypeUsers(List<Long> ids, Long applyer) {
            return SpringContextHelper.getBean(ProjectRoleService.class).selectUserIdsByRoleIds(ids);
        }

        @Override
        public Map<Long, String> getPersonTypeNameMap(Set<Long> y) {
            return SpringContextHelper.getBean(ProjectRoleService.class).selectProjectRoleByRoleIds(new ArrayList<>(y))
                    .stream().collect(Collectors.toMap(ProjectRoleModel::getId, ProjectRoleModel::getName));
        }
    },
    TYPE_SINGLE_REG_PERSON(4, "单个组织成员") {
        @Override
        public Object getPersonCanSelectList(ProjectFlowPersonTypePojo model) {
            return SpringContextHelper.getBean(ProjectTeamUserService.class).selectDeptUserWithNoParam();
        }

        @Override
        public List<Map<String, Object>> getSignatureTypes() {
            return null;
        }

        @Override
        public List<Long> getPersonTypeUsers(List<Long> ids, Long applyer) {
            return ids;
        }

        @Override
        public Map<Long, String> getPersonTypeNameMap(Set<Long> y) {
            return SpringContextHelper.getBean(SysUserService.class).selectByIds(new ArrayList<>(y))
                    .stream().collect(Collectors.toMap(SysUserModel::getUserId, SysUserModel::getRealName));
        }
    },
    TYPE_SINGLE_TEAM_PERSON(5, "单个项目成员") {
        @Override
        public Object getPersonCanSelectList(ProjectFlowPersonTypePojo model) {
            return SpringContextHelper.getBean(ProjectTeamService.class).listByProjectId(new ProjectTeamPojo(model.getProjectId(), Boolean.TRUE));
        }

        @Override
        public List<Map<String, Object>> getSignatureTypes() {
            return null;
        }

        @Override
        public List<Long> getPersonTypeUsers(List<Long> ids, Long applyer) {
            return SpringContextHelper.getBean(ProjectUserService.class).selectUserIdsByIds(ids);
        }

        @Override
        public Map<Long, String> getPersonTypeNameMap(Set<Long> y) {
            return SpringContextHelper.getBean(ProjectUserService.class).selectUserByIds(new ArrayList<>(y));
        }
    },
    TYPE_APPLYER(6, "申请人") {
        @Override
        public Object getPersonCanSelectList(ProjectFlowPersonTypePojo model) {
            return null;
        }

        @Override
        public List<Map<String, Object>> getSignatureTypes() {
            return null;
        }

        @Override
        public List<Long> getPersonTypeUsers(List<Long> ids, Long applyer) {
            return Stream.of(applyer).collect(Collectors.toList());
        }

        @Override
        public Map<Long, String> getPersonTypeNameMap(Set<Long> y) {
            return new HashMap<>();
        }
    };

    private Integer value;
    private String text;

    public static List<Map<String, Object>> getFlowVerfiyMap(ProjectFlowPersonTypePojo model) {
        return Stream.of(ProjectPersonTypeEnum.values()).filter(x -> model.getProjectId() == null
                || (!Objects.equals(x, TYPE_TEAM_ROLE) && !Objects.equals(x, TYPE_SINGLE_TEAM_PERSON))).map(x ->
                new HashMap<String, Object>(2) {{
                    put("value", x.value);
                    put("text", x.text);
                }}
        ).collect(Collectors.toList());
    }

    ProjectPersonTypeEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static Map<Integer, ProjectPersonTypeEnum> getEnumMap() {
        return Stream.of(ProjectPersonTypeEnum.values()).collect(Collectors.toMap(ProjectPersonTypeEnum::getValue, x -> x));
    }

    public static ProjectPersonTypeEnum getTargetEnum(Integer personType) {
        ProjectPersonTypeEnum targetEnum = getEnumMap().get(personType);
        if (targetEnum == null) {
            throw new SystemParamCheckException("所选的项目人员类型未定义");
        }
        return targetEnum;
    }

    public static Map<Integer, Map<Long, String>> getNamesMap(Map<Integer, Set<Long>> copyerNameMap) {
        Map<Integer, Map<Long, String>> map = new HashMap<>();
        copyerNameMap.forEach((x, y) -> map.put(x, getTargetEnum(x).getPersonTypeNameMap(y)));
        return map;
    }

    public static Map<Integer, String> getPersonTypeNames() {
        return Stream.of(ProjectPersonTypeEnum.values()).collect(Collectors.toMap(ProjectPersonTypeEnum::getValue, ProjectPersonTypeEnum::getText));
    }

    public abstract Map<Long, String> getPersonTypeNameMap(Set<Long> y);

    public abstract Object getPersonCanSelectList(ProjectFlowPersonTypePojo model);

    public abstract List<Map<String, Object>> getSignatureTypes();

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    /**
     * 获取用户类型下的用户
     *
     * @return
     */
    public abstract List<Long> getPersonTypeUsers(List<Long> ids, Long applyer);
}

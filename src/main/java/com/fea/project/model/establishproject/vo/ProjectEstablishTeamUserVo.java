package com.fea.project.model.establishproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.model.establishproject.team.ProjectEstablishTeamUserModel;
import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/14 16:58
 **/
@Data
public class ProjectEstablishTeamUserVo extends ProjectEstablishTeamUserModel {

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 真实用户id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long realUserId;

    /**
     * 团队id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 组织机构名称
     */
    private String regName;


    /**
     * 部门名称
     */
    private String deptName;


    /**
     * 职位名称
     */
    private String dutyName;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮件
     */
    private String mail;

    private Long roleId;

    public void setUserBaseInfo(SysUserModel sysUserModel) {
        if (sysUserModel == null) {
            return;
        }
        this.setUserName(sysUserModel.getRealName());
        this.setDeptName(sysUserModel.getDeptName());
        this.setGender(sysUserModel.getGender());
        this.setPhone(sysUserModel.getPhone());
        this.setDutyName(sysUserModel.getDutyName());
        this.setMail(sysUserModel.getMail());
        this.setRegName(sysUserModel.getRegName());
        this.setRoleName(sysUserModel.getRoleName());
    }
}

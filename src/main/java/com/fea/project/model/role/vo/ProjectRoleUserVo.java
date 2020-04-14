package com.fea.project.model.role.vo;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.model.role.ProjectRoleUserModel;
import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/16 17:50
 **/
@Data
public class ProjectRoleUserVo extends ProjectRoleUserModel {
    private String realName;

    private String roleName;

    private String regName;

    private String deptName;

    private String phone;

    private String mail;

    private String dutyName;

    public void setSysUserInfo(SysUserModel sysUserModel) {
        if (sysUserModel == null) {
            return;
        }
        this.setDeptName(sysUserModel.getDeptName());
        this.setDutyName(sysUserModel.getDeptName());
        this.setMail(sysUserModel.getMail());
        this.setPhone(sysUserModel.getPhone());
        this.setRegName(sysUserModel.getRegName());
        this.setRoleName(sysUserModel.getRoleName());
        this.setRealName(sysUserModel.getRealName());
    }
}

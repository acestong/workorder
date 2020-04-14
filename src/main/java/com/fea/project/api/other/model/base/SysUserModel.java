package com.fea.project.api.other.model.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/09/25.
 * 用户表 实体类
 */
@Data
public class SysUserModel implements Serializable {

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long userId;

    /**
     * 组织注册标识
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long regId;

    /**
     * 公司标识
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long orgId;

    /**
     * 员工自增标识
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long empId;


    /**
     * 真实姓名
     */
    protected String realName;


    /**
     * 是否超级管理员
     */
    protected Integer isSuper;


    /**
     * 直接上级用户姓名
     */
    protected String superiorName;

    /**
     * 是否集团公司管理员（false:否，true:是）
     */
    protected Integer isGroupManager;

    /**
     *
     */
    protected Integer delState;

    protected Integer isDisabled;

    protected Integer gender;

    protected String deptName;

    protected String dutyName;

    protected String regName;

    protected String phone;

    protected String mail;

    protected String roleName;

    public SysUserModel() {
    }

    public SysUserModel(Long userId, String realName) {
        this.userId = userId;
        this.realName = realName;
    }
}
package com.fea.project.api.other.model.base.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysUserModel;
import lombok.Data;

/**
 * Created by Administrator on 2019/09/25.
 * 用户表 实体类
 */
@Data
public class SysUserVo extends SysUserModel {

    private String orgName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deptId;

    public SysUserVo() {
    }

    public SysUserVo(Long userId, String realName) {
        super(userId, realName);
    }

    public SysUserVo(Long userId, String realName, Long deptId, String deptName) {
        super(userId, realName);
        this.deptId = deptId;
        this.deptName = deptName;
    }
}
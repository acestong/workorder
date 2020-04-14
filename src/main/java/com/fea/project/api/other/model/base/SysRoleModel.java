package com.fea.project.api.other.model.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/11/14.
 * 角色表 实体类
 */
@Data
public class SysRoleModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Long ROLEID;

    /**
     * 父角色ID
     */
    private Long PARENTID;

    /**
     * 角色编码
     */
    private String ROLECODE;

    /**
     * 角色名称
     */
    private String ROLENAME;

    /**
     * 组织注册id
     */
    private Long REGID;

    /**
     * 组织编号
     */
    private Long ORGID;

    /**
     * 描述
     */
    private String DESCRIPTION;

    /**
     * 角色状态（1=激活 0=停用）
     */
    private Integer STATE;

    /**
     * 创建人
     */
    private String CREATEUSER;

    /**
     * 创建时间
     */
    private Date CREATETIME;

    /**
     * 更新人
     */
    private String UPDATEUSER;

    /**
     * 更新时间
     */
    private Date UPDATETIME;

    /**
     * 树左边
     */
    private Integer LFT;

    /**
     * 树右边
     */
    private Integer RGT;

    /**
     * 排序
     */
    private Integer PRIORITY;

    /**
     * 角色人数
     */
    private Integer TOTAL;

    /**
     *
     */
    private Integer DELSTATE;

    /**
     * 创建来源：{0系统, 1企业微信, 2体验组织, 3钉钉}
     */
    private Integer SOURCE;

    public SysRoleModel() {
    }


    public SysRoleModel(Long regId, Integer state) {
        this.REGID = regId;
        this.STATE = state;
    }

}
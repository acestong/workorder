package com.fea.project.api.other.model.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/15.
 */
@Data
public class SysDepartmentModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    protected Long DEPID;

    /**
     *
     */
    protected Long REGID;

    /**
     * 组织ID
     */
    protected Long ORGID;

    /**
     * 部门名称
     */
    protected String DEPNAME;

    /**
     * 部门编码
     */
    protected String DEPCODE;

    /**
     * 经理id
     */
    protected Long EMPID;

    /**
     * 经理名字
     */
    protected String MANAGER;

    /**
     * 组织名称
     */
    protected String ORGNAME;

    /**
     * 组织编码
     */
    protected String ORGCODE;

    /**
     * 创建人
     */
    protected String CREATEUSER;

    /**
     * 创建时间
     */
    protected Date CREATETIME;

    /**
     * 修改人
     */
    protected String UPDATEUSER;

    /**
     * 修改时间
     */
    protected Date UPDATETIME;

    /**
     * 成立时间
     */
    protected Date BUILDDATE;

    /**
     *
     */
    protected Long WXPARENTID;

    /**
     *
     */
    protected Long WXDEPARTID;

    /**
     * 1:有效0：无效
     */
    protected Integer STATE;

    /**
     * 部门描述
     */
    protected String DESCRIPTION;

    /**
     * 树左边
     */
    protected Integer LFT;

    /**
     * 树右边
     */
    protected Integer RGT;

    /**
     * 排序
     */
    protected Integer PRIORITY;

    /**
     * 父部门ID
     */
    protected Long PARENTID;

    /**
     * 部门人数
     */
    protected Integer TOTAL;

    /**
     *
     */
    protected Integer DELSTATE;

    /**
     * 是否公开，0是：1否
     */
    protected Byte ISPUB;

}
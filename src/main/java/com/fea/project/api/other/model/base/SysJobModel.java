package com.fea.project.api.other.model.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/26.
 * 职位表 实体类
 */
@Data
public class SysJobModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    protected Long ID;

    /**
     * 父分类ID
     */
    protected Long PARENTID;

    /**
     * 职位名称
     */
    protected String NAME;

    /**
     * 组织注册编号
     */
    protected Long REGID;

    /**
     *
     */
    protected Long ORGID;

    /**
     * 创建用户ID
     */
    protected Long CREATEUSERID;

    /**
     * 创建人
     */
    protected String CREATEUSER;

    /**
     * 创建时间
     */
    protected Date CREATETIME;

    /**
     * 更新用户ID
     */
    protected Long UPDATEUSERID;

    /**
     * 修改人
     */
    protected String UPDATEUSER;

    /**
     * 修改时间
     */
    protected Date UPDATETIME;

    /**
     *
     */
    protected Long DEPID;

    /**
     * 部门名称
     */
    protected String DEPNAME;

    /**
     * 职位代码
     */
    protected String JOBCODE;

    /**
     * 状态,0激活，1冻结
     */
    protected Byte STATE;

    /**
     * 生效日期
     */
    protected Date EFFECTIVEDATE;

    /**
     * 职位性质  1代表全职，0代表兼职
     */
    protected Byte NATURE;

    /**
     * 编制
     */
    protected Integer STAFF;

    /**
     * 关键职位，1是，0否
     */
    protected Boolean KEYJOBS;

    /**
     * 职能类别ID
     */
    protected Long FUNCTIONID;

    /**
     * 职能类别
     */
    protected String FUNCTIONNAME;

    /**
     * 是否生产：1是，0否
     */
    protected Boolean PRODUCTION;

    /**
     * 薪等ID
     */
    protected Long SALARYLEVELSID;

    /**
     * 薪等名称
     */
    protected String SALARYLEVELSNAME;

    /**
     * 薪级ID
     */
    protected Long SALARYRANKID;

    /**
     * 薪级名称
     */
    protected String SALARYRANKNAME;

    /**
     * 职等ID
     */
    protected Long JOBLEVELSID;

    /**
     *
     */
    protected String JOBLEVELSNAME;

    /**
     * 排序
     */
    protected Double PRIORITY;

    /**
     *
     */
    protected String ORDERCODE;

    /**
     *
     */
    protected Byte DELSTATE;

    /**
     * 备用1
     */
    protected Long SPARE1;

    /**
     * 备用2
     */
    protected Long SPARE2;

    /**
     * 备用3，已使用：是否参与流程审批标示1是，0否
     */
    protected Integer SPARE3;

    /**
     * 备用4
     */
    protected Integer SPARE4;

    /**
     * 备用5
     */
    protected String SPARE5;

    /**
     * 备用6
     */
    protected String SPARE6;

    /**
     * 备用7
     */
    protected Date SPARE7;
}
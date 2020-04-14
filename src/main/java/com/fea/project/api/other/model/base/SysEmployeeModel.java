package com.fea.project.api.other.model.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/15.
 * 员工信息表 实体类
 */
@Data
public class SysEmployeeModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 员工自增标识
     */
    private Long EMPID;

    /**
     * 员工姓名
     */
    private String EMPNAME;

    /**
     * 姓名首字母缩写
     */
    private String acronym;

    /**
     * 员工编码
     */
    private String EMPCODE;

    /**
     * 所属组织id
     */
    private Long ORGID;

    /**
     * 所属组织编码
     */
    private String ORGCODE;

    /**
     * 组织名称
     */
    private String ORGNAME;

    /**
     * 部门id
     */
    private Long DEPID;

    /**
     * 部门编码
     */
    private String DEPCODE;

    /**
     * 部门名称
     */
    private String DEPNAME;

    /**
     * 区域id
     */
    private Long REGIONID;

    /**
     * 区域编码
     */
    private String REGIONCODE;

    /**
     * 区域名称
     */
    private String REGIONNAME;

    /**
     * 性别（1 男  2 女）
     */
    private String GENDER;

    /**
     * 出生日期
     */
    private Date BIRTHDAY;

    /**
     * 身高
     */
    private Double HEIGTH;

    /**
     * 入职时间
     */
    private Date ENTERDATE;

    /**
     * 联系电话
     */
    private String PHONE;

    /**
     * 传真
     */
    private String FAX;

    /**
     * 电子邮箱
     */
    private String EMAIL;

    /**
     * 联系地址
     */
    private String ADDRESS;

    /**
     * 邮编
     */
    private String ZIPCODE;

    /**
     * 员工状态
     */
    private Integer STATE;

    /**
     * 学位
     */
    private String DEGREE;

    /**
     * 毕业学校
     */
    private String GRADUATESCHOOL;

    /**
     * 学历
     */
    private String EDUCATION;

    /**
     * 身份证号
     */
    private String IDCARD;

    /**
     * 创建人
     */
    private String CREATEUSER;

    /**
     * 创建时间
     */
    private Date CREATETIME;

    /**
     * 修改人
     */
    private String UPDATEUSER;

    /**
     * 修改时间
     */
    private Date UPDATETIME;

    /**
     * 备注
     */
    private String REMARK;

    /**
     * 员工工作状态1：在职 0：离职 2：退休
     */
    private Integer WORKCONDITION;

    /**
     * 职位
     */
    private String JOB;

    /**
     * 是否分配用户1：已分配 0：未分配
     */
    private Integer ISDISTRIBUTE;

    /**
     * 固定电话
     */
    private String TELEPHONE;

    /**
     * 人力地图上不显示的数据ID字符串
     */
    private String UNDISPLAYHUMANMAP;

    /**
     * 注册组织id
     */
    private Long REGID;

    /**
     *
     */
    private Integer DELSTATE;

    /**
     * 非公开范围模板
     */
    private Long TEMPLETID;

    /**
     *
     */
    private Long HREMPID;

    /**
     *
     */
    private Byte SOURCE;

    /**
     *
     */
    private String SIMPLECODE;

    /**
     *
     */
    private Long INSURANCEID;


    private Long USERID;

}
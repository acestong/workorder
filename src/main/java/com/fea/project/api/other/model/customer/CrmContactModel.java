package com.fea.project.api.other.model.customer;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/24.
 * 联系人基本信息表 实体类
 */
@Data
public class CrmContactModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 自增标识
     */
    private Long ID;

    /**
     * 组织注册编号
     */
    private Long REGID;

    /**
     *
     */
    private Long ORGID;

    /**
     * 客户编号
     */
    private Long CUSTOMERID;

    /**
     *
     */
    private String COMPANYNAME;

    /**
     * 姓名
     */
    private String CONTACTNAME;

    /**
     * 姓名首字母缩写
     */
    private String acronym;

    /**
     *
     */
    private String CODE;

    /**
     * 部门ID
     */
    private Long STRUCTUREID;

    /**
     * 部门名称
     */
    private String DEPARTMENTNAME;

    /**
     * 职位
     */
    private String POSITION;

    /**
     * 职责
     */
    private String DUTY;

    /**
     * 联系人级别ID
     */
    private Long LEVELID;

    /**
     * 联系人级别
     */
    private String CONTACTLEVEL;

    /**
     * 熟悉程度ID
     */
    private Long FAMILIARID;

    /**
     * 熟悉程度
     */
    private String FAMILIAR;

    /**
     * 关系ID
     */
    private Long RELATIONID;

    /**
     * 关系 {1普通联系人，2关键联系人，3决策联系人}
     */
    private String RELATION;

    /**
     * --------------------无用的字段20180419
     */
    private Integer INFOPERCENT;

    /**
     * 信息完整度
     */
    private Integer INFOINTEGRITY;

    /**
     * 信息完整度str
     */
    private String INFOINTEGRITYSTR;

    /**
     * 联系总次数
     */
    private Integer TOTALTIMES;

    /**
     * 当前负责人联系次数
     */
    private Integer CURMANTIMES;

    /**
     * 当前财年联系次数
     */
    private Integer CURYEARTIMES;

    /**
     * 联系人类型id：0、全部客户联系人 1、企业客户联系人 2、线索联系人 3、商务联系人4、其他（在桌面通讯录中新建）
     */
    private Integer CONTACTTYPEID;

    /**
     * 联系人类型
     */
    private Long CONTACTTYPE;

    /**
     * 是否决策联系人
     */
    private Integer ISDECISION;

    /**
     * 是否关键联系人
     */
    private Integer ISKEY;

    /**
     * 是否为签约联系人
     */
    private Integer ISSIGN;

    /**
     * 联系人当前财年销售机会次数
     */
    private Integer CURYEARCHANCES;

    /**
     * 联系人关联报价数
     */
    private Integer CURYEARQUOTES;

    /**
     * 联系人当前财年签约额
     */
    private Integer CURYEARSALES;

    /**
     * 负责人编号
     */
    private Long OWNERID;

    /**
     * 负责人
     */
    private String OWNER;

    /**
     * 创建人ID
     */
    private Long CREATEUSERID;

    /**
     * 创建人
     */
    private String CREATEUSER;

    /**
     * 创建时间
     */
    private Date CREATETIME;

    /**
     * 修改人ID
     */
    private Long UPDATEUSERID;

    /**
     * 修改人
     */
    private String UPDATEUSER;

    /**
     * 修改时间
     */
    private Date UPDATETIME;

    /**
     * 关注度
     */
    private Integer ATTENTIONNUM;

    /**
     * 办公电话类型ID
     */
    private Long TELTYPEID;

    /**
     * 办公电话类型
     */
    private String TELTYPE;

    /**
     * 办公电话
     */
    private String TEL;

    /**
     * 手机类型ID
     */
    private Long MOBILETYPEID;

    /**
     * 手机类型
     */
    private String MOBILETYPE;

    /**
     * 手机
     */
    private String MOBILE;

    /**
     * 邮箱类型ID
     */
    private Long EMAILTYPEID;

    /**
     * 邮箱类型
     */
    private String EMAILTYPE;

    /**
     * 邮箱
     */
    private String EMAIL;

    /**
     * 传真
     */
    private String FAX;

    /**
     *
     */
    private String WEIXIN;

    /**
     * 是否删除
     */
    private Integer DELSTATE;

    /**
     * 去电联系次数
     */
    private Integer CALLTIMES;

    /**
     * 来电联系次数
     */
    private Integer CALLBACKTIMES;

    /**
     * 发送邮件次数
     */
    private Integer SENDEMAILS;

    /**
     * 接收邮件次数
     */
    private Integer GETEMAILS;

    /**
     * 邮递资料次数
     */
    private Integer SENDPOSTS;

    /**
     * 接收邮递次数
     */
    private Integer GETPOSTS;

    /**
     * 外出拜访次数
     */
    private Integer OUTVISITTIMES;

    /**
     * 客户来访次数
     */
    private Integer COMEVISITTIMES;

    /**
     * 客户共计联系次数
     */
    private Integer RECORDTIMES;

    /**
     *
     */
    private String CREATERELATION;

    /**
     *
     */
    private String HELPDESC;

    /**
     * 关系类型--20171111因机会决策联系人统计添加-{合作多次,合作一次,未合作}-有新合作时需要更新
     */
    private String RELATIONSHIPTYPE;

    /**
     * 名片地址（专供名片使用）
     */
    private String CARDADDRESS;

    /**
     *
     */
    private Integer contactSourceTypeid;

    private Integer GENDER;

    private String CUSTOMERNAME;


}
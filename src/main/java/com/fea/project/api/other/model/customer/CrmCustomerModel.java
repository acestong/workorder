package com.fea.project.api.other.model.customer;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/24.
 * 客户表 实体类
 */
@Data
public class CrmCustomerModel implements Serializable {
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
     * 集团客户编号
     */
    private Long CUSTOMERGROUPID;

    /**
     * 客户名称
     */
    private String NAME;

    /**
     * 客户编码
     */
    private String CODE;

    /**
     * 客户业务类型（1：销售客户；2：线索客户；3：其他待定）
     */
    private Integer CUSTOMERBUSSTYPE;

    /**
     * 客户分类编号(1:企业客户，2：个人客户)
     */
    private Long CATEGORYID;

    /**
     * 客户级别编号
     */
    private Long GRADEID;

    /**
     * 客户级别
     */
    private String GRADE;

    /**
     * 所属行业编号
     */
    private String INDUSTRYID;

    /**
     * 所属行业
     */
    private String INDUSTRY;

    /**
     *
     */
    private String REGIONID;

    /**
     *
     */
    private String REGION;

    /**
     * 是否签约老客户 --- 暂时已不用该字段 20170830
     */
    private Integer ISSIGNING;

    /**
     * 历史签约额
     */
    private Double FOREHEADSIGNING;

    /**
     * 当前财年签约额
     */
    private Double FISCALSIGNING;

    /**
     * 当前财年销售机会数
     */
    private Integer FISCALOPPORTUNITY;

    /**
     * 当前财年客户总费用
     */
    private Double FISCALTOTALCOST;

    /**
     * 历史购买产品数
     */
    private Integer FOREHEADPRODUCT;

    /**
     * 信息完整度
     */
    private Integer INTEGRITY;

    /**
     *
     */
    private Integer INFOINTEGRITY;

    /**
     *
     */
    private String INFOINTEGRITYSTR;

    /**
     * 负责人编号
     */
    private Long OWNERID;

    /**
     * 负责人
     */
    private String OWNER;

    /**
     * 创建人id
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
     * 修改人id
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
     * 关注次数
     */
    private Integer ATTENTIONNUM;

    /**
     * 是否删除
     */
    private Integer DELSTATE;

    /**
     * 组织架构图
     */
    private String STRUCTUREIMAGE;

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
     * 是否公海客户
     */
    private Integer ISCOMMON;

    /**
     * 客户阶段id
     */
    private Long CUSTOMERPHASEID;

    /**
     * 转为公海客户时间
     */
    private Date ISCOMMONTIME;

    /**
     * 公海客户预计收回日期
     */
    private Date ISCOMMONBACKTIME;

    /**
     * 自定义扩展字段(表单)id
     */
    private Long FORMID;

    /**
     * 激活状态1激活2冻结
     */
    private Integer ACTIVESTATE;

    /**
     * 作废状态1:不作废2:作废
     */
    private Integer CANCELSTATE;

    /**
     * 原负责人id
     */
    private Long oldOwnerId;

    /**
     * 原客户负责人名称
     */
    private String oldOwnerName;

    /**
     * 转公海人id
     */
    private Long commonUserId;

    /**
     * 转公海人名称
     */
    private String commonUser;

    /**
     * 是否申请公海
     */
    private Integer isApplyCommon;

    /**
     * 转公海时存转机会公海id
     */
    private String salechanceIds;

    /**
     * 是否入池
     */
    private Integer ispool;

    /**
     * 是否展示
     */
    private Integer isShow;

    /**
     * 分配负责人id
     */
    private Long distributeOwnerId;

    /**
     * 分配负责人名称
     */
    private String distributeOwner;

    /**
     * 分配时间
     */
    private Date distributeTime;

    /**
     * 分配状态 0 未分配 1已分配
     */
    private Integer distributeStatus;

    /**
     * 申领人名称
     */
    private String receiver;

    /**
     * 申领人id
     */
    private Long receiverId;

    /**
     * 申领时间
     */
    private Date receiveTime;

    /**
     * 申领状态 为空为申领 不为空 已申领，申领中
     */
    private Integer commonApplyState;

    /**
     * 扩展字段
     */
    private String fieldExt;

}
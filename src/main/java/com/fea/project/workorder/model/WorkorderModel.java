package com.fea.project.workorder.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工单Model
 * @author st
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkorderModel implements Serializable {
	/**
	 * 主键id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workorderId;

    /**
     * 任务id，预留
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskId;

    /**
     * 任务名称，预留
     */
    private String taskName;

    /**
     * 工单名称
     */
    private String workorderName;

    /**
     * 工单编号
     */
    private String workorderNum;

    /**
     * 工单来源类型
     */
    private Long workorderResourceType;

    /**
     * 工单类型
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workorderTypeId;

    /**
     * 工单模板id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long mouldId;

    /**
     * 工单模板名
     */
    private String mouldName;

    /**
     * 期待完成时间
     */
    private Date wishDealTime;

    /**
     * 截止完成时间
     */
    private Date deadlineTime;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 工单工时
     */
    private Double workHour;

    /**
     * 优先级
     */
    private Long priority;

    /**
     * 负责人或提交人类型
     */
    private Long switchPerson;

    /**
     * 此字段存放的是emp中的员工Id，非user表中的userId
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long personId;

    /**
     * 员工名
     */
    private String personName;
    
    /**
     * 被工单池拦截自动分配时会记录工单池的id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long dispatchPoolId;
    
    /**
     * 记录分配人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long dispatchId;
    
    /**
     * 记录分配人名称
     */
    private String dispatchBy;
    
    /**
     * 记录工单分配时间
     */
    private Date dispatchTime;

    /**
     * 客户id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long customerId;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 联系人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long contactId;

    /**
     * 联系人名称
     */
    private String contactName;

    /**
     * 关联业务类型
     */
    private Long businessType;

    /**
     * 关联业务id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessId;

    /**
     * 关联业务名称
     */
    private String businessName;

    /**
     * 关联产品id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long productId;

    /**
     * 关联产品名称
     */
    private String productName;

    /**
     * 产品问题类型id,产品库未完成，2020/03/27需求改为页面输入
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String productTroubleTypeId;

    /**
     * 产品问题分配id,产品库未完成，2020/03/27需求改为页面输入
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String productTroubleSortId;

    /**
     * 工单内容
     */
    private String workorderContent;

    /**
     * 工单说明
     */
    private String remark;

    /**
     * 工单状态
     */
    private Long workorderStatus;

    /**
     * 拒绝原因
     */
    private String rejectReason;

    /**
     * 工单进度
     */
    private Double workorderProgrossRate;

    /**
     * 关注状态，此状态不用传值进数据库，仅作显示，数据来源是t_workorder_attention中的关注状态
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long attentionStatus;
    
    /**
     * 组织id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orgId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    private String createBy;

    private Date createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    private String updateBy;

    private Date updateTime;

    private Long delStatus;

    private static final long serialVersionUID = 1L;


}
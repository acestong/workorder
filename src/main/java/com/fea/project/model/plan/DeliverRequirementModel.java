package com.fea.project.model.plan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.base.AppendixModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *  交付要求模型
 * @author st
 * @since 2019/10/31 11:25
 *
 */
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class DeliverRequirementModel implements Serializable {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planDeliverRequirementId;

    /*
     * 交付要求名
     */
    private String planDeliverRequirementName;


    /*
     * 交付要求时间
     */
    private Date planDeliverRequirementTime;

    /*
     * 交付要求描述
     */
    private String planDeliverRequirementDesc;

    /*
     * 交付要求附件id
     */
    private Long planDeliverRequirementAppendixId;

    /*
     * 交付要求附件类，一个交付要求附件可以对应多个附件（数据库外键关系）
     */
    private List<AppendixModel> appendixList;
    
	/*
	*计划id，外键
	*/
    @JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long planId;
	
	/*
	 * 存放计划一对多模型
	 */
	private PlanModel planModel;
    /*
     * 创建人id
     */
	 @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    /*
     * 创建人
     */	
    private String createBy;

    /*
     * 创建时间
     */
    private Date createTime;

    /*
     * 更新人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    /*
     * 更新人
     */
    private String updateBy;

    /*
     * 更新时间
     */
    private Date updateTime;

    /*
     * 删除状态，使用枚举类型 DeleteStatusEnum.java
   * NOT_DELETE(0, "未删除"),
   * DELETE(1, "删除");
     */
    private Long delStatus;
    

    private static final long serialVersionUID = 1L;

}
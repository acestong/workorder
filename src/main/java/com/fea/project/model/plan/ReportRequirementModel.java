package com.fea.project.model.plan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.base.AppendixModel;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 汇报要求模型ReportRequirementModel
 * @author st
 * @since 2019/10/31 15:15
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ReportRequirementModel implements Serializable {
	/*
	 * 汇报要求id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planReportRequirementId;
  
    /*
     * 汇报要求主题
     */
    private String planReportRequirementTheme;

    /*
     * 汇报时间
     */
    private Date planReportRequirementTime;

    /*
     * 汇报方式，取值为枚举类型，取值为书面汇报，当面汇报，会议汇报，电话汇报，邮件汇报
     */
    private Long planReportRequirementMethod;

    /*
     * 汇报要求
     */
    private String planReportRequirement;

    /*
     * 汇报要求附件id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planReportAppendixId;

    /*
     * 汇报要求附件集合，其中一个汇报要求可以有多个附件集合
     */
    private List<AppendixModel> appendixModel;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long planId;
    
    /*
	 * 存放一对多计划模型
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
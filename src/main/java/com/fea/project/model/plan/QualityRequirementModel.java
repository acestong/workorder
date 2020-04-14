package com.fea.project.model.plan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.base.AppendixModel;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*
 * 质量要求模型QualityRequirementModel
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class QualityRequirementModel implements Serializable {
	/*
	 * 质量要求id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planQualityRequirementId;

    /* 
     * 质量要求名称 
     */
    private String planQualityRequirementName;

    /*
     * 质量要求内容
     */
    private String planQualityRequirementContent;

    /*
     * 质量要求附件id
     */
    private Long planQualityAppendixId;


    /*
     * 质量要求附件集合，一个质量要求附件可以有多个附件
     */
    private List<AppendixModel> appendixList;
    
	private Long planId;
	
	/*
	 * 存放一对多计划模型
	 */
	private PlanModel planModel;
	
	
    /*
     * 创建人id
     */
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
     * 修改人id
     */
    private Long updateId;

    /*
     * 修改人
     */
    private String updateBy;

    /*
     * 修改时间
     */
    private Date updateTime;

    /*
     * 删除状态
     */
    private Long delStatus;

    private static final long serialVersionUID = 1L;

   
}
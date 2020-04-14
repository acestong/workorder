package com.fea.project.model.plan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.team.ProjectTeamModel;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 关联计划模型
 * @author st
 * @since 2019/10/31 14:23
 * 
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PlanAssociationModel implements Serializable {
	/*
	 * 关联计划id，数据库insert时自动获取主键值
	 */ 
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planAssociationId;

	private String planAssociationName;

    /*
     * 关联计划所属阶段
     */
    private Long planStep;


    /*
     * 关联计划优先级
     */
    private Long planPority;

    /*
     * 关联计划状态
     */
    private Long planExecutionStatus;

    /*
     * 关联计划所属关系
     */
    private Long planRelationship;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long planId;
	
	/*
	 * 存放一对多计划模型
	 */
	private PlanModel planModel;
	
    /*
     * 关联计划负责人id
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planLeaderId;

    /*
     * 所属团队id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planTeamId;

    /*
     * 存放项目团队对象ProjectTeamModel，一个关联计划只能有一个所属团队及其负责人
     */
    private ProjectTeamModel projectTeamModel;
    
    /*
     * 计划开始时间
     */
    private Date planStarttime;

    /*
     * 计划结束时间
     */
    private Date planEndtime;

    /*
     * 计划工时
     */
    private Long planWorkingHour;

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
     * 修改人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;
	
	/*
	*修改人
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
package com.fea.project.model.plan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.base.AppendixModel;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 计划附件模型
 * @author st
 * @since 2019/10/31 12:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class PlanAppendixModel implements Serializable {
	/* 
	 * 计划附件id，由MybatisPrimaryKeyAutoCreatePlugin.java自动生成主键id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessAppendixId;
	 
	private String businessAppendixName;

    /*
     * 附件类型为枚举类，取值为其他、PPT、ZIP、图片、Word、PDF、Excel
     */
    private Long businessAppendixType;

    /*
     * 计划类型描述
     */
    private String businessAppendixDesc;

    /*
     * 类型附件id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long appendixId;

    /*
     * 存放计划类型的附件，计划类型附件可以有多个附件，因此类需要通用，businessId修改为存放业务Id
     */
    private List<AppendixModel> appendixList;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long businessId;
	
    /*
     * 存放业务名称
     */
    private String businessName;
    
    /*
     * 存放项目Id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;
    
    /*
     * 存放业务类型
     */
    private Long businessType;
	
    /*
     * 计划类型创建人id
     */
	 @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    /*
     * 计划类型创建人
     */
    private String createBy;

    /*
     * 计划类型创建时间
     */
    private Date createTime;


    /*
     * 计划类型更新人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    /*
     * 计划类型更新人
     */
    private String updateBy;

    /*
     * 计划类型更新时间
     */
    private Date updateTime;

    /*
     * 计划类型删除状态。使用枚举类型 DeleteStatusEnum.java
   * NOT_DELETE(0, "未删除"),
   * DELETE(1, "删除");
     */
    private Long delStatus;
    
    private Long projectStep;

    private static final long serialVersionUID = 1L;

}
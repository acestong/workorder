package com.fea.project.workorder.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.workorder.enums.DeleteStatusEnum;
import com.fea.project.workorder.enums.InsertOrUpdateEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 设置权重model
 * @author st
 * @since 2020/03/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentWeightModel implements Serializable {
	/**
	 * 权重id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long commentWeightId;
    
    /**
     * 组织id
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orgId;

    /**
     * 质量权重
     */
    private Double qualityWeight;

    /**
     * 时间权重
     */
    private Double timeWeight;

    /**
     * 满意度
     */
    private Double satisfyWeight;

    /**
     * 创建人权重
     */
    private Double createIdWeight;

    /**
     * 直属上级权重
     */
    private Double superiorIdWeight;

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

   public CommentWeightModel(SysUserModel currentUsr ,InsertOrUpdateEnum e) {
	   this.orgId = currentUsr.getOrgId();
	   this.qualityWeight = 0.3d;
	   this.timeWeight = 0.3d;
	   this.satisfyWeight = 0.4d;
	   this.createIdWeight = 0.5d;
	   this.superiorIdWeight = 0.5d;
	   this.delStatus = DeleteStatusEnum.NOT_DELETE.getStatus().longValue();
	   if(e == InsertOrUpdateEnum.INSERT) {
		   this.createId = currentUsr.getUserId();
		   this.createBy = currentUsr.getRealName();
		   this.createTime = new Date();
	   }
	   if(e == InsertOrUpdateEnum.UPDATE) {
		   this.updateId = currentUsr.getUserId();
		   this.updateBy = currentUsr.getRealName();
		   this.updateTime = new Date();
	   }
   }
}
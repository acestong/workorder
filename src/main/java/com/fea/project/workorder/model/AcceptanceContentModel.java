package com.fea.project.workorder.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AcceptanceContentModel implements Serializable {
	/*
	 * 验收内容id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long acceptanceContentId;

    /*
     * 验收内容（名称）
     */
    private String content;
    
    /*
     * 单位  来源枚举com.fea.project.workorder.enums.UnitEnum
     */
    private Long unit;

    /*
     * 数量
     */
    private Long countNum;

    /*
     * 验收结论 来源枚举com.fea.project.workorder.enums.ConclusionEnum
     */
    private Long conclusion;

    /*
     * 验收意见
     */
    private String opinion;

    /*
     * 验收id，外键列com.fea.project.workorder.model.AcceptanceModel::getAcceptanceId
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long acceptanceId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    private String createBy;

    private Date createTime;

    private static final long serialVersionUID = 1L;

}
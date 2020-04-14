package com.fea.project.workorder.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工单验收model
 * @author st
 * @since 2020/03/23
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcceptanceModel implements Serializable {
	/**
	 * 主键id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long acceptanceId;

    /**
     * 工单id
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workorderId;

    /**
     * 验收人id
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long personId;

    /**
     * 验收人名称
     */
    private String personName;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String county;

    /**详细地址
     * 
     */
    private String location;

    /**
     * 结论
     */
    private Long conclusion;

    /**
     * 意见
     */
    private String opinion;
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
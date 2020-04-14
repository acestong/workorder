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
public class AcceptanceFileModel implements Serializable {
	/*
	 * 验收文件id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long acceptanceFileId;

    /*
     * 文件名称
     */
    private String name;

    /*
     * 文件说明
     */
    private String fileDesc;

    /*
     * 验收文件id 来源com.fea.project.workorder.model.AcceptanceModel::getAcceptanceId
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long acceptanceId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    private String createBy;

    private Date createTime;

    private static final long serialVersionUID = 1L;

}
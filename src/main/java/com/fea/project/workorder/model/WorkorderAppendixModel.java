package com.fea.project.workorder.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 工单附件Model
 * @author st
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class WorkorderAppendixModel implements Serializable {
	
	/*
	 * 工单附件id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /*
     * 工单附件名称
     */
    private String name;

    /*
     * 工单附件类型
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long type;

    /*
     * 工单附件说明
     */
    private String desc;

    private static final long serialVersionUID = 1L;
}
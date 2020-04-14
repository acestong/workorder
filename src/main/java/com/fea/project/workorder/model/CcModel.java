package com.fea.project.workorder.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 抄送Model
 * @author st
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CcModel implements Serializable {
	/*
	 * 抄送id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long ccId;

    /*
     * 工单id
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workorderId;

    /*
     * 抄送人id
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long ccPersonId;
    
    /*
     * 抄送人姓名
     */
    private String ccPersonName;
    
    
    private static final long serialVersionUID = 1L;
}
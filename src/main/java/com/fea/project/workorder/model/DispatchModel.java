package com.fea.project.workorder.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 分配Model
 * @author st
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DispatchModel implements Serializable {
	/*
	 * 分配id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long dispatchId;

    /*
     * 工单id
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workorderId;

    /*
     * 分配人id
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long dispatcherId;

    /*
     * 被分配人id
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long dispatchUserId;

    /*
     * 分配时间
     */
    private Date dispatchTime;

    private static final long serialVersionUID = 1L;

}
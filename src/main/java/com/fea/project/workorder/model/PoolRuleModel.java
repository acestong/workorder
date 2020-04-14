package com.fea.project.workorder.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 工单池入池规则Model
 * @author st
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PoolRuleModel implements Serializable {
	/*
	 * 工单入池规则id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long poolRuleId;

    /*
     * 工单池id （pool与poolRule为1对多关系）
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workorderPoolId;

    /*
     * 字段名称
     */
    private String fieldName;

    /*
     * 规律操作符 <,<=,>,>=,=,!=,like....
     */
    private String filterRule;

    /*
     * 过滤值
     */
    private String filterValue;

    /*
     * 连接符 and or ...
     */
    private String connector;

    private static final long serialVersionUID = 1L;

}
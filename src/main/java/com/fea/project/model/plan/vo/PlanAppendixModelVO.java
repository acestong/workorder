package com.fea.project.model.plan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

public class PlanAppendixModelVO<T> {

	private T model;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<Long> appendixIds; 
}

package com.fea.project.model.task.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.BasePageInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TaskBasePageInfo<T> extends BasePageInfo<T>{

	private BasePageInfoWithCount<T> page;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Integer type;
	
	
	
	
}
 
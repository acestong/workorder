package com.fea.project.model.task.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TaskCountInfoVo {

	private Long count;
	private String info;
	private Long type;
}

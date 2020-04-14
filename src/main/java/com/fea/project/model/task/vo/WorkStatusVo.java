package com.fea.project.model.task.vo;

import lombok.Data;

import java.util.Date;

@Data
public class WorkStatusVo {

	private Long workStatus;
	private Date taskStartTime;
	private Date taskEndTime;
	private Long workHour;
}

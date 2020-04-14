package com.fea.project.model.plan.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectTreeModelVo implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long id;
	private String label;
	private Long tag;
	private String job;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long leaderId;
	private List<ProjectTreeModelVo> children;
	private ProjectTreeModelVo leader;
	private Long gender;
}

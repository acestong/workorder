package com.fea.project.api.other.model.base.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 员工职位树型列表Model
 * @author st
 * @since 2020/03/12 9:41
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpTreeModelVo {

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long jobId;
	private String label;
	private Long gender;
	private String genderStr;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long userId;
	private String userName;
	private List<EmpTreeModelVo> children;
}

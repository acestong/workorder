package com.fea.project.model.user.vo;

import lombok.Data;

import java.util.List;

@Data
public class UserWithJobVo {

	private Long userId;
	private String userName;
	private Long jobId;
	private String jobName;
	private Long gender;
	private String genderStr;
	private Long parentJobId;
	private List<UserWithJobVo> children;
}

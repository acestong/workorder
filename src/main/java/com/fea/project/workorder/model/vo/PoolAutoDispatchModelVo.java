package com.fea.project.workorder.model.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.workorder.model.PoolAutoDispatchModel;
import com.fea.project.workorder.model.PoolDispatchUserModel;

import lombok.Data;

@Data
public class PoolAutoDispatchModelVo extends PoolAutoDispatchModel {
	
	private static final long serialVersionUID = 1L;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<PoolDispatchUserModel> dispatchUserList;
}

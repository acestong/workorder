package com.fea.project.model.task.vo;

import java.util.List;

import com.fea.project.model.plan.vo.AppendixIdAndNameInfoModelVo;
import com.fea.project.model.task.TaskDeliverProductModel;
import lombok.Data;

@Data
public class TaskDeliverProductModelVo extends TaskDeliverProductModel {
	private static final long serialVersionUID = 1L;

	private List<AppendixIdAndNameInfoModelVo> appendixInfoList;

}

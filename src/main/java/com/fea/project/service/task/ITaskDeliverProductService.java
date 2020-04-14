package com.fea.project.service.task;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.deliverable.vo.ProjectDeliverableVo;
import com.fea.project.model.task.TaskDeliverProductModel;
import com.fea.project.model.task.vo.TaskDeliverProductModelVo;

import java.util.List;
import java.util.Map;

public interface ITaskDeliverProductService {

	void save(TaskDeliverProductModel taskDeliverProductModel ,List<Long> appendixIds);
	void delete(TaskDeliverProductModel taskDeliverProductModel);
	void update(TaskDeliverProductModel taskDeliverProductModel);
	Map<String,Object> getAll(BasePageInfo<TaskDeliverProductModel> page);
	List<TaskDeliverProductModel> getAll(Long taskId);
	TaskDeliverProductModelVo getOne(Long deliverProductId,Long taskId);
	/**
	 *	根据主键获取
	 *@return ProjectDeliverableVo 通用项目交付物
	 */
	ProjectDeliverableVo selectTaskDeliverableInfoById(Long id);
	/**
	 * 提交审核
	 */
	TaskDeliverProductModel verifyTaskDeliverable(TaskDeliverProductModel model);
}
 
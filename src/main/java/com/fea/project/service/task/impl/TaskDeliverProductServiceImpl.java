package com.fea.project.service.task.impl;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.task.TaskDeliverProductModelMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.deliverable.vo.ProjectDeliverableVo;
import com.fea.project.model.task.TaskDeliverProductModel;
import com.fea.project.model.task.TaskDeliverProductModelExample;
import com.fea.project.model.task.vo.TaskDeliverProductModelVo;
import com.fea.project.model.task.vo.UpdateBusinessIdInProjectAppendixModelVo;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.service.apply.io.IProjectApplyBusiness;
import com.fea.project.service.businessflow.flowtype.ProjectBusinessTaskDeliverableApplyImplService;
import com.fea.project.service.task.ITaskDeliverProductService;
import com.fea.project.util.TaskDeliverProductNumUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskDeliverProductServiceImpl implements ITaskDeliverProductService, IProjectApplyBusiness {

	@Resource
	private TaskDeliverProductModelMapper mapper;
	
	@Resource
	private SysUserService sysUserService;
	
	@Resource
	private ProjectAppendixService projectAppendixService;

	/**
	 * 工作流审批相关
	 */
	@Autowired
	private ProjectBusinessTaskDeliverableApplyImplService taskDeliverableApplyImplService;
	/*
	 * 新增设计 
	 */
	@Override
	public synchronized void save(TaskDeliverProductModel taskDeliverProductModel,List<Long> appendixIds) {
		// TODO Auto-generated method stub
		if ( taskDeliverProductModel == null || appendixIds ==null) {
            throw new SystemParamCheckException("交付物模型传入为空，无法进行新增");
        }
		taskDeliverProductModel.setDeliverProductNum("JFW"+new Date());
		taskDeliverProductModel.setCreateBy(sysUserService.getCurrentUsr().getRealName());
		taskDeliverProductModel.setCreateId(sysUserService.getCurrentUsr().getUserId());
		taskDeliverProductModel.setCreateTime(new Date());
		taskDeliverProductModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		//生成交付物编号
		taskDeliverProductModel.setDeliverProductNum(TaskDeliverProductNumUtil.getNum());
		/*
		 * 默认初始值
		 */
		taskDeliverProductModel.setTaskDeliverStatus(0L);
		taskDeliverProductModel.setTaskDeliverTime(new Date());
		taskDeliverProductModel.setTaskDelivererId(sysUserService.getCurrentUsr().getUserId());
		taskDeliverProductModel.setTaskDelivererName(sysUserService.getCurrentUsr().getRealName());
		
		mapper.insert(taskDeliverProductModel);
		UpdateBusinessIdInProjectAppendixModelVo<TaskDeliverProductModel> modelVo = new UpdateBusinessIdInProjectAppendixModelVo<TaskDeliverProductModel>();
		for (Long appendixId : appendixIds) {
			modelVo.setAppendixId(appendixId);
			modelVo.setDeliverProductId(taskDeliverProductModel.getDeliverProductId());
			mapper.updateBusinessIdInTProjectAppendix(modelVo);
		}
	}

	/*
	 * 假删除
	 */
	@Override
	public void delete(TaskDeliverProductModel taskDeliverProductModel) {
		// TODO Auto-generated method stub
		if ( taskDeliverProductModel.getDeliverProductId()==null) {
            throw new SystemParamCheckException("传入参数异常，无法进行删除");
        }
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		taskDeliverProductModel = mapper.selectByPrimaryKeyWithDelStatus(taskDeliverProductModel);
		taskDeliverProductModel.setUpdateBy(currentUsr.getRealName());
		taskDeliverProductModel.setUpdateId(currentUsr.getUserId());
		taskDeliverProductModel.setUpdateTime(new Date());
		taskDeliverProductModel.setDelStatus(DeleteStatusEnum.DELETE.getStatus().longValue());
		mapper.updateByPrimaryKeySelectiveWithDelStatus(taskDeliverProductModel);
	}

	@Override
	public void update(TaskDeliverProductModel taskDeliverProductModel) {
		// TODO Auto-generated method stub
		if ( taskDeliverProductModel == null || taskDeliverProductModel.getDeliverProductId()==null) {
            throw new SystemParamCheckException("评论id或模型传入为空，无法进行修改");
        }
		taskDeliverProductModel.setUpdateBy(sysUserService.getCurrentUsr().getRealName());
		taskDeliverProductModel.setUpdateId(sysUserService.getCurrentUsr().getUserId());
		taskDeliverProductModel.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelective(taskDeliverProductModel);
	}

	

	@Override
	public TaskDeliverProductModelVo getOne(Long deliverProductId, Long taskId) {
		// TODO Auto-generated method stub
		if ( deliverProductId == null ) {
            throw new SystemParamCheckException("传入参数异常，无法进行查询");
        }
		TaskDeliverProductModel taskDeliverProductModel = new TaskDeliverProductModel();
		taskDeliverProductModel.setTaskId(taskId);
		taskDeliverProductModel.setDeliverProductId(deliverProductId);
		TaskDeliverProductModelVo modelVo = mapper.selectByPrimaryKeyWithDelStatus(taskDeliverProductModel);
		modelVo.setAppendixInfoList(projectAppendixService.selectIdAndNameByBusiness(deliverProductId));
		return modelVo;
	}

	@Override
	public Map<String,Object> getAll(BasePageInfo<TaskDeliverProductModel> page) {
		// TODO Auto-generated method stub
		if ( page == null || page.getModel() == null || page.getModel().getTaskId() ==null) {
            throw new SystemParamCheckException("传入参数异常，无法进行查询");
        }
		PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
		Map<String,Object> map = new HashMap<>();
		List<TaskDeliverProductModel> selectAllWithDelStatusWithPage = mapper.selectAllWithDelStatusWithPage(page);
		map.put("test", new BasePageInfo<>(selectAllWithDelStatusWithPage));
		return map;
	}

	@Override
	public List<TaskDeliverProductModel> getAll(Long taskId) {
		// TODO Auto-generated method stub
		if ( taskId==null) {
            throw new SystemParamCheckException("传入参数异常，无法进行查询");
        }
		return mapper.selectAllWithDelStatus(taskId);
	}
	@Override
	public ProjectDeliverableVo selectTaskDeliverableInfoById(Long id){
		ProjectDeliverableVo deliverableVo = mapper.selectTaskDeliverableInfoById(id);
		return deliverableVo;
	}
	/**
	 * 提交审批
	 */
	@Override
	public TaskDeliverProductModel verifyTaskDeliverable(TaskDeliverProductModel model) {
		//检查提交状态
		TaskDeliverProductModel taskDeliverProductModel = mapper.selectByPrimaryKey(model.getDeliverProductId());
		if (!ProjectApplyVerifyStatusEnum.getCanSubmitStatus().contains(taskDeliverProductModel.getTaskDeliverStatus()==null?ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getValue():taskDeliverProductModel.getTaskDeliverStatus().intValue())){
			throw new SystemParamCheckException("当前状态无法再次提交审批");
		}
		taskDeliverProductModel.setTaskDeliverStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue().longValue());
		if (this.taskDeliverableApplyImplService.createApplyInfo(taskDeliverProductModel)
				&& this.mapper.updateByPrimaryKeySelective(taskDeliverProductModel) >= 0) {
			return model;
		}
		throw new SystemParamCheckException("项目提交审核异常，无法进行提交");
	}

	@Override
	public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
		TaskDeliverProductModelExample example = new TaskDeliverProductModelExample();
		example.createCriteria().andDeliverProductIdIn(ids);
		List<TaskDeliverProductModel> list = mapper.selectByExample(example);
		return list.stream().collect(Collectors.toMap(TaskDeliverProductModel::getDeliverProductId,
				TaskDeliverProductModel::getDeliverProductName));
	}
}

package com.fea.project.workorder.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.workorder.dao.WorkorderTypeModelMapper;
import com.fea.project.workorder.enums.DeleteStatusEnum;
import com.fea.project.workorder.model.WorkorderTypeModel;
import com.fea.project.workorder.model.vo.TypeModelVo;
import com.fea.project.workorder.service.IWorkorderTypeService;

/**
 * 工单类型
 * @author st
 * @since 2020/03/27
 *
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class WorkorderTypeServiceImpl implements IWorkorderTypeService{

	@Resource
	private WorkorderTypeModelMapper mapper;
	@Resource
	private SysUserService sysUserService;
	
	/**
	 * 新增工单类型
	 */
	@Override
	@Transactional
	public Integer insert(WorkorderTypeModel model) {
		// TODO Auto-generated method stub
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
			model.setCreateBy(currentUsr.getRealName());
			model.setCreateId(currentUsr.getUserId());
			model.setCreateTime(new Date());
			model.setOrgId(currentUsr.getOrgId());
			model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		return mapper.insertSelective(model);
	}

	/**
     * 获取树型类型结构
     * @param orgId
     * @return
     */
	@Override
	@Transactional
	public List<TypeModelVo> selectRootTypeListByorgId() {
		// TODO Auto-generated method stub
		return mapper.selectRootTypeListByorgId(sysUserService.getCurrentUsr().getOrgId());
	}

}

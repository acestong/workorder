package com.fea.project.workorder.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.workorder.dao.PoolModelMapper;
import com.fea.project.workorder.model.PoolModel;
import com.fea.project.workorder.model.vo.IdAndNameModelVo;
import com.fea.project.workorder.model.vo.PoolModelVo;
import com.fea.project.workorder.service.IPoolAutoDispatchService;
import com.fea.project.workorder.service.IPoolRuleService;
import com.fea.project.workorder.service.IPoolService;
import com.fea.project.workorder.service.IVisiblePersonService;

/**
 * 工单池Service
 * @author st
 * @since 2020/03/18
 *
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class PoolServiceImpl implements IPoolService {

	@Resource
	private PoolModelMapper mapper;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private IPoolRuleService poolRuleService;
	@Resource
	private IPoolAutoDispatchService poolAutoDispatchService;
	@Resource
	private IVisiblePersonService visblePersonService;
	
	/**
	 * 新增一个工单池
	 */
	@Override
	@Transactional
	public Integer insert(PoolModelVo poolModelVo) {
		// TODO Auto-generated method stub
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		poolModelVo.setCreateBy(currentUsr.getRealName());
		poolModelVo.setCreateId(currentUsr.getUserId());
		poolModelVo.setCreateTime(new Date());
		poolModelVo.setOrgId(currentUsr.getOrgId());
		int insert = mapper.insert(poolModelVo);
		if(poolModelVo.getRuleList() != null) {
			//添加入池规则
			poolRuleService.insertList(poolModelVo.getWorkorderPoolId(), poolModelVo.getRuleList());
		}
		if(poolModelVo.getDispatchList() != null) {
			//添加自动分配规则
			poolAutoDispatchService.insertByList(poolModelVo.getWorkorderPoolId(), poolModelVo.getDispatchList());
		}
		if(poolModelVo.getVisiblePersonList() != null) {
			visblePersonService.insertByList(poolModelVo.getWorkorderPoolId(), poolModelVo.getVisiblePersonList());
		}
		return insert;
	}

	
	/**
	 * 通过orgId获取工单池列表
	 */
	@Override
	@Transactional
	public List<PoolModel> selectListByOrgId() {
		// TODO Auto-generated method stub
		return mapper.selectListByOrgId(sysUserService.getCurrentUsr().getOrgId());
	}


	/**
     * 通过组织Id获取工单池Id和name集合
     * @return
     */
	@Override
	@Transactional
	public List<IdAndNameModelVo> selectIdAndNameListByOrgId() {
		// TODO Auto-generated method stub
		return mapper.selectIdAndNameListByOrgId(sysUserService.getCurrentUsr().getOrgId());
	}

}

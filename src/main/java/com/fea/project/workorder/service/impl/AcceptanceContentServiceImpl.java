package com.fea.project.workorder.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.workorder.dao.AcceptanceContentModelMapper;
import com.fea.project.workorder.enums.ConclusionEnum;
import com.fea.project.workorder.enums.UnitEnum;
import com.fea.project.workorder.model.AcceptanceContentModel;
import com.fea.project.workorder.model.vo.AcceptanceContentModelVo;
import com.fea.project.workorder.service.IAcceptanceContentService;

/**
 * 工单验收内容service
 * @author st
 * @since 2020/03/24
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class AcceptanceContentServiceImpl implements IAcceptanceContentService {

	@Resource
	private AcceptanceContentModelMapper mapper;
	@Resource
	private SysUserService sysUserService;
	
	/**
	 * 新增
	 */
	@Override
	@Transactional
	public Integer insert(AcceptanceContentModel model) {
		// TODO Auto-generated method stub
		if(model == null) {
			return null;
		}
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		model.setCreateId(currentUsr.getUserId());
		model.setCreateBy(currentUsr.getRealName());
		model.setCreateTime(new Date());
		return mapper.insertSelective(model);
	}

	/**
	 * 通过验收id获取验收内容列表
	 */
	@Override
	@Transactional(readOnly = true)
	public List<AcceptanceContentModelVo> selectListByAcceptanceId(Long acceptanceId) {
		// TODO Auto-generated method stub
		List<AcceptanceContentModelVo> list = mapper.selectListByAcceptanceId(acceptanceId);
		list.stream().forEach(modelVo->{
			modelVo.setUnitStr(UnitEnum.getValue(modelVo.getUnit().intValue()));
			modelVo.setConclusionStr(ConclusionEnum.getValue(modelVo.getConclusion().intValue()));
		});
		return list;
	}

}

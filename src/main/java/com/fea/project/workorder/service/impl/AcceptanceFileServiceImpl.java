package com.fea.project.workorder.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.model.plan.vo.AppendixIdAndNameInfoModelVo;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.workorder.dao.AcceptanceFileModelMapper;
import com.fea.project.workorder.model.vo.AcceptanceFileModelVo;
import com.fea.project.workorder.service.IAcceptanceFileService;

/**
 * 验收文件Service
 * @author st
 * @since 2020/03/24
 *
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class AcceptanceFileServiceImpl implements IAcceptanceFileService {

	@Resource
	private AcceptanceFileModelMapper mapper;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private ProjectAppendixService projectAppendixService;
	
	/**
	 * 新增
	 */
	@Override
	@Transactional
	public Integer insert(AcceptanceFileModelVo modelVo) {
		// TODO Auto-generated method stub
		if(modelVo == null) {
			return null;
		}
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		modelVo.setCreateBy(currentUsr.getRealName());
		modelVo.setCreateId(currentUsr.getUserId());
		modelVo.setCreateTime(new Date());
		int insertSelective = mapper.insertSelective(modelVo);
			if(modelVo.getAppendixList() != null) {
				projectAppendixService.updateByBusinessIdAndIds(modelVo.getAcceptanceFileId(), modelVo.getAppendixList());
			}
		return insertSelective;
	}

	/**
	 * 按验收id获取验收文件id
	 */
	@Override
	@Transactional(readOnly = true)
	public List<AcceptanceFileModelVo> selectListByAcceptanceId(Long acceptanceId) {
		// TODO Auto-generated method stub
		List<AcceptanceFileModelVo> list = mapper.selectByAcceptanceId(acceptanceId);
		list.stream().forEach(modelVo->{
			modelVo.setAppendixInfoList(projectAppendixService.selectIdAndNameByBusiness(modelVo.getAcceptanceFileId()));
		});
		return list ; 
	}

}

package com.fea.project.workorder.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.workorder.dao.CcModelMapper;
import com.fea.project.workorder.model.CcModel;
import com.fea.project.workorder.model.vo.PersonInfoModelVo;
import com.fea.project.workorder.service.ICcService;

@Service(version = "1.0.0",timeout = 6000)
@Component
public class CcServiceImpl implements ICcService {

	@Resource
	private CcModelMapper mapper;
	
	/**
	 * 批量插入抄送人model
	 */
	@Override
	@Transactional
	public  void insertList(List<CcModel> list) {
		// TODO Auto-generated method stub
		if(list.size()>0) {
			Integer insert = mapper.insertList(list);
			ArrayList<Long> arrayList = new ArrayList<>();
			if(insert != null ) {
				list.stream().forEach(model->arrayList.add(model.getCcId()));
			}
		}
	}

	/**
	 * 通过workorderId 获取抄送人列表
	 */
	@Override
	@Transactional(readOnly = true)
	public List<PersonInfoModelVo> selectCCPerson(Long workorderId) {
		// TODO Auto-generated method stub
		return workorderId == null ? new ArrayList<PersonInfoModelVo>() : mapper.selectCCPerson(workorderId);
	}

	/**
	 * 通过工单Id删除抄送人
	 */
	@Override
	@Transactional
	public Integer deleteByBusinessId(Long workorderId) {
		// TODO Auto-generated method stub
		return workorderId == null ? null : mapper.deleteByBusinessId(workorderId);
	}

}

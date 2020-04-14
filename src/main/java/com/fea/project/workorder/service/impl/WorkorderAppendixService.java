package com.fea.project.workorder.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.workorder.model.vo.PersonInfoModelVo;
import com.fea.project.workorder.service.IWorkorderAppendixService;

@Service(version = "1.0.0",timeout = 6000)
@Component
public class WorkorderAppendixService implements IWorkorderAppendixService {

	@Override
	@Transactional
	public PersonInfoModelVo selectAppendixInfo(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.fea.project.workorder.service;

import com.fea.project.workorder.model.vo.PersonInfoModelVo;

public interface IWorkorderAppendixService {

	PersonInfoModelVo selectAppendixInfo(Long id);
}

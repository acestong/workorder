package com.fea.project.service.task;

import java.util.List;

import com.fea.project.model.task.vo.PercentSettingModelVo;

public interface IPercentSettingService {

	List<PercentSettingModelVo> selectByResourceBusinessId(Long resourceBusinessId);
}

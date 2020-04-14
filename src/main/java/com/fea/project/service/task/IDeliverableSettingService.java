package com.fea.project.service.task;

import java.util.List;

import com.fea.project.model.task.DeliverableSettingModel;

public interface IDeliverableSettingService {

	List<DeliverableSettingModel> selectByModel(DeliverableSettingModel model);
}

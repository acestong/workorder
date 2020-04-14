package com.fea.project.workorder.service;

import java.util.List;


import com.fea.project.workorder.model.ParticipantModel;

public interface IParticipantService {

	Integer insertByList(List<ParticipantModel> list,Long businessId);
}

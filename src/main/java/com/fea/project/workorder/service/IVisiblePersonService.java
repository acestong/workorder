package com.fea.project.workorder.service;

import java.util.List;


import com.fea.project.workorder.model.VisiblePersonModel;

public interface IVisiblePersonService {

	Integer insertByList( Long poolId ,  List<VisiblePersonModel> list);
}

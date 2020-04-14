package com.fea.project.workorder.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fea.project.model.BasePageInfo;
import com.fea.project.workorder.model.vo.ProcedureModelVo;
import com.fea.project.workorder.model.vo.ProcedureReportModelVo;

public interface IProcedureService {

	  Integer insertByList( Long mouldId ,List<ProcedureModelVo> list);
	  
	  Long insert( ProcedureModelVo modelVo);
	  
	  Integer updateMouldIdByProcedureIdList(List<Long> list , Long mouldId);

	  ProcedureModelVo selectByPrimaryKey(Long procedureId);
	  
	  Integer insertByListAndWorkorderId(Long workorderId ,List<ProcedureModelVo> list );
	  
	  Integer deleteByWorkorderId(Long workorderId);
	  
	  BasePageInfo<ProcedureModelVo> selectListByLeaderId(BasePageInfo<ProcedureModelVo> page);
	  
	  BasePageInfo<ProcedureModelVo> selectListByParticipantUserId(BasePageInfo<ProcedureModelVo> page);
	  
	  List<ProcedureModelVo> selectListByWorkorderId(Long workorderId);
}

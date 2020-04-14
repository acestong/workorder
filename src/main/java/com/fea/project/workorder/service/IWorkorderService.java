package com.fea.project.workorder.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fea.project.api.other.model.base.vo.EmpTreeModelVo;
import com.fea.project.api.other.model.customer.CrmContactInfoModel;
import com.fea.project.api.other.model.customer.CrmCustomerModel;
import com.fea.project.api.other.model.pdt.PdtLibraryModel;
import com.fea.project.model.BasePageInfo;
import com.fea.project.workorder.model.AcceptanceContentModel;
import com.fea.project.workorder.model.AcceptanceModel;
import com.fea.project.workorder.model.CommentModel;
import com.fea.project.workorder.model.WorkorderModel;
import com.fea.project.workorder.model.WorkorderReportModel;
import com.fea.project.workorder.model.WorkorderResponseModel;
import com.fea.project.workorder.model.vo.AcceptanceContentModelVo;
import com.fea.project.workorder.model.vo.AcceptanceFileModelVo;
import com.fea.project.workorder.model.vo.AcceptanceModelVo;
import com.fea.project.workorder.model.vo.PersonInfoModelVo;
import com.fea.project.workorder.model.vo.WorkorderModelVo;
import com.fea.project.workorder.model.vo.WorkorderReportModelVo;

public interface IWorkorderService {

	Long insert(WorkorderModelVo modelVo);
	
	BasePageInfo<WorkorderModel> selectAll(BasePageInfo<WorkorderModel> page);
	
	List<WorkorderModel> selectAll();
	
	List<EmpTreeModelVo> getUserListByOrgId();
	
	List<PersonInfoModelVo> selectCrmCustomer();
	
	List<PersonInfoModelVo> selectCrmContact(Long customerId);
	
	List<CrmContactInfoModel> selectCrmContactByContactId(Long contactId);
	
	List<PersonInfoModelVo> selectPdtLibraryByRegId();
	
	PdtLibraryModel selectPdtLibraryById(Long id);
	
	WorkorderModelVo selectOne(Long workorderId);
	
	Long update(WorkorderModelVo modelVo);
	
	Integer delete(Long workorderId);
	
	Integer commit(Long workorderId);
	
	Integer revoke(WorkorderModel model);
	
	Integer response(WorkorderResponseModel model);
	
	Integer authorize(WorkorderModel workorderModel);
	
	Integer attention(WorkorderModel workorderModel);
	
	Integer activate(Long workorderId);
	
	Integer insertWorkorderReport(WorkorderReportModel model);
	
	List<WorkorderReportModelVo> selectReportListByWorkorderId(Long workorderId);
	
	WorkorderReportModel selectReportModelById(Long reportId);
	
	Integer updateReportModelById(WorkorderReportModel model);
	
	Integer deleteReportModelById(Long reportId);
	
	BasePageInfo<WorkorderModelVo> selectListByCreateId(BasePageInfo<WorkorderModelVo> page);
	
	BasePageInfo<WorkorderModelVo> selectListByPersonId(BasePageInfo<WorkorderModelVo> page);
	
	BasePageInfo<WorkorderModelVo> selectListByDispatchId(BasePageInfo<WorkorderModelVo> page);
	
	BasePageInfo<WorkorderModelVo> selectListByDispatchIdAndPersonId(BasePageInfo<WorkorderModelVo> page);
	
	BasePageInfo<WorkorderModelVo> selectListByCcPersonId(BasePageInfo<WorkorderModelVo> page);
	
	BasePageInfo<WorkorderModelVo> selectListByAttentionId(BasePageInfo<WorkorderModelVo> page);
	
	BasePageInfo<WorkorderModelVo> selectListByRate(BasePageInfo<WorkorderModelVo> page);
	
	BasePageInfo<WorkorderModelVo> selectListByRestart(BasePageInfo<WorkorderModelVo> page);
	
	BasePageInfo<WorkorderModelVo> selectListByClosed(BasePageInfo<WorkorderModelVo> page);
	
	BasePageInfo<WorkorderModelVo> selectListByDispatchPoolId(BasePageInfo<WorkorderModelVo> page);
	
	BasePageInfo<WorkorderModelVo> selectListParticipantUserId(BasePageInfo<WorkorderModelVo> page);
	
	Integer acceptance(AcceptanceModel model);
	
	AcceptanceModelVo selectByAcceptanceId(Long acceptanceId);
	
	Integer insertAcceptanceContent(AcceptanceContentModel model);
	
	List<AcceptanceContentModelVo> selectListByAcceptanceId(Long acceptanceId);
	
	Integer insertAcceptanceFile(AcceptanceFileModelVo modelVo);
	
	List<AcceptanceFileModelVo> selectFileListByAcceptanceId(Long acceptanceId);
	
	BasePageInfo<WorkorderModelVo> selectListByPoolId(@Param("page") BasePageInfo<WorkorderModelVo> page);
	
	List<AcceptanceModelVo> selectAcceptanceListByWorkorderId(Long workorderId);
	
	Integer insertCommentModel(CommentModel commentModel);
	
    List<CommentModel> selectCommentListByWorkorderId(Long workorderId);
    
    Integer close(WorkorderModel workorderModel);
}

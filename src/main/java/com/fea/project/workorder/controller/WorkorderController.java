package com.fea.project.workorder.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.EmpTreeModelVo;
import com.fea.project.api.other.model.customer.CrmContactInfoModel;
import com.fea.project.api.other.model.customer.CrmContactModel;
import com.fea.project.api.other.model.customer.CrmCustomerModel;
import com.fea.project.api.other.model.pdt.PdtLibraryModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.api.other.service.customer.CrmContactService;
import com.fea.project.api.other.service.customer.CrmCustomerService;
import com.fea.project.model.BasePageInfo;
import com.fea.project.workorder.model.AcceptanceContentModel;
import com.fea.project.workorder.model.AcceptanceModel;
import com.fea.project.workorder.model.CommentModel;
import com.fea.project.workorder.model.ContactModel;
import com.fea.project.workorder.model.WorkorderModel;
import com.fea.project.workorder.model.WorkorderRecordModel;
import com.fea.project.workorder.model.WorkorderReportModel;
import com.fea.project.workorder.model.WorkorderResponseModel;
import com.fea.project.workorder.model.vo.AcceptanceContentModelVo;
import com.fea.project.workorder.model.vo.AcceptanceFileModelVo;
import com.fea.project.workorder.model.vo.AcceptanceModelVo;
import com.fea.project.workorder.model.vo.IdAndNameModelVo;
import com.fea.project.workorder.model.vo.PersonInfoModelVo;
import com.fea.project.workorder.model.vo.WorkorderModelVo;
import com.fea.project.workorder.model.vo.WorkorderReportModelVo;
import com.fea.project.workorder.service.IWorkorderRecordService;
import com.fea.project.workorder.service.IWorkorderService;
import com.github.pagehelper.PageHelper;

/**
 * 工单Controller
 * @author st
 *
 */
@RestController
@RequestMapping("/workorder")
public class WorkorderController {

	@Resource
	private IWorkorderService service;
	@Resource
	private CrmCustomerService crmCustomerService;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private CrmContactService crmContactService;
	@Resource
	private IWorkorderRecordService workorderRecordService;
	
	
	@PostMapping("/test")
	public Object test() {
		return null;
	}
	
	@PostMapping("/insert")
	public void insert(@RequestBody WorkorderModelVo model) {
		service.insert(model);
	}
	
	@PostMapping
	public BasePageInfo<WorkorderModel> selectAll(@RequestBody BasePageInfo<WorkorderModel> page){
		return service.selectAll(page);
	}
	
	@GetMapping("/getUserListByOrgId")
	public List<EmpTreeModelVo> getUserListByOrgId(){
		return service.getUserListByOrgId();
		
	}
	@GetMapping("/selectCrmCustomer")
	public List<PersonInfoModelVo> selectCrmCustomer(){
		return service.selectCrmCustomer();
		
	}
	
	@GetMapping("/selectCrmContact")
	public List<PersonInfoModelVo> selectCrmContact(Long customerId){
		return service.selectCrmContact(customerId);
	}
	
	
	@GetMapping("/selectCrmContactByContactId")
	public List<CrmContactInfoModel> selectCrmContactByContactId(Long contactId){
		return service.selectCrmContactByContactId(contactId);
	}
	
	@GetMapping("/selectPdtLibraryByRegId")
	public List<PersonInfoModelVo> selectPdtLibraryByRegId(){
		return service.selectPdtLibraryByRegId();
	}
	
	@GetMapping("/selectPdtLibraryById")
	public PdtLibraryModel selectPdtLibraryById(Long id){
		return service.selectPdtLibraryById(id);
	}
	
	@PostMapping("/selectOne")
	public WorkorderModelVo selectOne(@RequestBody WorkorderModel model){
		return service.selectOne(model.getWorkorderId());
	}
	
	@PostMapping("/update")
	public Long update(@RequestBody WorkorderModelVo modelVo){
		return service.update(modelVo);
	}
	
	@GetMapping("/delete")
	public void delete(Long workorderId){
		service.delete(workorderId);
	}
	
	@GetMapping("/commit")
	public void commit(Long workorderId){
		service.commit(workorderId);
	}
	
	@PostMapping("/revoke")
	public void revoke(@RequestBody WorkorderModel model){
		service.revoke(model);
	}
	
	@PostMapping("/response")
	public void response(@RequestBody WorkorderResponseModel model){
		service.response(model);
	}
	
	@PostMapping("/authorize")
	public void authorize(@RequestBody WorkorderModel model){
		service.authorize(model);
	}
	
	@PostMapping("/attention")
	public void attention(@RequestBody WorkorderModel model){
		service.attention(model);
	}
	
	@GetMapping("/activate")
	public void activate(Long workorderId){
		service.activate(workorderId);
	}
	
	@PostMapping("/insertWorkorderReport")
	public void insertWorkorderReport(@RequestBody WorkorderReportModel model){
		service.insertWorkorderReport(model);
	}
	
	@GetMapping("/selectReportListByWorkorderId")
	public List<WorkorderReportModelVo> selectReportListByWorkorderId(Long workorderId){
		return service.selectReportListByWorkorderId(workorderId);
	}
	
	@GetMapping("/selectReportModelById")
	public WorkorderReportModel selectReportModelById(Long reportId){
		return service.selectReportModelById(reportId);
	}
	
	@PostMapping("/updateReportModelById")
	public void updateReportModelById(@RequestBody WorkorderReportModel model){
		service.updateReportModelById(model);
	}
	
	@GetMapping("/deleteReportModelById")
	public void deleteReportModelById(Long reportId){
		 service.deleteReportModelById(reportId);
	}
	@PostMapping("/selectListByCreateId")
	public BasePageInfo<WorkorderModelVo> selectListByCreateId(@RequestBody BasePageInfo<WorkorderModelVo> page){
		return service.selectListByCreateId(page);
	}
	@PostMapping("/selectListByPersonId")
	public BasePageInfo<WorkorderModelVo> selectListByPersonId(@RequestBody BasePageInfo<WorkorderModelVo> page){
		return service.selectListByPersonId(page);
	}
	@PostMapping("/selectListByDispatchId")
	public BasePageInfo<WorkorderModelVo> selectListByDispatchId(@RequestBody BasePageInfo<WorkorderModelVo> page){
		return service.selectListByDispatchId(page);
	}
	@PostMapping("/selectListByDispatchIdAndPersonId")
	public BasePageInfo<WorkorderModelVo> selectListByDispatchIdAndPersonId(@RequestBody BasePageInfo<WorkorderModelVo> page){
		return service.selectListByDispatchIdAndPersonId(page);
	}
	@PostMapping("/selectListByCcPersonId")
	public BasePageInfo<WorkorderModelVo> selectListByCcPersonId(@RequestBody BasePageInfo<WorkorderModelVo> page){
		return service.selectListByCcPersonId(page);
	}
	@PostMapping("/selectListByAttentionId")
	public BasePageInfo<WorkorderModelVo> selectListByAttentionId(@RequestBody BasePageInfo<WorkorderModelVo> page){
		return service.selectListByAttentionId(page);
	}
	@PostMapping("/selectListByRate")
	public BasePageInfo<WorkorderModelVo> selectListByRate(@RequestBody BasePageInfo<WorkorderModelVo> page){
		return service.selectListByRate(page);
	}
	@PostMapping("/selectListByRestart")
	public BasePageInfo<WorkorderModelVo> selectListByRestart(@RequestBody BasePageInfo<WorkorderModelVo> page){
		return service.selectListByRestart(page);
	}
	@PostMapping("/selectListByClosed")
	public BasePageInfo<WorkorderModelVo> selectListByClosed(@RequestBody BasePageInfo<WorkorderModelVo> page){
		return service.selectListByClosed(page);
	}
	@PostMapping("/selectListByDispatchPoolId")
	public BasePageInfo<WorkorderModelVo> selectListByDispatchPoolId(@RequestBody BasePageInfo<WorkorderModelVo> page){
		return service.selectListByDispatchPoolId(page);
	}
	@PostMapping("/selectListParticipantUserId")
	public BasePageInfo<WorkorderModelVo> selectListParticipantUserId(@RequestBody BasePageInfo<WorkorderModelVo> page){
		return service.selectListParticipantUserId(page);
	}
	
	@PostMapping("/acceptance")
	public void acceptance(@RequestBody AcceptanceModel model){
		service.acceptance(model);
	}
	
	@PostMapping("/selectByAcceptanceId")
	public AcceptanceModelVo selectByAcceptanceId(@RequestBody AcceptanceModel model){
		return service.selectByAcceptanceId(model.getAcceptanceId());
	}
	
	@PostMapping("/insertAcceptanceContent")
	public void insertAcceptanceContent(@RequestBody AcceptanceContentModel model){
		service.insertAcceptanceContent(model);
	}
	
	@GetMapping("/selectListByAcceptanceId")
	public List<AcceptanceContentModelVo> selectListByAcceptanceId(Long acceptanceId){
		return service.selectListByAcceptanceId(acceptanceId);
	}
	@GetMapping("/selectAcceptanceListByWorkorderId")
	public List<AcceptanceModelVo> selectAcceptanceListByWorkorderId(Long workorderId){
		return service.selectAcceptanceListByWorkorderId(workorderId);
	}
	
	@PostMapping("/insertAcceptanceFile")
	public void insertAcceptanceFile(@RequestBody AcceptanceFileModelVo modelVo){
		service.insertAcceptanceFile(modelVo);
	}
	@PostMapping("/selectFileListByAcceptanceId")
	public List<AcceptanceFileModelVo> selectFileListByAcceptanceId(@RequestBody AcceptanceFileModelVo modelVo){
		return service.selectFileListByAcceptanceId(modelVo.getAcceptanceId());
	}
	
	/**
	 * 通过orgId获取当前组织的客户列表
	 * @return
	 */
	@RequestMapping("/selectCustomerModelByOrgId")
	public List<IdAndNameModelVo> selectCustomerModelByOrgId() {
		CrmCustomerModel crmCustomerModel = new CrmCustomerModel();
		crmCustomerModel.setORGID(sysUserService.getCurrentUsr().getOrgId());
		List<CrmCustomerModel> list = crmCustomerService.selectByModel(crmCustomerModel);
		List<IdAndNameModelVo> tempList = new ArrayList<>();
		list.stream().forEach(customerModel->{
			tempList.add(new IdAndNameModelVo(customerModel.getID(),customerModel.getNAME()));
		});
		return tempList;
	}
	/**
	 * 通过客户id获取当前客户的联系人id和name列表
	 * @return
	 */
	@GetMapping("/selectContactModelByCustomerId")
	public List<IdAndNameModelVo> selectContactModelByCustomerId(Long customerId) {
		CrmContactModel model = new CrmContactModel();
		model.setCUSTOMERID(customerId);
		List<CrmContactModel> list = crmContactService.selectByModel(model);
		List<IdAndNameModelVo> tempList = new ArrayList<>();
		list.stream().forEach(contactModel->{
			tempList.add(new IdAndNameModelVo(contactModel.getID(),contactModel.getCONTACTNAME()));
		});
		return tempList;
	}
	
	/**
	 * 通过联系人id获取联系人详情
	 */
	@GetMapping("/selectContactInfoByContactId")
	public ContactModel selectContactInfoByContactId(Long contactId) {
		if(contactId == null) {
			return null;
		}
		CrmContactModel model = crmContactService.selectById(contactId);
		ContactModel contactModel = new ContactModel(model);
		contactModel.setContactId(contactId);
		contactModel.setAddress(crmCustomerService.selectAddressByCustomerId(model.getCUSTOMERID()));
		return contactModel;
	}
	/**
	 * 通过工单id获取操作记录
	 */
	@GetMapping("/selectRecordListByWorkorderId")
	public  List<WorkorderRecordModel> selectRecordListByWorkorderId(Long workorderId)  {
		return workorderRecordService.selectByWorkorderId(workorderId);
	}
	
	/**
	 * 新建工单评价
	 * @param commentModel
	 */
	@PostMapping("/insertCommentModel")
	public void insertCommentModel(@RequestBody CommentModel commentModel){
		 service.insertCommentModel(commentModel);
	}
	/**
	 * 按照工单id获取评价列表
	 * @param workorderId
	 * @return 
	 */
	@GetMapping("/selectCommentListByWorkorderId")
	public List<CommentModel> selectCommentListByWorkorderId(Long workorderId){
		return service.selectCommentListByWorkorderId(workorderId);
	}
	
	@PostMapping("/close")
	public void close(@RequestBody WorkorderModel workorderModel) {
		service.close(workorderModel);
	}
}

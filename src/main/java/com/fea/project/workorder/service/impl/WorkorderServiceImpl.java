package com.fea.project.workorder.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.EmpTreeModelVo;
import com.fea.project.api.other.model.customer.CrmContactInfoModel;
import com.fea.project.api.other.model.customer.CrmContactModel;
import com.fea.project.api.other.model.customer.CrmCustomerModel;
import com.fea.project.api.other.model.pdt.PdtLibraryModel;
import com.fea.project.api.other.service.base.SysJobService;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.api.other.service.customer.CrmContactService;
import com.fea.project.api.other.service.customer.CrmCustomerService;
import com.fea.project.api.other.service.pdt.PdtLibraryService;
import com.fea.project.workorder.configure.annotation.AutoDispatchWorkorder;
import com.fea.project.workorder.configure.annotation.OptionAnno;
import com.fea.project.workorder.configure.annotation.WorkorderLogAnno;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.BasePageInfo;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.workorder.dao.WorkorderModelMapper;
import com.fea.project.workorder.enums.AttentionEnum;
import com.fea.project.workorder.enums.DeleteStatusEnum;
import com.fea.project.workorder.enums.InsertOrUpdateEnum;
import com.fea.project.workorder.enums.PriorityEnum;
import com.fea.project.workorder.enums.ProductTroubleSortEnum;
import com.fea.project.workorder.enums.ProductTroubleTypeEnum;
import com.fea.project.workorder.enums.SwitchPersonEnum;
import com.fea.project.workorder.enums.TypeEnum;
import com.fea.project.workorder.enums.WorkorderResourceTypeEnum;
import com.fea.project.workorder.enums.WorkorderStatusEnum;
import com.fea.project.workorder.model.AcceptanceContentModel;
import com.fea.project.workorder.model.AcceptanceModel;
import com.fea.project.workorder.model.AttentionModel;
import com.fea.project.workorder.model.CcModel;
import com.fea.project.workorder.model.CommentModel;
import com.fea.project.workorder.model.ContactModel;
import com.fea.project.workorder.model.WorkorderModel;
import com.fea.project.workorder.model.WorkorderReportModel;
import com.fea.project.workorder.model.WorkorderResponseModel;
import com.fea.project.workorder.model.vo.AcceptanceContentModelVo;
import com.fea.project.workorder.model.vo.AcceptanceFileModelVo;
import com.fea.project.workorder.model.vo.AcceptanceModelVo;
import com.fea.project.workorder.model.vo.PersonInfoModelVo;
import com.fea.project.workorder.model.vo.ProcedureModelVo;
import com.fea.project.workorder.model.vo.WorkorderModelVo;
import com.fea.project.workorder.model.vo.WorkorderReportModelVo;
import com.fea.project.workorder.service.IAcceptanceContentService;
import com.fea.project.workorder.service.IAcceptanceFileService;
import com.fea.project.workorder.service.IAcceptanceService;
import com.fea.project.workorder.service.ICcService;
import com.fea.project.workorder.service.ICommentService;
import com.fea.project.workorder.service.IContactService;
import com.fea.project.workorder.service.IMouldService;
import com.fea.project.workorder.service.IProcedureService;
import com.fea.project.workorder.service.IWorkorderAttentionService;
import com.fea.project.workorder.service.IWorkorderReportService;
import com.fea.project.workorder.service.IWorkorderResponseService;
import com.fea.project.workorder.service.IWorkorderService;
import com.fea.project.workorder.util.WorkorderNumUtil;
import com.github.pagehelper.PageHelper;

/**
 * 工单Service
 * @author st
 *
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class WorkorderServiceImpl implements IWorkorderService {

	private static final Long ID = null;
	@Resource
	private WorkorderModelMapper mapper; 
	@Resource
	private SysUserService sysUserService;
	@Resource
	private ProjectAppendixService projectAppendixService;
	@Resource
	private SysJobService sysJobService;
	@Resource
	private CrmCustomerService crmCustomerService;
	@Resource
	private CrmContactService crmContactService;
	@Resource
	private PdtLibraryService pdtLibraryService;
	@Resource
	private ICcService ccService;
	@Resource
	private IWorkorderResponseService WorkorderResponseService;
	@Resource 
	private IWorkorderReportService workorderReportService;
	@Resource
	private IWorkorderAttentionService attentionService;
	@Resource
	private IMouldService mouldService;
	@Resource
	private IProcedureService procedureService;
	@Resource
	private IAcceptanceService acceptanceService;
	@Resource
	private IAcceptanceContentService acceptanceContentService;
	@Resource
	private IAcceptanceFileService acceptanceFileService;
	@Resource
	private IContactService contactService;
	@Resource
	private ICommentService commentService;
	
	/**
	 * 新建工单，此方法经AOP拦截，判断是否入工单池，入池做相关操作，工单默认值放入切面中设置
	 * AOP： com.fea.project.configure.aop.AutoDispatchWorkorderHandler
	 */
	@Override
	@WorkorderLogAnno(resultType=1)
	@AutoDispatchWorkorder
	@Transactional
	public Long insert(WorkorderModelVo modelVo) {
		// TODO Auto-generated method stub
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		modelVo.setCreateId(currentUsr.getUserId());
		modelVo.setCreateBy(currentUsr.getRealName());
		modelVo.setCreateTime(new Date());
		modelVo.setWorkorderStatus(WorkorderStatusEnum.UNRESPONSE.getStatus().longValue());
		modelVo.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		modelVo.setOrgId(currentUsr.getOrgId());
		modelVo.setWorkorderNum(WorkorderNumUtil.getNum());
		modelVo.setWorkorderProgrossRate(0d);
		mapper.insert(modelVo);
		Long workorderId = modelVo.getWorkorderId();
		//添加附件
		if(modelVo != null && modelVo.getAppendixList() != null ) {
			//修改附件中的businessId
			projectAppendixService.updateByBusinessIdAndIds(workorderId, modelVo.getAppendixList());
		}
		//抄送人入库
		if(modelVo != null && modelVo.getCcList() != null) {
			List<CcModel> arrayList = new ArrayList<>();
			modelVo.getCcList().stream().forEach((model)->arrayList.add( new CcModel(null,workorderId,model.getId(),model.getName())));
			ccService.insertList(arrayList);
		}
		//当工单模板不为空时，需要带出模板中的工序，然后按照模板数据将工序新增至数据库
		if(modelVo.getMouldId() != null) {
			List<ProcedureModelVo> procedureInfoList = mouldService.selectByPrimaryKey(modelVo.getMouldId()).getProcedureInfoList();
			procedureService.insertByListAndWorkorderId(workorderId, procedureInfoList);
		}
		//当工单联系人模型传入不为空时，新建一个联系人信息
		if(modelVo.getContactModel() != null ) {
			modelVo.getContactModel().setWorkorderId(workorderId);
			contactService.insert(modelVo.getContactModel());
		}
		attentionService.insert(new AttentionModel(modelVo));
		return workorderId;
	}

	/**
	 * 查询所有列表，用于生产测试，带分页等功能
	 */
	@Override
	@Transactional
	public BasePageInfo<WorkorderModel> selectAll(BasePageInfo<WorkorderModel> page) {
		// TODO Auto-generated method stub
		Long orgId = sysUserService.getCurrentUsr().getOrgId();
		PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
		List<WorkorderModel> selectAll = mapper.selectAll(orgId);
		return new BasePageInfo<WorkorderModel>(selectAll);
	}
	
	/**
	 * 查询所有列表，用于生产测试
	 */
	@Override
	@Transactional
	public List<WorkorderModel> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll(sysUserService.getCurrentUsr().getOrgId());
	}
	
	
	/**
	 * 新增或者修改时添加部分默认字段信息
	 * @param modelVo
	 * @param option
	 * @return modelVo
	 */
	private WorkorderModel setBaseInfoBymodel(WorkorderModel model,InsertOrUpdateEnum option) {
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		if(option.equals(InsertOrUpdateEnum.UPDATE)){
			model.setUpdateId(currentUsr.getUserId());
			model.setUpdateBy(currentUsr.getRealName());
			model.setUpdateTime(new Date());
		}else if(option.equals(InsertOrUpdateEnum.INSERT)) {
			model.setCreateId(currentUsr.getUserId());
			model.setCreateBy(currentUsr.getRealName());
			model.setCreateTime(new Date());
			model.setAttentionStatus(AttentionEnum.NOT_ATTENTION.getStatus().longValue());
			model.setWorkorderStatus(WorkorderStatusEnum.UNRESPONSE.getStatus().longValue());
			model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
			model.setOrgId(currentUsr.getOrgId());
			model.setWorkorderProgrossRate(0d);
		}
		return model;
	}

	
	/**
	 * 获取公司树型组织架构
	 */
	@Override
	@Transactional
	public List<EmpTreeModelVo> getUserListByOrgId() {
		// TODO Auto-generated method stub
		Long orgId = sysUserService.getCurrentUsr().getOrgId();
//		Long orgId = 1439857849903614202L;
		 List<EmpTreeModelVo> empList = sysJobService.selectByOrgIdAndParentId(orgId);
		return empList;
	}

	/**
	 * 获取当前用户所在组织中的客户列表
	 */
	@Override
	@Transactional
	public List<PersonInfoModelVo> selectCrmCustomer() {
		// TODO Auto-generated method stub
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		CrmCustomerModel crmCustomerModel = new CrmCustomerModel();
		crmCustomerModel.setORGID(currentUsr.getOrgId());
		List<CrmCustomerModel> list = crmCustomerService.selectByModel(crmCustomerModel);
		ArrayList<PersonInfoModelVo> arrayList = new ArrayList<>();
		list.stream().forEach(model->{
			PersonInfoModelVo crmCustomerModelVo = new PersonInfoModelVo(model.getID(),model.getNAME());
			arrayList.add(crmCustomerModelVo);
		});
		return arrayList;
	}

	/**
	 * 通过customerId 客户Id，获取客户联系人列表
	 */
	@Override
	@Transactional
	public List<PersonInfoModelVo> selectCrmContact(Long customerId) {
		// TODO Auto-generated method stub
		if(customerId == null) {
			throw new SystemParamCheckException("传入参数为空，无法查询联系人");
		}
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		CrmContactModel crmContactModel = new CrmContactModel();
		crmContactModel.setCUSTOMERID(customerId);
		List<CrmContactModel> list = crmContactService.selectByModel(crmContactModel);
		ArrayList<PersonInfoModelVo> arrayList = new ArrayList<>();
		list.stream().forEach(model->{
			PersonInfoModelVo crmCustomerModelVo = new PersonInfoModelVo(model.getID(),model.getCONTACTNAME());
			arrayList.add(crmCustomerModelVo);
		});
		return arrayList;
	}
	
	
	/**
	 * 通过联系人Id获取联系人基本信息
	 */
	@Override
	@Transactional
	public List<CrmContactInfoModel> selectCrmContactByContactId(Long contactId) {
		// TODO Auto-generated method stub
		if(contactId == null) {
			throw new SystemParamCheckException("传入参数为空，无法查询联系人");
		}
		List<CrmContactInfoModel> list = crmContactService.selectEmpInfoById(contactId);
		return list;
	}

	/**
	 * 通过regId获取当前用户下所有的产品信息列表
	 */
	@Override
	@Transactional
	public List<PersonInfoModelVo> selectPdtLibraryByRegId() {
		// TODO Auto-generated method stub
		PdtLibraryModel pdtLibraryModel = new PdtLibraryModel();
		pdtLibraryModel.setREGID(sysUserService.getCurrentUsr().getRegId());
		List<PdtLibraryModel> selectByModel = pdtLibraryService.selectByModel(pdtLibraryModel);
		List<PersonInfoModelVo> list = new ArrayList<>();
		selectByModel.stream().forEach(model->{
			PersonInfoModelVo personInfoModelVo = new PersonInfoModelVo(model.getID(),model.getNAME());
			list.add(personInfoModelVo);
		});
		return list;
	}

	@Override
	@Transactional
	public PdtLibraryModel selectPdtLibraryById(Long id) {
		// TODO Auto-generated method stub
		if(id == null) {
			throw new SystemParamCheckException("传入参数为空，无法查询产品信息");
		}
		return pdtLibraryService.selectById(id);
	}

	/**
	 * 通过工单id获取一条工单，带附件
	 */
	@Override
	@Transactional
	public WorkorderModelVo selectOne(Long workorderId) {
		// TODO Auto-generated method stub
		WorkorderModelVo selectByPrimaryKey = mapper.selectByPrimaryKey(workorderId);
		if(selectByPrimaryKey == null) {
			throw new SystemParamCheckException("无工单");
		}
		WorkorderModelVo workorderModelVo = new WorkorderModelVo(selectByPrimaryKey);
		workorderModelVo.setPriorityStr(PriorityEnum.getValue(workorderModelVo.getPriority().intValue()));
		workorderModelVo.setSwitchPersonStr(SwitchPersonEnum.getValue(workorderModelVo.getSwitchPerson().intValue()));
		workorderModelVo.setCcList(ccService.selectCCPerson(workorderId));
		workorderModelVo.setAppendixInfoList(projectAppendixService.selectIdAndNameByBusiness(workorderId));
		workorderModelVo.setWorkorderStatusStr(WorkorderStatusEnum.getValue(workorderModelVo.getWorkorderStatus().intValue()));
		workorderModelVo.setProcedureList(procedureService.selectListByWorkorderId(workorderId));
		/*
		 * 如果联系人在系统中存在则在老系统客户表中查找相关信息，否则在工单联系表中按照工单id查找
		 */
		if(workorderModelVo.getContactId() != null && workorderModelVo.getCustomerId() != null) {
			CrmContactModel crmContactModel = crmContactService.selectById(workorderModelVo.getContactId());
			ContactModel contactModel = new ContactModel(crmContactModel);
			contactModel.setWorkorderId(workorderModelVo.getWorkorderId());
			contactModel.setAddress(crmCustomerService.selectAddressByCustomerId(workorderModelVo.getCustomerId()));
			workorderModelVo.setContactModel(contactModel);
		}else {
			workorderModelVo.setContactModel(contactService.selectByWorkorderId(workorderId));
		}
		return workorderModelVo;
	}

	/**
	 * 修改一条工单
	 */
	@Override
	@Transactional
	public Long update(WorkorderModelVo modelVo) {
		// TODO Auto-generated method stub
		if(modelVo == null || modelVo.getWorkorderId() == null) {
			throw new SystemParamCheckException("参数传入为空，无法进行修改");
		}
		if(modelVo.getSwitchPerson() == SwitchPersonEnum.LEADER.getStatus().longValue() && 
				modelVo.getPersonId() != sysUserService.getCurrentUsr().getUserId()) {
			throw new SystemParamCheckException("仅工单负责人"+modelVo.getPersonName()+"有权编辑工单");
		}
		mapper.updateByPrimaryKeySelective(modelVo);
		//修改附件，先删除之前旧所有的附件，在上传新的附件
		//删除旧附件
		projectAppendixService.deleteByBusinessId(modelVo.getWorkorderId());
		if(modelVo.getAppendixList() != null) {
			//添加新附件，直接修改附件表中的业务id
			projectAppendixService.updateByBusinessIdAndIds(modelVo.getWorkorderId(), modelVo.getAppendixList());
		}
		//修改抄送人列表
		//先删除旧抄送人列表
		ccService.deleteByBusinessId(modelVo.getWorkorderId());
		if(modelVo.getCcList() != null) {
			List<CcModel> arrayList = new ArrayList<>();
			modelVo.getCcList().stream().forEach((model)->arrayList.add( new CcModel(null,modelVo.getWorkorderId(),model.getId(),model.getName())));
			ccService.insertList(arrayList);
		}
		//工单在未提交状态下，且模板id不为空则可以对工单中的工序进行修改
		WorkorderModelVo workorderModel = mapper.selectByPrimaryKey(modelVo.getWorkorderId());
		if( workorderModel != null && workorderModel.getMouldId() != null 
				&& workorderModel.getWorkorderStatus() == WorkorderStatusEnum.UNCOMMITED.getStatus().longValue()) {
			//删除掉旧工序列表
			procedureService.deleteByWorkorderId(modelVo.getWorkorderId());
			//批量新增工序列表
			if(modelVo.getProcedureList().size() != 0) {
				procedureService.insertByListAndWorkorderId(modelVo.getWorkorderId(), modelVo.getProcedureList());
			}
		}
		return modelVo.getWorkorderId();
	}

	/**
	 * 删除一条工单，假删除
	 */
	@Override
	@Transactional
	public Integer delete(Long workorderId) {
		// TODO Auto-generated method stub
		if(workorderId == null) {
			throw new SystemParamCheckException("参数传入异常，无法删除");
		}
		WorkorderModelVo modelVo = mapper.selectByPrimaryKey(workorderId);
		if(modelVo.getWorkorderStatus() != WorkorderStatusEnum.UNCOMMITED.getStatus().longValue()) {
			throw new SystemParamCheckException("非提交状态，不能删除");
		}
		if(modelVo.getSwitchPerson() == SwitchPersonEnum.LEADER.getStatus().longValue() && 
				modelVo.getPersonId() != sysUserService.getCurrentUsr().getUserId()) {
			throw new SystemParamCheckException("仅工单负责人"+modelVo.getPersonName()+"有权删除工单");
		}
		WorkorderModel workorderModel = new WorkorderModel();
		workorderModel = setBaseInfoBymodel(workorderModel,InsertOrUpdateEnum.UPDATE);
		workorderModel.setWorkorderId(workorderId);
		workorderModel.setDelStatus(DeleteStatusEnum.DELETE.getStatus().longValue());
		return mapper.updateByPrimaryKeySelective(workorderModel) ;
	}

	/**
	 * 提交工单
	 */
	@Override
	@Transactional
	public Integer commit(Long workorderId) {
		// TODO Auto-generated method stub
		if(workorderId == null) {
			throw new SystemParamCheckException("参数传入异常，无法提交");
		}
		WorkorderModel workorderModel = new WorkorderModel();
		workorderModel = setBaseInfoBymodel(workorderModel,InsertOrUpdateEnum.UPDATE);
		workorderModel.setWorkorderId(workorderId); 
		workorderModel.setWorkorderStatus(WorkorderStatusEnum.UNRESPONSE.getStatus().longValue());
		return mapper.updateByPrimaryKeySelective(workorderModel) ;
	}

	
	/**
	 * 关闭工单
	 */
	@Override
	@WorkorderLogAnno(resultType=8)
	@OptionAnno(type=6)
	@Transactional
	public Integer close(WorkorderModel model) {
		// TODO Auto-generated method stub
		if(model.getWorkorderId() == null || model.getWorkorderStatus() == null) {
			throw new SystemParamCheckException("参数传入异常，无法关闭");
		}
		if(model.getWorkorderStatus() != WorkorderStatusEnum.RESOLVED.getStatus().longValue()) {
			throw new SystemParamCheckException("仅已完成状态工单可进行关闭操作");
		}
		model.setWorkorderStatus(WorkorderStatusEnum.CLOSED.getStatus().longValue());
		return mapper.updateByPrimaryKeySelective(model) ;
	}
	
	
	/**
	 * 撤销工单
	 */
	@Override
	@Transactional
	public Integer revoke(WorkorderModel model) {
		// TODO Auto-generated method stub
		if(model.getWorkorderId() == null) {
			throw new SystemParamCheckException("参数传入异常，无法撤销");
		}
		WorkorderModel workorderModel = new WorkorderModel();
		workorderModel = setBaseInfoBymodel(workorderModel,InsertOrUpdateEnum.UPDATE);
		workorderModel.setWorkorderId(model.getWorkorderId());
		workorderModel.setWorkorderStatus(WorkorderStatusEnum.REVOKE.getStatus().longValue());
		workorderModel.setRejectReason(model.getRejectReason());
		return mapper.updateByPrimaryKeySelective(workorderModel) ;
	}

	
	/**
	 * 响应工单
	 */
	@Override
	@WorkorderLogAnno(resultType=2)
	@Transactional
	public Integer response(WorkorderResponseModel model) {
		// TODO Auto-generated method stub
		if(model.getWorkorderId() == null || this.selectOne(model.getWorkorderId()) == null) {
			throw new SystemParamCheckException("工单Id传入为空");
		}
		Integer insert = WorkorderResponseService.insert(model);
		if(insert > 0) {
			WorkorderModel workorderModel = new WorkorderModel();
			workorderModel = setBaseInfoBymodel(workorderModel,InsertOrUpdateEnum.UPDATE);
			workorderModel.setWorkorderId(model.getWorkorderId());
			workorderModel.setWorkorderStatus(model.getIsConfirm());
			return mapper.updateByPrimaryKeySelective(workorderModel) ;
		}
		return  insert;
	}
	
	
	
	/**
	 * 分配负责人
	 */
	@Override
	@WorkorderLogAnno(resultType=3)
	@Transactional
	public Integer authorize(WorkorderModel workorderModel) {
		// TODO Auto-generated method stub
		if(workorderModel == null || workorderModel.getWorkorderId() == null 
				|| workorderModel.getPersonId() == null || workorderModel.getPersonName() == null) {
			throw new SystemParamCheckException("参数id传入异常，无法撤销");
		}
		WorkorderModelVo modelVo = mapper.selectByPrimaryKey(workorderModel.getWorkorderId());
		if(modelVo.getSwitchPerson() == SwitchPersonEnum.LEADER.getStatus().longValue() && 
				modelVo.getPersonId() != sysUserService.getCurrentUsr().getUserId()) {
			throw new SystemParamCheckException("仅工单负责人"+modelVo.getPersonName()+"有权分配订单");
		}
		workorderModel = setBaseInfoBymodel(workorderModel,InsertOrUpdateEnum.UPDATE);
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		workorderModel.setDispatchBy(currentUsr.getRealName());
		workorderModel.setDispatchId(currentUsr.getUserId());
		workorderModel.setDispatchTime(new Date());
		return mapper.updateByPrimaryKeySelective(workorderModel) ;
	}

	
	/**
	 * 关注 取消关注
	 */
	@Override
	@Transactional
	public Integer attention(WorkorderModel workorderModel) {
		// TODO Auto-generated method stub
		if(workorderModel == null || workorderModel.getWorkorderId() == null 
				|| workorderModel.getAttentionStatus() == null) {
			throw new SystemParamCheckException("参数id传入异常，无法撤销");
		}
		if(attentionService.selectByWorkorderId(workorderModel.getWorkorderId())) {
			return attentionService.insert(new AttentionModel(workorderModel));
		}
		return attentionService.update(new AttentionModel(workorderModel));
	}
	
	
	/**
	 * 激活工单
	 */
	@Override
	@WorkorderLogAnno(resultType=5)
	@Transactional
	public Integer activate(Long workorderId) {
		// TODO Auto-generated method stub
		if(workorderId == null) {
			throw new SystemParamCheckException("参数传入异常，无法撤销");
		}
		if( mapper.selectByPrimaryKey(workorderId).getWorkorderStatus() != WorkorderStatusEnum.CLOSED.getStatus().longValue()) {
			throw new SystemParamCheckException("工单需要关闭状态才可激活");
		}
		WorkorderModel workorderModel = new WorkorderModel();
		workorderModel = setBaseInfoBymodel(workorderModel,InsertOrUpdateEnum.UPDATE);
		workorderModel.setWorkorderId(workorderId);
		workorderModel.setWorkorderStatus(WorkorderStatusEnum.RESTART.getStatus().longValue());
		return mapper.updateByPrimaryKeySelective(workorderModel) ;
	}

	/**
	 * 新建一条工单汇报
	 */
	@Override
	@WorkorderLogAnno(resultType=4)
	@OptionAnno(type=2)
	@Transactional
	public Integer insertWorkorderReport(WorkorderReportModel model) {
		// TODO Auto-generated method stub
		WorkorderModel workorderModel = new WorkorderModel();
		workorderModel.setWorkorderId(model.getWorkorderId());
		workorderModel.setWorkorderProgrossRate(model.getWorkorderProgrossRate());
		//workorderModel中默认更新为最新的进度
		if(model.getWorkorderProgrossRate() >= 1) {
			workorderModel.setWorkorderStatus(WorkorderStatusEnum.RESOLVED.getStatus().longValue());
		}
		mapper.updateByPrimaryKeySelective(workorderModel);
		return workorderReportService.insert(model);
	}

	/**
	 * 通过工单id获取工单汇报列表
	 */
	@Override
	@Transactional
	public List<WorkorderReportModelVo> selectReportListByWorkorderId(Long workorderId) {
		// TODO Auto-generated method stub
		return workorderReportService.selectListByWorkorderId(workorderId);
	}

	/**
	 * 通过汇报id获取当前汇报Model
	 */
	@Override
	@Transactional
	public WorkorderReportModel selectReportModelById(Long reportId) {
		// TODO Auto-generated method stub
		return workorderReportService.selectById(reportId);
	}

	/**
	 * 通过汇报id修改当前汇报Model
	 */
	@Override
	@Transactional
	public Integer updateReportModelById(WorkorderReportModel model) {
		// TODO Auto-generated method stub
		return workorderReportService.update(model);
	}

	/**
	 * 删除一条工单汇报
	 */
	@Override
	@Transactional
	public Integer deleteReportModelById(Long reportId) {
		// TODO Auto-generated method stub
		return workorderReportService.delete(reportId);
	}

	/**
	 * 获取当前用户创建的工单列表 
	 * 条件：create_id是当前用户
	 */
	@Override
	@Transactional
	public BasePageInfo<WorkorderModelVo> selectListByCreateId(BasePageInfo<WorkorderModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		PageHelper.orderBy(page.getSortKey().replaceAll("[A-Z]", "_$0").toLowerCase()+" "+page.getSortValue());
		List<WorkorderModelVo> list = mapper.selectListByCreateId(page);
		list.stream().forEach(modelVo->{
			modelVo.setPriorityStr(PriorityEnum.getValue(modelVo.getPriority().intValue()));
			modelVo.setWorkorderResourceTypeStr(WorkorderResourceTypeEnum.getValue(modelVo.getWorkorderResourceType().intValue()));
			modelVo.setWorkorderStatusStr(WorkorderStatusEnum.getValue(modelVo.getWorkorderStatus().intValue()));
			modelVo.setSwitchPersonStr(SwitchPersonEnum.getValue(modelVo.getSwitchPerson().intValue()));
		});
		return new BasePageInfo<>(list);
	}
	
	/**
	 * 获取提交给当前用户的工单列表
	 * 条件： person_id是当前用户，且workorder_status != 未提交状态
	 */
	@Override
	@Transactional
	public BasePageInfo<WorkorderModelVo> selectListByPersonId(BasePageInfo<WorkorderModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		PageHelper.orderBy(page.getSortKey().replaceAll("[A-Z]", "_$0").toLowerCase()+" "+page.getSortValue());
		List<WorkorderModelVo> list = mapper.selectListByPersonId(page);
		list.stream().forEach(modelVo->{
			modelVo.setPriorityStr(PriorityEnum.getValue(modelVo.getPriority().intValue()));
			modelVo.setWorkorderResourceTypeStr(WorkorderResourceTypeEnum.getValue(modelVo.getWorkorderResourceType().intValue()));
			modelVo.setWorkorderStatusStr(WorkorderStatusEnum.getValue(modelVo.getWorkorderStatus().intValue()));
			modelVo.setSwitchPersonStr(SwitchPersonEnum.getValue(modelVo.getSwitchPerson().intValue()));
		});
		return new BasePageInfo<>(list);
	}
	
	/**
	 * 获取当前用户分配的工单列表
	 * 条件：dispatch_id是当前用户
	 */
	@Override
	@Transactional
	public BasePageInfo<WorkorderModelVo> selectListByDispatchId(BasePageInfo<WorkorderModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		PageHelper.orderBy(page.getSortKey().replaceAll("[A-Z]", "_$0").toLowerCase()+" "+page.getSortValue());
		List<WorkorderModelVo> list = mapper.selectListByDispatchId(page);
		list.stream().forEach(modelVo->{
			modelVo.setPriorityStr(PriorityEnum.getValue(modelVo.getPriority().intValue()));
			modelVo.setWorkorderResourceTypeStr(WorkorderResourceTypeEnum.getValue(modelVo.getWorkorderResourceType().intValue()));
			modelVo.setWorkorderStatusStr(WorkorderStatusEnum.getValue(modelVo.getWorkorderStatus().intValue()));
			modelVo.setSwitchPersonStr(SwitchPersonEnum.getValue(modelVo.getSwitchPerson().intValue()));
		});
		return new BasePageInfo<>(list);
	}
	
	/**
	 * 获取分配当前用户的工单列表
	 * 条件：dispatch_id不为空，且Person_id是当前用户
	 */
	@Override
	@Transactional
	public BasePageInfo<WorkorderModelVo> selectListByDispatchIdAndPersonId(BasePageInfo<WorkorderModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		PageHelper.orderBy(page.getSortKey().replaceAll("[A-Z]", "_$0").toLowerCase()+" "+page.getSortValue());
		List<WorkorderModelVo> list = mapper.selectListByDispatchIdAndPersonId(page);
		list.stream().forEach(modelVo->{
			modelVo.setPriorityStr(PriorityEnum.getValue(modelVo.getPriority().intValue()));
			modelVo.setWorkorderResourceTypeStr(WorkorderResourceTypeEnum.getValue(modelVo.getWorkorderResourceType().intValue()));
			modelVo.setWorkorderStatusStr(WorkorderStatusEnum.getValue(modelVo.getWorkorderStatus().intValue()));
			modelVo.setSwitchPersonStr(SwitchPersonEnum.getValue(modelVo.getSwitchPerson().intValue()));
		});
		return new BasePageInfo<>(list);
	}
	
	/**
	 * 获取分配当前用户的工单列表
	 * 条件：cc_person_id是当前用户对应的工单列表
	 */
	@Override
	@Transactional
	public BasePageInfo<WorkorderModelVo> selectListByCcPersonId(BasePageInfo<WorkorderModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		PageHelper.orderBy(page.getSortKey().replaceAll("[A-Z]", "_$0").toLowerCase()+" "+page.getSortValue());
		List<WorkorderModelVo> list = mapper.selectListByCcPersonId(page);
		list.stream().forEach(modelVo->{
			modelVo.setPriorityStr(PriorityEnum.getValue(modelVo.getPriority().intValue()));
			modelVo.setWorkorderResourceTypeStr(WorkorderResourceTypeEnum.getValue(modelVo.getWorkorderResourceType().intValue()));
			modelVo.setWorkorderStatusStr(WorkorderStatusEnum.getValue(modelVo.getWorkorderStatus().intValue()));
			modelVo.setSwitchPersonStr(SwitchPersonEnum.getValue(modelVo.getSwitchPerson().intValue()));
		});
		return new BasePageInfo<>(list);
	}
	
	/**
	 * 获取当前用户关注的工单列表
	 * 条件：attention_id是当前用户对应的工单列表
	 */
	@Override
	@Transactional
	public BasePageInfo<WorkorderModelVo> selectListByAttentionId(BasePageInfo<WorkorderModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		PageHelper.orderBy(page.getSortKey().replaceAll("[A-Z]", "_$0").toLowerCase()+" "+page.getSortValue());
		List<WorkorderModelVo> list = mapper.selectListByAttentionId(page);
		list.stream().forEach(modelVo->{
			modelVo.setPriorityStr(PriorityEnum.getValue(modelVo.getPriority().intValue()));
			modelVo.setWorkorderResourceTypeStr(WorkorderResourceTypeEnum.getValue(modelVo.getWorkorderResourceType().intValue()));
			modelVo.setWorkorderStatusStr(WorkorderStatusEnum.getValue(modelVo.getWorkorderStatus().intValue()));
			modelVo.setSwitchPersonStr(SwitchPersonEnum.getValue(modelVo.getSwitchPerson().intValue()));
		});
		return new BasePageInfo<>(list);
	}
	
	/**
	 * 获取当前用户已完成的工单列表
	 * 条件：查询前用户已完成的工单列表信息  进度为100% 并且工单创建人或负责人是当前用户的工单列表
	 */
	@Override
	@Transactional
	public BasePageInfo<WorkorderModelVo> selectListByRate(BasePageInfo<WorkorderModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		PageHelper.orderBy(page.getSortKey().replaceAll("[A-Z]", "_$0").toLowerCase()+" "+page.getSortValue());
		List<WorkorderModelVo> list = mapper.selectListByRate(page);
		list.stream().forEach(modelVo->{
			modelVo.setPriorityStr(PriorityEnum.getValue(modelVo.getPriority().intValue()));
			modelVo.setWorkorderResourceTypeStr(WorkorderResourceTypeEnum.getValue(modelVo.getWorkorderResourceType().intValue()));
			modelVo.setWorkorderStatusStr(WorkorderStatusEnum.getValue(modelVo.getWorkorderStatus().intValue()));
			modelVo.setSwitchPersonStr(SwitchPersonEnum.getValue(modelVo.getSwitchPerson().intValue()));
		});
		return new BasePageInfo<>(list);
	}
	
	/**
	 * 获取当前用户已激活的工单列表
	 * 条件：查询前用户已完成的工单列表信息  workorderId 为已激活状态 并且工单创建人或负责人是当前用户的工单列表
	 */
	@Override
	@Transactional
	public BasePageInfo<WorkorderModelVo> selectListByRestart(BasePageInfo<WorkorderModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		PageHelper.orderBy(page.getSortKey().replaceAll("[A-Z]", "_$0").toLowerCase()+" "+page.getSortValue());
		List<WorkorderModelVo> list = mapper.selectListByRestart(page);
		list.stream().forEach(modelVo->{
			modelVo.setPriorityStr(PriorityEnum.getValue(modelVo.getPriority().intValue()));
			modelVo.setWorkorderResourceTypeStr(WorkorderResourceTypeEnum.getValue(modelVo.getWorkorderResourceType().intValue()));
			modelVo.setWorkorderStatusStr(WorkorderStatusEnum.getValue(modelVo.getWorkorderStatus().intValue()));
			modelVo.setSwitchPersonStr(SwitchPersonEnum.getValue(modelVo.getSwitchPerson().intValue()));
		});
		return new BasePageInfo<>(list);
	}
	
	/**
	 * 获取当前用户已关闭的工单列表
	 * 条件：查询前用户已完成的工单列表信息  workorderId 为已关闭状态 并且工单创建人或负责人是当前用户的工单列表
	 */
	@Override
	@Transactional
	public BasePageInfo<WorkorderModelVo> selectListByClosed(BasePageInfo<WorkorderModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		PageHelper.orderBy(page.getSortKey().replaceAll("[A-Z]", "_$0").toLowerCase()+" "+page.getSortValue());
		List<WorkorderModelVo> list = mapper.selectListByClosed(page);
		list.stream().forEach(modelVo->{
			modelVo.setPriorityStr(PriorityEnum.getValue(modelVo.getPriority().intValue()));
			modelVo.setWorkorderResourceTypeStr(WorkorderResourceTypeEnum.getValue(modelVo.getWorkorderResourceType().intValue()));
			modelVo.setWorkorderStatusStr(WorkorderStatusEnum.getValue(modelVo.getWorkorderStatus().intValue()));
			modelVo.setSwitchPersonStr(SwitchPersonEnum.getValue(modelVo.getSwitchPerson().intValue()));
		});
		return new BasePageInfo<>(list);
	}
	/**
	 * 获取当前用户参与的工单列表
	 * 条件：该工单下所有工序的负责人和所有工序的参与人是当前用户的
	 */
	@Override
	@Transactional
	public BasePageInfo<WorkorderModelVo> selectListParticipantUserId(BasePageInfo<WorkorderModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		PageHelper.orderBy(page.getSortKey().replaceAll("[A-Z]", "_$0").toLowerCase()+" "+page.getSortValue());
		List<WorkorderModelVo> list = mapper.selectListParticipantUserId(page);
		list.stream().forEach(modelVo->{
			modelVo.setPriorityStr(PriorityEnum.getValue(modelVo.getPriority().intValue()));
			modelVo.setWorkorderResourceTypeStr(WorkorderResourceTypeEnum.getValue(modelVo.getWorkorderResourceType().intValue()));
			modelVo.setWorkorderStatusStr(WorkorderStatusEnum.getValue(modelVo.getWorkorderStatus().intValue()));
			modelVo.setSwitchPersonStr(SwitchPersonEnum.getValue(modelVo.getSwitchPerson().intValue()));
		});
		return new BasePageInfo<>(list);
	}
	
	/**
	 * 获取当前用户领取的工单列表
	 * 条件：查询前用户的工单列表信息  dispatch_pool_id 不为null的工单列表
	 */
	@Override
	@Transactional
	public BasePageInfo<WorkorderModelVo> selectListByDispatchPoolId(BasePageInfo<WorkorderModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		PageHelper.orderBy(page.getSortKey().replaceAll("[A-Z]", "_$0").toLowerCase()+" "+page.getSortValue());
		List<WorkorderModelVo> list = mapper.selectListByDispatchPoolId(page);
		list.stream().forEach(modelVo->{
			modelVo.setPriorityStr(PriorityEnum.getValue(modelVo.getPriority().intValue()));
			modelVo.setWorkorderResourceTypeStr(WorkorderResourceTypeEnum.getValue(modelVo.getWorkorderResourceType().intValue()));
			modelVo.setWorkorderStatusStr(WorkorderStatusEnum.getValue(modelVo.getWorkorderStatus().intValue()));
			modelVo.setSwitchPersonStr(SwitchPersonEnum.getValue(modelVo.getSwitchPerson().intValue()));
		});
		return new BasePageInfo<>(list);
	}

	/**
	 * 新建验收
	 */
	@Override
	@WorkorderLogAnno(resultType=6)
	@OptionAnno(type=4)
	@Transactional
	public Integer acceptance(AcceptanceModel model) {
		// TODO Auto-generated method stub
		return acceptanceService.insert(model);
	}

	/**
	 * 获取一条验收详情
	 */
	@Override
	@Transactional
	public AcceptanceModelVo selectByAcceptanceId(Long acceptanceId) {
		// TODO Auto-generated method stub
		return acceptanceService.selectByPrimaryKey(acceptanceId);
	}

	/**
	 * 新建一条验收内容
	 */
	@Override
	@Transactional
	public Integer insertAcceptanceContent(AcceptanceContentModel model) {
		// TODO Auto-generated method stub
		return acceptanceContentService.insert(model);
	}

	/**
	 * 通过验收id获取验收
	 */
	@Override
	@Transactional
	public List<AcceptanceContentModelVo> selectListByAcceptanceId(Long acceptanceId) {
		// TODO Auto-generated method stub
		return acceptanceId == null ? null : acceptanceContentService.selectListByAcceptanceId(acceptanceId);
	}

	@Override
	@Transactional
	public Integer insertAcceptanceFile(AcceptanceFileModelVo modelVo) {
		// TODO Auto-generated method stub
		return acceptanceFileService.insert(modelVo);
	}

	@Override
	@Transactional
	public List<AcceptanceFileModelVo> selectFileListByAcceptanceId(Long acceptanceId) {
		// TODO Auto-generated method stub
		return acceptanceFileService.selectListByAcceptanceId(acceptanceId);
	}

	/**
	 * 通过工单池Id获取工单列表，带联系人
	 */
	@Override
	@Transactional
	public BasePageInfo<WorkorderModelVo> selectListByPoolId(BasePageInfo<WorkorderModelVo> page) {
		// TODO Auto-generated method stub
		List<WorkorderModelVo> list = mapper.selectListByPoolId(page);
		list.stream().filter(model-> model.getContactModel()== null && model.getContactId() != null && model.getCustomerId() != null).forEach(modelVo->{
			CrmContactModel crmContactModel = crmContactService.selectById(modelVo.getContactId());
			ContactModel contactModel = new ContactModel(crmContactModel);
			contactModel.setWorkorderId(modelVo.getWorkorderId());
			contactModel.setAddress(crmCustomerService.selectAddressByCustomerId(modelVo.getCustomerId()));
			modelVo.setContactModel(contactModel);
		});
		list.stream().forEach(model->{
			model.setPriorityStr(PriorityEnum.getValue(model.getPriority().intValue()));
			model.setWorkorderResourceTypeStr(WorkorderResourceTypeEnum.getValue(model.getWorkorderResourceType().intValue()));
			model.setWorkorderStatusStr(WorkorderStatusEnum.getValue(model.getWorkorderStatus().intValue()));
		});
		return new BasePageInfo<>(list);
	}

	/**
	 * 通过工单Id获取工单验收列表
	 */
	@Override
	@Transactional
	public List<AcceptanceModelVo> selectAcceptanceListByWorkorderId(Long workorderId) {
		// TODO Auto-generated method stub
		return acceptanceService.selectListByWorkorderId(workorderId);
	}

	/**
	 * 新建一条工单评价
	 */
	@Override
	@OptionAnno(type=5)
	@Transactional
	public Integer insertCommentModel(CommentModel commentModel) {
		// TODO Auto-generated method stub
		return commentService.insert(commentModel);
	}

	
	
	/**
	 * 根据工单id获取评价列表
	 */
	@Override
	@Transactional
	public List<CommentModel> selectCommentListByWorkorderId(Long workorderId) {
		// TODO Auto-generated method stub
		return workorderId == null ? null : commentService.selectListByWorkorderId(workorderId);
	}
	

	
}

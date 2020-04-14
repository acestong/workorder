package com.fea.project.service.publish.impl;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.publish.PublishModelMapper;
import com.fea.project.enums.publish.*;
import com.fea.project.enums.task.WorkTaskStatusEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.publish.*;
import com.fea.project.model.publish.vo.*;
import com.fea.project.model.task.vo.WorkStatusVo;
import com.fea.project.service.publish.*;
import com.fea.project.service.task.ITaskService;
import com.fea.project.service.websocket.WebSocketServer;
import com.fea.project.util.AddressUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PublishServiceImpl implements IPublishService {

	@Resource
	private PublishModelMapper mapper;
	
	@Resource
	private IPublishScopeService publishScopeService;

	@Resource
	private IPublishAppointService publishAppointService;
	@Resource
    private SysUserService sysUserService;
	@Resource
	private IPublishImageService publishImageService;
	@Resource
	private IPublishFileService publishFileService;
	@Resource
	private IPublishLikeService publishLikeServcie;
	@Resource
	private IPublishCommentService publishCommentService;
	@Resource
	private IPublishCommentReplyService publishCommentReplyService;
	@Resource
	private IPublishCollectService publishCollectService;
	@Resource
	private ITaskService taskService;
	
	
	/**
	 * 新增一条动态和多个发布范围,非转发动态
	 */
	@Override
	public void save(PublishModelVo publishModelVo) {
		// TODO Auto-generated method stub
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		publishModelVo.setUserId(currentUsr.getUserId());
		publishModelVo.setUserName(currentUsr.getRealName());
		publishModelVo.setRegId(currentUsr.getRegId());
		publishModelVo.setCreateTime(new Date());
		publishModelVo.setBusinessType(BusinessTypeEnum.DESKTOP_PUB.getStatus().longValue());
			if(publishModelVo.getPlace() == null  || publishModelVo.getIp() !=null) {
				publishModelVo.setPlace(AddressUtils.getAddresses("ip="+publishModelVo.getIp(), "utf-8"));
			}
		mapper.insertSelective(publishModelVo);
		if(publishModelVo.getScopeDepartmentList() != null && publishModelVo.getScopeDepartmentList().size() >0) {
			saveScopeDepartment(publishModelVo);
		}
		if(publishModelVo.getScopePersonList() != null && publishModelVo.getScopePersonList().size() >0 ) {
			saveScopePerson(publishModelVo);
		}
		if(publishModelVo.getAppendixIdList() != null && publishModelVo.getAppendixIdList().size() >0 ) {
			saveAppendixIdList(publishModelVo);
		}
		if(publishModelVo.getImageInfoList() != null && publishModelVo.getImageInfoList().size() >0 ) {
			saveImagenfoList(publishModelVo);
		}
		if(publishModelVo.getAppointUserList() != null && publishModelVo.getAppointUserList().size() >0) {
			saveAppointUser(publishModelVo);
		}
	}

	//删除publish模型，暂未删除其他相关数据，如赞，图片等
	@Override
	public void delete(PublishModelVo publishModelVo) {
		// TODO Auto-generated method stub
		if(publishModelVo.getPublishId() == null) {
			throw new SystemParamCheckException("publishId传入异常，无法进行删除");
		}
		mapper.deleteByPrimaryKey(publishModelVo.getPublishId());
	}

	/**
	 * 获取我的所有动态，条件：公开可见的、我部门可见的、我可见的、按照发布人模糊搜索的、按照创建时间降序排列的
	 */
	@Override
	public BasePageInfo<PublishViewVo> getAll(BasePageInfo<PublishGetViewVo> page) {
		// TODO Auto-generated method stub
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		PublishGetViewVo model = page.getModel();
		model.setUserId(currentUsr.getUserId());
		model.setRegId(currentUsr.getRegId());
//		model.setRegId(14383335124397610L);
//		model.setUserId(535L);
		page.setModel(model);
		if(page.getKeywords() != null) {
			page.setKeywords("%"+page.getKeywords()+"%");
		}else {
			page.setKeywords("%%");
		}
		PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
		List<PublishModel> selectAll = mapper.selectAllPublishWithMe(page);
		List<PublishViewVo> viewVoList = new ArrayList<PublishViewVo>();
		for (PublishModel publishModel : selectAll) {
			PublishViewVo publishViewVo = new PublishViewVo(publishModel);
			//获取该动态Id下所有的图片
			publishViewVo.setImageList(publishImageService.getAll(publishModel.getPublishId()));
			//获取该动态id下所有的附件
			publishViewVo.setFileList(publishFileService.getAll(publishModel.getPublishId()));
			//获取动态创建人头像
			publishViewVo.setUserImagePath(mapper.selectUserImage(publishModel.getPublishId()));
			viewVoList.add(publishViewVo);
			//返回客户端类型
			publishViewVo.setOriginTypeStr(PublishResourceEnum.getValue(publishViewVo.getOriginType().intValue()));
			//返回所有赞的集合
			List<PublishLikeModel> likeList = publishLikeServcie.getAll(publishModel.getPublishId());
			List<PublishLikeViewVo> likeLikeVo = new ArrayList<PublishLikeViewVo>();
			for (PublishLikeModel publishLikeModel : likeList) {
				PublishLikeViewVo publishLikeViewVo = new PublishLikeViewVo(publishLikeModel);
				publishLikeViewVo.setUserImagePath(mapper.selectUserImageByUserId(publishLikeModel.getUserId()));
				likeLikeVo.add(publishLikeViewVo);
			}
			publishViewVo.setLikeList(likeLikeVo);
			//返回获赞数
			publishViewVo.setLikeCount(likeList.size());
			//获取当前动态下的所有评论
			List<PublishCommentViewVo> publishCommentViewVoList = publishCommentService.getAll(publishModel.getPublishId());
			for (PublishCommentViewVo publishCommentViewVo : publishCommentViewVoList) {
				//获取当前评论下的回复
				publishCommentViewVo.setReplyList(publishCommentReplyService.getAll(publishCommentViewVo.getPublishCommentId()));
			}
			publishViewVo.setCommentList(publishCommentViewVoList);
			//获取该评论的个数
			publishViewVo.setCommentCount(publishCommentViewVoList.size());
			//获取是否收藏
			PublishCollectModel collectModel = publishCollectService.getOne(new PublishCollectModel(null, publishModel.getPublishId(), null, currentUsr.getUserId(), null));
			publishViewVo.setIsCollect(collectModel == null ? IsCollectEnum.NOT_COLLECT.getStatus(): IsCollectEnum.COLLECT.getStatus());
			//获取转发动态模型
			if(publishModel.getTransmitedPublishId() != null) {
				publishViewVo.setTransmitedPublishModel(getOne(publishModel.getTransmitedPublishId()));
			}
			
		}
		return new BasePageInfo<>(viewVoList);
	}

	/*
	 *按照前端传入的部门id和名称集合，新增范围数据
	 */
	private void saveScopeDepartment(PublishModelVo publishModelVo) {
		PublishScopeModel model = new PublishScopeModel();
		model.setPublishId(publishModelVo.getPublishId());
		model.setScopeType(ScopeEnum.DEPARTMENT.getStatus().longValue());
		if(publishModelVo.getScopeDepartmentList() != null) {
			for (Map<Long,String> map : publishModelVo.getScopeDepartmentList()) {
				for (Long id : map.keySet()) {
					model.setScopeDepartmentId(id);
					model.setScopeDepartmentName(map.get(id));
					publishScopeService.save(model);
				}
			}
		}
	}
	
	
	/*
	 *按照前端传入的个人id和名称集合，新增范围数据
	 */
	private void saveScopePerson(PublishModelVo publishModelVo) {
		PublishScopeModel model = new PublishScopeModel();
		model.setPublishId(publishModelVo.getPublishId());
		model.setScopeType(ScopeEnum.PERSON.getStatus().longValue());
		if(publishModelVo.getScopePersonList() != null) {
			for (Map<Long,String> map : publishModelVo.getScopeDepartmentList()) {
				for (Long id : map.keySet()) {
					model.setScopePersonId(id);
					model.setScopePersonName(map.get(id));
					publishScopeService.save(model);
				}
			}
		}
	}
	
	
	/*
	 *按照前端传入的个人id和名称集合，新增@提醒
	 */
	private void saveAppointUser(PublishModelVo publishModelVo) {
		PublishAppointModel model = new PublishAppointModel();
		if(publishModelVo.getAppointUserList() != null) {
			for (Map<Long,String> map : publishModelVo.getAppointUserList()) {
				for (Long id : map.keySet()) {
					model.setPublishAppointUserId(id);
					model.setPublishAppointUserName(map.get(id));
					model.setPublishId(publishModelVo.getPublishId());
					publishAppointService.save(model);
				}
			}
		}
	}
	/*
	 *按照前端传入的个人id和名称集合，新增@提醒
	 */
	private void saveAppendixIdList(PublishModelVo publishModelVo) {
		PublishFileModel model = new PublishFileModel();
		if(publishModelVo.getAppointUserList() != null) {
			for (Long id : publishModelVo.getAppendixIdList()) {
				model.setPubishId(publishModelVo.getPublishId());
				model.setPublishFileId(id);
				publishFileService.save(model);
			}
		}
	}
	
	
	/*
	 *按照前端传入的个人id和名称集合，新增@提醒
	 */
	private void saveImagenfoList(PublishModelVo publishModelVo) {
		PublishImageModel model = new PublishImageModel();
		if(publishModelVo.getImageInfoList() != null) {
			for (Map<Long,String> map : publishModelVo.getImageInfoList()) {
				for (Long id : map.keySet()) {
					model.setPublishId(publishModelVo.getPublishId());
					model.setPublishImagePath(map.get(id));
					publishImageService.save(model);
				}
			}
		}
	}
	
	/*
	 * 通过动态id获取一条动态
	 */
	private PublishViewVo getOne(Long publishId) {
		if(publishId == null) {
			throw new SystemParamCheckException("publishId传入为空，无法进行查询动态");
		}
		PublishModel selectByPrimaryKey = mapper.selectByPrimaryKey(publishId);
		PublishViewVo transmitedPublishViewVo = new PublishViewVo(selectByPrimaryKey);
		//获取该转发动态Id下所有的图片
		transmitedPublishViewVo.setImageList(publishImageService.getAll(publishId));
		//获取该动态id下所有的附件
		transmitedPublishViewVo.setFileList(publishFileService.getAll(publishId));
		return transmitedPublishViewVo;
		
	}

	@Override
	public List<PublishNavigateViewVo> getAllCount(Long businessId,Long businessType) {
		// TODO Auto-generated method stub
		List<PublishNavigateViewVo> viewVoList = new ArrayList<PublishNavigateViewVo>();
		for (int i = 1; i <= PublishNavigateTypeEnum.values().length; i++) {
			PublishNavigateViewVo publishNavigateViewVo = new PublishNavigateViewVo();
			switch (i) {
			case 1:
			case 3:
				publishNavigateViewVo = new PublishNavigateViewVo(i, PublishNavigateTypeEnum.getValue(i), null);
				viewVoList.add(publishNavigateViewVo);
				break;
			case 2:
				publishNavigateViewVo = new PublishNavigateViewVo(i, PublishNavigateTypeEnum.getValue(i), publishAppointService.getTotalCount());
				viewVoList.add(publishNavigateViewVo);
				break;
			case 4:
				publishNavigateViewVo = new PublishNavigateViewVo(i, PublishNavigateTypeEnum.getValue(i), publishLikeServcie.getTotalCount());
				viewVoList.add(publishNavigateViewVo);
				break;
			case 5:
				publishNavigateViewVo = new PublishNavigateViewVo(i, PublishNavigateTypeEnum.getValue(i), publishCommentService.getTotalCount());
				viewVoList.add(publishNavigateViewVo);
				break;
			case 6:
				publishNavigateViewVo = new PublishNavigateViewVo(i, PublishNavigateTypeEnum.getValue(i), publishCommentService.getTotalCountMe());
				viewVoList.add(publishNavigateViewVo);
				break;
			case 7:
				publishNavigateViewVo = new PublishNavigateViewVo(i, PublishNavigateTypeEnum.getValue(i), null);
				viewVoList.add(publishNavigateViewVo);
				break;
			case 8:
				publishNavigateViewVo = new PublishNavigateViewVo(i, PublishNavigateTypeEnum.getValue(i), null);
				viewVoList.add(publishNavigateViewVo);
				break;

			default:
				break;
			}
			
		}
		return viewVoList;
	}

	@Override
	public EmpInfoVo getUserInfo() {
		// TODO Auto-generated method stub
		EmpInfoVo selectEmpInfoVoByCurUserId = mapper.selectEmpInfoVoByCurUserId(sysUserService.getCurrentUsr().getUserId());
		selectEmpInfoVoByCurUserId.setGenderStr(GenderEnum.getValue(selectEmpInfoVoByCurUserId.getGender().intValue()));
		WorkStatusVo selectCurWorkStatusByCurUserInfo = taskService.selectCurWorkStatusByCurUserInfo();
		if(selectCurWorkStatusByCurUserInfo != null && selectCurWorkStatusByCurUserInfo.getWorkStatus() == WorkTaskStatusEnum.IS_WORKTASK.getStatus().longValue()) {
			selectEmpInfoVoByCurUserId.setWorkStatus(selectCurWorkStatusByCurUserInfo.getWorkStatus());
			selectEmpInfoVoByCurUserId.setWorkStatusStr("工作中");
			selectEmpInfoVoByCurUserId.setTaskStartTime(selectCurWorkStatusByCurUserInfo.getTaskStartTime());
			selectEmpInfoVoByCurUserId.setTaskEndTime(selectCurWorkStatusByCurUserInfo.getTaskEndTime());
			selectEmpInfoVoByCurUserId.setWorkHour(selectCurWorkStatusByCurUserInfo.getWorkHour());
		}else if(selectCurWorkStatusByCurUserInfo == null || selectCurWorkStatusByCurUserInfo.getWorkStatus() == WorkTaskStatusEnum.IS_NOT_WORKTASK.getStatus().longValue()){
			selectEmpInfoVoByCurUserId.setWorkStatus(1L);//1代表空闲状态
			selectEmpInfoVoByCurUserId.setWorkStatusStr("空闲中");
		}
		return selectEmpInfoVoByCurUserId;
	}

	@Override
	public List<ProjectUserViewVo> selectScopeUserListByprojectId(Long projectId) {
		// TODO Auto-generated method stub
		if(projectId == null) {
			throw new SystemParamCheckException("projectId传入为空，无法回显人员列表");
		}
		List<ProjectUserViewVo> list = publishScopeService.selectScopeUserListByprojectId(projectId);
		List<ProjectUserViewVo> listTemp = new ArrayList<ProjectUserViewVo>();
		//按照枚举添加性别字符串,gender为空是，设置值为“保密”
		for (ProjectUserViewVo projectUserViewVo : list) {
			if(projectUserViewVo.getGender() == null) {
				projectUserViewVo.setGenderStr(GenderEnum.SECRET.getInfo());
			}else{
				projectUserViewVo.setGenderStr(GenderEnum.getValue(projectUserViewVo.getGender().intValue()));
			}
			listTemp.add(projectUserViewVo);
		}
		return listTemp;
	}

	
	
	
}

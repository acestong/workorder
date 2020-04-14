package com.fea.project.workorder.model.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.plan.vo.AppendixIdAndNameInfoModelVo;
import com.fea.project.workorder.model.ContactModel;
import com.fea.project.workorder.model.WorkorderModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 工单显示Vo
 * @author st
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkorderModelVo extends WorkorderModel {

	private static final long serialVersionUID = 1L;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<Long> appendixList;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<AppendixIdAndNameInfoModelVo> appendixInfoList;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<PersonInfoModelVo> ccList;
	
	private String priorityStr;
	
	private String switchPersonStr;
	
	private String workorderStatusStr;
	
	private String workorderResourceTypeStr;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<ProcedureModelVo> procedureList;
	
	/**
	 * 存放联系人信息
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private ContactModel contactModel;
	
	
	public WorkorderModelVo(WorkorderModel model) {
		super.setAttentionStatus(model.getAttentionStatus());
		super.setBusinessId(model.getBusinessId());
		super.setBusinessName(model.getBusinessName());
		super.setBusinessType(model.getBusinessType());
		super.setWorkorderStatus(model.getWorkorderStatus());
		super.setContactId(model.getContactId());
		super.setContactName(model.getContactName());
		super.setCreateBy(model.getCreateBy());
		super.setCreateId(model.getCreateId());
		super.setCreateTime(model.getCreateTime());
		super.setCustomerId(model.getCustomerId());
		super.setCustomerName(model.getCustomerName());
		super.setDeadlineTime(model.getDeadlineTime());
		super.setDelStatus(model.getDelStatus());
		super.setEndTime(model.getEndTime());
		super.setMouldId(model.getMouldId());
		super.setMouldName(model.getMouldName());
		super.setPersonId(model.getPersonId());
		super.setPersonName(model.getPersonName());
		super.setPriority(model.getPriority());
		super.setProductId(model.getProductId());
		super.setProductName(model.getProductName());
		super.setProductTroubleSortId(model.getProductTroubleSortId());
		super.setProductTroubleTypeId(model.getProductTroubleTypeId());
		super.setRemark(model.getRemark());
		super.setRejectReason(model.getRejectReason());
		super.setStartTime(model.getStartTime());
		super.setSwitchPerson(model.getSwitchPerson());
		super.setTaskId(model.getTaskId());
		super.setTaskName(model.getTaskName());
		super.setUpdateBy(model.getUpdateBy());
		super.setUpdateId(model.getUpdateId());
		super.setUpdateTime(model.getUpdateTime());
		super.setWishDealTime(model.getWishDealTime());
		super.setWorkHour(model.getWorkHour());
		super.setWorkorderContent(model.getWorkorderContent());
		super.setWorkorderId(model.getWorkorderId());
		super.setWorkorderName(model.getWorkorderName());
		super.setWorkorderNum(model.getWorkorderNum());
		super.setWorkorderProgrossRate(model.getWorkorderProgrossRate());
		super.setWorkorderResourceType(model.getWorkorderResourceType());
		super.setWorkorderTypeId(model.getWorkorderTypeId());
	}
}

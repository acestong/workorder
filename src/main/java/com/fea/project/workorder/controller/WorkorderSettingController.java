package com.fea.project.workorder.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fea.project.workorder.model.CommentWeightModel;
import com.fea.project.workorder.model.WorkorderTypeModel;
import com.fea.project.workorder.model.vo.TypeModelVo;
import com.fea.project.workorder.service.ICommentWeightService;
import com.fea.project.workorder.service.IWorkorderTypeService;

/**
 * 工单设置controller
 * @author st
 * @since 2020/03/26
 *
 */
@RestController
@RequestMapping("/workorderSetting")
public class WorkorderSettingController {

	@Resource
	private ICommentWeightService commentWeightService;
	@Resource
	private IWorkorderTypeService workorderTypeService;
	
	@PostMapping("/updateWeight")
	public void  update(@RequestBody CommentWeightModel model) {
		commentWeightService.update(model);
	}
	
	
	@RequestMapping("/selectByOrgId")
	public CommentWeightModel  selectByOrgId() {
		return commentWeightService.selectByOrgId();
	}
	
	@PostMapping("/insertType")
	public void  insertType(@RequestBody WorkorderTypeModel model) {
		workorderTypeService.insert(model);
	}
	
	@RequestMapping("/selectRootTypeListByorgId")
	public List<TypeModelVo>  selectRootTypeListByorgId() {
		return workorderTypeService.selectRootTypeListByorgId();
	}
	
}

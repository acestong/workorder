package com.fea.project.workorder.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fea.project.api.other.service.base.SysDepartmentService;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.team.vo.TeamPersonSelectVo;
import com.fea.project.util.UserUtil;
import com.fea.project.workorder.model.vo.ProcedureModelVo;
import com.fea.project.workorder.model.vo.ProcedureReportModelVo;
import com.fea.project.workorder.service.IProcedureReportService;
import com.fea.project.workorder.service.IProcedureService;

/**
 * 工序Controller
 * @author st
 * @since 2020/03/20
 *
 */
@RestController
@RequestMapping("/procedure")
public class ProcedureController {

	@Resource
	private IProcedureService service;
	@Resource
	private IProcedureReportService procedureReportService;
	@Resource
	private SysDepartmentService sysDepartmentService;
	
	@PostMapping("/insert")
	public Long insert(@RequestBody ProcedureModelVo modelVo) {
		return service.insert(modelVo);
	}
	
	@PostMapping("/selectByPrimaryKey")
	public ProcedureModelVo selectByPrimaryKey(@RequestBody ProcedureModelVo modelVo) {
		return service.selectByPrimaryKey(modelVo.getProcedureId());
	}
	
	@PostMapping("/insertReport")
	public void insertReport(@RequestBody ProcedureReportModelVo modelVo) {
		procedureReportService.insert(modelVo);
	}
	
	@PostMapping("/selectByReportId")
	public ProcedureReportModelVo selectByReportId(@RequestBody ProcedureReportModelVo modelVo) {
		return procedureReportService.selectById(modelVo.getId());
	}
	@GetMapping("/selectAvgRate") 
	public Double selectAvgRate(Long workorderId) {
		return procedureReportService.selectAvgRateByWorkorderId(workorderId);
	}
	@PostMapping("/selectByProcedureId") 
	public BasePageInfo<ProcedureReportModelVo> selectByProcedureId(@RequestBody BasePageInfo<ProcedureReportModelVo> page) {
		return procedureReportService.selectByProcedureId(page);
	}
	@PostMapping("/selectListByLeaderId") 
	public BasePageInfo<ProcedureModelVo> selectListByLeaderId(@RequestBody BasePageInfo<ProcedureModelVo> page) {
		return service.selectListByLeaderId(page);
	}
	
	@RequestMapping("/selectDeptTreeByRegId")
	public List<TeamPersonSelectVo> selectDeptTreeByRegId(){
		return sysDepartmentService.selectDeptTreeByRegId(UserUtil.getUserRegId());
	}
	
	@PostMapping("/selectListByParticipantUserId") 
	public BasePageInfo<ProcedureModelVo> selectListByParticipantUserId(@RequestBody BasePageInfo<ProcedureModelVo> page) {
		return service.selectListByParticipantUserId(page);
	}
}

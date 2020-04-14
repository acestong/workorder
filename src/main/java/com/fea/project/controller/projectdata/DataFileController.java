package com.fea.project.controller.projectdata;

import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.base.vo.ProjectDictionaryItemSelectVo;
import com.fea.project.model.projectdata.AppendixDataFileVo;
import com.fea.project.model.projectdata.DataTeamVo;
import com.fea.project.model.projectdata.FinalTreeVo;
import com.fea.project.model.team.pojo.ProjectTeamPojo;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.service.projectdata.DataFileService;
import com.fea.project.service.team.ProjectTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @author Administrator
 */
@RestController
public class DataFileController {
    @Autowired
    private DataFileService dataFileService;
    @Autowired
    private ProjectTeamService projectTeamService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectAppendixService projectAppendixService;
    /**
    * 获取附件类型(数据字典)
    */
    @RequestMapping("/getAppendixType")
    @ResponseBody
    public List<ProjectDictionaryItemSelectVo> getAppendixType(){
        List<ProjectDictionaryItemSelectVo> appendixType = dataFileService.getAppendixType();
        return appendixType;
    }
    /**
    *通过项目id获取团队树
    * @param projectTeamModel 项目id
    */
    @RequestMapping("/listTeamUserByProjectId")
    @ResponseBody
    public List<FinalTreeVo> listTeamByProjectId(@RequestBody ProjectTeamPojo projectTeamModel) {
        //通过当前项目id，当前用户id获取团队负责人是当前用户的团队
        if (projectTeamModel.getProjectId() == null){
            throw new SystemParamCheckException("参数传入错误");
        }
        List<FinalTreeVo> appendixListByTeam = dataFileService.getAppendixTeamListByProjectId(projectTeamModel.getProjectId());
        return appendixListByTeam;
    }
    /**
     * 获取附件列表
     *
     */
    @RequestMapping("/getAppendixListByProjectId")
    @ResponseBody
    public BasePageInfo<AppendixDataFileVo> listByProjectId(@RequestBody BasePageInfo<DataTeamVo> dataFileVo) {
        //通过当前项目id，当前用户id获取团队负责人是当前用户的团队
        BasePageInfo<AppendixDataFileVo> appendixListByUserId = dataFileService.getAppendixListByIds(dataFileVo);
        return appendixListByUserId;
    }
    /**
     * 新增附件资料
     *
     */
    @RequestMapping("/addAppendixDataFile")
    @ResponseBody
    public AppendixDataFileVo addAppendixDataFile(@RequestBody AppendixDataFileVo dataFileVo) {
        //保存数据
        boolean b = dataFileService.addAppendixDataFile(dataFileVo);
        return dataFileVo;
    }
    @RequestMapping("/getAppendixDataFile")
    @ResponseBody
    public List<ProjectAppendixModel> getAppendixDataFile(@RequestBody AppendixDataFileVo dataFileVo) {
        //保存数据
        ProjectAppendixModel model = new ProjectAppendixModel();
        model.setBusinessId(dataFileVo.getBusinessAppendixId());
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        List<ProjectAppendixModel> modelList = projectAppendixService.selectByModel(model);
        return modelList;
    }
}

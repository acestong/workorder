package com.fea.project.service.baseconfig;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.model.baseconfig.ProjectBaseSetPlanModel;
import com.fea.project.model.baseconfig.ProjectBaseSetTaskModel;
import com.fea.project.model.baseconfig.ProjectCodeModel;
import com.fea.project.model.baseconfig.pojo.ProjectBaseSetPojo;
import com.fea.project.model.baseconfig.vo.ProjectBaseSetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/5 11:51
 **/
@Service
public class ProjectBaseConfigService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectCodeService projectCodeService;


    @Autowired
    private ProjectBaseSetPlanService projectBaseSetPlanService;

    @Autowired
    private ProjectBaseSetTaskService projectBaseSetTaskService;


    public ProjectBaseSetVo selectBaseSetConfig() {
        SysUserModel userModel = sysUserService.getCurrentUsr();
        ProjectCodeModel projectCodeModel = this.projectCodeService.selectOrCreateProjectCodeModel(userModel.getRegId());
        List<ProjectBaseSetPlanModel> projectBaseSetPlanModel = this.projectBaseSetPlanService.selectByRegId(userModel.getRegId());
        List<ProjectBaseSetTaskModel> projectBaseSetTaskModels = this.projectBaseSetTaskService.selectByRegId(userModel.getRegId());
        return new ProjectBaseSetVo(projectCodeModel, projectBaseSetPlanModel, projectBaseSetTaskModels);
    }

    /**
     * 全组织基础设置更新
     * 1 项目编号
     * 2 任务编号
     * 3 计划编号
     * 4 两个流程
     *
     * @param model
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ProjectBaseSetPojo updateBaseSetConfig(ProjectBaseSetPojo model) {
        this.projectCodeService.insertOrUpdateProjectCode(model.getProjectCodeModel());
        this.projectBaseSetPlanService.insertOrUpdateProjectBaseSetPlanModels(model.getProjectBaseSetPlanModels());
        this.projectBaseSetTaskService.insertOrUpdateProjectBaseSetTaskModels(model.getProjectBaseSetTaskModels());
        return model;
    }
}

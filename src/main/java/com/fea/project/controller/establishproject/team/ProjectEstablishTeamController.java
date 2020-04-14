package com.fea.project.controller.establishproject.team;

import com.fea.project.configure.annotations.base.PermissionAnno;
import com.fea.project.model.establishproject.team.ProjectEstablishTeamModel;
import com.fea.project.model.establishproject.pojo.ProjectEstablishTeamPojo;
import com.fea.project.model.establishproject.vo.EstablishTeamPageLeftTeamVo;
import com.fea.project.model.establishproject.vo.ProjectEstablishTeamVo;
import com.fea.project.service.establishproject.team.ProjectEstablishTeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 */
@RestController
@RequestMapping("projectEstablishTeam")
public class ProjectEstablishTeamController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectEstablishTeamController.class);


    @Autowired
    private ProjectEstablishTeamService projectEstablishTeamService;

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectEstablishTeamModel insert(@RequestBody ProjectEstablishTeamModel model) {
        return this.projectEstablishTeamService.insertModel(model);
    }

    /**
     * 获取项目信息
     */
    @RequestMapping("listByProjectId")
    @PermissionAnno("/projectManage/establishProject/establishTeam")
    public EstablishTeamPageLeftTeamVo listByProjectId(@RequestBody ProjectEstablishTeamPojo projectEstablishTeamPojo) {
        return this.projectEstablishTeamService.listByProjectId(projectEstablishTeamPojo);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    @PermissionAnno("/projectManage/establishProject/updateEstablishTeam")
    public ProjectEstablishTeamModel update(@RequestBody ProjectEstablishTeamModel model) {
        return this.projectEstablishTeamService.updateModel(model);
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    @PermissionAnno("/projectManage/establishProject/deleteEstablishTeam")
    public ProjectEstablishTeamModel delete(@RequestBody ProjectEstablishTeamModel model) {
        return this.projectEstablishTeamService.deleteModel(model);
    }

    @RequestMapping("selectTeamByTeamId")
    public ProjectEstablishTeamVo selectTeamByTeamId(@RequestBody ProjectEstablishTeamModel model) {
        return this.projectEstablishTeamService.selectTeamByTeamId(model);
    }

    @RequestMapping("exchangeTeamIndex")
    public List<Long> exchangeTeamIndex(@RequestBody List<Long> ids) {
        return this.projectEstablishTeamService.exchangeTeamIndex(ids);
    }


}
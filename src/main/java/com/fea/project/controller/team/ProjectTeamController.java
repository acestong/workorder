package com.fea.project.controller.team;

import com.fea.project.model.team.ProjectTeamModel;
import com.fea.project.model.team.pojo.ProjectTeamPojo;
import com.fea.project.model.team.vo.ProjectTeamVo;
import com.fea.project.model.team.vo.TeamPageLeftTeamVo;
import com.fea.project.service.team.ProjectTeamService;
import org.apache.ibatis.annotations.Param;
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
@RequestMapping("projectTeam")
public class ProjectTeamController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectTeamController.class);


    @Autowired
    private ProjectTeamService projectTeamService;

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectTeamModel insert(@RequestBody ProjectTeamModel model) {
        return this.projectTeamService.insertModel(model);
    }

    /**
     * 获取项目信息
     */
    @RequestMapping("listByProjectId")
    public TeamPageLeftTeamVo listByProjectId(@RequestBody ProjectTeamPojo projectTeamModel) throws CloneNotSupportedException {
        return this.projectTeamService.listByProjectId(projectTeamModel);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectTeamModel update(@RequestBody ProjectTeamModel model) {
        return this.projectTeamService.updateModel(model);
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectTeamModel delete(@RequestBody ProjectTeamModel model) {
        return this.projectTeamService.deleteModel(model);
    }

    @RequestMapping("selectTeamByTeamId")
    public ProjectTeamVo selectTeamByTeamId(@RequestBody ProjectTeamModel model) {
        return this.projectTeamService.selectTeamByTeamId(model);
    }

    @RequestMapping("exchangeTeamIndex")
    public List<Long> exchangeTeamIndex(@RequestBody List<Long> ids) {
        return this.projectTeamService.exchangeTeamIndex(ids);
    }

}
package com.fea.project.controller.flow;

import com.fea.project.enums.flow.base.ProjectFlowVerifyTypeEnum;
import com.fea.project.model.flow.ProjectFlowListModel;
import com.fea.project.model.flow.pojo.ProjectFlowListPojo;
import com.fea.project.model.flow.vo.ProjectFlowListVo;
import com.fea.project.service.flow.ProjectFlowListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */
@RestController
@RequestMapping("projectFlowList")
public class ProjectFlowListController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectFlowListController.class);


    @Autowired
    private ProjectFlowListService projectFlowListService;


    @RequestMapping("selectProjectFlowListByParam")
    public List<ProjectFlowListVo> selectProjectFlowListByParam(@RequestBody ProjectFlowListModel model) {
        return this.projectFlowListService.selectProjectFlowListByParam(model);
    }


    @RequestMapping("updateModel")
    public ProjectFlowListPojo updateModel(@RequestBody ProjectFlowListPojo model) {
        return this.projectFlowListService.updateModel(model, ProjectFlowVerifyTypeEnum.TYPE_CONDITION);
    }

    @RequestMapping("selectList")
    public List<ProjectFlowListVo> selectList(@RequestBody ProjectFlowListPojo model) {
        return this.projectFlowListService.selectList(model);
    }

    @RequestMapping("exchangeIndex")
    public List<Long> exchangeIndex(@RequestBody List<Long> ids) {
        return this.projectFlowListService.exchangeIndex(ids);
    }



}
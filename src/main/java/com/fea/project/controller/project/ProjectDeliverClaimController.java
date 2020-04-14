package com.fea.project.controller.project;

import com.fea.project.model.project.ProjectDeliverClaimModel;
import com.fea.project.model.project.vo.ProjectDeliverClaimVo;
import com.fea.project.service.project.ProjectDeliverClaimService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/09/30.
 */
@RestController
@RequestMapping("projectDeliverClaim")
public class ProjectDeliverClaimController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectDeliverClaimController.class);


    @Autowired
    private ProjectDeliverClaimService projectDeliverClaimService;

    /**
     * 插入数据
     */
    @RequestMapping("insertModel")
    public ProjectDeliverClaimModel insertModel(@RequestBody ProjectDeliverClaimModel model) {
        return this.projectDeliverClaimService.insertModel(model);
    }

    /**
     * 按模型选择
     */
    @RequestMapping("listByProjectId")
    public List<ProjectDeliverClaimVo> listByProjectId(@RequestBody ProjectDeliverClaimModel model) {
        return this.projectDeliverClaimService.listByProjectId(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("updateModel")
    public ProjectDeliverClaimModel updateModel(@RequestBody ProjectDeliverClaimModel model) {
        return this.projectDeliverClaimService.updateModel(model);
    }

    /**
     * 按主键删除
     */
    @RequestMapping("deleteModel")
    public ProjectDeliverClaimModel deleteModel(@RequestBody ProjectDeliverClaimModel model) {
        return this.projectDeliverClaimService.deleteModel(model);
    }
}
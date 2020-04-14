package com.fea.project.controller.establishproject.project;

import com.fea.project.configure.annotations.base.PermissionAnno;
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
@RequestMapping("establishProjectDeliverClaim")
public class EstablishProjectDeliverClaimController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EstablishProjectDeliverClaimController.class);


    @Autowired
    private ProjectDeliverClaimService projectDeliverClaimService;

    /**
     * 插入数据
     */
    @RequestMapping("insertModel")
    @PermissionAnno("/projectManage/establishProject/insertDeliverClaim")
    public ProjectDeliverClaimModel insertModel(@RequestBody ProjectDeliverClaimModel model) {
        return this.projectDeliverClaimService.insertModel(model);
    }

    /**
     * 按模型选择
     */
    @RequestMapping("listByProjectId")
    @PermissionAnno("/projectManage/establishProject/deliverClaim")
    public List<ProjectDeliverClaimVo> listByProjectId(@RequestBody ProjectDeliverClaimModel model) {
        return this.projectDeliverClaimService.listByProjectId(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("updateModel")
    @PermissionAnno("/projectManage/establishProject/updateDeliverClaim")
    public ProjectDeliverClaimModel updateModel(@RequestBody ProjectDeliverClaimModel model) {
        return this.projectDeliverClaimService.updateModel(model);
    }

    /**
     * 按主键删除
     */
    @RequestMapping("deleteModel")
    @PermissionAnno("/projectManage/establishProject/deleteDeliverClaim")
    public ProjectDeliverClaimModel deleteModel(@RequestBody ProjectDeliverClaimModel model) {
        return this.projectDeliverClaimService.deleteModel(model);
    }
}
package com.fea.project.controller.apply;

import com.fea.project.configure.annotations.base.PermissionAnno;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.apply.ProjectApplyModel;
import com.fea.project.model.apply.pojo.ProjectApplyPojo;
import com.fea.project.model.apply.pojo.ProjectRevertShowPojo;
import com.fea.project.model.apply.vo.ProjectApplyFlowVerifyPictureShowVo;
import com.fea.project.model.apply.vo.ProjectApplyVo;
import com.fea.project.service.apply.ProjectApplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/11/18.
 */
@RestController
@RequestMapping("projectApply")
public class ProjectApplyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectApplyController.class);


    @Autowired
    private ProjectApplyService projectApplyService;


    @RequestMapping("listByParam")
    @PermissionAnno("/projectManage/applyRecord")
    public BasePageInfo<ProjectApplyVo> listByParam(@RequestBody BasePageInfo<ProjectApplyPojo> basePageInfo) {
        if (basePageInfo == null) {
            throw new SystemParamCheckException("数据传入异常，无法进行查询");
        }
        if (basePageInfo.getModel() == null) {
            basePageInfo.setModel(new ProjectApplyPojo());
        }
        return this.projectApplyService.listByParam(basePageInfo);
    }

    @RequestMapping("listNeedVerifyByParam")
    @PermissionAnno("/projectManage/recordVerify")
    public BasePageInfo<ProjectApplyVo> listNeedVerifyByParam(@RequestBody BasePageInfo<ProjectApplyPojo> basePageInfo) {
        if (basePageInfo == null) {
            throw new SystemParamCheckException("数据传入异常，无法进行查询");
        }
        if (basePageInfo.getModel() == null) {
            basePageInfo.setModel(new ProjectApplyPojo());
        }
        return this.projectApplyService.listNeedVerifyByParam(basePageInfo);
    }

    @RequestMapping("selectOne")
    public ProjectApplyVo selectOne(@RequestBody ProjectApplyModel model) {
        return this.projectApplyService.selectOne(model);
    }

    @RequestMapping("selectApplyStatus")
    public List<Map<String, Object>> selectApplyStatus() {
        return ProjectApplyVerifyStatusEnum.getApplyStatus();
    }

    @RequestMapping("selectApplyType")
    public List<Map<String, Object>> selectApplyType() {
        return ProjectFlowTypeEnum.getFlowTypes();
    }

    /**
     * 查询可以驳回的节点
     *
     * @param projectApplyModel
     * @return
     */
    @RequestMapping("selectCanRevertStep")
    public List<ProjectRevertShowPojo> selectCanRevertStep(@RequestBody ProjectApplyModel projectApplyModel) {
        return this.projectApplyService.selectCanRevertStep(projectApplyModel);
    }

    /**
     * 选择流程图
     *
     * @param projectApplyModel
     * @return
     */
    @RequestMapping("selectApplyFlowStatus")
    public List<ProjectApplyFlowVerifyPictureShowVo> selectApplyFlowStatus(@RequestBody ProjectApplyModel projectApplyModel) {
        return this.projectApplyService.selectApplyFlowStatus(projectApplyModel);
    }



}
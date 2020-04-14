package com.fea.project.controller.flow;

import com.fea.project.configure.annotations.base.PermissionAnno;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.flow.base.ProjectPersonTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.base.vo.ProjectDictionaryItemSelectVo;
import com.fea.project.model.flow.PersonSelectParamModel;
import com.fea.project.model.flow.ProjectFlowModel;
import com.fea.project.model.flow.flowtype.FlowTypeIdAndParamIdModel;
import com.fea.project.model.flow.pojo.ProjectFlowPersonTypePojo;
import com.fea.project.model.flow.pojo.ProjectFlowPojo;
import com.fea.project.model.flow.vo.ProjectFlowVo;
import com.fea.project.model.project.pojo.ProjectPojo;
import com.fea.project.model.project.vo.ProjectVo;
import com.fea.project.service.flow.ProjectFlowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2019/10/10.
 */
@RestController
@RequestMapping("projectFlow")
public class ProjectFlowController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectFlowController.class);


    @Autowired
    private ProjectFlowService projectFlowService;

    /**
     * 查询流程表单数据
     * @param model
     * @return
     */
    @RequestMapping("listByParam")
    @PermissionAnno("/projectManage/flowConfig")
    public BasePageInfo<ProjectFlowVo> listByParam(@RequestBody BasePageInfo<ProjectFlowPojo> model) {
        if (model == null) {
            throw new SystemParamCheckException("传入参数异常无法进行查询");
        } else if (model.getModel() == null) {
            model.setModel(new ProjectFlowPojo());
        }
        return this.projectFlowService.listByParam(model);
    }

    @RequestMapping("selectOne")
    public ProjectFlowVo selectOne(@RequestBody ProjectFlowModel model) {
        return this.projectFlowService.selectOne(model);
    }

    @RequestMapping("selectProjectFlowType")
    public List<Map<String, Object>> selectProjectFlowType() {
        return this.projectFlowService.selectProjectFlowType();
    }


    @RequestMapping("selectProjectFlowParam")
    public Object selectProjectFlowParam(@RequestBody ProjectFlowModel model) {
        return this.projectFlowService.selectProjectFlowParam(model);
    }

    @RequestMapping("selectFlowTypeParamByFlowTypeIdAndParamId")
    public Object selectFlowTypeParamByFlowTypeIdAndParamId(@RequestBody FlowTypeIdAndParamIdModel model) {
        return this.projectFlowService.selectFlowTypeParamByFlowTypeIdAndParamId(model);
    }

    @RequestMapping("updateModel")
    @PermissionAnno("/projectManage/flowConfig/updateFlowConfig")
    public ProjectFlowPojo updateModel(@RequestBody ProjectFlowPojo model) {
        return this.projectFlowService.updateModel(model);
    }

    @RequestMapping("deleteModel")
    @PermissionAnno("/projectManage/flowConfig/deleteFlowConfig")
    public ProjectFlowModel deleteModel(@RequestBody ProjectFlowModel model) {
        return this.projectFlowService.deleteModel(model);
    }

    @RequestMapping("selectVerifyPersonType")
    public List<Map<String, Object>> selectVerifyPersonType(@RequestBody ProjectFlowPersonTypePojo model) {
        return ProjectPersonTypeEnum.getFlowVerfiyMap(model);
    }

    @RequestMapping("selectCopyPersonType")
    public List<Map<String, Object>> selectCopyPersonType(@RequestBody ProjectFlowPersonTypePojo model) {
        return ProjectPersonTypeEnum.getFlowVerfiyMap(model);
    }

    @RequestMapping("selectPersonByPersonType")
    public PersonSelectParamModel selectPersonByPersonType(@RequestBody ProjectFlowPersonTypePojo model) {
        return this.projectFlowService.selectPersonByPersonType(model);
    }

    @RequestMapping("changeState")
    public ProjectFlowModel changeState(@RequestBody ProjectFlowModel model) {
        return this.projectFlowService.changeState(model);
    }

    @RequestMapping("selectProjectTypeByReg")
    public List<ProjectDictionaryItemSelectVo> selectProjectTypeByReg() {
        return this.projectFlowService.selectProjectTypeByReg();
    }

    @RequestMapping("selectProjectByReg")
    public BasePageInfo<ProjectVo> selectProjectByReg(@RequestBody BasePageInfo<ProjectPojo> model) throws ExecutionException, InterruptedException {
        return this.projectFlowService.selectProjectByReg(model);
    }
}
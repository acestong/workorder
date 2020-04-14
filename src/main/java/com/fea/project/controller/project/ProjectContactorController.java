package com.fea.project.controller.project;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.project.ProjectContactorModel;
import com.fea.project.model.project.pojo.ProjectContactorPojo;
import com.fea.project.model.project.vo.ProjectContactorVo;
import com.fea.project.model.project.vo.ProjectContactorsSelectVo;
import com.fea.project.service.project.ProjectContactorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/10/24.
 */
@RestController
@RequestMapping("projectContactor")
public class ProjectContactorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectContactorController.class);


    @Autowired
    private ProjectContactorService projectContactorService;


    @RequestMapping("selectContactorsByProjectId")
    public List<ProjectContactorsSelectVo> selectContactorsByProjectId(@RequestBody ProjectContactorModel model) {
        return this.projectContactorService.selectContactorsByProjectId(model);
    }

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectContactorPojo insert(@RequestBody ProjectContactorPojo model) {
        return this.projectContactorService.insertModel(model);
    }

    /**
     * 按模型选择
     */
    @RequestMapping("listByParam")
    public BasePageInfo<ProjectContactorVo> listByParam(@RequestBody BasePageInfo<ProjectContactorModel> model) {
        if (model == null || model.getModel().getProjectId() == null) {
            throw new SystemParamCheckException("传入的项目信息异常，无法进行查询");
        }
        return this.projectContactorService.listByParam(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectContactorModel update(@RequestBody ProjectContactorModel model) {
        return this.projectContactorService.updateModel(model);
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectContactorPojo delete(@RequestBody ProjectContactorPojo model) {
        return this.projectContactorService.deleteModels(model);
    }
}
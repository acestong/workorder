package com.fea.project.controller.interflow;


import com.fea.project.model.interflow.ProjectInterflowPhoneModel;
import java.util.List;

import com.fea.project.model.interflow.vo.InterflowCommonVo;
import com.fea.project.model.interflow.vo.ProjectInterflowPhoneModelVo;
import com.fea.project.service.interflow.ProjectInterflowPhoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 * @date 2020/01/09
 */
@RestController
@RequestMapping("projectInterflowPhone")
public class ProjectInterflowPhoneController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectInterflowPhoneController.class);


    @Autowired
    private ProjectInterflowPhoneService projectInterflowPhoneService;

    /**
     * 插入数据
     */
    @RequestMapping("insertPhone")
    public InterflowCommonVo insert(@RequestBody InterflowCommonVo<ProjectInterflowPhoneModel> model) {
        InterflowCommonVo insert = projectInterflowPhoneService.insert(model);

        return insert;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("showPhone")
    public List<ProjectInterflowPhoneModel> show(@RequestBody ProjectInterflowPhoneModel model) {

        return this.projectInterflowPhoneService.selectByModel(model);
    }
    /**
     * 按主键获取详情
     */
    @RequestMapping("getPhoneModelVo")
    public InterflowCommonVo<ProjectInterflowPhoneModelVo> getPhoneModelVo(@RequestBody ProjectInterflowPhoneModel model) {

        return this.projectInterflowPhoneService.getPhoneModelVo(model);
    }
    /**
     * 按主键更新
     */
    @RequestMapping("updatePhone")
    public InterflowCommonVo update(@RequestBody InterflowCommonVo<ProjectInterflowPhoneModel> model) {

        InterflowCommonVo<ProjectInterflowPhoneModel> update = this.projectInterflowPhoneService.update(model);
        return update;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("deletePhone")
    public ProjectInterflowPhoneModel delete(@RequestBody ProjectInterflowPhoneModel model) {
        if (this.projectInterflowPhoneService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
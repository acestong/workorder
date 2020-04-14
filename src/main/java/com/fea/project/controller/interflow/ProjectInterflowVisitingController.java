package com.fea.project.controller.interflow;


import com.fea.project.model.interflow.ProjectInterflowVisitingModel;
import java.util.List;

import com.fea.project.model.interflow.vo.InterflowCommonVo;
import com.fea.project.model.interflow.vo.ProjectInterflowVisitingModelVo;
import com.fea.project.service.interflow.ProjectInterflowVisitingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2020/01/09.
 */
@RestController
@RequestMapping("projectInterflowVisiting")
public class ProjectInterflowVisitingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectInterflowVisitingController.class);


    @Autowired
    private ProjectInterflowVisitingService projectInterflowVisitingService;

    /**
     * 插入数据
     */
    @RequestMapping("insertVisiting")
    public InterflowCommonVo insert(@RequestBody InterflowCommonVo<ProjectInterflowVisitingModel> model) {
        InterflowCommonVo insert = this.projectInterflowVisitingService.insert(model);

        return insert;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("getVisitingInfo")
    public InterflowCommonVo<ProjectInterflowVisitingModelVo> show(@RequestBody ProjectInterflowVisitingModel model) {
        InterflowCommonVo<ProjectInterflowVisitingModelVo> phoneModelVo = this.projectInterflowVisitingService.getPhoneModelVo(model);
        return phoneModelVo;
    }

    /**
     * 按主键更新
     */
    @RequestMapping("updateVisiting")
    public InterflowCommonVo update(@RequestBody InterflowCommonVo<ProjectInterflowVisitingModel> model) {
        InterflowCommonVo<ProjectInterflowVisitingModel> update = this.projectInterflowVisitingService.update(model);
        return update;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("deleteVisiting")
    public ProjectInterflowVisitingModel delete(@RequestBody ProjectInterflowVisitingModel model) {
        if (this.projectInterflowVisitingService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
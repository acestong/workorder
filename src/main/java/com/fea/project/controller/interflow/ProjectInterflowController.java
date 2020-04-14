package com.fea.project.controller.interflow;


import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.interflow.InterflowTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.interflow.ProjectInterflowPhoneModel;
import com.fea.project.model.interflow.vo.ProjectInterflowListShowVo;
import com.fea.project.model.projectdata.DataTeamVo;
import com.fea.project.service.interflow.ProjectInterflowPhoneService;
import com.fea.project.service.interflow.ProjectInterflowService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Administrator
 * @date 2020/01/09
 */
@RestController
@RequestMapping("projectInterflow")
public class ProjectInterflowController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectInterflowController.class);


    @Autowired
    private ProjectInterflowService projectInterflowService;

    /**
     * 按模型选择
     */
    @RequestMapping("showInterflow")
    public PageInfo<ProjectInterflowListShowVo> show(@RequestBody BasePageInfo<DataTeamVo> model) {
        PageInfo<ProjectInterflowListShowVo> showList = projectInterflowService.showList(model);
        return showList;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("deleteInterflow")
    public ProjectInterflowListShowVo delete(@RequestBody ProjectInterflowListShowVo model) {
        ProjectInterflowListShowVo delete = projectInterflowService.delete(model);
        return delete;
    }
}
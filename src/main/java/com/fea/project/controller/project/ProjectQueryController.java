package com.fea.project.controller.project;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.project.ProjectQueryPersonOrTeamEnum;
import com.fea.project.enums.project.ProjectQueryTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.project.pojo.ProjectPojo;
import com.fea.project.model.project.vo.ProjectStatisticsVo;
import com.fea.project.model.project.vo.ProjectUserSelectVo;
import com.fea.project.model.project.vo.ProjectVo;
import com.fea.project.service.project.ProjectQueryService;
import com.fea.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/26 10:07
 **/
@RestController
@RequestMapping("projectQuery")
public class ProjectQueryController {

    @Autowired
    private ProjectQueryService projectQueryService;


    @RequestMapping("listByUserIds")
    public BasePageInfo<ProjectVo> listByUserIds(@RequestBody BasePageInfo<ProjectPojo> basePageInfo) throws ExecutionException, InterruptedException {
        if (basePageInfo == null || basePageInfo.getModel() == null
                || basePageInfo.getModel().getQueryType() == null) {
            throw new SystemParamCheckException("传入参数异常无法进行查询");
        }
        return this.projectQueryService.listByUserIds(basePageInfo);
    }


    @RequestMapping("selectTreeList")
    public List<ProjectUserSelectVo> selectTreeList() {
        return this.projectQueryService.selectTreeList();
    }

    @RequestMapping("selectProjectCondition")
    public ProjectStatisticsVo selectProjectCondition(@RequestBody BasePageInfo<ProjectPojo> basePageInfo) throws ExecutionException, InterruptedException {
        if (basePageInfo == null || basePageInfo.getModel() == null
                || basePageInfo.getModel().getQueryType() == null) {
            throw new SystemParamCheckException("传入参数异常无法进行查询");
        }
        return this.projectQueryService.selectProjectConditionByUserIds(basePageInfo);
    }

}

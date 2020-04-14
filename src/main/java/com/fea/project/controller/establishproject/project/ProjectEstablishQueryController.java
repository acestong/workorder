package com.fea.project.controller.establishproject.project;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.establishproject.pojo.ProjectEstablishProjectPojo;
import com.fea.project.model.establishproject.vo.ProjectEstablishVo;
import com.fea.project.model.project.vo.ProjectStatisticsVo;
import com.fea.project.model.project.vo.ProjectUserSelectVo;
import com.fea.project.service.establishproject.project.ProjectEstablishQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/26 10:07
 **/
@RestController
@RequestMapping("projectEstablishQuery")
public class ProjectEstablishQueryController {

    @Autowired
    private ProjectEstablishQueryService projectEstablishQueryService;


    @RequestMapping("listByUserIds")
    public BasePageInfo<ProjectEstablishVo> listByUserIds(@RequestBody BasePageInfo<ProjectEstablishProjectPojo> basePageInfo) throws ExecutionException, InterruptedException {
        if (basePageInfo == null || basePageInfo.getModel() == null
                || basePageInfo.getModel().getQueryType() == null) {
            throw new SystemParamCheckException("传入参数异常无法进行查询");
        }
        return this.projectEstablishQueryService.listByUserIds(basePageInfo);
    }

    @RequestMapping("selectTreeList")
    public List<ProjectUserSelectVo> selectTreeList() {
        return this.projectEstablishQueryService.selectTreeList();
    }

    @RequestMapping("selectProjectCondition")
    public ProjectStatisticsVo selectProjectCondition(@RequestBody BasePageInfo<ProjectEstablishProjectPojo> basePageInfo) {
        if (basePageInfo == null || basePageInfo.getModel() == null
                || basePageInfo.getModel().getQueryType() == null) {
            throw new SystemParamCheckException("传入参数异常无法进行查询");
        }
        return  this.projectEstablishQueryService.selectProjectCondition(basePageInfo);
    }

}

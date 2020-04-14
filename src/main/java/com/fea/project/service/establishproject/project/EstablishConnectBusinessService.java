package com.fea.project.service.establishproject.project;

import com.fea.project.api.other.model.crm.CrmMoneyTranslateModel;
import com.fea.project.enums.project.ProjectResourceEnum;
import com.fea.project.model.establishproject.project.ProjectEstablishStepModel;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.service.project.ProjectService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/4 10:59
 **/
@Service
public class EstablishConnectBusinessService {

    @Autowired
    private ProjectEstablishStepService projectEstablishStepService;

    @Autowired
    private ProjectService projectService;


    /**
     * 通过项目id查询客户所在区域
     *
     * @param establishStepId
     * @return
     */
    public List<Long> selectProjectAreaByProjectId(Long establishStepId) {
        ProjectEstablishStepModel projectEstablishStepModel = projectEstablishStepService.selectById(establishStepId);
        ProjectModel projectModel = this.projectService.selectById(projectEstablishStepModel.getProjectId());
        List<Long> list = new ArrayList<>();
        list.add(projectModel.getArea());
        return list;
    }

    /**
     * 通过项目id查询项目所属行业
     *
     * @param establishStepId
     * @return
     */
    public List<Long> selectResourceByProjectId(Long establishStepId) {
        ProjectEstablishStepModel projectEstablishStepModel = projectEstablishStepService.selectById(establishStepId);
        ProjectModel projectModel = this.projectService.selectById(projectEstablishStepModel.getProjectId());
        List<Long> list = new ArrayList<>();
        list.add(projectModel.getIndustry());
        return list;
    }

    /**
     * 通过项目id，查询预算
     *
     * @param establishStepId
     * @return
     */
    public CrmMoneyTranslateModel selectBudgetByProjectId(Long establishStepId) {
        ProjectEstablishStepModel projectEstablishStepModel = projectEstablishStepService.selectById(establishStepId);
        ProjectModel projectModel = this.projectService.selectById(projectEstablishStepModel.getProjectId());
        return new CrmMoneyTranslateModel(projectModel.getCurrencyId(), projectModel.getBudget());
    }

}

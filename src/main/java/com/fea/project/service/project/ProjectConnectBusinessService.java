package com.fea.project.service.project;

import com.fea.project.api.other.model.crm.CrmMoneyTranslateModel;
import com.fea.project.enums.project.ProjectResourceEnum;
import com.fea.project.model.project.ProjectModel;
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
public class ProjectConnectBusinessService {

    @Autowired
    private ProjectService projectService;


    /**
     * 通过项目id查询项目绑定业务对应的产品
     *
     * @param projectId
     * @return
     */
    public List<Long> selectProductsByProjectId(Long projectId) {
        ProjectModel projectModel = this.projectService.selectById(projectId);
        Integer resource = projectModel.getResource();
        return ProjectResourceEnum.getProductsByBusinessIds(resource, Stream.of(projectModel.getConnectId()
                .split(",")).filter(StringUtil::isNotEmpty)
                .map(Long::parseLong).collect(Collectors.toList()));
    }

    /**
     * 通过项目id查询客户所在区域
     *
     * @param projectId
     * @return
     */
    public List<Long> selectProjectAreaByProjectId(Long projectId) {
        ProjectModel projectModel = this.projectService.selectById(projectId);
        List<Long> regionList = new ArrayList<>();
        regionList.add(projectModel.getArea());
        return regionList;
    }

    /**
     * 通过项目id查询项目所属行业
     *
     * @param projectId
     * @return
     */
    public List<Long> selectResourceByProjectId(Long projectId) {
        ProjectModel projectModel = this.projectService.selectById(projectId);
        List<Long> industryList = new ArrayList<>();
        industryList.add(projectModel.getIndustry());
        return industryList;
    }

    /**
     * 通过项目id，查询预算
     *
     * @param projectId
     * @return
     */
    public CrmMoneyTranslateModel selectBudgetByProjectId(Long projectId) {
        ProjectModel projectModel = this.projectService.selectById(projectId);
        return new CrmMoneyTranslateModel(projectModel.getCurrencyId(),projectModel.getBudget());
    }

    /**
     * 通过项目id查询合同金额
     *
     * @param projectId
     * @return
     */
    public CrmMoneyTranslateModel selectContractCostByProjectId(Long projectId) {
        ProjectModel projectModel = this.projectService.selectById(projectId);
        Integer resource = projectModel.getResource();
        return ProjectResourceEnum.getContractCostByBusinessIds(resource, Stream.of(projectModel.getConnectId()
                .split(",")).filter(StringUtil::isNotEmpty)
                .map(Long::parseLong).collect(Collectors.toList()));
    }

    /**
     * 通过项目查询关联的销售机会类型
     *
     * @param projectId
     * @return
     */
    public List<Long> selectConnectSaleChanceType(Long projectId) {
        ProjectModel projectModel = this.projectService.selectById(projectId);
        Integer resource = projectModel.getResource();
        return ProjectResourceEnum.getConnectSaleChanceTypeByBusinessIds(resource, Stream.of(projectModel.getConnectId()
                .split(",")).filter(StringUtil::isNotEmpty)
                .map(Long::parseLong).collect(Collectors.toList()));
    }

    /**
     * 项目关联销售机会预计签约金额
     *
     * @param projectId
     * @return
     */
    public CrmMoneyTranslateModel selectConnectSaleChanceEstimatedContractAmount(Long projectId) {
        ProjectModel projectModel = this.projectService.selectById(projectId);
        Integer resource = projectModel.getResource();
        return ProjectResourceEnum.getConnectSaleChanceEstimatedContractAmountByBusinessIds(resource, Stream.of(projectModel.getConnectId()
                .split(",")).filter(StringUtil::isNotEmpty)
                .map(Long::parseLong).collect(Collectors.toList()));
    }
}

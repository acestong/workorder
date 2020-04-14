package com.fea.project.service.project.draft;

import com.fea.project.api.other.model.crm.CrmMoneyTranslateModel;
import com.fea.project.enums.project.ProjectResourceEnum;
import com.fea.project.model.project.draft.DraftProjectModel;
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
public class DraftConnectBusinessService {

    @Autowired
    private DraftProjectService draftProjectService;


    /**
     * 通过项目id查询项目绑定业务对应的产品
     *
     * @param draftId
     * @return
     */
    public List<Long> selectProductsByDraftId(Long draftId) {
        DraftProjectModel draftProjectModel = this.draftProjectService.selectById(draftId);
        Integer resource = draftProjectModel.getResource();
        return ProjectResourceEnum.getProductsByBusinessIds(resource, Stream.of(draftProjectModel.getConnectId()
                .split(",")).filter(StringUtil::isNotEmpty)
                .map(Long::parseLong).collect(Collectors.toList()));
    }

    /**
     * 通过项目id查询客户所在区域
     *
     * @param draftId
     * @return
     */
    public List<Long> selectProjectAreaByDraftId(Long draftId) {
        DraftProjectModel draftProjectModel = this.draftProjectService.selectById(draftId);
        List<Long> list = new ArrayList<>();
        list.add(draftProjectModel.getArea());
        return list;
    }

    /**
     * 通过项目id查询项目所属行业
     *
     * @param draftId
     * @return
     */
    public List<Long> selectResourceByDraftId(Long draftId) {
        DraftProjectModel draftProjectModel = this.draftProjectService.selectById(draftId);
        List<Long> list = new ArrayList<>();
        list.add(draftProjectModel.getIndustry());
        return list;
    }

    /**
     * 通过项目id，查询预算
     *
     * @param draftId
     * @return
     */
    public CrmMoneyTranslateModel selectBudgetByProjectId(Long draftId) {
        DraftProjectModel draftProjectModel = this.draftProjectService.selectById(draftId);
        return new CrmMoneyTranslateModel(draftProjectModel.getCurrencyId(), draftProjectModel.getBudget());
    }

    /**
     * 通过项目id查询合同金额
     *
     * @param draftId
     * @return
     */
    public CrmMoneyTranslateModel selectContractCostByDraftId(Long draftId) {
        DraftProjectModel draftProjectModel = this.draftProjectService.selectById(draftId);
        Integer resource = draftProjectModel.getResource();
        return ProjectResourceEnum.getContractCostByBusinessIds(resource, Stream.of(draftProjectModel.getConnectId()
                .split(",")).filter(StringUtil::isNotEmpty)
                .map(Long::parseLong).collect(Collectors.toList()));
    }

    /**
     * 通过项目查询关联的销售机会类型
     *
     * @param draftId
     * @return
     */
    public List<Long> selectConnectSaleChanceType(Long draftId) {
        DraftProjectModel draftProjectModel = this.draftProjectService.selectById(draftId);
        Integer resource = draftProjectModel.getResource();
        return ProjectResourceEnum.getConnectSaleChanceTypeByBusinessIds(resource, Stream.of(draftProjectModel.getConnectId()
                .split(",")).filter(StringUtil::isNotEmpty)
                .map(Long::parseLong).collect(Collectors.toList()));
    }

    /**
     * 项目关联销售机会预计签约金额
     *
     * @param draftId
     * @return
     */
    public CrmMoneyTranslateModel selectConnectSaleChanceEstimatedContractAmount(Long draftId) {
        DraftProjectModel draftProjectModel = this.draftProjectService.selectById(draftId);
        Integer resource = draftProjectModel.getResource();
        return ProjectResourceEnum.getConnectSaleChanceEstimatedContractAmountByBusinessIds(resource, Stream.of(draftProjectModel.getConnectId()
                .split(",")).filter(StringUtil::isNotEmpty)
                .map(Long::parseLong).collect(Collectors.toList()));
    }
}

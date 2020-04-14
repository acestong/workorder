package com.fea.project.service.businessflow.flowtype;

import com.fea.project.model.apply.pojo.ProjectApplyPojo;
import org.springframework.stereotype.Service;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/2 17:14
 **/
//TODO
@Service
public class ProjectBusinessBudgetChangeApplyImplService extends AbstractFlowApply {
    @Override
    protected Long getProjectId(Object model) {
        return null;
    }

    @Override
    protected boolean checkFlowParamIsAvailable(Object model) {
        return false;
    }

    @Override
    protected Integer getFlowTypeId() {
        return null;
    }

    @Override
    protected Long getCurrentFlowNeedChooseFlowList(Long businessId, Long flowId) {
        return null;
    }

    @Override
    protected Long getModelPrimaryId(Object model) {
        return null;
    }

    @Override
    protected Long getApplyer(Object model) {
        return null;
    }

    @Override
    protected void setProjectApplyConnectBusinessInfo(ProjectApplyPojo projectApplyPojo, Object model) {

    }

    @Override
    public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
        return false;
    }

    @Override
    //TODO
    public boolean revertBusinessInfo(Long businessId) {
        return true;
    }

    @Override
    //TODO
    public boolean refuseBusinessInfo(Long businessId) {
        return true;
    }
}

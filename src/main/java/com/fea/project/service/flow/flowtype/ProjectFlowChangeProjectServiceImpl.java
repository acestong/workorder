package com.fea.project.service.flow.flowtype;

import com.fea.project.enums.flow.base.flowtype.ProjectFlowChangeProjectConditionTypeEnum;
import com.fea.project.model.flow.flowtype.FlowTypeIdAndParamIdModel;
import org.springframework.stereotype.Service;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/11 11:23
 **/
@Service
public class ProjectFlowChangeProjectServiceImpl implements IProjectFLowService {


    @Override
    public Object getFlowTypeParam(FlowTypeIdAndParamIdModel model) {
        return ProjectFlowChangeProjectConditionTypeEnum.getDetailParamMap(model);
    }
}

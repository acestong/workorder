package com.fea.project.service.apply.io;

import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2020/1/4 17:49
 **/
public interface IProjectFlowListChoose {

    Object selectModelByIdAndConditionModel(Long businessId, Map<Integer, String> map);
}

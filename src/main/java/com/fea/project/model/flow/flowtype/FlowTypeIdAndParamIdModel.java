package com.fea.project.model.flow.flowtype;

import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/11 14:31
 **/
@Data
public class FlowTypeIdAndParamIdModel {

    private Integer flowType;

    private Integer paramId;

    private Long regId;

    private Long businessId;
}

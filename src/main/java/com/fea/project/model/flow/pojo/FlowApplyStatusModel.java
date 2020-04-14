package com.fea.project.model.flow.pojo;

import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2020/1/3 10:15
 **/
@Data
public class FlowApplyStatusModel {

    private Integer status;
    private Long flowId;

    public FlowApplyStatusModel() {
    }

    public FlowApplyStatusModel(Integer status, Long flowId) {
        this.status = status;
        this.flowId = flowId;
    }
}

package com.fea.project.model.deliverable.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Administrator
 */
@AllArgsConstructor
@Data
public class DeliverableBusinessVo {

    /**
     * id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessId;
    /**
     * 名称
     */
    private String businessName;
    /**
     * 项目阶段
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectStep;
    /**
     * 项目阶段名称
     */
    private String projectStepName;
    /**
     * 负责人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long ownerId;

    /**
     * 负责人
     */
    private String owner;

    public DeliverableBusinessVo() {
    }
}

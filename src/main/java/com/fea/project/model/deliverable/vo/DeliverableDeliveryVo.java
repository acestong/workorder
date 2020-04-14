package com.fea.project.model.deliverable.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@AllArgsConstructor
@Data
public class DeliverableDeliveryVo {
    /**
     * id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 要求交付物名称
     */
    private String name;

    /**
     * 要求交付时间
     */
    private Date deliveryTime;

    /**
     * 负责人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long ownerId;

    /**
     * 负责人
     */
    private String owner;

    /**
     * 负责团队id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long teamId;

    /**
     * 负责团队
     */
    private String teamName;

    /**
     * 交付要求说明
     */
    private String requirement;

    public DeliverableDeliveryVo() {
    }
}

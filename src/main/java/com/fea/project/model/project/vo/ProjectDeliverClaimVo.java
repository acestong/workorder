package com.fea.project.model.project.vo;

import com.fea.project.model.project.ProjectDeliverClaimModel;
import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/30 15:13
 **/
@Data
public class ProjectDeliverClaimVo extends ProjectDeliverClaimModel {

    private String leaderName;

    private String deliverName;

    private String deliverStatusName;

    private String verifyerName;

    private String verifyerStatusName;
}

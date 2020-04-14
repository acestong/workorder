package com.fea.project.model.project.history.vo;

import com.fea.project.model.project.history.HistoryDeliverClaimModel;
import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/30 15:13
 **/
@Data
public class HistoryDeliverClaimVo extends HistoryDeliverClaimModel {

    private String leaderName;

    private String deliverName;

    private String deliverStatusName;

    private String verifyerName;

    private String verifyerStatusName;
}

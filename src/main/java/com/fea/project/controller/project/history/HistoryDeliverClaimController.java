package com.fea.project.controller.project.history;

import com.fea.project.model.project.history.HistoryDeliverClaimModel;
import com.fea.project.model.project.history.vo.HistoryDeliverClaimVo;
import com.fea.project.service.project.history.HistoryDeliverClaimService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/12/19.
 */
@RestController
@RequestMapping("historyDeliverClaim")
public class HistoryDeliverClaimController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HistoryDeliverClaimController.class);


    @Autowired
    private HistoryDeliverClaimService historyDeliverClaimService;

    /**
     * 按模型选择
     */
    @RequestMapping("listByHistory")
    public List<HistoryDeliverClaimVo> listByHistory(@RequestBody HistoryDeliverClaimModel model) {
        return this.historyDeliverClaimService.listByHistory(model);
    }

}
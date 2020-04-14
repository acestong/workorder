package com.fea.project.controller.project.history;

import com.fea.project.model.project.history.HistoryStepModel;
import com.fea.project.model.project.history.HistoryStepVerifyModel;
import com.fea.project.model.project.history.vo.HistoryStepVo;
import com.fea.project.service.project.history.HistoryStepService;
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
@RequestMapping("historyStep")
public class HistoryStepController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HistoryStepController.class);


    @Autowired
    private HistoryStepService historyStepService;

    /**
     * 按模型选择
     */
    @RequestMapping("listByHistoryId")
    public List<HistoryStepVo> listByHistoryId(@RequestBody HistoryStepModel model) {
        return this.historyStepService.listByHistoryId(model);
    }

    @RequestMapping("selectVerifyProjectStepDetail")
    public HistoryStepVerifyModel selectVerifyProjectStepDetail(@RequestBody HistoryStepVerifyModel model) {
        return this.historyStepService.selectVerifyProjectStepDetail(model);
    }
}
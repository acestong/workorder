package com.fea.project.controller.project.history;

import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.project.draft.DraftProjectModel;
import com.fea.project.model.project.history.HistoryProjectModel;
import com.fea.project.model.project.history.vo.HistoryProjectVo;
import com.fea.project.service.project.history.HistoryProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/12/19.
 * 项目信息表 Controller
 */
@RestController
@RequestMapping("historyProject")
public class HistoryProjectController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HistoryProjectController.class);

    @Autowired
    private HistoryProjectService historyProjectService;

    @RequestMapping("createDraftProject")
    public HistoryProjectModel createHistoryProject(@RequestBody ProjectModel model) throws Exception {
        return this.historyProjectService.createHistoryProject(model);
    }

    @RequestMapping("selectOne")
    public HistoryProjectVo selectOne(@RequestBody DraftProjectModel model) throws Exception {
        return this.historyProjectService.selectOne(model);
    }
}
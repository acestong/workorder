package com.fea.project.controller.project.draft;

import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.project.draft.DraftProjectModel;
import com.fea.project.model.project.draft.vo.DraftProjectVo;
import com.fea.project.service.project.draft.DraftProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/12/10.
 * 项目信息表 Controller
 */
@RestController
@RequestMapping("draftProject")
public class DraftProjectController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DraftProjectController.class);


    @Autowired
    private DraftProjectService draftProjectService;

    @RequestMapping("createDraftProject")
    public DraftProjectModel createDraftProject(@RequestBody ProjectModel model) throws Exception {
        return this.draftProjectService.createDraftProject(model);
    }

    @RequestMapping("selectOne")
    public DraftProjectVo selectOne(@RequestBody DraftProjectModel model) throws Exception {
        return this.draftProjectService.selectOne(model);
    }

    /**
     * 草稿删除
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteModel")
    public DraftProjectModel deleteModel(@RequestBody DraftProjectModel model) throws Exception {
        return this.draftProjectService.deleteModel(model);
    }

    /**
     * 同步版本信息
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("refreshModel")
    public DraftProjectModel refreshModel(@RequestBody DraftProjectModel model) throws Exception {
        return this.draftProjectService.refreshModel(model);
    }

    @RequestMapping("updateModel")
    public DraftProjectModel updateModel(@RequestBody DraftProjectModel model) {
        return this.draftProjectService.updateModel(model);
    }

    @RequestMapping("updateProjectContent")
    public DraftProjectModel updateProjectContent(@RequestBody DraftProjectModel model) {
        return this.draftProjectService.updateProjectContent(model);
    }

    /**
     * 提交审核
     * @param draftProjectModel
     * @return
     */
    @RequestMapping("submitChangeToVerify")
    public DraftProjectModel submitChangeToVerify(@RequestBody DraftProjectModel draftProjectModel) {
        return this.draftProjectService.submitChangeToVerify(draftProjectModel);
    }


}
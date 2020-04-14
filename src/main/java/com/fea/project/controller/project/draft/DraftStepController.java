package com.fea.project.controller.project.draft;

import com.fea.project.model.project.draft.DraftStepModel;
import com.fea.project.model.project.draft.DraftStepVerifyModel;
import com.fea.project.model.project.draft.vo.DraftStepVo;
import com.fea.project.service.project.draft.DraftStepService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/12/10.
 */
@RestController
@RequestMapping("draftStep")
public class DraftStepController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DraftStepController.class);


    @Autowired
    private DraftStepService draftStepService;

    /**
     * 插入数据
     */
    @RequestMapping("insertModel")
    public DraftStepModel insertModel(@RequestBody DraftStepModel model) {
        return this.draftStepService.insertModel(model);
    }

    /**
     * 按模型选择
     */
    @RequestMapping("listByDraftId")
    public List<DraftStepVo> listByDraftId(@RequestBody DraftStepModel model) {
        return this.draftStepService.listByDraftId(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("updateModel")
    public DraftStepModel updateModel(@RequestBody DraftStepModel model) {
        return this.draftStepService.updateModel(model);
    }

    /**
     * 按主键删除
     */
    @RequestMapping("deleteModel")
    public DraftStepModel deleteModel(@RequestBody DraftStepModel model) {
        return this.draftStepService.deleteModel(model);
    }


    @RequestMapping("selectVerifyProjectStepDetail")
    public DraftStepVerifyModel selectVerifyProjectStepDetail(@RequestBody DraftStepVerifyModel model) {
        return this.draftStepService.selectVerifyProjectStepDetail(model);
    }
}
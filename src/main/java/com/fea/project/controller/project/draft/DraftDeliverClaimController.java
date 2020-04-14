package com.fea.project.controller.project.draft;

import com.fea.project.model.project.draft.DraftDeliverClaimModel;
import com.fea.project.model.project.draft.vo.DraftDeliverClaimVo;
import com.fea.project.service.project.draft.DraftDeliverClaimService;
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
@RequestMapping("draftDeliverClaim")
public class DraftDeliverClaimController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DraftDeliverClaimController.class);


    @Autowired
    private DraftDeliverClaimService draftDeliverClaimService;


    /**
     * 插入数据
     */
    @RequestMapping("insertModel")
    public DraftDeliverClaimModel insertModel(@RequestBody DraftDeliverClaimModel model) {
        return this.draftDeliverClaimService.insertModel(model);
    }

    /**
     * 按模型选择
     */
    @RequestMapping("listByDraft")
    public List<DraftDeliverClaimVo> listByDraft(@RequestBody DraftDeliverClaimModel model) {
        return this.draftDeliverClaimService.listByDraft(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("updateModel")
    public DraftDeliverClaimModel updateModel(@RequestBody DraftDeliverClaimModel model) {
        return this.draftDeliverClaimService.updateModel(model);
    }

    /**
     * 按主键删除
     */
    @RequestMapping("deleteModel")
    public DraftDeliverClaimModel deleteModel(@RequestBody DraftDeliverClaimModel model) {
        return this.draftDeliverClaimService.deleteModel(model);
    }
}
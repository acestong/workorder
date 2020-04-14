package com.fea.project.model.project.draft.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.project.draft.DraftStepModel;
import com.fea.project.model.project.draft.DraftStepVerifyModel;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/12 14:56
 **/
@Data
public class DraftStepVo extends DraftStepModel {

    private String leadName;
    private String deptName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long stepVerifyId;
    private Integer stepVerifyStatus;
    private String stepVerifyStatusName;

    private List<DraftStepVerifyModel> draftStepVerifyModels;

    public DraftStepVo() {
    }
}

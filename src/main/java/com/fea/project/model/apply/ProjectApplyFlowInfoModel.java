package com.fea.project.model.apply;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/11/18.
 */
@Data
public class ProjectApplyFlowInfoModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;

    /**
     * 申请单号
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long applyId;

    /**
     * 实际业务的流程id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long businessFlowVerifyId;

    /**
     * 人员类型
     */
    protected Integer personType;

    /**
     * 审核类型（获签/会签）
     */
    protected Integer verifyType;

    /**
     * 审核状态
     */
    protected Integer verifyStatus;

    protected Date createTime;

    protected String stopTime;

    protected Date actionTime;

    protected Integer actionType;

    protected String verifyResult;

    protected String describe;

    public ProjectApplyFlowInfoModel(Long id, Long applyId, Long businessFlowVerifyId, Integer personType, Integer verifyType, Integer verifyStatus) {
        this.id = id;
        this.applyId = applyId;
        this.businessFlowVerifyId = businessFlowVerifyId;
        this.personType = personType;
        this.verifyType = verifyType;
        this.verifyStatus = verifyStatus;
    }

    public ProjectApplyFlowInfoModel() {

    }

}
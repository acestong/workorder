package com.fea.project.model.apply.vo;

import com.fea.project.model.flow.vo.ProjectFlowVerifyerVo;
import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/9 18:22
 **/
@Data
public class ProjectApplyFlowVerifyPictureShowVo extends ProjectFlowVerifyerVo {

    private Integer flowStatus;

    private Integer beatBack;


    public ProjectApplyFlowVerifyPictureShowVo() {
    }


    public ProjectApplyFlowVerifyPictureShowVo(ProjectFlowVerifyerVo model) {
        this.id = model.getId();
        this.listId = model.getListId();
        this.personType = model.getPersonType();
        this.detailStr = model.getDetailStr();
        this.createId = model.getCreateId();
        this.createBy = model.getCreateBy();
        this.createTime = model.getCreateTime();
        this.updateId = model.getUpdateId();
        this.updateBy = model.getUpdateBy();
        this.updateTime = model.getUpdateTime();
        this.delStatus = model.getDelStatus();
        this.parentId = model.getParentId();
        this.verifyType = model.getVerifyType();
        this.detailStrName = model.getDetailStrName();
    }

}

package com.fea.project.model.apply.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.model.apply.ProjectApplyFlowVerifyModel;
import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/2 10:46
 **/
@Data
public class ProjectApplyFlowVerifyPojo extends ProjectApplyFlowVerifyModel {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNullAnno(field = "apply_id", value = "申请id")
    private Long applyId;


    /**
     * 打回操作，打回的操作点
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long beatBackBusinessFlowVerifyId;
}

package com.fea.project.model.interflow.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.interflow.ProjectInterflowContactsModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 */
@Data
public class InterflowCommonVo<T>  implements Serializable{
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    private T model;

    private List<ProjectInterflowContactsModel> contactModels;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> appendixIds;

    public InterflowCommonVo() {
    }

    public InterflowCommonVo(T model, List<ProjectInterflowContactsModel> contactModels) {
        this.model = model;
        this.contactModels = contactModels;
    }

    public InterflowCommonVo(T model, List<ProjectInterflowContactsModel> contactModels, List<Long> appendixIds) {
        this.model = model;
        this.contactModels = contactModels;
        this.appendixIds = appendixIds;
    }
}

package com.fea.project.model.apply;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.configure.annotations.base.PrimaryKey;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/11/27.
 */
@Data
public class ProjectApplyCodeModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @PrimaryKey(field = "id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 流程类型
     */
    private Integer flowType;

    /**
     * 编号简称
     */
    private String shortName;

    /**
     * 字符串格式类型
     */
    private Integer dataStr;

    /**
     * 创建周期
     */
    private Integer createPeriod;

    /**
     * 组织id
     */
    @JsonIgnore
    private Long regId;

    /**
     * 字符长度
     */
    private Integer codeNumber;


    public ProjectApplyCodeModel() {

    }

    public ProjectApplyCodeModel(Long regId, int flowType) {
        this.regId = regId;
        this.flowType = flowType;
    }


}
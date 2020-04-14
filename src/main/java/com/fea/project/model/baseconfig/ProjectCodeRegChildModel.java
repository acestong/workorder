package com.fea.project.model.baseconfig;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/09/27.
 */
@Data
public class ProjectCodeRegChildModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     *
     */
    private String parentProjectCode;

    /**
     *
     */
    private String childProjectCode;

    @JsonIgnore
    private Long regId;

    private String childShortName;

    public ProjectCodeRegChildModel() {
    }

    public ProjectCodeRegChildModel(String parentProjectCode, Long regId, String childProjectCode, String childShortName) {
        this.parentProjectCode = parentProjectCode;
        this.childProjectCode = childProjectCode;
        this.regId = regId;
        this.childShortName = childShortName;
    }
}
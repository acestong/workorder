package com.fea.project.model.baseconfig;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/11/05.
 */
@Data
public class ProjectCodePLanRegChildModel implements Serializable {
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
    @JsonIgnore
    private Long regId;

    /**
     *
     */
    private Long projectId;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentPlanId;

    /**
     *
     */
    private String planCode;

    /**
     *
     */
    private Integer typeId;

    private String dateStr;


    public ProjectCodePLanRegChildModel() {

    }


}
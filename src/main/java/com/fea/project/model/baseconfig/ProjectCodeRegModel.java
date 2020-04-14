package com.fea.project.model.baseconfig;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/09/27.
 * 项目组织编号 实体类
 */
@Data
public class ProjectCodeRegModel implements Serializable {
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
     * 组织id
     */
    @JsonIgnore
    private Long regId;


    /**
     * 父项目id
     */
    private String parentProject;


    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除状态
     */
    @JsonIgnore
    private Integer delStatus;

    public static ProjectCodeRegModel createModel(Long regId, Integer delStatus, Date updateTime, String parentProject) {
        ProjectCodeRegModel model = new ProjectCodeRegModel();
        model.setRegId(regId);
        model.setDelStatus(delStatus);
        model.setUpdateTime(updateTime);
        model.setParentProject(parentProject);
        return model;
    }

}
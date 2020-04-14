package com.fea.project.model.base;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/09/25.
 */
@Data
@Builder
public class ProjectDictionaryModel implements Serializable {
    /**
     *
     */
    private Long id;

    /**
     * 名称
     */
    private String name;


    /**
     * 简称
     */
    private String shortName;

    /**
     * 组织id
     */
    private Long regId;

    /**
     * 创建人id
     */
    private Long createId;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    private Long updateId;

    /**
     * 更新人名称
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    public ProjectDictionaryModel() {
    }

    public ProjectDictionaryModel(Long id, String name, String shortName, Long regId, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.regId = regId;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    public ProjectDictionaryModel(String shortName, Long regId) {
        this.shortName = shortName;
        this.regId = regId;
    }
}
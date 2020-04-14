package com.fea.project.model.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/03/19.
 */
@Data
public class ProjectProductModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 项目立项产品表
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orgId;

    /**
     * 组织id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long regId;

    /**
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品分类id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long classifyId;

    /**
     * 产品分类
     */
    private String classify;

    /**
     * 产品类型id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long typeId;

    /**
     * 产品类型
     */
    private String type;

    /**
     * 主单位id
     */
    private Long unitId;

    /**
     * 主单位
     */
    private String unit;

    /**
     * 产品说明
     */
    private String description;

    /**
     * 产品性能
     */
    private String performance;

    /**
     * 产品结构
     */
    private String structure;

    /**
     * 产品适用范围
     */
    private String scope;

    /**
     * 产品需求背景
     */
    private String background;

    /**
     * 创建人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    /**
     * 创建人名称
     */
    private String createBy;

    /**
     * 创建人时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    /**
     * 更新人名称
     */
    private String updateBy;

    /**
     * 更新人时间
     */
    private Date updateTime;

    /**
     * 删除标识
     */
    private Integer delStatus;

    //附件id
    private List<Long> appendixIds;
    //产品图片列表
    private List<ProjectProductAppendixModel> pictureList;
    //产品规格型号列表
    private List<ProjectProductSpecificModel> specificModels;
    //产品详情附件列表
    private List<ProjectProductAppendixModel> detailsAppendixList;



    public ProjectProductModel () {
        
    }

    public ProjectProductModel(Long id, Long orgId, Long regId, Long projectId, String name, Long classifyId, String classify, Long typeId, String type, Long unitId, String unit, String description, String performance, String structure, String scope, String background, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime, Integer delStatus, List<Long> appendixIds, List<ProjectProductAppendixModel> pictureList, List<ProjectProductSpecificModel> specificModels, List<ProjectProductAppendixModel> detailsAppendixList) {
        this.id = id;
        this.orgId = orgId;
        this.regId = regId;
        this.projectId = projectId;
        this.name = name;
        this.classifyId = classifyId;
        this.classify = classify;
        this.typeId = typeId;
        this.type = type;
        this.unitId = unitId;
        this.unit = unit;
        this.description = description;
        this.performance = performance;
        this.structure = structure;
        this.scope = scope;
        this.background = background;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delStatus = delStatus;
        this.appendixIds = appendixIds;
        this.pictureList = pictureList;
        this.specificModels = specificModels;
        this.detailsAppendixList = detailsAppendixList;
    }
}
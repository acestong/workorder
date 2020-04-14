package com.fea.project.model.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/03/20.
 */
@Data
@Builder
public class ProjectProductSpecificModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 产品规格型号表
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;

    /**
     * 产品id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long productId;

    /**
     * 产品规格
     */
    private String specification;

    /**
     * 产品规格说明
     */
    private String specDescription;

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
    private List<ProjectProductAppendixModel> appendixModels;

    public ProjectProductSpecificModel() {
    }

    public ProjectProductSpecificModel(Long id, Long projectId, Long productId, String specification, String specDescription, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime, Integer delStatus, List<Long> appendixIds, List<ProjectProductAppendixModel> appendixModels) {
        this.id = id;
        this.projectId = projectId;
        this.productId = productId;
        this.specification = specification;
        this.specDescription = specDescription;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delStatus = delStatus;
        this.appendixIds = appendixIds;
        this.appendixModels = appendixModels;
    }
}
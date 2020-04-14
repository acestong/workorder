package com.fea.project.model.feebudget;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2020/01/13.
 */
@Builder
@Data
public class ProjectFeeDubgetParentModel implements Serializable {
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
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;

    /**
     * 父版本名称
     */
    private String name;

    /**
     * 预算版本
     */
    private Long version;

    /**
     * 是否为草稿 0-不是 1-是 2-已变更
     */
    private Integer isDraft;
    /**
     * 审核状态
     */
    private Integer verifyerStatus;

    /**
     * 审核标题
     */
    private String checkTitle;

    /**
     * 审核说明
     */
    private String checkContent;

    /**
     * 创建人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
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
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer delStatus;


    public ProjectFeeDubgetParentModel () {
        
    }

    public ProjectFeeDubgetParentModel(Long id, Long projectId, String name, Long version, Integer isDraft, Integer verifyerStatus, String checkTitle, String checkContent, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime, Integer delStatus) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
        this.version = version;
        this.isDraft = isDraft;
        this.verifyerStatus = verifyerStatus;
        this.checkTitle = checkTitle;
        this.checkContent = checkContent;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delStatus = delStatus;
    }


}
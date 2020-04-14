package com.fea.project.model.interflow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.base.AppendixModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/01/09.
 */
@Data
public class ProjectInterflowMeetingAppendixModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 附件信息表id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 绑定业务id（会议）
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessId;

    /**
     * 附件id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long appendixId;

    private List<ProjectAppendixModel> appendixIds;
    /**
     * 会议资料名称
     */
    private String name;

    private String fileName;
    /**
     * 会议资料描述
     */
    private String description;

    /**
     * 创建人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    /**
     * 
     */
    private String createBy;

    /**
     * 
     */
    private Date createTime;

    /**
     * 更新人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    /**
     * 
     */
    private String updateBy;

    /**
     * 
     */
    private Date updateTime;

    public ProjectInterflowMeetingAppendixModel(Long id, Long businessId, Long appendixId, String name, String fileName, String description, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime) {
        this.id = id;
        this.businessId = businessId;
        this.appendixId = appendixId;
        this.name = name;
        this.fileName = fileName;
        this.description = description;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    public ProjectInterflowMeetingAppendixModel (Long id, Long businessId, Long appendixId, String name, String description, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime) {
        this.id = id;
        this.businessId = businessId;
        this.appendixId = appendixId;
        this.name = name;
        this.description = description;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }
    public ProjectInterflowMeetingAppendixModel (Long businessId) {
        this.businessId = businessId;
    }

    public ProjectInterflowMeetingAppendixModel () {
        
    }
}
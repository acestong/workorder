package com.fea.project.model.projectdata;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@Data
public class AppendixDataFileVo {
    /**
     * 附件id
     */
    @JsonIgnore
    private Long id;

    @JsonIgnore
    private String name;

    /**
     * 文件名
     */
    @JsonIgnore
    private String realName;

    /**
     * 附件URL
     */
    @JsonIgnore
    private String url;

    /**
     * 附件id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessAppendixId;
    /**
     * 附件名称，前端填写
     */
    private String businessAppendixName;
    /**
     * 附件类型为枚举类
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessAppendixType;
    private String businessAppendixTypeString;
    /**
     * 描述
     */
    private String businessAppendixDesc;
    /**
     * 附件id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> appendixId;
    /**
     * 附件数量
     */
    private String appendixCount;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessId;
    /**
     * 存放业务名称(计划或任务)
     */
    @JsonIgnore
    private String businessName;

    /**
     * 存放项目Id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;

    /**
     * 存放业务类型(计划或任务)
     */
    @JsonIgnore
    private Long businessType;

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
    @JsonIgnore
    private Long updateId;

    /**
     * 更新人
     */
    @JsonIgnore
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonIgnore
    private Date updateTime;

    /**
     * 删除状态。使用枚举类型 DeleteStatusEnum.java
     * NOT_DELETE(0, "未删除"),
     * DELETE(1, "删除");
     */
    @JsonIgnore
    private Long delStatus;

    /**
     * 关联任务
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskId;
    private String taskName;
    /**
     * 关联阶段
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectStepId;
    private String projectStepName;
}

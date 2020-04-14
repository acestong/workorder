package com.fea.project.model.milestone;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrator
 * @date 2020/01/19
 */
@AllArgsConstructor
@Data
public class ProjectMilestoneVerifyModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;

    /**
     *
     */
    private String code;

    /**
     * 负责人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long applyUserId;

    /**
     * 审核状态
     */
    private Integer verifyStatus;
    private String verifyStatusStr;
    /**
     * 备注
     */
    private String remark;

    /**
     *
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
     *
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

    /**
     * 版本
     */
    private Integer version;


    public ProjectMilestoneVerifyModel () {

    }
}
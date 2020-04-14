package com.fea.project.model.interflow.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/01/09.
 */
@Data
public class ProjectInterflowMeetingModelVo implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 会议交流主键id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 会议标题
     */
    private String title;

    /**
     * 交流类型
     */
    private Integer type;
    private String typeString;

    /**
     * 会议方式
     */
    private Integer way;
    private String wayString;

    /**
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;
    private String projectName;
    /**
     * 项目阶段
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectStep;
    private String projectStepName;

    /**
     * 关联任务
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskId;
    private String taskName;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 会议时长
     */
    private String times;

    /**
     * 会议内容
     */
    private String details;

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

    /**
     * 删除状态(0正常，1删除)
     */
    @JsonIgnore
    private Integer delStates;
    /**
     * 预约会议（会议室名称，会议室地点）
     */
    private String meetingPlace;
    /**
     * 内部参与人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> userIds;
    private List<String> userNames;

    public ProjectInterflowMeetingModelVo() {
        
    }
}
package com.fea.project.model.interflow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrator
 * @date 2020/01/09
 */
@AllArgsConstructor
@Data
public class ProjectInterflowMeetingAgendaModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 会议议程主键id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 会议主键
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long meetingId;

    /**
     * 议程标题
     */
    private String agendaTitle;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 主讲人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long agendaUser;

    /**
     * 
     */
    private String agendaUserName;

    /**
     * 内容
     */
    private String description;

    /**
     * 备注
     */
    private String remark;

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

    public ProjectInterflowMeetingAgendaModel () {

    }
    public ProjectInterflowMeetingAgendaModel (Long meetingId) {
        this.meetingId = meetingId;
    }

}
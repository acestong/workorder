package com.fea.project.model.interflow.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.deliverable.vo.ProjectDeliverableVo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 * @date 2020/01/09
 */
@AllArgsConstructor
@Data
public class ProjectInterflowListShowVo implements Serializable, Comparable<ProjectInterflowListShowVo>  {
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
     * 会议标题
     */
    private String title;
    /**
     * 交流时间
     */
    private Date interflowTime;
    /**
     * 交流类型
     */
    private Integer type;
    private String typeString;
    /**
     * 会议方式
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
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


    public ProjectInterflowListShowVo() {
        
    }

    /**
     * 比较器排序
     */
    @Override
    public int compareTo(ProjectInterflowListShowVo o) {

        return o.createTime.compareTo(this.createTime);
    }
}
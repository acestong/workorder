package com.fea.project.model.task.vo;

import com.fea.project.model.task.TaskModel;
import lombok.Data;

/**
 * @author zhaoguolin
 */
@Data

public class TaskModelVo extends TaskModel {
    private String projectName;
    private String projectStepName;
}

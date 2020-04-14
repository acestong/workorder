package com.fea.project.model.interflow.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.model.interflow.ProjectInterflowPhoneModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrator
 * @date 2020/01/09
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectInterflowPhoneModelVo extends ProjectInterflowPhoneModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 类型
     */
    private String typeString;

    /**
     * 方式
     */
    private String wayString;
    /**
     * 联系人类型
     */
    private String contactTypeString;
     /**
     * 联系人id
     */
    private String contactName;
    /**
     * 项目id
     */
    private String projectName;
    /**
     * 项目阶段
     */
    private String projectStepName;
    /**
     * 关联任务
     */
    private String taskName;

}
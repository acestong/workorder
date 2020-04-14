package com.fea.project.model.flow.pojo;

import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/14 12:17
 * 根据选定人员类型，查询对应的下拉信息
 **/
@Data
public class ProjectFlowPersonTypePojo {

    /**
     * 人员类型
     */
    private Integer personType;
    /**
     * 项目id
     */
    private Long projectId;
}

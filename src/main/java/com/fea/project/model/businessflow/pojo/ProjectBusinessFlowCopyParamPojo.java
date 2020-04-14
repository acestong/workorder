package com.fea.project.model.businessflow.pojo;

import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/25 10:03
 **/
@Data
public class ProjectBusinessFlowCopyParamPojo {
    /**
     * t_project_flow_id流程id
     */
    private Long id;
    /**
     * t_project_flow_list_id的id
     */
    private Long listId;
}

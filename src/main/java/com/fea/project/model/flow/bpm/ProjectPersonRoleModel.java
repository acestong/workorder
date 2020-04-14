package com.fea.project.model.flow.bpm;

import com.fea.project.model.flow.bpm.io.IPersonType;
import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/10 10:54
 * 项目角色审核
 **/
@Data
public class ProjectPersonRoleModel implements IPersonType {

    private Long roleId;
    private Integer projectMutiplateLevelType;

}

package com.fea.project.model.flow.bpm;

import com.fea.project.model.flow.bpm.io.IPersonType;
import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/10 10:50
 * 上级审核设定model
 **/
@Data
public class ProjectPersonSuperiorModel implements IPersonType {


    private Integer levelType;

    private Integer projectMutiplateLevelType;


}

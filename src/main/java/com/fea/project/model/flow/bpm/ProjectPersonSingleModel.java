package com.fea.project.model.flow.bpm;

import com.fea.project.model.flow.bpm.io.IPersonType;
import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/10 10:56
 * 项目审核单个成员
 **/
@Data
public class ProjectPersonSingleModel implements IPersonType {

    private Long userId;
}

package com.fea.project.model.flow.vo;

import com.fea.project.model.flow.ProjectFlowListConditionModel;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */
@Data
public class ProjectFlowListConditionVo extends ProjectFlowListConditionModel {

    private String fieldTypeName;

    private String filterTypeName;

    private List<String> filterValues;

    private String filterValueUnitName;
}
package com.fea.project.model.flow.flowtype;

import com.fea.project.enums.base.ProjectActionCodeEnum;
import com.fea.project.enums.flow.base.flowtype.ProjectFlowCreateProjectConditionTypeEnum;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/11 15:40
 **/
@Data
public class ProjectFlowCreateProjectConditionTypeModel {

    private Integer value;
    private String text;
    private Integer typeStr;
    private List<Map<String, Object>> actionMap;
    private List<Map<String, Object>> moneyTypeIfNumber;

    public ProjectFlowCreateProjectConditionTypeModel() {
    }

    public ProjectFlowCreateProjectConditionTypeModel(ProjectFlowCreateProjectConditionTypeEnum typeEnum) {
        this.value = typeEnum.getValue();
        this.text = typeEnum.getText();
        this.typeStr = typeEnum.getTypeStr();
        this.actionMap = ProjectActionCodeEnum.getEnumMap().get(typeStr).getViewActionList();
        this.moneyTypeIfNumber = ProjectActionCodeEnum.getEnumMap().get(typeStr).getMoneyType();
    }
}

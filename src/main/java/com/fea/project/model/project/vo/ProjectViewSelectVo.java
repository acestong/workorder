package com.fea.project.model.project.vo;

import com.fea.project.enums.project.ProjectViewFieldEnum;
import com.fea.project.util.UserUtil;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/28 11:25
 **/
@Data
public class ProjectViewSelectVo {

    private Integer code;
    private String name;
    private Integer type;
    private List<Map<String, Object>> actionList;
    private Object param;

    public ProjectViewSelectVo() {
    }

    public ProjectViewSelectVo(ProjectViewFieldEnum projectViewFieldEnum) {
        this.code = projectViewFieldEnum.getValue();
        this.name = projectViewFieldEnum.getText();
        this.type = projectViewFieldEnum.getProjectViewActionCodeEnum().getValue();
        this.actionList = projectViewFieldEnum.getProjectViewActionCodeEnum().getViewActionList();
        this.param = projectViewFieldEnum.selectParamByRegId(UserUtil.getUserRegId());
    }

    public static List<ProjectViewSelectVo> createList(ProjectViewFieldEnum[] projectViewFieldEnums) {
        return Stream.of(projectViewFieldEnums).map(x -> new ProjectViewSelectVo(x)).collect(Collectors.toList());
    }


}

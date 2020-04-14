package com.fea.project.model.role.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/18 10:32
 **/
@Data
public class ProjectRoleAuthorityDetailVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Integer status;
}

package com.fea.project.model.fieldconfig.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2020/1/19 18:19
 * 字段配置model
 **/
@Data
public class ProjectUpdateFieldPojo {

    private Integer typeId;
    private List<Long> enterpriseIds;
}

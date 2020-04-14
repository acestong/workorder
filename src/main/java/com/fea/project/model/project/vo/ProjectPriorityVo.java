package com.fea.project.model.project.vo;

import lombok.Data;

import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2020/3/9 18:24
 **/
@Data
public class ProjectPriorityVo {

    private Integer canChangable;

    private Map<String, Integer> priorityMap;

}

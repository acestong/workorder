package com.fea.project.model.projectdata;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Data
public class IdsVo {

    private Long projectId;

    private List<Long> businessIds;

    private List<Long> createIds;

    private Map<String, List<Object>> filters;

    private String sortKey;

    private String sortValue;

    private String keywords;
}

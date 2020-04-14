package com.fea.project.model.interflow.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.projectdata.DataTeamVo;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Data
public class QueryInterflowParamVo {
    /**
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;
    /**
     * ids
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> createIds;
    /**
     * 筛选字段
     */
    private Map<String, List<Object>> filters;
    /**
     *
     */
    private String sortKey;
    /**
     *
     */
    private String sortValue;
    /**
     * 按关键字搜索
     */
    private String keywords;

    public QueryInterflowParamVo() {
    }

    public QueryInterflowParamVo(BasePageInfo<DataTeamVo> model) {
        this.projectId = model.getModel().getProjectId();
        this.filters = model.getFilters();
        this.sortKey = model.getSortKey();
        this.sortValue = model.getSortValue();
        this.keywords = model.getKeywords();
    }
}

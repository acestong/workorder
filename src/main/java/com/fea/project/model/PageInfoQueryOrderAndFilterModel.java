package com.fea.project.model;

import java.util.List;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/5/9 10:08
 * pageInfo分页过滤参数model
 **/
public class PageInfoQueryOrderAndFilterModel<T> {

    private T model;
    private String sortKey;
    private String sortValue;
    private String keywords;
    private Map<String, List<Object>> filters;

    public PageInfoQueryOrderAndFilterModel(BasePageInfo<T> pageInfo) {
        this.model = pageInfo.getModel();
        this.sortKey = pageInfo.getSortKey();
        this.sortValue = pageInfo.getSortValue();
        this.filters = pageInfo.getFilters();
        this.keywords = pageInfo.getKeywords();
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public String getSortValue() {
        return sortValue;
    }

    public void setSortValue(String sortValue) {
        this.sortValue = sortValue;
    }

    public Map<String, List<Object>> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, List<Object>> filters) {
        this.filters = filters;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }


}
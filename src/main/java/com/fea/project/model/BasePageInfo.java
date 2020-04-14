package com.fea.project.model;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/5/8 20:40
 **/

public class BasePageInfo<T> extends PageInfo<T> {
    private T model;

    private Map<String, List<Object>> filters;

    private String sortKey;

    private String sortValue;

    private String keywords;

    public BasePageInfo() {
    }

    public BasePageInfo(List<T> list) {
        super(list);
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public Map<String, List<Object>> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, List<Object>> filters) {
        this.filters = filters;
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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Long getStartPage() {
        if (this.getPageNum() == 0) {
            return 1L;
        }
        return (this.getPageNum() - 1) * this.getPageSize() + 1L;
    }
}
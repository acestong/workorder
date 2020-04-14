package com.fea.project.model.baseconfig;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/09/27.
 */
@Data
public class ProjectCodeModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;

    /**
     * 日期类型
     * 来源数据字典
     */
    protected Integer dataStr;

    /**
     * 父项目数字个数
     */
    protected Integer parentNumber;

    /**
     * 子项目数字个数
     */
    protected Integer childNumber;


    /**
     * 生成周期类型
     */
    protected Integer createPeriod;

    /**
     * 组织机构id
     */
    @JsonIgnore
    protected Long regId;

    protected String childShortName;

}
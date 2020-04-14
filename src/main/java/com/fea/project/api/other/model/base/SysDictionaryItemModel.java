package com.fea.project.api.other.model.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/12/07.
 * 数据字典子表 实体类
 */
@Data
public class SysDictionaryItemModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据字典ID
     */
    private Long ITEMID;

    /**
     * 数据字典主表id
     */
    private Long DICID;

    /**
     * 数据字典值
     */
    private String DICVALUE;

    /**
     * 数据字典值code
     */
    private String DICCODE;

    /**
     * 显示顺序
     */
    private Integer DISPLAYORDER;

    /**
     * 组织注册标识
     */
    private Long REGID;

    /**
     *
     */
    private Integer DELSTATE;

    /**
     *
     */
    private Integer ISDISPLAY;

    /**
     *
     */
    private Integer ISDEFAULT;

    /**
     *
     */
    private String CREATEUSER;

    /**
     *
     */
    private Date CREATETIME;

    /**
     *
     */
    private String UPDATEUSER;

    /**
     *
     */
    private Date UPDATETIME;

}
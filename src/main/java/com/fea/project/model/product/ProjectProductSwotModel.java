package com.fea.project.model.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrator
 * @date 2020/03/20
 */
@Data
public class ProjectProductSwotModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 产品分析（swot）主键
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;

    /**
     * 项目立项产品id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long productId;

    /**
     * swot类型
     */
    private Integer swotType;

    /**
     * swot文本
     */
    private String details;

    /**
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    /**
     * 
     */
    private String createBy;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    /**
     * 
     */
    private String updateBy;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 删除状态(0正常，1删除)
     */
    @JsonIgnore
    private Integer delStates;

    public ProjectProductSwotModel (Long id, Long projectId, Long productId, Integer swotType, String details, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime, Integer delStates) {
        this.id = id;
        this.projectId = projectId;
        this.productId = productId;
        this.swotType = swotType;
        this.details = details;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delStates = delStates;
    }

    public ProjectProductSwotModel () {
        
    }
}
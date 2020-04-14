package com.fea.project.model.establishproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.io.project.IProjectBusinessModel;
import lombok.Data;

/**
 * @author wuqi
 * @since 2019/12/26 14:54
 * @version 1.0
 **/
@Data
public class ProjectInnerProjectBusinessVo implements IProjectBusinessModel {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String connectId;

    private String businessName;
    /**
     * 产品研发标识
     */
    private Integer productDevelopeFlag;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品类型
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long productType;

    private String productTypeName;

    public ProjectInnerProjectBusinessVo() {
    }

    @Override
    public String getShowName() {
        return productName;
    }
}

package com.fea.project.model.establishproject.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.establishproject.project.ProjectEstablishProjectModel;
import com.fea.project.model.project.pojo.ProjectPojo;
import com.fea.project.util.UserUtil;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/23 17:25
 **/
@Data
public class ProjectEstablishProjectPojo extends ProjectPojo {

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


    /**
     * 立项成员
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> establishPartners;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long establishLeader;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long establishStep;

    private Integer startStatus;

    private Date startDate;


    protected Integer personOrTeamType;

    /**
     * 人员查询人员
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected List<Long> userIds;
    /**
     * 人员查询类型
     */
    protected Integer queryType;

    protected List<Long> ids;

    private Long selectId;
    private Integer selectType;


    public ProjectEstablishProjectPojo() {
    }


    public ProjectEstablishProjectModel createProjectEstablishProjectModel() {
        ProjectEstablishProjectModel model = new ProjectEstablishProjectModel();
        model.setProjectId(this.getId());
        model.setCreateId(this.getCreateId());
        model.setCreateBy(this.getCreateBy());
        model.setCreateTime(this.getCreateTime());
        model.setUpdateId(this.getUpdateId());
        model.setUpdateBy(this.getUpdateBy());
        model.setUpdateTime(this.getUpdateTime());
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        model.setProductDevelopeFlag(this.getProductDevelopeFlag());
        model.setProductName(this.getProductName());
        model.setProductType(this.getProductType());
        model.setApplyer(this.getApplyer());
        model.setEstablishLeader(this.getEstablishLeader());
        model.setRegId(UserUtil.getUserRegId());
        return model;
    }
}

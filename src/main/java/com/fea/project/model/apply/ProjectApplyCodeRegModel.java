package com.fea.project.model.apply;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.util.DateUtil;
import com.fea.project.util.StringUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/11/27.
 * 项目组织编号 实体类
 */
@Data
public class ProjectApplyCodeRegModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 组织id
     */
    @JsonIgnore
    private Long regId;

    /**
     * 年-季度
     */
    private String yearQuarter;

    /**
     * 父项目code
     */
    private String lastCode;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除状态
     */
    @JsonIgnore
    private Integer delStatus;

    private Integer flowType;


    public ProjectApplyCodeRegModel() {

    }

    public ProjectApplyCodeRegModel(Long regId, Integer flowType, Integer codeNumber, Date currentTime) {
        this.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        this.setFlowType(flowType);
        this.setLastCode(StringUtil.getNextCodeByCurrentStr(
                StringUtil.getInitStartCodeByLength(codeNumber), codeNumber));
        this.setRegId(regId);
        this.setUpdateTime(currentTime);
        this.setYearQuarter(DateUtil.getTimeQuarter(currentTime));
    }
}
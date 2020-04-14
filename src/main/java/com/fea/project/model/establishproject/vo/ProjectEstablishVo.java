package com.fea.project.model.establishproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.project.vo.ProjectVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/12/23.
 */
@Data
public class ProjectEstablishVo extends ProjectVo {



    /**
     * 立项成员
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> establishPartners;


    /**
     * 立项成员名称
     */
    private String establishPartnersNames;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long establishLeader;

    private String establishLeaderName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long establishStep;

    private String establishStepName;

    private String establishStepVerifyStatusName;

    private Integer startStatus;

    private String startStatusName;

    private Date startDate;

    protected Date establishTime;

    private Integer startBtnShow;


    public ProjectEstablishVo() {
    }


    public void setAppendInfo(ProjectEstablishProjectVo projectEstablishProjectVo) {
        this.establishLeader = projectEstablishProjectVo.getEstablishLeader();
        this.establishLeaderName = projectEstablishProjectVo.getEstablishLeaderName();
        this.establishPartners = projectEstablishProjectVo.getEstablishPartners();
        this.establishPartnersNames = projectEstablishProjectVo.getEstablishPartnersNames();
        this.updateId = projectEstablishProjectVo.getUpdateId();
        this.updateBy = projectEstablishProjectVo.getUpdateBy();
        this.updateTime = projectEstablishProjectVo.getUpdateTime();
        this.regId = projectEstablishProjectVo.getRegId();
        this.establishStep = projectEstablishProjectVo.getEstablishStep();
        this.establishStepName = projectEstablishProjectVo.getEstablishStepName();
        this.startDate = projectEstablishProjectVo.getStartDate();
        this.startStatus = projectEstablishProjectVo.getStartStatus();
        this.startStatusName = projectEstablishProjectVo.getStartStatusName();
    }
}
package com.fea.project.model.project.vo;

import com.fea.project.api.other.model.customer.CrmContactModel;
import com.fea.project.model.project.ProjectContactorModel;
import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/25 9:15
 * 项目联系人
 **/
@Data
public class ProjectContactorVo extends ProjectContactorModel {

    private String name;
    private Integer sex;
    private String customerName;
    private String deptName;
    private String position;
    private String mobile;
    private String email;


    public void setContactBaseInfo(CrmContactModel tmpModel) {
        this.setName(tmpModel.getCONTACTNAME());
        this.setCustomerName(tmpModel.getCUSTOMERNAME());
        this.setDeptName(tmpModel.getDEPARTMENTNAME());
        this.setEmail(tmpModel.getEMAIL());
        this.setMobile(tmpModel.getMOBILE());
        this.setPosition(tmpModel.getPOSITION());
        this.setSex(tmpModel.getGENDER());
    }
}

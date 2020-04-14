package com.fea.project.workorder.model;

import java.io.Serializable;

import com.fea.project.api.other.model.customer.CrmContactModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactModel implements Serializable {
    private Long contactId;

    private String name;

    private String tel;

    private String email;

    private String deptName;

    private String jobName;

    private String address;

    private Long workorderId;

    private static final long serialVersionUID = 1L;

    public ContactModel(CrmContactModel crmContactModel) {
    	if(crmContactModel != null) {
    		this.name = crmContactModel.getCONTACTNAME();
    		this.tel = crmContactModel.getTEL();
    		this.email = crmContactModel.getEMAIL();
    		this.deptName = crmContactModel.getDEPARTMENTNAME();
    		this.jobName = crmContactModel.getPOSITION();
    	}
    }
}
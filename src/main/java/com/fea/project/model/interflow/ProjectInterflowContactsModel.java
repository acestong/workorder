package com.fea.project.model.interflow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrator
 * @date 2020/01/09
 */
@AllArgsConstructor
@Data
public class ProjectInterflowContactsModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 外部联系人主键id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 业务主键id（会议，邮件，电话，拜访）
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 公司名称
     */
    private String company;

    /**
     * 部门
     */
    private String department;

    /**
     * 职务
     */
    private String jobName;

    /**
     * 手机
     */
    private String phoneNum;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 创建人
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
     * 更新人
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


    public ProjectInterflowContactsModel () {
        
    }
    public ProjectInterflowContactsModel (Long businessId) {
        this.businessId = businessId;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", businessId=").append(businessId);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", company=").append(company);
        sb.append(", department=").append(department);
        sb.append(", jobName=").append(jobName);
        sb.append(", phoneNum=").append(phoneNum);
        sb.append(", email=").append(email);
        sb.append(", address=").append(address);
        sb.append(", createId=").append(createId);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}
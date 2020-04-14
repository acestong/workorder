package com.fea.project.model.milestone;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/29.
 * 编码配置表 实体类
 */
@Builder
public class MilestoneCodeconfigModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编码主键
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 编码类型
     */
    private Integer type;

    /**
     * 编码前缀
     */
    private String prefix;

    /**
     * 是否含编码前缀(0-false,1-true)
     */
    private Boolean isPrefix;

    /**
     * 是否含日期(0-false,1-true)
     */
    private Boolean isDate;

    /**
     * 最大值
     */
    private Long nextNo;

    /**
     * 数值长度
     */
    private Integer noLen;

    /**
     * 组织注册编号
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long regId;

    /**
     * 创建人ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新用户ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    /**
     * 更新用户
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    public MilestoneCodeconfigModel(Long id, Integer type, String prefix, Boolean isPrefix, Boolean isDate, Long nextNo, Integer noLen, Long regId, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime) {
        this.id = id;
        this.type = type;
        this.prefix = prefix;
        this.isPrefix = isPrefix;
        this.isDate = isDate;
        this.nextNo = nextNo;
        this.noLen = noLen;
        this.regId = regId;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    public MilestoneCodeconfigModel() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix == null ? null : prefix.trim();
    }

    public Boolean getIsPrefix() {
        return isPrefix;
    }

    public void setIsPrefix(Boolean isPrefix) {
        this.isPrefix = isPrefix;
    }

    public Boolean getIsDate() {
        return isDate;
    }

    public void setIsDate(Boolean isDate) {
        this.isDate = isDate;
    }

    public Long getNextNo() {
        return nextNo;
    }

    public void setNextNo(Long nextNo) {
        this.nextNo = nextNo;
    }

    public Integer getNoLen() {
        return noLen;
    }

    public void setNoLen(Integer noLen) {
        this.noLen = noLen;
    }

    public Long getRegId() {
        return regId;
    }

    public void setRegId(Long regId) {
        this.regId = regId;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", prefix=").append(prefix);
        sb.append(", isPrefix=").append(isPrefix);
        sb.append(", isDate=").append(isDate);
        sb.append(", nextNo=").append(nextNo);
        sb.append(", noLen=").append(noLen);
        sb.append(", regId=").append(regId);
        sb.append(", createId=").append(createId);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MilestoneCodeconfigModel other = (MilestoneCodeconfigModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getPrefix() == null ? other.getPrefix() == null : this.getPrefix().equals(other.getPrefix()))
            && (this.getIsPrefix() == null ? other.getIsPrefix() == null : this.getIsPrefix().equals(other.getIsPrefix()))
            && (this.getIsDate() == null ? other.getIsDate() == null : this.getIsDate().equals(other.getIsDate()))
            && (this.getNextNo() == null ? other.getNextNo() == null : this.getNextNo().equals(other.getNextNo()))
            && (this.getNoLen() == null ? other.getNoLen() == null : this.getNoLen().equals(other.getNoLen()))
            && (this.getRegId() == null ? other.getRegId() == null : this.getRegId().equals(other.getRegId()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getPrefix() == null) ? 0 : getPrefix().hashCode());
        result = prime * result + ((getIsPrefix() == null) ? 0 : getIsPrefix().hashCode());
        result = prime * result + ((getIsDate() == null) ? 0 : getIsDate().hashCode());
        result = prime * result + ((getNextNo() == null) ? 0 : getNextNo().hashCode());
        result = prime * result + ((getNoLen() == null) ? 0 : getNoLen().hashCode());
        result = prime * result + ((getRegId() == null) ? 0 : getRegId().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}
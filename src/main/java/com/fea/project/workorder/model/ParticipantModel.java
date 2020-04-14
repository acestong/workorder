package com.fea.project.workorder.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ParticipantModel implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long participantId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    private String userName;

    private Long businessType;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessId;

    private static final long serialVersionUID = 1L;

    public Long getParticipantId() {
        return participantId;
    }

    public ParticipantModel withParticipantId(Long participantId) {
        this.setParticipantId(participantId);
        return this;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public Long getUserId() {
        return userId;
    }

    public ParticipantModel withUserId(Long userId) {
        this.setUserId(userId);
        return this;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public ParticipantModel withUserName(String userName) {
        this.setUserName(userName);
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Long getBusinessType() {
        return businessType;
    }

    public ParticipantModel withBusinessType(Long businessType) {
        this.setBusinessType(businessType);
        return this;
    }

    public void setBusinessType(Long businessType) {
        this.businessType = businessType;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public ParticipantModel withBusinessId(Long businessId) {
        this.setBusinessId(businessId);
        return this;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", participantId=").append(participantId);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", businessType=").append(businessType);
        sb.append(", businessId=").append(businessId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
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
        ParticipantModel other = (ParticipantModel) that;
        return (this.getParticipantId() == null ? other.getParticipantId() == null : this.getParticipantId().equals(other.getParticipantId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getBusinessType() == null ? other.getBusinessType() == null : this.getBusinessType().equals(other.getBusinessType()))
            && (this.getBusinessId() == null ? other.getBusinessId() == null : this.getBusinessId().equals(other.getBusinessId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getParticipantId() == null) ? 0 : getParticipantId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getBusinessType() == null) ? 0 : getBusinessType().hashCode());
        result = prime * result + ((getBusinessId() == null) ? 0 : getBusinessId().hashCode());
        return result;
    }
}
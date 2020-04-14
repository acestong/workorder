package com.fea.project.workorder.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VisiblePersonModel implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long personId;

    private String personName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deptId;

    private String deptName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long poolId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public VisiblePersonModel withId(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public VisiblePersonModel withPersonId(Long personId) {
        this.setPersonId(personId);
        return this;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public VisiblePersonModel withPersonName(String personName) {
        this.setPersonName(personName);
        return this;
    }

    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    public Long getDeptId() {
        return deptId;
    }

    public VisiblePersonModel withDeptId(Long deptId) {
        this.setDeptId(deptId);
        return this;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public VisiblePersonModel withDeptName(String deptName) {
        this.setDeptName(deptName);
        return this;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Long getPoolId() {
        return poolId;
    }

    public VisiblePersonModel withPoolId(Long poolId) {
        this.setPoolId(poolId);
        return this;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", personId=").append(personId);
        sb.append(", personName=").append(personName);
        sb.append(", deptId=").append(deptId);
        sb.append(", deptName=").append(deptName);
        sb.append(", poolId=").append(poolId);
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
        VisiblePersonModel other = (VisiblePersonModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPersonId() == null ? other.getPersonId() == null : this.getPersonId().equals(other.getPersonId()))
            && (this.getPersonName() == null ? other.getPersonName() == null : this.getPersonName().equals(other.getPersonName()))
            && (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
            && (this.getDeptName() == null ? other.getDeptName() == null : this.getDeptName().equals(other.getDeptName()))
            && (this.getPoolId() == null ? other.getPoolId() == null : this.getPoolId().equals(other.getPoolId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPersonId() == null) ? 0 : getPersonId().hashCode());
        result = prime * result + ((getPersonName() == null) ? 0 : getPersonName().hashCode());
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getDeptName() == null) ? 0 : getDeptName().hashCode());
        result = prime * result + ((getPoolId() == null) ? 0 : getPoolId().hashCode());
        return result;
    }
}
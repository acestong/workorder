package com.fea.project.workorder.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PoolAutoDispatchModel implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long autoDispatchId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workorderPoolId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workorderTypeId;

    private String connector;

    private static final long serialVersionUID = 1L;

    public Long getAutoDispatchId() {
        return autoDispatchId;
    }

    public PoolAutoDispatchModel withAutoDispatchId(Long autoDispatchId) {
        this.setAutoDispatchId(autoDispatchId);
        return this;
    }

    public void setAutoDispatchId(Long autoDispatchId) {
        this.autoDispatchId = autoDispatchId;
    }

    public Long getWorkorderPoolId() {
        return workorderPoolId;
    }

    public PoolAutoDispatchModel withWorkorderPoolId(Long workorderPoolId) {
        this.setWorkorderPoolId(workorderPoolId);
        return this;
    }

    public void setWorkorderPoolId(Long workorderPoolId) {
        this.workorderPoolId = workorderPoolId;
    }

    public Long getWorkorderTypeId() {
        return workorderTypeId;
    }

    public PoolAutoDispatchModel withWorkorderTypeId(Long workorderTypeId) {
        this.setWorkorderTypeId(workorderTypeId);
        return this;
    }

    public void setWorkorderTypeId(Long workorderTypeId) {
        this.workorderTypeId = workorderTypeId;
    }

    public String getConnector() {
        return connector;
    }

    public PoolAutoDispatchModel withConnector(String connector) {
        this.setConnector(connector);
        return this;
    }

    public void setConnector(String connector) {
        this.connector = connector == null ? null : connector.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", autoDispatchId=").append(autoDispatchId);
        sb.append(", workorderPoolId=").append(workorderPoolId);
        sb.append(", workorderTypeId=").append(workorderTypeId);
        sb.append(", connector=").append(connector);
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
        PoolAutoDispatchModel other = (PoolAutoDispatchModel) that;
        return (this.getAutoDispatchId() == null ? other.getAutoDispatchId() == null : this.getAutoDispatchId().equals(other.getAutoDispatchId()))
            && (this.getWorkorderPoolId() == null ? other.getWorkorderPoolId() == null : this.getWorkorderPoolId().equals(other.getWorkorderPoolId()))
            && (this.getWorkorderTypeId() == null ? other.getWorkorderTypeId() == null : this.getWorkorderTypeId().equals(other.getWorkorderTypeId()))
            && (this.getConnector() == null ? other.getConnector() == null : this.getConnector().equals(other.getConnector()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAutoDispatchId() == null) ? 0 : getAutoDispatchId().hashCode());
        result = prime * result + ((getWorkorderPoolId() == null) ? 0 : getWorkorderPoolId().hashCode());
        result = prime * result + ((getWorkorderTypeId() == null) ? 0 : getWorkorderTypeId().hashCode());
        result = prime * result + ((getConnector() == null) ? 0 : getConnector().hashCode());
        return result;
    }
}
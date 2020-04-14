package com.fea.project.model.product;

import lombok.Builder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2020/03/27.
 */
@Builder
public class ProjectProductProfitModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 产品利润分析
     */
    private Long id;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 产品id
     */
    private Long productId;
    /**
     * 产品名称
     */
    private String productName;

    /**
     * 字段名称
     */
    private String name;

    /**
     * 字段类型id
     */
    private Long typeId;

    /**
     * 字段类型
     */
    private String type;

    /**
     * 启用状态(0-启用  1-未启用）
     */
    private Integer state;

    /**
     * 字段排序
     */
    private Integer ordering;

    /**
     * 价格
     */
    private BigDecimal amount;

    /**
     * 金额单位id
     */
    private Long amountUnitId;

    /**
     * 金额单位（元，万元）
     */
    private String amountUnit;

    /**
     * 币种（人民币，美元）
     */
    private String currency;

    /**
     * 计量单位id
     */
    private Long unitId;

    /**
     * 计量单位
     */
    private String unit;

    /**
     * 创建人id
     */
    private Long createId;

    /**
     * 创建人名称
     */
    private String createBy;

    /**
     * 创建人时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    private Long updateId;

    /**
     * 更新人名称
     */
    private String updateBy;

    /**
     * 更新人时间
     */
    private Date updateTime;

    /**
     * 删除标识
     */
    private Integer delStatus;

    /**
     * 上移下移标志
     */
    private String sortStr;


    public ProjectProductProfitModel () {
        
    }

    public ProjectProductProfitModel(Long id, Long projectId, Long productId, String productName, String name, Long typeId, String type, Integer state, Integer ordering, BigDecimal amount, Long amountUnitId, String amountUnit, String currency, Long unitId, String unit, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime, Integer delStatus, String sortStr) {
        this.id = id;
        this.projectId = projectId;
        this.productId = productId;
        this.productName = productName;
        this.name = name;
        this.typeId = typeId;
        this.type = type;
        this.state = state;
        this.ordering = ordering;
        this.amount = amount;
        this.amountUnitId = amountUnitId;
        this.amountUnit = amountUnit;
        this.currency = currency;
        this.unitId = unitId;
        this.unit = unit;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delStatus = delStatus;
        this.sortStr = sortStr;
    }

    public String getSortStr() {
        return sortStr;
    }

    public void setSortStr(String sortStr) {
        this.sortStr = sortStr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOrdering() {
        return ordering;
    }

    public void setOrdering(Integer ordering) {
        this.ordering = ordering;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getAmountUnitId() {
        return amountUnitId;
    }

    public void setAmountUnitId(Long amountUnitId) {
        this.amountUnitId = amountUnitId;
    }

    public String getAmountUnit() {
        return amountUnit;
    }

    public void setAmountUnit(String amountUnit) {
        this.amountUnit = amountUnit == null ? null : amountUnit.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
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

    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectId=").append(projectId);
        sb.append(", productId=").append(productId);
        sb.append(", name=").append(name);
        sb.append(", typeId=").append(typeId);
        sb.append(", type=").append(type);
        sb.append(", state=").append(state);
        sb.append(", ordering=").append(ordering);
        sb.append(", amount=").append(amount);
        sb.append(", amountUnitId=").append(amountUnitId);
        sb.append(", amountUnit=").append(amountUnit);
        sb.append(", currency=").append(currency);
        sb.append(", unitId=").append(unitId);
        sb.append(", unit=").append(unit);
        sb.append(", createId=").append(createId);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", delStatus=").append(delStatus);
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
        ProjectProductProfitModel other = (ProjectProductProfitModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getOrdering() == null ? other.getOrdering() == null : this.getOrdering().equals(other.getOrdering()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getAmountUnitId() == null ? other.getAmountUnitId() == null : this.getAmountUnitId().equals(other.getAmountUnitId()))
            && (this.getAmountUnit() == null ? other.getAmountUnit() == null : this.getAmountUnit().equals(other.getAmountUnit()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDelStatus() == null ? other.getDelStatus() == null : this.getDelStatus().equals(other.getDelStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getOrdering() == null) ? 0 : getOrdering().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getAmountUnitId() == null) ? 0 : getAmountUnitId().hashCode());
        result = prime * result + ((getAmountUnit() == null) ? 0 : getAmountUnit().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDelStatus() == null) ? 0 : getDelStatus().hashCode());
        return result;
    }
}
package com.fea.project.api.other.model.base;

import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2020/03/05.
 */
@Builder
public class PdtUnitModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private Long UNITID;

    /**
     * 所属分类
     */
    private Long CATEGORYID;

    /**
     * 单位名称
     */
    private String NAME;

    /**
     * 单位编码
     */
    private String CODE;

    /**
     * 
     */
    private Boolean ISBASEUNIT;

    /**
     * 转换关系
     */
    private Boolean RELATION;

    /**
     * 转换数
     */
    private Double CONVERTNUM;

    /**
     * 是否启用
     */
    private Boolean ISENABLE;

    /**
     * 
     */
    private Boolean DELETEFLAG;

    /**
     * 组织注册编号
     */
    private Long REGID;

    /**
     * 创建人
     */
    private String CREATEUSER;

    /**
     * 创建时间
     */
    private Date CREATETIME;

    /**
     * 修改人
     */
    private String UPDATEUSER;

    /**
     * 修改时间
     */
    private Date UPDATETIME;

    public PdtUnitModel (Long UNITID, Long CATEGORYID, String NAME, String CODE, Boolean ISBASEUNIT, Boolean RELATION, Double CONVERTNUM, Boolean ISENABLE, Boolean DELETEFLAG, Long REGID, String CREATEUSER, Date CREATETIME, String UPDATEUSER, Date UPDATETIME) {
        this.UNITID = UNITID;
        this.CATEGORYID = CATEGORYID;
        this.NAME = NAME;
        this.CODE = CODE;
        this.ISBASEUNIT = ISBASEUNIT;
        this.RELATION = RELATION;
        this.CONVERTNUM = CONVERTNUM;
        this.ISENABLE = ISENABLE;
        this.DELETEFLAG = DELETEFLAG;
        this.REGID = REGID;
        this.CREATEUSER = CREATEUSER;
        this.CREATETIME = CREATETIME;
        this.UPDATEUSER = UPDATEUSER;
        this.UPDATETIME = UPDATETIME;
    }

    public PdtUnitModel () {
        
    }

    public Long getUNITID() {
        return UNITID;
    }

    public void setUNITID(Long UNITID) {
        this.UNITID = UNITID;
    }

    public Long getCATEGORYID() {
        return CATEGORYID;
    }

    public void setCATEGORYID(Long CATEGORYID) {
        this.CATEGORYID = CATEGORYID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME == null ? null : NAME.trim();
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE == null ? null : CODE.trim();
    }

    public Boolean getISBASEUNIT() {
        return ISBASEUNIT;
    }

    public void setISBASEUNIT(Boolean ISBASEUNIT) {
        this.ISBASEUNIT = ISBASEUNIT;
    }

    public Boolean getRELATION() {
        return RELATION;
    }

    public void setRELATION(Boolean RELATION) {
        this.RELATION = RELATION;
    }

    public Double getCONVERTNUM() {
        return CONVERTNUM;
    }

    public void setCONVERTNUM(Double CONVERTNUM) {
        this.CONVERTNUM = CONVERTNUM;
    }

    public Boolean getISENABLE() {
        return ISENABLE;
    }

    public void setISENABLE(Boolean ISENABLE) {
        this.ISENABLE = ISENABLE;
    }

    public Boolean getDELETEFLAG() {
        return DELETEFLAG;
    }

    public void setDELETEFLAG(Boolean DELETEFLAG) {
        this.DELETEFLAG = DELETEFLAG;
    }

    public Long getREGID() {
        return REGID;
    }

    public void setREGID(Long REGID) {
        this.REGID = REGID;
    }

    public String getCREATEUSER() {
        return CREATEUSER;
    }

    public void setCREATEUSER(String CREATEUSER) {
        this.CREATEUSER = CREATEUSER == null ? null : CREATEUSER.trim();
    }

    public Date getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(Date CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public String getUPDATEUSER() {
        return UPDATEUSER;
    }

    public void setUPDATEUSER(String UPDATEUSER) {
        this.UPDATEUSER = UPDATEUSER == null ? null : UPDATEUSER.trim();
    }

    public Date getUPDATETIME() {
        return UPDATETIME;
    }

    public void setUPDATETIME(Date UPDATETIME) {
        this.UPDATETIME = UPDATETIME;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", UNITID=").append(UNITID);
        sb.append(", CATEGORYID=").append(CATEGORYID);
        sb.append(", NAME=").append(NAME);
        sb.append(", CODE=").append(CODE);
        sb.append(", ISBASEUNIT=").append(ISBASEUNIT);
        sb.append(", RELATION=").append(RELATION);
        sb.append(", CONVERTNUM=").append(CONVERTNUM);
        sb.append(", ISENABLE=").append(ISENABLE);
        sb.append(", DELETEFLAG=").append(DELETEFLAG);
        sb.append(", REGID=").append(REGID);
        sb.append(", CREATEUSER=").append(CREATEUSER);
        sb.append(", CREATETIME=").append(CREATETIME);
        sb.append(", UPDATEUSER=").append(UPDATEUSER);
        sb.append(", UPDATETIME=").append(UPDATETIME);
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
        PdtUnitModel other = (PdtUnitModel) that;
        return (this.getUNITID() == null ? other.getUNITID() == null : this.getUNITID().equals(other.getUNITID()))
            && (this.getCATEGORYID() == null ? other.getCATEGORYID() == null : this.getCATEGORYID().equals(other.getCATEGORYID()))
            && (this.getNAME() == null ? other.getNAME() == null : this.getNAME().equals(other.getNAME()))
            && (this.getCODE() == null ? other.getCODE() == null : this.getCODE().equals(other.getCODE()))
            && (this.getISBASEUNIT() == null ? other.getISBASEUNIT() == null : this.getISBASEUNIT().equals(other.getISBASEUNIT()))
            && (this.getRELATION() == null ? other.getRELATION() == null : this.getRELATION().equals(other.getRELATION()))
            && (this.getCONVERTNUM() == null ? other.getCONVERTNUM() == null : this.getCONVERTNUM().equals(other.getCONVERTNUM()))
            && (this.getISENABLE() == null ? other.getISENABLE() == null : this.getISENABLE().equals(other.getISENABLE()))
            && (this.getDELETEFLAG() == null ? other.getDELETEFLAG() == null : this.getDELETEFLAG().equals(other.getDELETEFLAG()))
            && (this.getREGID() == null ? other.getREGID() == null : this.getREGID().equals(other.getREGID()))
            && (this.getCREATEUSER() == null ? other.getCREATEUSER() == null : this.getCREATEUSER().equals(other.getCREATEUSER()))
            && (this.getCREATETIME() == null ? other.getCREATETIME() == null : this.getCREATETIME().equals(other.getCREATETIME()))
            && (this.getUPDATEUSER() == null ? other.getUPDATEUSER() == null : this.getUPDATEUSER().equals(other.getUPDATEUSER()))
            && (this.getUPDATETIME() == null ? other.getUPDATETIME() == null : this.getUPDATETIME().equals(other.getUPDATETIME()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUNITID() == null) ? 0 : getUNITID().hashCode());
        result = prime * result + ((getCATEGORYID() == null) ? 0 : getCATEGORYID().hashCode());
        result = prime * result + ((getNAME() == null) ? 0 : getNAME().hashCode());
        result = prime * result + ((getCODE() == null) ? 0 : getCODE().hashCode());
        result = prime * result + ((getISBASEUNIT() == null) ? 0 : getISBASEUNIT().hashCode());
        result = prime * result + ((getRELATION() == null) ? 0 : getRELATION().hashCode());
        result = prime * result + ((getCONVERTNUM() == null) ? 0 : getCONVERTNUM().hashCode());
        result = prime * result + ((getISENABLE() == null) ? 0 : getISENABLE().hashCode());
        result = prime * result + ((getDELETEFLAG() == null) ? 0 : getDELETEFLAG().hashCode());
        result = prime * result + ((getREGID() == null) ? 0 : getREGID().hashCode());
        result = prime * result + ((getCREATEUSER() == null) ? 0 : getCREATEUSER().hashCode());
        result = prime * result + ((getCREATETIME() == null) ? 0 : getCREATETIME().hashCode());
        result = prime * result + ((getUPDATEUSER() == null) ? 0 : getUPDATEUSER().hashCode());
        result = prime * result + ((getUPDATETIME() == null) ? 0 : getUPDATETIME().hashCode());
        return result;
    }
}
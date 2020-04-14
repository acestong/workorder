package com.fea.project.api.other.model.base;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2020/03/06.
 * 通用资源表 实体类
 */
public class SysUriModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 菜单地址自增标识
     */
    private Long URIID;

    /**
     * 地址名称
     */
    private String URINAME;

    /**
     * CODE
     */
    private String URICODE;

    /**
     * URI地址
     */
    private String URIADDRESS;

    /**
     * URI类型(内部、外部)
     */
    private Integer TYPE;

    /**
     * URI描述
     */
    private String DESCRIPTION;

    /**
     * 
     */
    private Long REGID;

    /**
     * 
     */
    private Long ORGID;

    /**
     * 
     */
    private String CREATEUSER;

    /**
     * 
     */
    private Date CREATETIME;

    /**
     * 
     */
    private String UPDATEUSER;

    /**
     * 
     */
    private Date UPDATETIME;

    public SysUriModel (Long URIID, String URINAME, String URICODE, String URIADDRESS, Integer TYPE, String DESCRIPTION, Long REGID, Long ORGID, String CREATEUSER, Date CREATETIME, String UPDATEUSER, Date UPDATETIME) {
        this.URIID = URIID;
        this.URINAME = URINAME;
        this.URICODE = URICODE;
        this.URIADDRESS = URIADDRESS;
        this.TYPE = TYPE;
        this.DESCRIPTION = DESCRIPTION;
        this.REGID = REGID;
        this.ORGID = ORGID;
        this.CREATEUSER = CREATEUSER;
        this.CREATETIME = CREATETIME;
        this.UPDATEUSER = UPDATEUSER;
        this.UPDATETIME = UPDATETIME;
    }

    public SysUriModel () {
        
    }

    public Long getURIID() {
        return URIID;
    }

    public void setURIID(Long URIID) {
        this.URIID = URIID;
    }

    public String getURINAME() {
        return URINAME;
    }

    public void setURINAME(String URINAME) {
        this.URINAME = URINAME == null ? null : URINAME.trim();
    }

    public String getURICODE() {
        return URICODE;
    }

    public void setURICODE(String URICODE) {
        this.URICODE = URICODE == null ? null : URICODE.trim();
    }

    public String getURIADDRESS() {
        return URIADDRESS;
    }

    public void setURIADDRESS(String URIADDRESS) {
        this.URIADDRESS = URIADDRESS == null ? null : URIADDRESS.trim();
    }

    public Integer getTYPE() {
        return TYPE;
    }

    public void setTYPE(Integer TYPE) {
        this.TYPE = TYPE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION == null ? null : DESCRIPTION.trim();
    }

    public Long getREGID() {
        return REGID;
    }

    public void setREGID(Long REGID) {
        this.REGID = REGID;
    }

    public Long getORGID() {
        return ORGID;
    }

    public void setORGID(Long ORGID) {
        this.ORGID = ORGID;
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
        sb.append(", URIID=").append(URIID);
        sb.append(", URINAME=").append(URINAME);
        sb.append(", URICODE=").append(URICODE);
        sb.append(", URIADDRESS=").append(URIADDRESS);
        sb.append(", TYPE=").append(TYPE);
        sb.append(", DESCRIPTION=").append(DESCRIPTION);
        sb.append(", REGID=").append(REGID);
        sb.append(", ORGID=").append(ORGID);
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
        SysUriModel other = (SysUriModel) that;
        return (this.getURIID() == null ? other.getURIID() == null : this.getURIID().equals(other.getURIID()))
            && (this.getURINAME() == null ? other.getURINAME() == null : this.getURINAME().equals(other.getURINAME()))
            && (this.getURICODE() == null ? other.getURICODE() == null : this.getURICODE().equals(other.getURICODE()))
            && (this.getURIADDRESS() == null ? other.getURIADDRESS() == null : this.getURIADDRESS().equals(other.getURIADDRESS()))
            && (this.getTYPE() == null ? other.getTYPE() == null : this.getTYPE().equals(other.getTYPE()))
            && (this.getDESCRIPTION() == null ? other.getDESCRIPTION() == null : this.getDESCRIPTION().equals(other.getDESCRIPTION()))
            && (this.getREGID() == null ? other.getREGID() == null : this.getREGID().equals(other.getREGID()))
            && (this.getORGID() == null ? other.getORGID() == null : this.getORGID().equals(other.getORGID()))
            && (this.getCREATEUSER() == null ? other.getCREATEUSER() == null : this.getCREATEUSER().equals(other.getCREATEUSER()))
            && (this.getCREATETIME() == null ? other.getCREATETIME() == null : this.getCREATETIME().equals(other.getCREATETIME()))
            && (this.getUPDATEUSER() == null ? other.getUPDATEUSER() == null : this.getUPDATEUSER().equals(other.getUPDATEUSER()))
            && (this.getUPDATETIME() == null ? other.getUPDATETIME() == null : this.getUPDATETIME().equals(other.getUPDATETIME()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getURIID() == null) ? 0 : getURIID().hashCode());
        result = prime * result + ((getURINAME() == null) ? 0 : getURINAME().hashCode());
        result = prime * result + ((getURICODE() == null) ? 0 : getURICODE().hashCode());
        result = prime * result + ((getURIADDRESS() == null) ? 0 : getURIADDRESS().hashCode());
        result = prime * result + ((getTYPE() == null) ? 0 : getTYPE().hashCode());
        result = prime * result + ((getDESCRIPTION() == null) ? 0 : getDESCRIPTION().hashCode());
        result = prime * result + ((getREGID() == null) ? 0 : getREGID().hashCode());
        result = prime * result + ((getORGID() == null) ? 0 : getORGID().hashCode());
        result = prime * result + ((getCREATEUSER() == null) ? 0 : getCREATEUSER().hashCode());
        result = prime * result + ((getCREATETIME() == null) ? 0 : getCREATETIME().hashCode());
        result = prime * result + ((getUPDATEUSER() == null) ? 0 : getUPDATEUSER().hashCode());
        result = prime * result + ((getUPDATETIME() == null) ? 0 : getUPDATETIME().hashCode());
        return result;
    }
}
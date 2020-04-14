package com.fea.project.api.other.model.crm;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/28.
 * 销售行业表 实体类
 */
public class CrmDictionaryIndustryModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 自增标识
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long ID;

    /**
     * 组织注册编号
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long REGID;

    /**
     * 父分类
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long PARENTID;

    /**
     * 编码
     */
    private String CODE;

    /**
     * 名称
     */
    private String NAME;

    /**
     * 描述
     */
    private String DESCRIPTION;

    /**
     * 状态
     */
    private Integer STATUS;

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

    /**
     * 树左边
     */
    private Integer LFT;

    /**
     * 树右边
     */
    private Integer RGT;

    /**
     * 排序
     */
    private Integer PRIORITY;

    /**
     *
     */
    private Byte DELSTATE;

    public CrmDictionaryIndustryModel(Long ID, Long REGID, Long PARENTID, String CODE, String NAME, String DESCRIPTION, Integer STATUS, String CREATEUSER, Date CREATETIME, String UPDATEUSER, Date UPDATETIME, Integer LFT, Integer RGT, Integer PRIORITY, Byte DELSTATE) {
        this.ID = ID;
        this.REGID = REGID;
        this.PARENTID = PARENTID;
        this.CODE = CODE;
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.STATUS = STATUS;
        this.CREATEUSER = CREATEUSER;
        this.CREATETIME = CREATETIME;
        this.UPDATEUSER = UPDATEUSER;
        this.UPDATETIME = UPDATETIME;
        this.LFT = LFT;
        this.RGT = RGT;
        this.PRIORITY = PRIORITY;
        this.DELSTATE = DELSTATE;
    }

    public CrmDictionaryIndustryModel() {

    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getREGID() {
        return REGID;
    }

    public void setREGID(Long REGID) {
        this.REGID = REGID;
    }

    public Long getPARENTID() {
        return PARENTID;
    }

    public void setPARENTID(Long PARENTID) {
        this.PARENTID = PARENTID;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE == null ? null : CODE.trim();
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME == null ? null : NAME.trim();
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION == null ? null : DESCRIPTION.trim();
    }

    public Integer getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Integer STATUS) {
        this.STATUS = STATUS;
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

    public Integer getLFT() {
        return LFT;
    }

    public void setLFT(Integer LFT) {
        this.LFT = LFT;
    }

    public Integer getRGT() {
        return RGT;
    }

    public void setRGT(Integer RGT) {
        this.RGT = RGT;
    }

    public Integer getPRIORITY() {
        return PRIORITY;
    }

    public void setPRIORITY(Integer PRIORITY) {
        this.PRIORITY = PRIORITY;
    }

    public Byte getDELSTATE() {
        return DELSTATE;
    }

    public void setDELSTATE(Byte DELSTATE) {
        this.DELSTATE = DELSTATE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID=").append(ID);
        sb.append(", REGID=").append(REGID);
        sb.append(", PARENTID=").append(PARENTID);
        sb.append(", CODE=").append(CODE);
        sb.append(", NAME=").append(NAME);
        sb.append(", DESCRIPTION=").append(DESCRIPTION);
        sb.append(", STATUS=").append(STATUS);
        sb.append(", CREATEUSER=").append(CREATEUSER);
        sb.append(", CREATETIME=").append(CREATETIME);
        sb.append(", UPDATEUSER=").append(UPDATEUSER);
        sb.append(", UPDATETIME=").append(UPDATETIME);
        sb.append(", LFT=").append(LFT);
        sb.append(", RGT=").append(RGT);
        sb.append(", PRIORITY=").append(PRIORITY);
        sb.append(", DELSTATE=").append(DELSTATE);
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
        CrmDictionaryIndustryModel other = (CrmDictionaryIndustryModel) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
                && (this.getREGID() == null ? other.getREGID() == null : this.getREGID().equals(other.getREGID()))
                && (this.getPARENTID() == null ? other.getPARENTID() == null : this.getPARENTID().equals(other.getPARENTID()))
                && (this.getCODE() == null ? other.getCODE() == null : this.getCODE().equals(other.getCODE()))
                && (this.getNAME() == null ? other.getNAME() == null : this.getNAME().equals(other.getNAME()))
                && (this.getDESCRIPTION() == null ? other.getDESCRIPTION() == null : this.getDESCRIPTION().equals(other.getDESCRIPTION()))
                && (this.getSTATUS() == null ? other.getSTATUS() == null : this.getSTATUS().equals(other.getSTATUS()))
                && (this.getCREATEUSER() == null ? other.getCREATEUSER() == null : this.getCREATEUSER().equals(other.getCREATEUSER()))
                && (this.getCREATETIME() == null ? other.getCREATETIME() == null : this.getCREATETIME().equals(other.getCREATETIME()))
                && (this.getUPDATEUSER() == null ? other.getUPDATEUSER() == null : this.getUPDATEUSER().equals(other.getUPDATEUSER()))
                && (this.getUPDATETIME() == null ? other.getUPDATETIME() == null : this.getUPDATETIME().equals(other.getUPDATETIME()))
                && (this.getLFT() == null ? other.getLFT() == null : this.getLFT().equals(other.getLFT()))
                && (this.getRGT() == null ? other.getRGT() == null : this.getRGT().equals(other.getRGT()))
                && (this.getPRIORITY() == null ? other.getPRIORITY() == null : this.getPRIORITY().equals(other.getPRIORITY()))
                && (this.getDELSTATE() == null ? other.getDELSTATE() == null : this.getDELSTATE().equals(other.getDELSTATE()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getREGID() == null) ? 0 : getREGID().hashCode());
        result = prime * result + ((getPARENTID() == null) ? 0 : getPARENTID().hashCode());
        result = prime * result + ((getCODE() == null) ? 0 : getCODE().hashCode());
        result = prime * result + ((getNAME() == null) ? 0 : getNAME().hashCode());
        result = prime * result + ((getDESCRIPTION() == null) ? 0 : getDESCRIPTION().hashCode());
        result = prime * result + ((getSTATUS() == null) ? 0 : getSTATUS().hashCode());
        result = prime * result + ((getCREATEUSER() == null) ? 0 : getCREATEUSER().hashCode());
        result = prime * result + ((getCREATETIME() == null) ? 0 : getCREATETIME().hashCode());
        result = prime * result + ((getUPDATEUSER() == null) ? 0 : getUPDATEUSER().hashCode());
        result = prime * result + ((getUPDATETIME() == null) ? 0 : getUPDATETIME().hashCode());
        result = prime * result + ((getLFT() == null) ? 0 : getLFT().hashCode());
        result = prime * result + ((getRGT() == null) ? 0 : getRGT().hashCode());
        result = prime * result + ((getPRIORITY() == null) ? 0 : getPRIORITY().hashCode());
        result = prime * result + ((getDELSTATE() == null) ? 0 : getDELSTATE().hashCode());
        return result;
    }
}
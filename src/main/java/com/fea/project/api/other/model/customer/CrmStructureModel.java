package com.fea.project.api.other.model.customer;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/24.
 * 客户组织结构表 实体类
 */
public class CrmStructureModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 自增标识
     */
    private Long ID;

    /**
     * 父分组标识
     */
    private Long PARENTID;

    /**
     * 分组编码
     */
    private String GROUPCODE;

    /**
     * 分组名称
     */
    private String GROUPNAME;

    /**
     * 分组描述
     */
    private String DESCRIPTION;

    /**
     *
     */
    private Long ORGID;

    /**
     * 组织注册id
     */
    private Long REGID;

    /**
     * 组织编号
     */
    private String ORGCODE;

    /**
     * 创建人
     */
    private String CREATEUSER;

    /**
     * 创建时间
     */
    private Date CREATETIME;

    /**
     * 更新人
     */
    private String UPDATEUSER;

    /**
     * 更新时间
     */
    private Date UPDATETIME;

    /**
     * 状态
     */
    private Integer STATE;

    /**
     * 左节点
     */
    private Integer LFT;

    /**
     * 右节点
     */
    private Integer RGT;

    /**
     * 排序
     */
    private Integer PRIORITY;

    /**
     * 部门人数
     */
    private Integer TOTAL;

    /**
     * 客户ID
     */
    private Long CUSTOMERID;

    public CrmStructureModel(Long ID, Long PARENTID, String GROUPCODE, String GROUPNAME, String DESCRIPTION, Long ORGID, Long REGID, String ORGCODE, String CREATEUSER, Date CREATETIME, String UPDATEUSER, Date UPDATETIME, Integer STATE, Integer LFT, Integer RGT, Integer PRIORITY, Integer TOTAL, Long CUSTOMERID) {
        this.ID = ID;
        this.PARENTID = PARENTID;
        this.GROUPCODE = GROUPCODE;
        this.GROUPNAME = GROUPNAME;
        this.DESCRIPTION = DESCRIPTION;
        this.ORGID = ORGID;
        this.REGID = REGID;
        this.ORGCODE = ORGCODE;
        this.CREATEUSER = CREATEUSER;
        this.CREATETIME = CREATETIME;
        this.UPDATEUSER = UPDATEUSER;
        this.UPDATETIME = UPDATETIME;
        this.STATE = STATE;
        this.LFT = LFT;
        this.RGT = RGT;
        this.PRIORITY = PRIORITY;
        this.TOTAL = TOTAL;
        this.CUSTOMERID = CUSTOMERID;
    }

    public CrmStructureModel() {

    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getPARENTID() {
        return PARENTID;
    }

    public void setPARENTID(Long PARENTID) {
        this.PARENTID = PARENTID;
    }

    public String getGROUPCODE() {
        return GROUPCODE;
    }

    public void setGROUPCODE(String GROUPCODE) {
        this.GROUPCODE = GROUPCODE == null ? null : GROUPCODE.trim();
    }

    public String getGROUPNAME() {
        return GROUPNAME;
    }

    public void setGROUPNAME(String GROUPNAME) {
        this.GROUPNAME = GROUPNAME == null ? null : GROUPNAME.trim();
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION == null ? null : DESCRIPTION.trim();
    }

    public Long getORGID() {
        return ORGID;
    }

    public void setORGID(Long ORGID) {
        this.ORGID = ORGID;
    }

    public Long getREGID() {
        return REGID;
    }

    public void setREGID(Long REGID) {
        this.REGID = REGID;
    }

    public String getORGCODE() {
        return ORGCODE;
    }

    public void setORGCODE(String ORGCODE) {
        this.ORGCODE = ORGCODE == null ? null : ORGCODE.trim();
    }

    public String getCREATEUSER() {
        return CREATEUSER;
    }

    public void setCreateBy(String CREATEUSER) {
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

    public void setUpdateBy(String UPDATEUSER) {
        this.UPDATEUSER = UPDATEUSER == null ? null : UPDATEUSER.trim();
    }

    public Date getUPDATETIME() {
        return UPDATETIME;
    }

    public void setUPDATETIME(Date UPDATETIME) {
        this.UPDATETIME = UPDATETIME;
    }

    public Integer getSTATE() {
        return STATE;
    }

    public void setSTATE(Integer STATE) {
        this.STATE = STATE;
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

    public Integer getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(Integer TOTAL) {
        this.TOTAL = TOTAL;
    }

    public Long getCUSTOMERID() {
        return CUSTOMERID;
    }

    public void setCUSTOMERID(Long CUSTOMERID) {
        this.CUSTOMERID = CUSTOMERID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID=").append(ID);
        sb.append(", PARENTID=").append(PARENTID);
        sb.append(", GROUPCODE=").append(GROUPCODE);
        sb.append(", GROUPNAME=").append(GROUPNAME);
        sb.append(", DESCRIPTION=").append(DESCRIPTION);
        sb.append(", ORGID=").append(ORGID);
        sb.append(", REGID=").append(REGID);
        sb.append(", ORGCODE=").append(ORGCODE);
        sb.append(", CREATEUSER=").append(CREATEUSER);
        sb.append(", CREATETIME=").append(CREATETIME);
        sb.append(", UPDATEUSER=").append(UPDATEUSER);
        sb.append(", UPDATETIME=").append(UPDATETIME);
        sb.append(", STATE=").append(STATE);
        sb.append(", LFT=").append(LFT);
        sb.append(", RGT=").append(RGT);
        sb.append(", PRIORITY=").append(PRIORITY);
        sb.append(", TOTAL=").append(TOTAL);
        sb.append(", CUSTOMERID=").append(CUSTOMERID);
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
        CrmStructureModel other = (CrmStructureModel) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
                && (this.getPARENTID() == null ? other.getPARENTID() == null : this.getPARENTID().equals(other.getPARENTID()))
                && (this.getGROUPCODE() == null ? other.getGROUPCODE() == null : this.getGROUPCODE().equals(other.getGROUPCODE()))
                && (this.getGROUPNAME() == null ? other.getGROUPNAME() == null : this.getGROUPNAME().equals(other.getGROUPNAME()))
                && (this.getDESCRIPTION() == null ? other.getDESCRIPTION() == null : this.getDESCRIPTION().equals(other.getDESCRIPTION()))
                && (this.getORGID() == null ? other.getORGID() == null : this.getORGID().equals(other.getORGID()))
                && (this.getREGID() == null ? other.getREGID() == null : this.getREGID().equals(other.getREGID()))
                && (this.getORGCODE() == null ? other.getORGCODE() == null : this.getORGCODE().equals(other.getORGCODE()))
                && (this.getCREATEUSER() == null ? other.getCREATEUSER() == null : this.getCREATEUSER().equals(other.getCREATEUSER()))
                && (this.getCREATETIME() == null ? other.getCREATETIME() == null : this.getCREATETIME().equals(other.getCREATETIME()))
                && (this.getUPDATEUSER() == null ? other.getUPDATEUSER() == null : this.getUPDATEUSER().equals(other.getUPDATEUSER()))
                && (this.getUPDATETIME() == null ? other.getUPDATETIME() == null : this.getUPDATETIME().equals(other.getUPDATETIME()))
                && (this.getSTATE() == null ? other.getSTATE() == null : this.getSTATE().equals(other.getSTATE()))
                && (this.getLFT() == null ? other.getLFT() == null : this.getLFT().equals(other.getLFT()))
                && (this.getRGT() == null ? other.getRGT() == null : this.getRGT().equals(other.getRGT()))
                && (this.getPRIORITY() == null ? other.getPRIORITY() == null : this.getPRIORITY().equals(other.getPRIORITY()))
                && (this.getTOTAL() == null ? other.getTOTAL() == null : this.getTOTAL().equals(other.getTOTAL()))
                && (this.getCUSTOMERID() == null ? other.getCUSTOMERID() == null : this.getCUSTOMERID().equals(other.getCUSTOMERID()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getPARENTID() == null) ? 0 : getPARENTID().hashCode());
        result = prime * result + ((getGROUPCODE() == null) ? 0 : getGROUPCODE().hashCode());
        result = prime * result + ((getGROUPNAME() == null) ? 0 : getGROUPNAME().hashCode());
        result = prime * result + ((getDESCRIPTION() == null) ? 0 : getDESCRIPTION().hashCode());
        result = prime * result + ((getORGID() == null) ? 0 : getORGID().hashCode());
        result = prime * result + ((getREGID() == null) ? 0 : getREGID().hashCode());
        result = prime * result + ((getORGCODE() == null) ? 0 : getORGCODE().hashCode());
        result = prime * result + ((getCREATEUSER() == null) ? 0 : getCREATEUSER().hashCode());
        result = prime * result + ((getCREATETIME() == null) ? 0 : getCREATETIME().hashCode());
        result = prime * result + ((getUPDATEUSER() == null) ? 0 : getUPDATEUSER().hashCode());
        result = prime * result + ((getUPDATETIME() == null) ? 0 : getUPDATETIME().hashCode());
        result = prime * result + ((getSTATE() == null) ? 0 : getSTATE().hashCode());
        result = prime * result + ((getLFT() == null) ? 0 : getLFT().hashCode());
        result = prime * result + ((getRGT() == null) ? 0 : getRGT().hashCode());
        result = prime * result + ((getPRIORITY() == null) ? 0 : getPRIORITY().hashCode());
        result = prime * result + ((getTOTAL() == null) ? 0 : getTOTAL().hashCode());
        result = prime * result + ((getCUSTOMERID() == null) ? 0 : getCUSTOMERID().hashCode());
        return result;
    }
}
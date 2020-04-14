package com.fea.project.api.other.model.product;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/28.
 * 产品分类表 实体类
 */
public class ProductStructureModel implements Serializable {
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
     * 组织注册id
     */
    private Long REGID;

    /**
     * 分类类型
     */
    private String MODELCODE;

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
     * 是否还有子分组1：没有0：有
     */
    private Integer ISLEAF;

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

    public ProductStructureModel(Long ID, Long PARENTID, String GROUPCODE, String GROUPNAME, String DESCRIPTION, Long REGID, String MODELCODE, String CREATEUSER, Date CREATETIME, String UPDATEUSER, Date UPDATETIME, Integer STATE, Integer ISLEAF, Integer LFT, Integer RGT, Integer PRIORITY) {
        this.ID = ID;
        this.PARENTID = PARENTID;
        this.GROUPCODE = GROUPCODE;
        this.GROUPNAME = GROUPNAME;
        this.DESCRIPTION = DESCRIPTION;
        this.REGID = REGID;
        this.MODELCODE = MODELCODE;
        this.CREATEUSER = CREATEUSER;
        this.CREATETIME = CREATETIME;
        this.UPDATEUSER = UPDATEUSER;
        this.UPDATETIME = UPDATETIME;
        this.STATE = STATE;
        this.ISLEAF = ISLEAF;
        this.LFT = LFT;
        this.RGT = RGT;
        this.PRIORITY = PRIORITY;
    }

    public ProductStructureModel() {

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

    public Long getREGID() {
        return REGID;
    }

    public void setREGID(Long REGID) {
        this.REGID = REGID;
    }

    public String getMODELCODE() {
        return MODELCODE;
    }

    public void setMODELCODE(String MODELCODE) {
        this.MODELCODE = MODELCODE == null ? null : MODELCODE.trim();
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

    public Integer getSTATE() {
        return STATE;
    }

    public void setSTATE(Integer STATE) {
        this.STATE = STATE;
    }

    public Integer getISLEAF() {
        return ISLEAF;
    }

    public void setISLEAF(Integer ISLEAF) {
        this.ISLEAF = ISLEAF;
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
        sb.append(", REGID=").append(REGID);
        sb.append(", MODELCODE=").append(MODELCODE);
        sb.append(", CREATEUSER=").append(CREATEUSER);
        sb.append(", CREATETIME=").append(CREATETIME);
        sb.append(", UPDATEUSER=").append(UPDATEUSER);
        sb.append(", UPDATETIME=").append(UPDATETIME);
        sb.append(", STATE=").append(STATE);
        sb.append(", ISLEAF=").append(ISLEAF);
        sb.append(", LFT=").append(LFT);
        sb.append(", RGT=").append(RGT);
        sb.append(", PRIORITY=").append(PRIORITY);
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
        ProductStructureModel other = (ProductStructureModel) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
                && (this.getPARENTID() == null ? other.getPARENTID() == null : this.getPARENTID().equals(other.getPARENTID()))
                && (this.getGROUPCODE() == null ? other.getGROUPCODE() == null : this.getGROUPCODE().equals(other.getGROUPCODE()))
                && (this.getGROUPNAME() == null ? other.getGROUPNAME() == null : this.getGROUPNAME().equals(other.getGROUPNAME()))
                && (this.getDESCRIPTION() == null ? other.getDESCRIPTION() == null : this.getDESCRIPTION().equals(other.getDESCRIPTION()))
                && (this.getREGID() == null ? other.getREGID() == null : this.getREGID().equals(other.getREGID()))
                && (this.getMODELCODE() == null ? other.getMODELCODE() == null : this.getMODELCODE().equals(other.getMODELCODE()))
                && (this.getCREATEUSER() == null ? other.getCREATEUSER() == null : this.getCREATEUSER().equals(other.getCREATEUSER()))
                && (this.getCREATETIME() == null ? other.getCREATETIME() == null : this.getCREATETIME().equals(other.getCREATETIME()))
                && (this.getUPDATEUSER() == null ? other.getUPDATEUSER() == null : this.getUPDATEUSER().equals(other.getUPDATEUSER()))
                && (this.getUPDATETIME() == null ? other.getUPDATETIME() == null : this.getUPDATETIME().equals(other.getUPDATETIME()))
                && (this.getSTATE() == null ? other.getSTATE() == null : this.getSTATE().equals(other.getSTATE()))
                && (this.getISLEAF() == null ? other.getISLEAF() == null : this.getISLEAF().equals(other.getISLEAF()))
                && (this.getLFT() == null ? other.getLFT() == null : this.getLFT().equals(other.getLFT()))
                && (this.getRGT() == null ? other.getRGT() == null : this.getRGT().equals(other.getRGT()))
                && (this.getPRIORITY() == null ? other.getPRIORITY() == null : this.getPRIORITY().equals(other.getPRIORITY()));
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
        result = prime * result + ((getREGID() == null) ? 0 : getREGID().hashCode());
        result = prime * result + ((getMODELCODE() == null) ? 0 : getMODELCODE().hashCode());
        result = prime * result + ((getCREATEUSER() == null) ? 0 : getCREATEUSER().hashCode());
        result = prime * result + ((getCREATETIME() == null) ? 0 : getCREATETIME().hashCode());
        result = prime * result + ((getUPDATEUSER() == null) ? 0 : getUPDATEUSER().hashCode());
        result = prime * result + ((getUPDATETIME() == null) ? 0 : getUPDATETIME().hashCode());
        result = prime * result + ((getSTATE() == null) ? 0 : getSTATE().hashCode());
        result = prime * result + ((getISLEAF() == null) ? 0 : getISLEAF().hashCode());
        result = prime * result + ((getLFT() == null) ? 0 : getLFT().hashCode());
        result = prime * result + ((getRGT() == null) ? 0 : getRGT().hashCode());
        result = prime * result + ((getPRIORITY() == null) ? 0 : getPRIORITY().hashCode());
        return result;
    }
}
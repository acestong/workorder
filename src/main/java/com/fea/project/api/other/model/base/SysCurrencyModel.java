package com.fea.project.api.other.model.base;

import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2020/03/05.
 */
@Builder
public class SysCurrencyModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private Long ID;

    /**
     * 币种名称
     */
    private String NAME;

    /**
     * 币种缩写
     */
    private String SHORTNAME;

    /**
     * 符号
     */
    private String SYMBOL;

    /**
     * 
     */
    private String STANDARD;

    /**
     * 是否自动汇率
     */
    private Boolean ISAUTO;

    /**
     * 手动设置固定汇率
     */
    private Double SETRATE;

    /**
     * 当前汇率
     */
    private Double NOWRATE;

    /**
     * 自动汇率的更新时间
     */
    private Date UPDATETIMERATE;

    /**
     * 是否激活
     */
    private Boolean ISACTIVE;

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
     * 是否本位币
     */
    private Byte STANDARDMONEY;

    /**
     * 是否删除，0否，1是
     */
    private Byte DELSTATE;

    /**
     * 组织注册编号
     */
    private Long REGID;

    /**
     * 
     */
    private Long ORGID;

    /**
     * 汇率有效数字位数
     */
    private Integer RATEDIGIT;

    public SysCurrencyModel (Long ID, String NAME, String SHORTNAME, String SYMBOL, String STANDARD, Boolean ISAUTO, Double SETRATE, Double NOWRATE, Date UPDATETIMERATE, Boolean ISACTIVE, String CREATEUSER, Date CREATETIME, String UPDATEUSER, Date UPDATETIME, Byte STANDARDMONEY, Byte DELSTATE, Long REGID, Long ORGID, Integer RATEDIGIT) {
        this.ID = ID;
        this.NAME = NAME;
        this.SHORTNAME = SHORTNAME;
        this.SYMBOL = SYMBOL;
        this.STANDARD = STANDARD;
        this.ISAUTO = ISAUTO;
        this.SETRATE = SETRATE;
        this.NOWRATE = NOWRATE;
        this.UPDATETIMERATE = UPDATETIMERATE;
        this.ISACTIVE = ISACTIVE;
        this.CREATEUSER = CREATEUSER;
        this.CREATETIME = CREATETIME;
        this.UPDATEUSER = UPDATEUSER;
        this.UPDATETIME = UPDATETIME;
        this.STANDARDMONEY = STANDARDMONEY;
        this.DELSTATE = DELSTATE;
        this.REGID = REGID;
        this.ORGID = ORGID;
        this.RATEDIGIT = RATEDIGIT;
    }

    public SysCurrencyModel () {
        
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME == null ? null : NAME.trim();
    }

    public String getSHORTNAME() {
        return SHORTNAME;
    }

    public void setSHORTNAME(String SHORTNAME) {
        this.SHORTNAME = SHORTNAME == null ? null : SHORTNAME.trim();
    }

    public String getSYMBOL() {
        return SYMBOL;
    }

    public void setSYMBOL(String SYMBOL) {
        this.SYMBOL = SYMBOL == null ? null : SYMBOL.trim();
    }

    public String getSTANDARD() {
        return STANDARD;
    }

    public void setSTANDARD(String STANDARD) {
        this.STANDARD = STANDARD == null ? null : STANDARD.trim();
    }

    public Boolean getISAUTO() {
        return ISAUTO;
    }

    public void setISAUTO(Boolean ISAUTO) {
        this.ISAUTO = ISAUTO;
    }

    public Double getSETRATE() {
        return SETRATE;
    }

    public void setSETRATE(Double SETRATE) {
        this.SETRATE = SETRATE;
    }

    public Double getNOWRATE() {
        return NOWRATE;
    }

    public void setNOWRATE(Double NOWRATE) {
        this.NOWRATE = NOWRATE;
    }

    public Date getUPDATETIMERATE() {
        return UPDATETIMERATE;
    }

    public void setUPDATETIMERATE(Date UPDATETIMERATE) {
        this.UPDATETIMERATE = UPDATETIMERATE;
    }

    public Boolean getISACTIVE() {
        return ISACTIVE;
    }

    public void setISACTIVE(Boolean ISACTIVE) {
        this.ISACTIVE = ISACTIVE;
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

    public Byte getSTANDARDMONEY() {
        return STANDARDMONEY;
    }

    public void setSTANDARDMONEY(Byte STANDARDMONEY) {
        this.STANDARDMONEY = STANDARDMONEY;
    }

    public Byte getDELSTATE() {
        return DELSTATE;
    }

    public void setDELSTATE(Byte DELSTATE) {
        this.DELSTATE = DELSTATE;
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

    public Integer getRATEDIGIT() {
        return RATEDIGIT;
    }

    public void setRATEDIGIT(Integer RATEDIGIT) {
        this.RATEDIGIT = RATEDIGIT;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID=").append(ID);
        sb.append(", NAME=").append(NAME);
        sb.append(", SHORTNAME=").append(SHORTNAME);
        sb.append(", SYMBOL=").append(SYMBOL);
        sb.append(", STANDARD=").append(STANDARD);
        sb.append(", ISAUTO=").append(ISAUTO);
        sb.append(", SETRATE=").append(SETRATE);
        sb.append(", NOWRATE=").append(NOWRATE);
        sb.append(", UPDATETIMERATE=").append(UPDATETIMERATE);
        sb.append(", ISACTIVE=").append(ISACTIVE);
        sb.append(", CREATEUSER=").append(CREATEUSER);
        sb.append(", CREATETIME=").append(CREATETIME);
        sb.append(", UPDATEUSER=").append(UPDATEUSER);
        sb.append(", UPDATETIME=").append(UPDATETIME);
        sb.append(", STANDARDMONEY=").append(STANDARDMONEY);
        sb.append(", DELSTATE=").append(DELSTATE);
        sb.append(", REGID=").append(REGID);
        sb.append(", ORGID=").append(ORGID);
        sb.append(", RATEDIGIT=").append(RATEDIGIT);
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
        SysCurrencyModel other = (SysCurrencyModel) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getNAME() == null ? other.getNAME() == null : this.getNAME().equals(other.getNAME()))
            && (this.getSHORTNAME() == null ? other.getSHORTNAME() == null : this.getSHORTNAME().equals(other.getSHORTNAME()))
            && (this.getSYMBOL() == null ? other.getSYMBOL() == null : this.getSYMBOL().equals(other.getSYMBOL()))
            && (this.getSTANDARD() == null ? other.getSTANDARD() == null : this.getSTANDARD().equals(other.getSTANDARD()))
            && (this.getISAUTO() == null ? other.getISAUTO() == null : this.getISAUTO().equals(other.getISAUTO()))
            && (this.getSETRATE() == null ? other.getSETRATE() == null : this.getSETRATE().equals(other.getSETRATE()))
            && (this.getNOWRATE() == null ? other.getNOWRATE() == null : this.getNOWRATE().equals(other.getNOWRATE()))
            && (this.getUPDATETIMERATE() == null ? other.getUPDATETIMERATE() == null : this.getUPDATETIMERATE().equals(other.getUPDATETIMERATE()))
            && (this.getISACTIVE() == null ? other.getISACTIVE() == null : this.getISACTIVE().equals(other.getISACTIVE()))
            && (this.getCREATEUSER() == null ? other.getCREATEUSER() == null : this.getCREATEUSER().equals(other.getCREATEUSER()))
            && (this.getCREATETIME() == null ? other.getCREATETIME() == null : this.getCREATETIME().equals(other.getCREATETIME()))
            && (this.getUPDATEUSER() == null ? other.getUPDATEUSER() == null : this.getUPDATEUSER().equals(other.getUPDATEUSER()))
            && (this.getUPDATETIME() == null ? other.getUPDATETIME() == null : this.getUPDATETIME().equals(other.getUPDATETIME()))
            && (this.getSTANDARDMONEY() == null ? other.getSTANDARDMONEY() == null : this.getSTANDARDMONEY().equals(other.getSTANDARDMONEY()))
            && (this.getDELSTATE() == null ? other.getDELSTATE() == null : this.getDELSTATE().equals(other.getDELSTATE()))
            && (this.getREGID() == null ? other.getREGID() == null : this.getREGID().equals(other.getREGID()))
            && (this.getORGID() == null ? other.getORGID() == null : this.getORGID().equals(other.getORGID()))
            && (this.getRATEDIGIT() == null ? other.getRATEDIGIT() == null : this.getRATEDIGIT().equals(other.getRATEDIGIT()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getNAME() == null) ? 0 : getNAME().hashCode());
        result = prime * result + ((getSHORTNAME() == null) ? 0 : getSHORTNAME().hashCode());
        result = prime * result + ((getSYMBOL() == null) ? 0 : getSYMBOL().hashCode());
        result = prime * result + ((getSTANDARD() == null) ? 0 : getSTANDARD().hashCode());
        result = prime * result + ((getISAUTO() == null) ? 0 : getISAUTO().hashCode());
        result = prime * result + ((getSETRATE() == null) ? 0 : getSETRATE().hashCode());
        result = prime * result + ((getNOWRATE() == null) ? 0 : getNOWRATE().hashCode());
        result = prime * result + ((getUPDATETIMERATE() == null) ? 0 : getUPDATETIMERATE().hashCode());
        result = prime * result + ((getISACTIVE() == null) ? 0 : getISACTIVE().hashCode());
        result = prime * result + ((getCREATEUSER() == null) ? 0 : getCREATEUSER().hashCode());
        result = prime * result + ((getCREATETIME() == null) ? 0 : getCREATETIME().hashCode());
        result = prime * result + ((getUPDATEUSER() == null) ? 0 : getUPDATEUSER().hashCode());
        result = prime * result + ((getUPDATETIME() == null) ? 0 : getUPDATETIME().hashCode());
        result = prime * result + ((getSTANDARDMONEY() == null) ? 0 : getSTANDARDMONEY().hashCode());
        result = prime * result + ((getDELSTATE() == null) ? 0 : getDELSTATE().hashCode());
        result = prime * result + ((getREGID() == null) ? 0 : getREGID().hashCode());
        result = prime * result + ((getORGID() == null) ? 0 : getORGID().hashCode());
        result = prime * result + ((getRATEDIGIT() == null) ? 0 : getRATEDIGIT().hashCode());
        return result;
    }
}
package com.fea.project.api.other.model.pdt;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/12/04.
 */
public class PdtLibraryModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long ID;

    /**
     * 产品名称
     */
    private String NAME;

    /**
     * 产品编码
     */
    private String CODE;

    /**
     * 产品分类ID
     */
    private Long STRID;

    /**
     * 产品分类名称
     */
    private String STRNAME;

    /**
     * 产品单位
     */
    private Long UNITID;

    /**
     * 产品主单位名称
     */
    private String UNITNAME;

    /**
     * 产品规格型号
     */
    private String MODEL;

    /**
     * 分组描述
     */
    private String DESCRIPTION;

    /**
     * 类型
     */
    private Long TYPE;

    /**
     * 状态
     */
    private Integer STATE;

    /**
     * 定制性
     */
    private Long MADE;

    /**
     * 生产方式：如OEM/ODM
     */
    private Integer MAKETYPE;

    /**
     * 产品所属产权：IP
     */
    private Integer MAKEPROPERTY;

    /**
     * 服务类型
     */
    private Long SERVICETYPE;

    /**
     * 服务方式
     */
    private Long SERVICEWAY;

    /**
     * 软件类型
     */
    private Long SOFTTYPE;

    /**
     * 功能类型
     */
    private Long FUNCTIONTYPE;

    /**
     *
     */
    private Long CREATEUSERID;

    /**
     * 创建人
     */
    private String CREATEUSER;

    /**
     * 创建时间
     */
    private Date CREATETIME;

    /**
     *
     */
    private Long UPDATEUSERID;

    /**
     *
     */
    private String UPDATEUSER;

    /**
     * 更新时间
     */
    private Date UPDATETIME;

    /**
     * 组织注册id
     */
    private Long REGID;

    /**
     * 产品分类类型
     */
    private String MODELCODE;

    /**
     * 父产品ID
     */
    private Long PARENTID;

    /**
     * 是否删除,1是，0否
     */
    private Byte DELSTATE;

    /**
     * 基本价格
     */
    private Double price;

    /**
     * 币种
     */
    private Long currency;

    /**
     *
     */
    private String fieldExt;

    public PdtLibraryModel(Long ID, String NAME, String CODE, Long STRID, String STRNAME, Long UNITID, String UNITNAME, String MODEL, String DESCRIPTION, Long TYPE, Integer STATE, Long MADE, Integer MAKETYPE, Integer MAKEPROPERTY, Long SERVICETYPE, Long SERVICEWAY, Long SOFTTYPE, Long FUNCTIONTYPE, Long CREATEUSERID, String CREATEUSER, Date CREATETIME, Long UPDATEUSERID, String UPDATEUSER, Date UPDATETIME, Long REGID, String MODELCODE, Long PARENTID, Byte DELSTATE, Double price, Long currency, String fieldExt) {
        this.ID = ID;
        this.NAME = NAME;
        this.CODE = CODE;
        this.STRID = STRID;
        this.STRNAME = STRNAME;
        this.UNITID = UNITID;
        this.UNITNAME = UNITNAME;
        this.MODEL = MODEL;
        this.DESCRIPTION = DESCRIPTION;
        this.TYPE = TYPE;
        this.STATE = STATE;
        this.MADE = MADE;
        this.MAKETYPE = MAKETYPE;
        this.MAKEPROPERTY = MAKEPROPERTY;
        this.SERVICETYPE = SERVICETYPE;
        this.SERVICEWAY = SERVICEWAY;
        this.SOFTTYPE = SOFTTYPE;
        this.FUNCTIONTYPE = FUNCTIONTYPE;
        this.CREATEUSERID = CREATEUSERID;
        this.CREATEUSER = CREATEUSER;
        this.CREATETIME = CREATETIME;
        this.UPDATEUSERID = UPDATEUSERID;
        this.UPDATEUSER = UPDATEUSER;
        this.UPDATETIME = UPDATETIME;
        this.REGID = REGID;
        this.MODELCODE = MODELCODE;
        this.PARENTID = PARENTID;
        this.DELSTATE = DELSTATE;
        this.price = price;
        this.currency = currency;
        this.fieldExt = fieldExt;
    }

    public PdtLibraryModel() {

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

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE == null ? null : CODE.trim();
    }

    public Long getSTRID() {
        return STRID;
    }

    public void setSTRID(Long STRID) {
        this.STRID = STRID;
    }

    public String getSTRNAME() {
        return STRNAME;
    }

    public void setSTRNAME(String STRNAME) {
        this.STRNAME = STRNAME == null ? null : STRNAME.trim();
    }

    public Long getUNITID() {
        return UNITID;
    }

    public void setUNITID(Long UNITID) {
        this.UNITID = UNITID;
    }

    public String getUNITNAME() {
        return UNITNAME;
    }

    public void setUNITNAME(String UNITNAME) {
        this.UNITNAME = UNITNAME == null ? null : UNITNAME.trim();
    }

    public String getMODEL() {
        return MODEL;
    }

    public void setMODEL(String MODEL) {
        this.MODEL = MODEL == null ? null : MODEL.trim();
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION == null ? null : DESCRIPTION.trim();
    }

    public Long getTYPE() {
        return TYPE;
    }

    public void setTYPE(Long TYPE) {
        this.TYPE = TYPE;
    }

    public Integer getSTATE() {
        return STATE;
    }

    public void setSTATE(Integer STATE) {
        this.STATE = STATE;
    }

    public Long getMADE() {
        return MADE;
    }

    public void setMADE(Long MADE) {
        this.MADE = MADE;
    }

    public Integer getMAKETYPE() {
        return MAKETYPE;
    }

    public void setMAKETYPE(Integer MAKETYPE) {
        this.MAKETYPE = MAKETYPE;
    }

    public Integer getMAKEPROPERTY() {
        return MAKEPROPERTY;
    }

    public void setMAKEPROPERTY(Integer MAKEPROPERTY) {
        this.MAKEPROPERTY = MAKEPROPERTY;
    }

    public Long getSERVICETYPE() {
        return SERVICETYPE;
    }

    public void setSERVICETYPE(Long SERVICETYPE) {
        this.SERVICETYPE = SERVICETYPE;
    }

    public Long getSERVICEWAY() {
        return SERVICEWAY;
    }

    public void setSERVICEWAY(Long SERVICEWAY) {
        this.SERVICEWAY = SERVICEWAY;
    }

    public Long getSOFTTYPE() {
        return SOFTTYPE;
    }

    public void setSOFTTYPE(Long SOFTTYPE) {
        this.SOFTTYPE = SOFTTYPE;
    }

    public Long getFUNCTIONTYPE() {
        return FUNCTIONTYPE;
    }

    public void setFUNCTIONTYPE(Long FUNCTIONTYPE) {
        this.FUNCTIONTYPE = FUNCTIONTYPE;
    }

    public Long getCREATEUSERID() {
        return CREATEUSERID;
    }

    public void setCREATEUSERID(Long CREATEUSERID) {
        this.CREATEUSERID = CREATEUSERID;
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

    public Long getUPDATEUSERID() {
        return UPDATEUSERID;
    }

    public void setUPDATEUSERID(Long UPDATEUSERID) {
        this.UPDATEUSERID = UPDATEUSERID;
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

    public Long getPARENTID() {
        return PARENTID;
    }

    public void setPARENTID(Long PARENTID) {
        this.PARENTID = PARENTID;
    }

    public Byte getDELSTATE() {
        return DELSTATE;
    }

    public void setDELSTATE(Byte DELSTATE) {
        this.DELSTATE = DELSTATE;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCurrency() {
        return currency;
    }

    public void setCurrency(Long currency) {
        this.currency = currency;
    }

    public String getFieldExt() {
        return fieldExt;
    }

    public void setFieldExt(String fieldExt) {
        this.fieldExt = fieldExt == null ? null : fieldExt.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID=").append(ID);
        sb.append(", NAME=").append(NAME);
        sb.append(", CODE=").append(CODE);
        sb.append(", STRID=").append(STRID);
        sb.append(", STRNAME=").append(STRNAME);
        sb.append(", UNITID=").append(UNITID);
        sb.append(", UNITNAME=").append(UNITNAME);
        sb.append(", MODEL=").append(MODEL);
        sb.append(", DESCRIPTION=").append(DESCRIPTION);
        sb.append(", TYPE=").append(TYPE);
        sb.append(", STATE=").append(STATE);
        sb.append(", MADE=").append(MADE);
        sb.append(", MAKETYPE=").append(MAKETYPE);
        sb.append(", MAKEPROPERTY=").append(MAKEPROPERTY);
        sb.append(", SERVICETYPE=").append(SERVICETYPE);
        sb.append(", SERVICEWAY=").append(SERVICEWAY);
        sb.append(", SOFTTYPE=").append(SOFTTYPE);
        sb.append(", FUNCTIONTYPE=").append(FUNCTIONTYPE);
        sb.append(", CREATEUSERID=").append(CREATEUSERID);
        sb.append(", CREATEUSER=").append(CREATEUSER);
        sb.append(", CREATETIME=").append(CREATETIME);
        sb.append(", UPDATEUSERID=").append(UPDATEUSERID);
        sb.append(", UPDATEUSER=").append(UPDATEUSER);
        sb.append(", UPDATETIME=").append(UPDATETIME);
        sb.append(", REGID=").append(REGID);
        sb.append(", MODELCODE=").append(MODELCODE);
        sb.append(", PARENTID=").append(PARENTID);
        sb.append(", DELSTATE=").append(DELSTATE);
        sb.append(", price=").append(price);
        sb.append(", currency=").append(currency);
        sb.append(", fieldExt=").append(fieldExt);
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
        PdtLibraryModel other = (PdtLibraryModel) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
                && (this.getNAME() == null ? other.getNAME() == null : this.getNAME().equals(other.getNAME()))
                && (this.getCODE() == null ? other.getCODE() == null : this.getCODE().equals(other.getCODE()))
                && (this.getSTRID() == null ? other.getSTRID() == null : this.getSTRID().equals(other.getSTRID()))
                && (this.getSTRNAME() == null ? other.getSTRNAME() == null : this.getSTRNAME().equals(other.getSTRNAME()))
                && (this.getUNITID() == null ? other.getUNITID() == null : this.getUNITID().equals(other.getUNITID()))
                && (this.getUNITNAME() == null ? other.getUNITNAME() == null : this.getUNITNAME().equals(other.getUNITNAME()))
                && (this.getMODEL() == null ? other.getMODEL() == null : this.getMODEL().equals(other.getMODEL()))
                && (this.getDESCRIPTION() == null ? other.getDESCRIPTION() == null : this.getDESCRIPTION().equals(other.getDESCRIPTION()))
                && (this.getTYPE() == null ? other.getTYPE() == null : this.getTYPE().equals(other.getTYPE()))
                && (this.getSTATE() == null ? other.getSTATE() == null : this.getSTATE().equals(other.getSTATE()))
                && (this.getMADE() == null ? other.getMADE() == null : this.getMADE().equals(other.getMADE()))
                && (this.getMAKETYPE() == null ? other.getMAKETYPE() == null : this.getMAKETYPE().equals(other.getMAKETYPE()))
                && (this.getMAKEPROPERTY() == null ? other.getMAKEPROPERTY() == null : this.getMAKEPROPERTY().equals(other.getMAKEPROPERTY()))
                && (this.getSERVICETYPE() == null ? other.getSERVICETYPE() == null : this.getSERVICETYPE().equals(other.getSERVICETYPE()))
                && (this.getSERVICEWAY() == null ? other.getSERVICEWAY() == null : this.getSERVICEWAY().equals(other.getSERVICEWAY()))
                && (this.getSOFTTYPE() == null ? other.getSOFTTYPE() == null : this.getSOFTTYPE().equals(other.getSOFTTYPE()))
                && (this.getFUNCTIONTYPE() == null ? other.getFUNCTIONTYPE() == null : this.getFUNCTIONTYPE().equals(other.getFUNCTIONTYPE()))
                && (this.getCREATEUSERID() == null ? other.getCREATEUSERID() == null : this.getCREATEUSERID().equals(other.getCREATEUSERID()))
                && (this.getCREATEUSER() == null ? other.getCREATEUSER() == null : this.getCREATEUSER().equals(other.getCREATEUSER()))
                && (this.getCREATETIME() == null ? other.getCREATETIME() == null : this.getCREATETIME().equals(other.getCREATETIME()))
                && (this.getUPDATEUSERID() == null ? other.getUPDATEUSERID() == null : this.getUPDATEUSERID().equals(other.getUPDATEUSERID()))
                && (this.getUPDATEUSER() == null ? other.getUPDATEUSER() == null : this.getUPDATEUSER().equals(other.getUPDATEUSER()))
                && (this.getUPDATETIME() == null ? other.getUPDATETIME() == null : this.getUPDATETIME().equals(other.getUPDATETIME()))
                && (this.getREGID() == null ? other.getREGID() == null : this.getREGID().equals(other.getREGID()))
                && (this.getMODELCODE() == null ? other.getMODELCODE() == null : this.getMODELCODE().equals(other.getMODELCODE()))
                && (this.getPARENTID() == null ? other.getPARENTID() == null : this.getPARENTID().equals(other.getPARENTID()))
                && (this.getDELSTATE() == null ? other.getDELSTATE() == null : this.getDELSTATE().equals(other.getDELSTATE()))
                && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
                && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
                && (this.getFieldExt() == null ? other.getFieldExt() == null : this.getFieldExt().equals(other.getFieldExt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getNAME() == null) ? 0 : getNAME().hashCode());
        result = prime * result + ((getCODE() == null) ? 0 : getCODE().hashCode());
        result = prime * result + ((getSTRID() == null) ? 0 : getSTRID().hashCode());
        result = prime * result + ((getSTRNAME() == null) ? 0 : getSTRNAME().hashCode());
        result = prime * result + ((getUNITID() == null) ? 0 : getUNITID().hashCode());
        result = prime * result + ((getUNITNAME() == null) ? 0 : getUNITNAME().hashCode());
        result = prime * result + ((getMODEL() == null) ? 0 : getMODEL().hashCode());
        result = prime * result + ((getDESCRIPTION() == null) ? 0 : getDESCRIPTION().hashCode());
        result = prime * result + ((getTYPE() == null) ? 0 : getTYPE().hashCode());
        result = prime * result + ((getSTATE() == null) ? 0 : getSTATE().hashCode());
        result = prime * result + ((getMADE() == null) ? 0 : getMADE().hashCode());
        result = prime * result + ((getMAKETYPE() == null) ? 0 : getMAKETYPE().hashCode());
        result = prime * result + ((getMAKEPROPERTY() == null) ? 0 : getMAKEPROPERTY().hashCode());
        result = prime * result + ((getSERVICETYPE() == null) ? 0 : getSERVICETYPE().hashCode());
        result = prime * result + ((getSERVICEWAY() == null) ? 0 : getSERVICEWAY().hashCode());
        result = prime * result + ((getSOFTTYPE() == null) ? 0 : getSOFTTYPE().hashCode());
        result = prime * result + ((getFUNCTIONTYPE() == null) ? 0 : getFUNCTIONTYPE().hashCode());
        result = prime * result + ((getCREATEUSERID() == null) ? 0 : getCREATEUSERID().hashCode());
        result = prime * result + ((getCREATEUSER() == null) ? 0 : getCREATEUSER().hashCode());
        result = prime * result + ((getCREATETIME() == null) ? 0 : getCREATETIME().hashCode());
        result = prime * result + ((getUPDATEUSERID() == null) ? 0 : getUPDATEUSERID().hashCode());
        result = prime * result + ((getUPDATEUSER() == null) ? 0 : getUPDATEUSER().hashCode());
        result = prime * result + ((getUPDATETIME() == null) ? 0 : getUPDATETIME().hashCode());
        result = prime * result + ((getREGID() == null) ? 0 : getREGID().hashCode());
        result = prime * result + ((getMODELCODE() == null) ? 0 : getMODELCODE().hashCode());
        result = prime * result + ((getPARENTID() == null) ? 0 : getPARENTID().hashCode());
        result = prime * result + ((getDELSTATE() == null) ? 0 : getDELSTATE().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getFieldExt() == null) ? 0 : getFieldExt().hashCode());
        return result;
    }
}
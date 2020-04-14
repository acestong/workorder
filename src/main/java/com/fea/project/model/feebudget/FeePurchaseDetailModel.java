package com.fea.project.model.feebudget;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/12/18.
 * 采购明细表 实体类
 */
public class FeePurchaseDetailModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long ID;

    /**
     * 记账单ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long TALLYID;

    /**
     * 上游单据ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long PARENTID;

    /**
     * 该详情所属模块：1，费用申请单。2，借款单。3，报销单
     */
    private Byte PARENTTYPE;

    /**
     * 预计发生时间
     */
    private Date HAPPENTIME;

    /**
     * 产品ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long PRODUCTID;

    /**
     * 产品名
     */
    private String PRODUCTNAME;

    /**
     * 产品主单位ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long BASEUNITID;

    /**
     * 产品主单位
     */
    private String BASEUNIT;

    /**
     * 规格
     */
    private String SPEC;

    /**
     * 采购对象类型
     */
    private Long PURCHASEOBJECTID;

    /**
     * 采购单位ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long PRODUCTUNITID;

    /**
     * 供应商ID
     */
    private Long SUPPLIERID;

    /**
     * 供应商
     */
    private String SUPPLIER;

    /**
     * 品牌
     */
    private String BRAND;

    /**
     * 税率
     */
    private Double TAXRATE;

    /**
     * 采购方式
     */
    private Byte PURCHASETYPE;

    /**
     * 单价
     */
    private Double PRICE;

    /**
     * 数量
     */
    private Double NUMBER;

    /**
     * 总价
     */
    private Double MONEY;

    /**
     * 预计到货时间
     */
    private Date ETA;

    /**
     * 费用说明
     */
    private String DESCRIPTION;

    /**
     * 费用归属
     */
    private String FEEBELONGID;

    /**
     * 
     */
    private Long CREATEUSERID;

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
    private Long UPDATEUSERID;

    /**
     * 
     */
    private String UPDATEUSER;

    /**
     * 
     */
    private Date UPDATETIME;

    /**
     * 
     */
    private Long REGID;

    /**
     * 
     */
    private Long ORGID;

    /**
     * 是否删除
     */
    private Byte DELSTATE;

    /**
     * 费用分类ID
     */
    private Long CATEID;

    /**
     * 费用分类名称
     */
    private String CATENAME;

    /**
     * 费用分类字符串
     */
    private String CATESTR;

    /**
     * 相关客户ID
     */
    private Long CUSTOMERID;

    /**
     * 相关客户
     */
    private String CUSTOMERNAME;

    /**
     * 客户联系人ID
     */
    private String CONTACTIDS;

    /**
     * 客户联系人
     */
    private String CONTACTS;

    /**
     * 业务类型
     */
    private Byte BUSINESSTYPE;

    /**
     * 业务ID
     */
    private Long BUSINESSID;

    /**
     * 业务名称
     */
    private String BUSINESSNAME;

    /**
     * 费用归属者类型：0个人，1部门
     */
    private Byte OWNERTYPE;

    /**
     * 是否有发票,1是，0否
     */
    private Byte HASTICKET;

    /**
     * 发票数量
     */
    private Integer TICKETNUM;

    /**
     * 发票备注
     */
    private String TICKETREMARK;

    /**
     * 关联单据类型
     */
    private Byte RELATIONROUTINETYPE;

    /**
     * 关联单据id
     */
    private Long RELATIONROUTINEID;

    /**
     * 关联单据名称
     */
    private String RELATIONROUTINENAME;

    public FeePurchaseDetailModel (Long ID, Long TALLYID, Long PARENTID, Byte PARENTTYPE, Date HAPPENTIME, Long PRODUCTID, String PRODUCTNAME, Long BASEUNITID, String BASEUNIT, String SPEC, Long PURCHASEOBJECTID, Long PRODUCTUNITID, Long SUPPLIERID, String SUPPLIER, String BRAND, Double TAXRATE, Byte PURCHASETYPE, Double PRICE, Double NUMBER, Double MONEY, Date ETA, String DESCRIPTION, String FEEBELONGID, Long CREATEUSERID, String CREATEUSER, Date CREATETIME, Long UPDATEUSERID, String UPDATEUSER, Date UPDATETIME, Long REGID, Long ORGID, Byte DELSTATE, Long CATEID, String CATENAME, String CATESTR, Long CUSTOMERID, String CUSTOMERNAME, String CONTACTIDS, String CONTACTS, Byte BUSINESSTYPE, Long BUSINESSID, String BUSINESSNAME, Byte OWNERTYPE, Byte HASTICKET, Integer TICKETNUM, String TICKETREMARK, Byte RELATIONROUTINETYPE, Long RELATIONROUTINEID, String RELATIONROUTINENAME) {
        this.ID = ID;
        this.TALLYID = TALLYID;
        this.PARENTID = PARENTID;
        this.PARENTTYPE = PARENTTYPE;
        this.HAPPENTIME = HAPPENTIME;
        this.PRODUCTID = PRODUCTID;
        this.PRODUCTNAME = PRODUCTNAME;
        this.BASEUNITID = BASEUNITID;
        this.BASEUNIT = BASEUNIT;
        this.SPEC = SPEC;
        this.PURCHASEOBJECTID = PURCHASEOBJECTID;
        this.PRODUCTUNITID = PRODUCTUNITID;
        this.SUPPLIERID = SUPPLIERID;
        this.SUPPLIER = SUPPLIER;
        this.BRAND = BRAND;
        this.TAXRATE = TAXRATE;
        this.PURCHASETYPE = PURCHASETYPE;
        this.PRICE = PRICE;
        this.NUMBER = NUMBER;
        this.MONEY = MONEY;
        this.ETA = ETA;
        this.DESCRIPTION = DESCRIPTION;
        this.FEEBELONGID = FEEBELONGID;
        this.CREATEUSERID = CREATEUSERID;
        this.CREATEUSER = CREATEUSER;
        this.CREATETIME = CREATETIME;
        this.UPDATEUSERID = UPDATEUSERID;
        this.UPDATEUSER = UPDATEUSER;
        this.UPDATETIME = UPDATETIME;
        this.REGID = REGID;
        this.ORGID = ORGID;
        this.DELSTATE = DELSTATE;
        this.CATEID = CATEID;
        this.CATENAME = CATENAME;
        this.CATESTR = CATESTR;
        this.CUSTOMERID = CUSTOMERID;
        this.CUSTOMERNAME = CUSTOMERNAME;
        this.CONTACTIDS = CONTACTIDS;
        this.CONTACTS = CONTACTS;
        this.BUSINESSTYPE = BUSINESSTYPE;
        this.BUSINESSID = BUSINESSID;
        this.BUSINESSNAME = BUSINESSNAME;
        this.OWNERTYPE = OWNERTYPE;
        this.HASTICKET = HASTICKET;
        this.TICKETNUM = TICKETNUM;
        this.TICKETREMARK = TICKETREMARK;
        this.RELATIONROUTINETYPE = RELATIONROUTINETYPE;
        this.RELATIONROUTINEID = RELATIONROUTINEID;
        this.RELATIONROUTINENAME = RELATIONROUTINENAME;
    }

    public FeePurchaseDetailModel () {
        
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getTALLYID() {
        return TALLYID;
    }

    public void setTALLYID(Long TALLYID) {
        this.TALLYID = TALLYID;
    }

    public Long getPARENTID() {
        return PARENTID;
    }

    public void setPARENTID(Long PARENTID) {
        this.PARENTID = PARENTID;
    }

    public Byte getPARENTTYPE() {
        return PARENTTYPE;
    }

    public void setPARENTTYPE(Byte PARENTTYPE) {
        this.PARENTTYPE = PARENTTYPE;
    }

    public Date getHAPPENTIME() {
        return HAPPENTIME;
    }

    public void setHAPPENTIME(Date HAPPENTIME) {
        this.HAPPENTIME = HAPPENTIME;
    }

    public Long getPRODUCTID() {
        return PRODUCTID;
    }

    public void setPRODUCTID(Long PRODUCTID) {
        this.PRODUCTID = PRODUCTID;
    }

    public String getPRODUCTNAME() {
        return PRODUCTNAME;
    }

    public void setPRODUCTNAME(String PRODUCTNAME) {
        this.PRODUCTNAME = PRODUCTNAME == null ? null : PRODUCTNAME.trim();
    }

    public Long getBASEUNITID() {
        return BASEUNITID;
    }

    public void setBASEUNITID(Long BASEUNITID) {
        this.BASEUNITID = BASEUNITID;
    }

    public String getBASEUNIT() {
        return BASEUNIT;
    }

    public void setBASEUNIT(String BASEUNIT) {
        this.BASEUNIT = BASEUNIT == null ? null : BASEUNIT.trim();
    }

    public String getSPEC() {
        return SPEC;
    }

    public void setSPEC(String SPEC) {
        this.SPEC = SPEC == null ? null : SPEC.trim();
    }

    public Long getPURCHASEOBJECTID() {
        return PURCHASEOBJECTID;
    }

    public void setPURCHASEOBJECTID(Long PURCHASEOBJECTID) {
        this.PURCHASEOBJECTID = PURCHASEOBJECTID;
    }

    public Long getPRODUCTUNITID() {
        return PRODUCTUNITID;
    }

    public void setPRODUCTUNITID(Long PRODUCTUNITID) {
        this.PRODUCTUNITID = PRODUCTUNITID;
    }

    public Long getSUPPLIERID() {
        return SUPPLIERID;
    }

    public void setSUPPLIERID(Long SUPPLIERID) {
        this.SUPPLIERID = SUPPLIERID;
    }

    public String getSUPPLIER() {
        return SUPPLIER;
    }

    public void setSUPPLIER(String SUPPLIER) {
        this.SUPPLIER = SUPPLIER == null ? null : SUPPLIER.trim();
    }

    public String getBRAND() {
        return BRAND;
    }

    public void setBRAND(String BRAND) {
        this.BRAND = BRAND == null ? null : BRAND.trim();
    }

    public Double getTAXRATE() {
        return TAXRATE;
    }

    public void setTAXRATE(Double TAXRATE) {
        this.TAXRATE = TAXRATE;
    }

    public Byte getPURCHASETYPE() {
        return PURCHASETYPE;
    }

    public void setPURCHASETYPE(Byte PURCHASETYPE) {
        this.PURCHASETYPE = PURCHASETYPE;
    }

    public Double getPRICE() {
        return PRICE;
    }

    public void setPRICE(Double PRICE) {
        this.PRICE = PRICE;
    }

    public Double getNUMBER() {
        return NUMBER;
    }

    public void setNUMBER(Double NUMBER) {
        this.NUMBER = NUMBER;
    }

    public Double getMONEY() {
        return MONEY;
    }

    public void setMONEY(Double MONEY) {
        this.MONEY = MONEY;
    }

    public Date getETA() {
        return ETA;
    }

    public void setETA(Date ETA) {
        this.ETA = ETA;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION == null ? null : DESCRIPTION.trim();
    }

    public String getFEEBELONGID() {
        return FEEBELONGID;
    }

    public void setFEEBELONGID(String FEEBELONGID) {
        this.FEEBELONGID = FEEBELONGID == null ? null : FEEBELONGID.trim();
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

    public Long getORGID() {
        return ORGID;
    }

    public void setORGID(Long ORGID) {
        this.ORGID = ORGID;
    }

    public Byte getDELSTATE() {
        return DELSTATE;
    }

    public void setDELSTATE(Byte DELSTATE) {
        this.DELSTATE = DELSTATE;
    }

    public Long getCATEID() {
        return CATEID;
    }

    public void setCATEID(Long CATEID) {
        this.CATEID = CATEID;
    }

    public String getCATENAME() {
        return CATENAME;
    }

    public void setCATENAME(String CATENAME) {
        this.CATENAME = CATENAME == null ? null : CATENAME.trim();
    }

    public String getCATESTR() {
        return CATESTR;
    }

    public void setCATESTR(String CATESTR) {
        this.CATESTR = CATESTR == null ? null : CATESTR.trim();
    }

    public Long getCUSTOMERID() {
        return CUSTOMERID;
    }

    public void setCUSTOMERID(Long CUSTOMERID) {
        this.CUSTOMERID = CUSTOMERID;
    }

    public String getCUSTOMERNAME() {
        return CUSTOMERNAME;
    }

    public void setCUSTOMERNAME(String CUSTOMERNAME) {
        this.CUSTOMERNAME = CUSTOMERNAME == null ? null : CUSTOMERNAME.trim();
    }

    public String getCONTACTIDS() {
        return CONTACTIDS;
    }

    public void setCONTACTIDS(String CONTACTIDS) {
        this.CONTACTIDS = CONTACTIDS == null ? null : CONTACTIDS.trim();
    }

    public String getCONTACTS() {
        return CONTACTS;
    }

    public void setCONTACTS(String CONTACTS) {
        this.CONTACTS = CONTACTS == null ? null : CONTACTS.trim();
    }

    public Byte getBUSINESSTYPE() {
        return BUSINESSTYPE;
    }

    public void setBUSINESSTYPE(Byte BUSINESSTYPE) {
        this.BUSINESSTYPE = BUSINESSTYPE;
    }

    public Long getBUSINESSID() {
        return BUSINESSID;
    }

    public void setBUSINESSID(Long BUSINESSID) {
        this.BUSINESSID = BUSINESSID;
    }

    public String getBUSINESSNAME() {
        return BUSINESSNAME;
    }

    public void setBUSINESSNAME(String BUSINESSNAME) {
        this.BUSINESSNAME = BUSINESSNAME == null ? null : BUSINESSNAME.trim();
    }

    public Byte getOWNERTYPE() {
        return OWNERTYPE;
    }

    public void setOWNERTYPE(Byte OWNERTYPE) {
        this.OWNERTYPE = OWNERTYPE;
    }

    public Byte getHASTICKET() {
        return HASTICKET;
    }

    public void setHASTICKET(Byte HASTICKET) {
        this.HASTICKET = HASTICKET;
    }

    public Integer getTICKETNUM() {
        return TICKETNUM;
    }

    public void setTICKETNUM(Integer TICKETNUM) {
        this.TICKETNUM = TICKETNUM;
    }

    public String getTICKETREMARK() {
        return TICKETREMARK;
    }

    public void setTICKETREMARK(String TICKETREMARK) {
        this.TICKETREMARK = TICKETREMARK == null ? null : TICKETREMARK.trim();
    }

    public Byte getRELATIONROUTINETYPE() {
        return RELATIONROUTINETYPE;
    }

    public void setRELATIONROUTINETYPE(Byte RELATIONROUTINETYPE) {
        this.RELATIONROUTINETYPE = RELATIONROUTINETYPE;
    }

    public Long getRELATIONROUTINEID() {
        return RELATIONROUTINEID;
    }

    public void setRELATIONROUTINEID(Long RELATIONROUTINEID) {
        this.RELATIONROUTINEID = RELATIONROUTINEID;
    }

    public String getRELATIONROUTINENAME() {
        return RELATIONROUTINENAME;
    }

    public void setRELATIONROUTINENAME(String RELATIONROUTINENAME) {
        this.RELATIONROUTINENAME = RELATIONROUTINENAME == null ? null : RELATIONROUTINENAME.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID=").append(ID);
        sb.append(", TALLYID=").append(TALLYID);
        sb.append(", PARENTID=").append(PARENTID);
        sb.append(", PARENTTYPE=").append(PARENTTYPE);
        sb.append(", HAPPENTIME=").append(HAPPENTIME);
        sb.append(", PRODUCTID=").append(PRODUCTID);
        sb.append(", PRODUCTNAME=").append(PRODUCTNAME);
        sb.append(", BASEUNITID=").append(BASEUNITID);
        sb.append(", BASEUNIT=").append(BASEUNIT);
        sb.append(", SPEC=").append(SPEC);
        sb.append(", PURCHASEOBJECTID=").append(PURCHASEOBJECTID);
        sb.append(", PRODUCTUNITID=").append(PRODUCTUNITID);
        sb.append(", SUPPLIERID=").append(SUPPLIERID);
        sb.append(", SUPPLIER=").append(SUPPLIER);
        sb.append(", BRAND=").append(BRAND);
        sb.append(", TAXRATE=").append(TAXRATE);
        sb.append(", PURCHASETYPE=").append(PURCHASETYPE);
        sb.append(", PRICE=").append(PRICE);
        sb.append(", NUMBER=").append(NUMBER);
        sb.append(", MONEY=").append(MONEY);
        sb.append(", ETA=").append(ETA);
        sb.append(", DESCRIPTION=").append(DESCRIPTION);
        sb.append(", FEEBELONGID=").append(FEEBELONGID);
        sb.append(", CREATEUSERID=").append(CREATEUSERID);
        sb.append(", CREATEUSER=").append(CREATEUSER);
        sb.append(", CREATETIME=").append(CREATETIME);
        sb.append(", UPDATEUSERID=").append(UPDATEUSERID);
        sb.append(", UPDATEUSER=").append(UPDATEUSER);
        sb.append(", UPDATETIME=").append(UPDATETIME);
        sb.append(", REGID=").append(REGID);
        sb.append(", ORGID=").append(ORGID);
        sb.append(", DELSTATE=").append(DELSTATE);
        sb.append(", CATEID=").append(CATEID);
        sb.append(", CATENAME=").append(CATENAME);
        sb.append(", CATESTR=").append(CATESTR);
        sb.append(", CUSTOMERID=").append(CUSTOMERID);
        sb.append(", CUSTOMERNAME=").append(CUSTOMERNAME);
        sb.append(", CONTACTIDS=").append(CONTACTIDS);
        sb.append(", CONTACTS=").append(CONTACTS);
        sb.append(", BUSINESSTYPE=").append(BUSINESSTYPE);
        sb.append(", BUSINESSID=").append(BUSINESSID);
        sb.append(", BUSINESSNAME=").append(BUSINESSNAME);
        sb.append(", OWNERTYPE=").append(OWNERTYPE);
        sb.append(", HASTICKET=").append(HASTICKET);
        sb.append(", TICKETNUM=").append(TICKETNUM);
        sb.append(", TICKETREMARK=").append(TICKETREMARK);
        sb.append(", RELATIONROUTINETYPE=").append(RELATIONROUTINETYPE);
        sb.append(", RELATIONROUTINEID=").append(RELATIONROUTINEID);
        sb.append(", RELATIONROUTINENAME=").append(RELATIONROUTINENAME);
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
        FeePurchaseDetailModel other = (FeePurchaseDetailModel) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getTALLYID() == null ? other.getTALLYID() == null : this.getTALLYID().equals(other.getTALLYID()))
            && (this.getPARENTID() == null ? other.getPARENTID() == null : this.getPARENTID().equals(other.getPARENTID()))
            && (this.getPARENTTYPE() == null ? other.getPARENTTYPE() == null : this.getPARENTTYPE().equals(other.getPARENTTYPE()))
            && (this.getHAPPENTIME() == null ? other.getHAPPENTIME() == null : this.getHAPPENTIME().equals(other.getHAPPENTIME()))
            && (this.getPRODUCTID() == null ? other.getPRODUCTID() == null : this.getPRODUCTID().equals(other.getPRODUCTID()))
            && (this.getPRODUCTNAME() == null ? other.getPRODUCTNAME() == null : this.getPRODUCTNAME().equals(other.getPRODUCTNAME()))
            && (this.getBASEUNITID() == null ? other.getBASEUNITID() == null : this.getBASEUNITID().equals(other.getBASEUNITID()))
            && (this.getBASEUNIT() == null ? other.getBASEUNIT() == null : this.getBASEUNIT().equals(other.getBASEUNIT()))
            && (this.getSPEC() == null ? other.getSPEC() == null : this.getSPEC().equals(other.getSPEC()))
            && (this.getPURCHASEOBJECTID() == null ? other.getPURCHASEOBJECTID() == null : this.getPURCHASEOBJECTID().equals(other.getPURCHASEOBJECTID()))
            && (this.getPRODUCTUNITID() == null ? other.getPRODUCTUNITID() == null : this.getPRODUCTUNITID().equals(other.getPRODUCTUNITID()))
            && (this.getSUPPLIERID() == null ? other.getSUPPLIERID() == null : this.getSUPPLIERID().equals(other.getSUPPLIERID()))
            && (this.getSUPPLIER() == null ? other.getSUPPLIER() == null : this.getSUPPLIER().equals(other.getSUPPLIER()))
            && (this.getBRAND() == null ? other.getBRAND() == null : this.getBRAND().equals(other.getBRAND()))
            && (this.getTAXRATE() == null ? other.getTAXRATE() == null : this.getTAXRATE().equals(other.getTAXRATE()))
            && (this.getPURCHASETYPE() == null ? other.getPURCHASETYPE() == null : this.getPURCHASETYPE().equals(other.getPURCHASETYPE()))
            && (this.getPRICE() == null ? other.getPRICE() == null : this.getPRICE().equals(other.getPRICE()))
            && (this.getNUMBER() == null ? other.getNUMBER() == null : this.getNUMBER().equals(other.getNUMBER()))
            && (this.getMONEY() == null ? other.getMONEY() == null : this.getMONEY().equals(other.getMONEY()))
            && (this.getETA() == null ? other.getETA() == null : this.getETA().equals(other.getETA()))
            && (this.getDESCRIPTION() == null ? other.getDESCRIPTION() == null : this.getDESCRIPTION().equals(other.getDESCRIPTION()))
            && (this.getFEEBELONGID() == null ? other.getFEEBELONGID() == null : this.getFEEBELONGID().equals(other.getFEEBELONGID()))
            && (this.getCREATEUSERID() == null ? other.getCREATEUSERID() == null : this.getCREATEUSERID().equals(other.getCREATEUSERID()))
            && (this.getCREATEUSER() == null ? other.getCREATEUSER() == null : this.getCREATEUSER().equals(other.getCREATEUSER()))
            && (this.getCREATETIME() == null ? other.getCREATETIME() == null : this.getCREATETIME().equals(other.getCREATETIME()))
            && (this.getUPDATEUSERID() == null ? other.getUPDATEUSERID() == null : this.getUPDATEUSERID().equals(other.getUPDATEUSERID()))
            && (this.getUPDATEUSER() == null ? other.getUPDATEUSER() == null : this.getUPDATEUSER().equals(other.getUPDATEUSER()))
            && (this.getUPDATETIME() == null ? other.getUPDATETIME() == null : this.getUPDATETIME().equals(other.getUPDATETIME()))
            && (this.getREGID() == null ? other.getREGID() == null : this.getREGID().equals(other.getREGID()))
            && (this.getORGID() == null ? other.getORGID() == null : this.getORGID().equals(other.getORGID()))
            && (this.getDELSTATE() == null ? other.getDELSTATE() == null : this.getDELSTATE().equals(other.getDELSTATE()))
            && (this.getCATEID() == null ? other.getCATEID() == null : this.getCATEID().equals(other.getCATEID()))
            && (this.getCATENAME() == null ? other.getCATENAME() == null : this.getCATENAME().equals(other.getCATENAME()))
            && (this.getCATESTR() == null ? other.getCATESTR() == null : this.getCATESTR().equals(other.getCATESTR()))
            && (this.getCUSTOMERID() == null ? other.getCUSTOMERID() == null : this.getCUSTOMERID().equals(other.getCUSTOMERID()))
            && (this.getCUSTOMERNAME() == null ? other.getCUSTOMERNAME() == null : this.getCUSTOMERNAME().equals(other.getCUSTOMERNAME()))
            && (this.getCONTACTIDS() == null ? other.getCONTACTIDS() == null : this.getCONTACTIDS().equals(other.getCONTACTIDS()))
            && (this.getCONTACTS() == null ? other.getCONTACTS() == null : this.getCONTACTS().equals(other.getCONTACTS()))
            && (this.getBUSINESSTYPE() == null ? other.getBUSINESSTYPE() == null : this.getBUSINESSTYPE().equals(other.getBUSINESSTYPE()))
            && (this.getBUSINESSID() == null ? other.getBUSINESSID() == null : this.getBUSINESSID().equals(other.getBUSINESSID()))
            && (this.getBUSINESSNAME() == null ? other.getBUSINESSNAME() == null : this.getBUSINESSNAME().equals(other.getBUSINESSNAME()))
            && (this.getOWNERTYPE() == null ? other.getOWNERTYPE() == null : this.getOWNERTYPE().equals(other.getOWNERTYPE()))
            && (this.getHASTICKET() == null ? other.getHASTICKET() == null : this.getHASTICKET().equals(other.getHASTICKET()))
            && (this.getTICKETNUM() == null ? other.getTICKETNUM() == null : this.getTICKETNUM().equals(other.getTICKETNUM()))
            && (this.getTICKETREMARK() == null ? other.getTICKETREMARK() == null : this.getTICKETREMARK().equals(other.getTICKETREMARK()))
            && (this.getRELATIONROUTINETYPE() == null ? other.getRELATIONROUTINETYPE() == null : this.getRELATIONROUTINETYPE().equals(other.getRELATIONROUTINETYPE()))
            && (this.getRELATIONROUTINEID() == null ? other.getRELATIONROUTINEID() == null : this.getRELATIONROUTINEID().equals(other.getRELATIONROUTINEID()))
            && (this.getRELATIONROUTINENAME() == null ? other.getRELATIONROUTINENAME() == null : this.getRELATIONROUTINENAME().equals(other.getRELATIONROUTINENAME()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getTALLYID() == null) ? 0 : getTALLYID().hashCode());
        result = prime * result + ((getPARENTID() == null) ? 0 : getPARENTID().hashCode());
        result = prime * result + ((getPARENTTYPE() == null) ? 0 : getPARENTTYPE().hashCode());
        result = prime * result + ((getHAPPENTIME() == null) ? 0 : getHAPPENTIME().hashCode());
        result = prime * result + ((getPRODUCTID() == null) ? 0 : getPRODUCTID().hashCode());
        result = prime * result + ((getPRODUCTNAME() == null) ? 0 : getPRODUCTNAME().hashCode());
        result = prime * result + ((getBASEUNITID() == null) ? 0 : getBASEUNITID().hashCode());
        result = prime * result + ((getBASEUNIT() == null) ? 0 : getBASEUNIT().hashCode());
        result = prime * result + ((getSPEC() == null) ? 0 : getSPEC().hashCode());
        result = prime * result + ((getPURCHASEOBJECTID() == null) ? 0 : getPURCHASEOBJECTID().hashCode());
        result = prime * result + ((getPRODUCTUNITID() == null) ? 0 : getPRODUCTUNITID().hashCode());
        result = prime * result + ((getSUPPLIERID() == null) ? 0 : getSUPPLIERID().hashCode());
        result = prime * result + ((getSUPPLIER() == null) ? 0 : getSUPPLIER().hashCode());
        result = prime * result + ((getBRAND() == null) ? 0 : getBRAND().hashCode());
        result = prime * result + ((getTAXRATE() == null) ? 0 : getTAXRATE().hashCode());
        result = prime * result + ((getPURCHASETYPE() == null) ? 0 : getPURCHASETYPE().hashCode());
        result = prime * result + ((getPRICE() == null) ? 0 : getPRICE().hashCode());
        result = prime * result + ((getNUMBER() == null) ? 0 : getNUMBER().hashCode());
        result = prime * result + ((getMONEY() == null) ? 0 : getMONEY().hashCode());
        result = prime * result + ((getETA() == null) ? 0 : getETA().hashCode());
        result = prime * result + ((getDESCRIPTION() == null) ? 0 : getDESCRIPTION().hashCode());
        result = prime * result + ((getFEEBELONGID() == null) ? 0 : getFEEBELONGID().hashCode());
        result = prime * result + ((getCREATEUSERID() == null) ? 0 : getCREATEUSERID().hashCode());
        result = prime * result + ((getCREATEUSER() == null) ? 0 : getCREATEUSER().hashCode());
        result = prime * result + ((getCREATETIME() == null) ? 0 : getCREATETIME().hashCode());
        result = prime * result + ((getUPDATEUSERID() == null) ? 0 : getUPDATEUSERID().hashCode());
        result = prime * result + ((getUPDATEUSER() == null) ? 0 : getUPDATEUSER().hashCode());
        result = prime * result + ((getUPDATETIME() == null) ? 0 : getUPDATETIME().hashCode());
        result = prime * result + ((getREGID() == null) ? 0 : getREGID().hashCode());
        result = prime * result + ((getORGID() == null) ? 0 : getORGID().hashCode());
        result = prime * result + ((getDELSTATE() == null) ? 0 : getDELSTATE().hashCode());
        result = prime * result + ((getCATEID() == null) ? 0 : getCATEID().hashCode());
        result = prime * result + ((getCATENAME() == null) ? 0 : getCATENAME().hashCode());
        result = prime * result + ((getCATESTR() == null) ? 0 : getCATESTR().hashCode());
        result = prime * result + ((getCUSTOMERID() == null) ? 0 : getCUSTOMERID().hashCode());
        result = prime * result + ((getCUSTOMERNAME() == null) ? 0 : getCUSTOMERNAME().hashCode());
        result = prime * result + ((getCONTACTIDS() == null) ? 0 : getCONTACTIDS().hashCode());
        result = prime * result + ((getCONTACTS() == null) ? 0 : getCONTACTS().hashCode());
        result = prime * result + ((getBUSINESSTYPE() == null) ? 0 : getBUSINESSTYPE().hashCode());
        result = prime * result + ((getBUSINESSID() == null) ? 0 : getBUSINESSID().hashCode());
        result = prime * result + ((getBUSINESSNAME() == null) ? 0 : getBUSINESSNAME().hashCode());
        result = prime * result + ((getOWNERTYPE() == null) ? 0 : getOWNERTYPE().hashCode());
        result = prime * result + ((getHASTICKET() == null) ? 0 : getHASTICKET().hashCode());
        result = prime * result + ((getTICKETNUM() == null) ? 0 : getTICKETNUM().hashCode());
        result = prime * result + ((getTICKETREMARK() == null) ? 0 : getTICKETREMARK().hashCode());
        result = prime * result + ((getRELATIONROUTINETYPE() == null) ? 0 : getRELATIONROUTINETYPE().hashCode());
        result = prime * result + ((getRELATIONROUTINEID() == null) ? 0 : getRELATIONROUTINEID().hashCode());
        result = prime * result + ((getRELATIONROUTINENAME() == null) ? 0 : getRELATIONROUTINENAME().hashCode());
        return result;
    }
}
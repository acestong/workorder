package com.fea.project.api.other.model.base;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/15.
 * 组织注册表 实体类
 */
public class SysOrgRegisterModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long REGID;

    /**
     *
     */
    private Long ORGID;

    /**
     * 组织编码
     */
    private String ORGCODE;

    /**
     *
     */
    private String ORGNAME;

    /**
     * 成立时间
     */
    private Date STARTDATE;

    /**
     * 状态：{0:冻结, 1:激活}
     */
    private Integer STATE;

    /**
     * 企业微信状态：{0企业微信, 1系统, 2体验组织, 3钉钉}
     */
    private Integer WXSTATE;

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
     * 1.长期2.五年.3.一年.4.半年5.一个月
     */
    private Integer USEFULLIFE;

    /**
     * 注册号
     */
    private String REGCODE;

    /**
     * 备注
     */
    private String DESCRIPTION;

    /**
     * 失效日期
     */
    private Date EXPIRYDATE;

    /**
     * 用户上限
     */
    private Integer PORTAL;

    /**
     * 默认密码
     */
    private String DEFAULTPASSWORD;

    /**
     *
     */
    private Integer DELSTATE;

    /**
     * 文件存储空间大小（单位：byte）
     */
    private String STORAGEBYTE;

    /**
     * 已使用文件存储空间大小（单位：byte）
     */
    private String STORAGEBYTEUSED;

    /**
     *
     */
    private String aliasName;

    /**
     * 创建来源：{0系统, 1企业微信, 2体验组织, 3钉钉}
     */
    private Integer SOURCE;

    /**
     *
     */
    private String AUTHCORPID;

    /**
     * 注册组织唯一标识码
     */
    private String uniqueCode;

    /**
     *
     */
    private String agentId;

    public SysOrgRegisterModel(Long REGID, Long ORGID, String ORGCODE, String ORGNAME, Date STARTDATE, Integer STATE, Integer WXSTATE, String CREATEUSER, Date CREATETIME, String UPDATEUSER, Date UPDATETIME, Integer USEFULLIFE, String REGCODE, String DESCRIPTION, Date EXPIRYDATE, Integer PORTAL, String DEFAULTPASSWORD, Integer DELSTATE, String STORAGEBYTE, String STORAGEBYTEUSED, String aliasName, Integer SOURCE, String AUTHCORPID, String uniqueCode, String agentId) {
        this.REGID = REGID;
        this.ORGID = ORGID;
        this.ORGCODE = ORGCODE;
        this.ORGNAME = ORGNAME;
        this.STARTDATE = STARTDATE;
        this.STATE = STATE;
        this.WXSTATE = WXSTATE;
        this.CREATEUSER = CREATEUSER;
        this.CREATETIME = CREATETIME;
        this.UPDATEUSER = UPDATEUSER;
        this.UPDATETIME = UPDATETIME;
        this.USEFULLIFE = USEFULLIFE;
        this.REGCODE = REGCODE;
        this.DESCRIPTION = DESCRIPTION;
        this.EXPIRYDATE = EXPIRYDATE;
        this.PORTAL = PORTAL;
        this.DEFAULTPASSWORD = DEFAULTPASSWORD;
        this.DELSTATE = DELSTATE;
        this.STORAGEBYTE = STORAGEBYTE;
        this.STORAGEBYTEUSED = STORAGEBYTEUSED;
        this.aliasName = aliasName;
        this.SOURCE = SOURCE;
        this.AUTHCORPID = AUTHCORPID;
        this.uniqueCode = uniqueCode;
        this.agentId = agentId;
    }

    public SysOrgRegisterModel() {

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

    public String getORGCODE() {
        return ORGCODE;
    }

    public void setORGCODE(String ORGCODE) {
        this.ORGCODE = ORGCODE == null ? null : ORGCODE.trim();
    }

    public String getORGNAME() {
        return ORGNAME;
    }

    public void setORGNAME(String ORGNAME) {
        this.ORGNAME = ORGNAME == null ? null : ORGNAME.trim();
    }

    public Date getSTARTDATE() {
        return STARTDATE;
    }

    public void setSTARTDATE(Date STARTDATE) {
        this.STARTDATE = STARTDATE;
    }

    public Integer getSTATE() {
        return STATE;
    }

    public void setSTATE(Integer STATE) {
        this.STATE = STATE;
    }

    public Integer getWXSTATE() {
        return WXSTATE;
    }

    public void setWXSTATE(Integer WXSTATE) {
        this.WXSTATE = WXSTATE;
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

    public Integer getUSEFULLIFE() {
        return USEFULLIFE;
    }

    public void setUSEFULLIFE(Integer USEFULLIFE) {
        this.USEFULLIFE = USEFULLIFE;
    }

    public String getREGCODE() {
        return REGCODE;
    }

    public void setREGCODE(String REGCODE) {
        this.REGCODE = REGCODE == null ? null : REGCODE.trim();
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION == null ? null : DESCRIPTION.trim();
    }

    public Date getEXPIRYDATE() {
        return EXPIRYDATE;
    }

    public void setEXPIRYDATE(Date EXPIRYDATE) {
        this.EXPIRYDATE = EXPIRYDATE;
    }

    public Integer getPORTAL() {
        return PORTAL;
    }

    public void setPORTAL(Integer PORTAL) {
        this.PORTAL = PORTAL;
    }

    public String getDEFAULTPASSWORD() {
        return DEFAULTPASSWORD;
    }

    public void setDEFAULTPASSWORD(String DEFAULTPASSWORD) {
        this.DEFAULTPASSWORD = DEFAULTPASSWORD == null ? null : DEFAULTPASSWORD.trim();
    }

    public Integer getDELSTATE() {
        return DELSTATE;
    }

    public void setDELSTATE(Integer DELSTATE) {
        this.DELSTATE = DELSTATE;
    }

    public String getSTORAGEBYTE() {
        return STORAGEBYTE;
    }

    public void setSTORAGEBYTE(String STORAGEBYTE) {
        this.STORAGEBYTE = STORAGEBYTE == null ? null : STORAGEBYTE.trim();
    }

    public String getSTORAGEBYTEUSED() {
        return STORAGEBYTEUSED;
    }

    public void setSTORAGEBYTEUSED(String STORAGEBYTEUSED) {
        this.STORAGEBYTEUSED = STORAGEBYTEUSED == null ? null : STORAGEBYTEUSED.trim();
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName == null ? null : aliasName.trim();
    }

    public Integer getSOURCE() {
        return SOURCE;
    }

    public void setSOURCE(Integer SOURCE) {
        this.SOURCE = SOURCE;
    }

    public String getAUTHCORPID() {
        return AUTHCORPID;
    }

    public void setAUTHCORPID(String AUTHCORPID) {
        this.AUTHCORPID = AUTHCORPID == null ? null : AUTHCORPID.trim();
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode == null ? null : uniqueCode.trim();
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId == null ? null : agentId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", REGID=").append(REGID);
        sb.append(", ORGID=").append(ORGID);
        sb.append(", ORGCODE=").append(ORGCODE);
        sb.append(", ORGNAME=").append(ORGNAME);
        sb.append(", STARTDATE=").append(STARTDATE);
        sb.append(", STATE=").append(STATE);
        sb.append(", WXSTATE=").append(WXSTATE);
        sb.append(", CREATEUSER=").append(CREATEUSER);
        sb.append(", CREATETIME=").append(CREATETIME);
        sb.append(", UPDATEUSER=").append(UPDATEUSER);
        sb.append(", UPDATETIME=").append(UPDATETIME);
        sb.append(", USEFULLIFE=").append(USEFULLIFE);
        sb.append(", REGCODE=").append(REGCODE);
        sb.append(", DESCRIPTION=").append(DESCRIPTION);
        sb.append(", EXPIRYDATE=").append(EXPIRYDATE);
        sb.append(", PORTAL=").append(PORTAL);
        sb.append(", DEFAULTPASSWORD=").append(DEFAULTPASSWORD);
        sb.append(", DELSTATE=").append(DELSTATE);
        sb.append(", STORAGEBYTE=").append(STORAGEBYTE);
        sb.append(", STORAGEBYTEUSED=").append(STORAGEBYTEUSED);
        sb.append(", aliasName=").append(aliasName);
        sb.append(", SOURCE=").append(SOURCE);
        sb.append(", AUTHCORPID=").append(AUTHCORPID);
        sb.append(", uniqueCode=").append(uniqueCode);
        sb.append(", agentId=").append(agentId);
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
        SysOrgRegisterModel other = (SysOrgRegisterModel) that;
        return (this.getREGID() == null ? other.getREGID() == null : this.getREGID().equals(other.getREGID()))
                && (this.getORGID() == null ? other.getORGID() == null : this.getORGID().equals(other.getORGID()))
                && (this.getORGCODE() == null ? other.getORGCODE() == null : this.getORGCODE().equals(other.getORGCODE()))
                && (this.getORGNAME() == null ? other.getORGNAME() == null : this.getORGNAME().equals(other.getORGNAME()))
                && (this.getSTARTDATE() == null ? other.getSTARTDATE() == null : this.getSTARTDATE().equals(other.getSTARTDATE()))
                && (this.getSTATE() == null ? other.getSTATE() == null : this.getSTATE().equals(other.getSTATE()))
                && (this.getWXSTATE() == null ? other.getWXSTATE() == null : this.getWXSTATE().equals(other.getWXSTATE()))
                && (this.getCREATEUSER() == null ? other.getCREATEUSER() == null : this.getCREATEUSER().equals(other.getCREATEUSER()))
                && (this.getCREATETIME() == null ? other.getCREATETIME() == null : this.getCREATETIME().equals(other.getCREATETIME()))
                && (this.getUPDATEUSER() == null ? other.getUPDATEUSER() == null : this.getUPDATEUSER().equals(other.getUPDATEUSER()))
                && (this.getUPDATETIME() == null ? other.getUPDATETIME() == null : this.getUPDATETIME().equals(other.getUPDATETIME()))
                && (this.getUSEFULLIFE() == null ? other.getUSEFULLIFE() == null : this.getUSEFULLIFE().equals(other.getUSEFULLIFE()))
                && (this.getREGCODE() == null ? other.getREGCODE() == null : this.getREGCODE().equals(other.getREGCODE()))
                && (this.getDESCRIPTION() == null ? other.getDESCRIPTION() == null : this.getDESCRIPTION().equals(other.getDESCRIPTION()))
                && (this.getEXPIRYDATE() == null ? other.getEXPIRYDATE() == null : this.getEXPIRYDATE().equals(other.getEXPIRYDATE()))
                && (this.getPORTAL() == null ? other.getPORTAL() == null : this.getPORTAL().equals(other.getPORTAL()))
                && (this.getDEFAULTPASSWORD() == null ? other.getDEFAULTPASSWORD() == null : this.getDEFAULTPASSWORD().equals(other.getDEFAULTPASSWORD()))
                && (this.getDELSTATE() == null ? other.getDELSTATE() == null : this.getDELSTATE().equals(other.getDELSTATE()))
                && (this.getSTORAGEBYTE() == null ? other.getSTORAGEBYTE() == null : this.getSTORAGEBYTE().equals(other.getSTORAGEBYTE()))
                && (this.getSTORAGEBYTEUSED() == null ? other.getSTORAGEBYTEUSED() == null : this.getSTORAGEBYTEUSED().equals(other.getSTORAGEBYTEUSED()))
                && (this.getAliasName() == null ? other.getAliasName() == null : this.getAliasName().equals(other.getAliasName()))
                && (this.getSOURCE() == null ? other.getSOURCE() == null : this.getSOURCE().equals(other.getSOURCE()))
                && (this.getAUTHCORPID() == null ? other.getAUTHCORPID() == null : this.getAUTHCORPID().equals(other.getAUTHCORPID()))
                && (this.getUniqueCode() == null ? other.getUniqueCode() == null : this.getUniqueCode().equals(other.getUniqueCode()))
                && (this.getAgentId() == null ? other.getAgentId() == null : this.getAgentId().equals(other.getAgentId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getREGID() == null) ? 0 : getREGID().hashCode());
        result = prime * result + ((getORGID() == null) ? 0 : getORGID().hashCode());
        result = prime * result + ((getORGCODE() == null) ? 0 : getORGCODE().hashCode());
        result = prime * result + ((getORGNAME() == null) ? 0 : getORGNAME().hashCode());
        result = prime * result + ((getSTARTDATE() == null) ? 0 : getSTARTDATE().hashCode());
        result = prime * result + ((getSTATE() == null) ? 0 : getSTATE().hashCode());
        result = prime * result + ((getWXSTATE() == null) ? 0 : getWXSTATE().hashCode());
        result = prime * result + ((getCREATEUSER() == null) ? 0 : getCREATEUSER().hashCode());
        result = prime * result + ((getCREATETIME() == null) ? 0 : getCREATETIME().hashCode());
        result = prime * result + ((getUPDATEUSER() == null) ? 0 : getUPDATEUSER().hashCode());
        result = prime * result + ((getUPDATETIME() == null) ? 0 : getUPDATETIME().hashCode());
        result = prime * result + ((getUSEFULLIFE() == null) ? 0 : getUSEFULLIFE().hashCode());
        result = prime * result + ((getREGCODE() == null) ? 0 : getREGCODE().hashCode());
        result = prime * result + ((getDESCRIPTION() == null) ? 0 : getDESCRIPTION().hashCode());
        result = prime * result + ((getEXPIRYDATE() == null) ? 0 : getEXPIRYDATE().hashCode());
        result = prime * result + ((getPORTAL() == null) ? 0 : getPORTAL().hashCode());
        result = prime * result + ((getDEFAULTPASSWORD() == null) ? 0 : getDEFAULTPASSWORD().hashCode());
        result = prime * result + ((getDELSTATE() == null) ? 0 : getDELSTATE().hashCode());
        result = prime * result + ((getSTORAGEBYTE() == null) ? 0 : getSTORAGEBYTE().hashCode());
        result = prime * result + ((getSTORAGEBYTEUSED() == null) ? 0 : getSTORAGEBYTEUSED().hashCode());
        result = prime * result + ((getAliasName() == null) ? 0 : getAliasName().hashCode());
        result = prime * result + ((getSOURCE() == null) ? 0 : getSOURCE().hashCode());
        result = prime * result + ((getAUTHCORPID() == null) ? 0 : getAUTHCORPID().hashCode());
        result = prime * result + ((getUniqueCode() == null) ? 0 : getUniqueCode().hashCode());
        result = prime * result + ((getAgentId() == null) ? 0 : getAgentId().hashCode());
        return result;
    }
}
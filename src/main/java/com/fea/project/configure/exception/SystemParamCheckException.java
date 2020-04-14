package com.fea.project.configure.exception;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/20 15:18
 **/
public class SystemParamCheckException extends RuntimeException {

    private String alarmMsg;

    public SystemParamCheckException() {
        super();
    }

    public SystemParamCheckException(String message) {
        super(message);
    }

    public SystemParamCheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemParamCheckException(Throwable cause) {
        super(cause);
    }

    protected SystemParamCheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getAlarmMsg() {
        return alarmMsg;
    }

    public void setAlarmMsg(String alarmMsg) {
        this.alarmMsg = alarmMsg;
    }

    public SystemParamCheckException appendAlaramMsg(String alarmMsg) {
        this.setAlarmMsg(alarmMsg);
        return this;
    }
}

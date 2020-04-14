package com.fea.project.configure.exception;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/18 16:32
 **/
public class PriorityIllegalException extends RuntimeException {

    private String alarmMsg = "该用户不具备权限，无法进行操作";

    public PriorityIllegalException() {
        super();
    }

    public PriorityIllegalException(String message) {
        super(message);
    }

    public PriorityIllegalException(String message, Throwable cause) {
        super(message, cause);
    }

    public PriorityIllegalException(Throwable cause) {
        super(cause);
    }

    protected PriorityIllegalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getAlarmMsg() {
        return alarmMsg;
    }

    public void setAlarmMsg(String alarmMsg) {
        this.alarmMsg = alarmMsg;
    }

    public PriorityIllegalException appendAlaramMsg(String alarmMsg) {
        this.setAlarmMsg(alarmMsg);
        return this;
    }
}

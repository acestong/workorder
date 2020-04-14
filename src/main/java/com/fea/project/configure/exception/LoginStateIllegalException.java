package com.fea.project.configure.exception;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/18 16:32
 **/
public class LoginStateIllegalException extends RuntimeException {

    public LoginStateIllegalException() {
        super();
    }

    public LoginStateIllegalException(String message) {
        super(message);
    }

    public LoginStateIllegalException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginStateIllegalException(Throwable cause) {
        super(cause);
    }

    protected LoginStateIllegalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

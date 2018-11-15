package com.common.base.exception;

/**
 * 各个模块中所有自定义业务异常类的父类
 */
public class BaseBusinessException extends RuntimeException {

    public BaseBusinessException() {
    }

    public BaseBusinessException(String message) {
        super(message);
    }

    public BaseBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseBusinessException(Throwable cause) {
        super(cause);
    }

    public BaseBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

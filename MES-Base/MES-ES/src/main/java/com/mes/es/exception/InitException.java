package com.mes.es.exception;

/**
 * Created by Administrator on 2015/8/27.
 */
public class InitException extends Exception {

    private static final long serialVersionUID = 1L;

    public InitException() {
        super();
    }

    public InitException(String msg) {
        super(msg);
    }

    public InitException(Throwable throwable) {
        super(throwable);
    }

    public InitException(String msg, Throwable throwable) {
        super(msg,throwable);
    }

    public void printStackTrace() {
        super.printStackTrace();
    }

}

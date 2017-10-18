package com.mes.es.exception;

/**
 * Created by Administrator on 2015/8/27.
 */
public class ExistIndexException extends Exception {

    private static final long serialVersionUID = 1L;

    public ExistIndexException() {
        super();
    }

    public ExistIndexException(String msg) {
        super(msg);
    }

    public ExistIndexException(Throwable throwable) {
        super(throwable);
    }

    public ExistIndexException(String msg, Throwable throwable) {
        super(msg,throwable);
    }

    public void printStackTrace() {
        super.printStackTrace();
    }

}

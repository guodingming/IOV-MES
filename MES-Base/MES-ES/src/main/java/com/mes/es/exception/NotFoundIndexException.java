package com.mes.es.exception;

/**
 * Created by Administrator on 2015/8/27.
 */
public class NotFoundIndexException extends Exception {

    private static final long serialVersionUID = 1L;

    public NotFoundIndexException() {
        super();
    }

    public NotFoundIndexException(String msg) {
        super(msg);
    }

    public NotFoundIndexException(Throwable throwable) {
        super(throwable);
    }

    public NotFoundIndexException(String msg, Throwable throwable) {
        super(msg,throwable);
    }

    public void printStackTrace() {
        super.printStackTrace();
    }

}

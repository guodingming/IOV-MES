package com.mes.common.framework.Exception;

/**
 * Used to identify while method is not supported in a special restful service class
 * Created by aihua.sun on 2015/2/11.
 */
public class RestServiceNotSupportedException extends RuntimeException {
    private static final long serialVersionUID = 7376627195548856813L;

    public RestServiceNotSupportedException() {
        super();
    }

    public RestServiceNotSupportedException(String msg) {
        super(msg);
    }
}

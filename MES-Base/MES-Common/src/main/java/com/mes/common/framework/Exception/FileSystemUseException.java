package com.mes.common.framework.Exception;

/**
 *
 */
public class FileSystemUseException extends DubboProviderException {
    public FileSystemUseException(Exception e){
        super(e);
    }

    public FileSystemUseException(String message, Exception e){
        super( message, e );
    }

    public FileSystemUseException(String message){
        super( message);
    }
}

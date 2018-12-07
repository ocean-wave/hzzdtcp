package com.hzzd.protocol.protocal3761.exception;

/**
 * Created by PETER on 2015/3/23.
 */
public class CipherException extends Exception{
	private static final long serialVersionUID = 1264587840146282886L;
	private int errorCode;
    public CipherException(int errorCode,String message){
        super(message);
        this.errorCode=errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}

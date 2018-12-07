package com.hzzd.protocol.protocal3761.exception;

/**
 * Created by PETER on 2015/3/23.
 */
public class VerifyException extends Exception{
	private static final long serialVersionUID = 1219327967406784018L;
	private int errorCode;
    public VerifyException(int errorCode,String message){
        super(message);
        this.errorCode=errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}

package com.hzzd.protocol.protocal3761.exception;

/**
 * Created by PETER on 2015/3/23.
 */
public class EncodingException extends Exception{
	private static final long serialVersionUID = -2731299110412845216L;
	private int errorCode;
    public EncodingException(int errorCode,String message){
        super(message);
        this.errorCode=errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}

package com.hzzd.protocol.protocal3761.exception;

/**
 * Created by PETER on 2015/3/23.
 *
 *
 */
public class DecodingException extends Exception{
	private static final long serialVersionUID = 1560637332190291696L;
	private int errorCode;
    public DecodingException(int errorCode,String message){
        super(message);
        this.errorCode=errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}

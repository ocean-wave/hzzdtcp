package com.hzzd.protocol.protocal3761.exception;

/**
 * Created by PETER on 2015/2/28.
 */
public class InvalidConfigException extends Exception{
    private static final long serialVersionUID = -614392367119589902L;
    private int errorCode;
    public InvalidConfigException(int errorCode,String message) {
        super(message);
        this.setErrorCode(errorCode);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}

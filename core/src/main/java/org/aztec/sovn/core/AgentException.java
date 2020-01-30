package org.aztec.sovn.core;

public class AgentException extends RuntimeException {
	
	private String errorCode;
	
	public static interface CommonErrorCodes {
		String PREFIX = "AE_COMMON_E_";
		String UNKONW_ERROR = "001";
	}

	public AgentException(String errorCode) {
		super(errorCode);
		this.errorCode = errorCode;
	}

	public AgentException(String errorCode,String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public AgentException(Throwable cause) {
		super(cause);
		this.errorCode = CommonErrorCodes.UNKONW_ERROR;
	}

	public AgentException(String message, Throwable cause) {
		super(message, cause);
		this.errorCode = CommonErrorCodes.UNKONW_ERROR;
	}

	public AgentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errorCode = CommonErrorCodes.UNKONW_ERROR;
	}

}

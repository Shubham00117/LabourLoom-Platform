package com.labourloomplatform.labourloomPlatform.customException;

@SuppressWarnings("serial")
public class ApiException extends RuntimeException {
	public ApiException(String mesg) {
		super(mesg);
	}

}

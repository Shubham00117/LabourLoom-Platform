package com.labourloomplatform.labourloomPlatform.customException;

@SuppressWarnings("serial")
public class AdminException extends ResourceNotFoundException {
	public AdminException (String msg) {
		super(msg);
	}

}

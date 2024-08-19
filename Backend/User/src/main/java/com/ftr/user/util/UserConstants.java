package com.ftr.user.util;

public enum UserConstants {

	USER_GENERAL_EXCEPTION("general.exception"),
	USER_UPDATE_SUCCESS("user.update.success"),
	USER_DELETE_SUCCESS("user.delete.success"),
	USER_LOGIN_SUCCESS("user.login.success"),
	USER_LOGIN_FAILED("user.login.failure"),
	USER_CREATE_SUCCESS("user.create.success"),
	USER_NOT_FOUND("user.not.found");
	
	private String message;

	private UserConstants(String message) {
		this.message = message;
	}
	
	public String toString() {
		return this.message;
	}

}

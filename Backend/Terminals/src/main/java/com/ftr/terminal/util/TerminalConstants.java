package com.ftr.terminal.util;

public enum TerminalConstants {
	
	TERMINAL_ITEMTYPE_NOT_FOUND("terminal.itemtype.notFound"),
	TERMINAL_NOT_FOUND("terminal.notFound"),
	TERMINAL_GENERAL_EXCEPTION("general.exception"),
	TERMINAL_CAPACITY_FAILED("terminal.capacity.failed"),
	TERMINAL_EMPTY("terminal.empty"),
	TERMINAL_ALREADY_EXISTS("terminal.already.exists"),
	TERMINAL_UPDATE_SUCCESS("terminal.update.success"),
	TERMINAL_STATUS_UPDATE_SUCCESS("terminal.status.update.success"),
	TERMINAL_DELETE_SUCCESS("terminal.delete.success");
	
	private String message;

	private TerminalConstants(String message) {
		this.message = message;
	}
	
	public String toString() {
		return this.message;
	}

}

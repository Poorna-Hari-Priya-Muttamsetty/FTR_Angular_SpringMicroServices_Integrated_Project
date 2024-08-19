package com.ftr.workitem.dto;

public class WorkitemTerminalDTO {

private String workitem_id;
	
	private String terminal_id;

	public WorkitemTerminalDTO(String workitem_id, String terminal_id) {
		super();
		this.workitem_id = workitem_id;
		this.terminal_id = terminal_id;
	}

	public WorkitemTerminalDTO() {
		super();
	}

	public String getWorkitem_id() {
		return workitem_id;
	}

	public void setWorkitem_id(String workitem_id) {
		this.workitem_id = workitem_id;
	}

	public String getTerminal_id() {
		return terminal_id;
	}

	public void setTerminal_id(String terminal_id) {
		this.terminal_id = terminal_id;
	}

	@Override
	public String toString() {
		return "WorkitemTerminals [workitem_id=" + workitem_id + ", terminal_id=" + terminal_id + "]";
	}
	
}

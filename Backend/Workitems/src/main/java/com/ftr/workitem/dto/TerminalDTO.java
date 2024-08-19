package com.ftr.workitem.dto;

public class TerminalDTO {

	private String terminal_id;
	
	private String terminal_name;
	
	private String country;
	
	private String item_type;
	
	private String terminal_description;
	
	private Long capacity;
	
	private Long available_capacity;
	
	private String status;
	
	private String harbor_location;

	public TerminalDTO(String terminal_id, String terminal_name, String country, String item_type,
			String terminal_description, Long capacity, Long available_capacity, String status, String harbor_location) {
		super();
		this.terminal_id = terminal_id;
		this.terminal_name = terminal_name;
		this.country = country;
		this.item_type = item_type;
		this.terminal_description = terminal_description;
		this.capacity = capacity;
		this.available_capacity = available_capacity;
		this.status = status;
		this.harbor_location = harbor_location;
	}

	public TerminalDTO() {
		super();
	}

	public String getTerminal_id() {
		return terminal_id;
	}

	public void setTerminal_id(String terminal_id) {
		this.terminal_id = terminal_id;
	}

	public String getTerminal_name() {
		return terminal_name;
	}

	public void setTerminal_name(String terminal_name) {
		this.terminal_name = terminal_name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getItem_type() {
		return item_type;
	}

	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}

	public String getTerminal_description() {
		return terminal_description;
	}

	public void setTerminal_description(String terminal_description) {
		this.terminal_description = terminal_description;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	public Long getAvailable_capacity() {
		return available_capacity;
	}

	public void setAvailable_capacity(Long available_capacity) {
		this.available_capacity = available_capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHarbor_location() {
		return harbor_location;
	}

	public void setHarbor_location(String harbor_location) {
		this.harbor_location = harbor_location;
	}

	@Override
	public String toString() {
		return "TerminalsDTO [terminal_id=" + terminal_id + ", terminal_name=" + terminal_name + ", country=" + country
				+ ", item_type=" + item_type + ", terminal_description=" + terminal_description + ", capacity="
				+ capacity + ", available_capacity=" + available_capacity + ", status=" + status + ", harbor_location="
				+ harbor_location + "]";
	}
	
	
}

package com.ftr.workitem.dto;

public class HarborDTO {

	private String country;
	
	private String available_harbor_locations;

	public HarborDTO(String country, String available_harbor_locations) {
		super();
		this.country = country;
		this.available_harbor_locations = available_harbor_locations;
	}

	public HarborDTO() {
		super();
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAvailable_harbor_locations() {
		return available_harbor_locations;
	}

	public void setAvailable_harbor_locations(String available_harbor_locations) {
		this.available_harbor_locations = available_harbor_locations;
	}

	@Override
	public String toString() {
		return "Harbor [country=" + country + ", available_harbor_locations=" + available_harbor_locations + "]";
	}
}

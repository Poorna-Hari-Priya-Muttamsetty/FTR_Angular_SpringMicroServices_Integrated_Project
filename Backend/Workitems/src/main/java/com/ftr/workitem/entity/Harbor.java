package com.ftr.workitem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ftr_harbor")
public class Harbor {

	@Id
	private String country;
	
	private String available_harbor_locations;

	public Harbor(String country, String available_harbor_locations) {
		super();
		this.country = country;
		this.available_harbor_locations = available_harbor_locations;
	}

	public Harbor() {
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

package com.ftr.vehicle.dto;

import java.util.Date;

public class VehicleDTO {

	private String vehicle_number;
	
	private String vehicle_name;
	
	private Long max_lifting_capacity;
	
	private Date retire_date;
	
	private String vehicle_status;
	
	private String harbor_location;
	
	private String country;

	public VehicleDTO(String vehicle_number, String vehicle_name, Long max_lifting_capacity, Date retire_date,
			String vehicle_status, String harbor_location, String country) {
		super();
		this.vehicle_number = vehicle_number;
		this.vehicle_name = vehicle_name;
		this.max_lifting_capacity = max_lifting_capacity;
		this.retire_date = retire_date;
		this.vehicle_status = vehicle_status;
		this.harbor_location = harbor_location;
		this.country = country;
	}

	public VehicleDTO() {
		super();
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public String getVehicle_name() {
		return vehicle_name;
	}

	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}

	public Long getMax_lifting_capacity() {
		return max_lifting_capacity;
	}

	public void setMax_lifting_capacity(Long max_lifting_capacity) {
		this.max_lifting_capacity = max_lifting_capacity;
	}

	public Date getRetire_date() {
		return retire_date;
	}

	public void setRetire_date(Date retire_date) {
		this.retire_date = retire_date;
	}

	public String getVehicle_status() {
		return vehicle_status;
	}

	public void setVehicle_status(String vehicle_status) {
		this.vehicle_status = vehicle_status;
	}

	public String getHarbor_location() {
		return harbor_location;
	}

	public void setHarbor_location(String harbor_location) {
		this.harbor_location = harbor_location;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "VehiclesDTO [vehicle_number=" + vehicle_number + ", vehicle_name=" + vehicle_name
				+ ", max_lifting_capacity=" + max_lifting_capacity + ", retire_date=" + retire_date
				+ ", vehicle_status=" + vehicle_status + ", harbor_location=" + harbor_location + ", country=" + country
				+ "]";
	}
	
	
}

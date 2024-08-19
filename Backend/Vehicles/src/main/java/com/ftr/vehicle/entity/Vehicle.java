package com.ftr.vehicle.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="ftr_vehicles")
public class Vehicle {

	@Id
	@NotEmpty(message = "{vehicle.vehicle_number.must}")
	@Pattern( regexp = "^[A-Z]{2}[0-9]{4}$", message = "{vehicle.vehicle_number.invalid}")
	private String vehicle_number;

	@NotEmpty(message="{vehicle.vehicle_name.must}")
	private String vehicle_name;
	
	@NotNull( message= "{vehicle.max_lifting_capacity.must}")
	@Digits(integer = 19, fraction=0, message="{vehicle.max_lifting_capacity.invalid}")
	private Long max_lifting_capacity;
	
	@NotNull( message = "{vehicle.retire_date.must}")
	private Date retire_date;
	
	@NotEmpty(message = "{vehicle.vehicle_status.must}")
    @Pattern(regexp = "Active|InProgress|Retired", message = "{vehicle.vehicle_status.invalid}")
	private String vehicle_status;
	
	private String harbor_location;
	
	private String country;

	public Vehicle(String vehicle_number, String vehicle_name, Long max_lifting_capacity, Date retire_date,
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

	public Vehicle() {
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
		return "Vehicles [vehicle_number=" + vehicle_number + ", vehicle_name=" + vehicle_name
				+ ", max_lifting_capacity=" + max_lifting_capacity + ", retire_date=" + retire_date
				+ ", vehicle_status=" + vehicle_status + ", harbor_location=" + harbor_location + ", country=" + country
				+ "]";
	}
	
	
}

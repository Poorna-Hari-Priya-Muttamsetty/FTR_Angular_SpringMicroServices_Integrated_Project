package com.ftr.user.dto;

public class UserDTO {

	private Long user_id;
	
	private String first_name;
	
	private String last_name;
	
	private String email_id;
	
	private Long mobile_number;
	
	private String password;
	
	private String nationality;
	
	private String passport_number;
	
	private String permanent_address;
	
	private String office_address;
	
	private Long personal_identification_number;

	public UserDTO(Long user_id, String first_name, String last_name, String email_id, Long mobile_number,
			String password, String nationality, String passport_number, String permanent_address,
			String office_address, Long personal_identification_number) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.mobile_number = mobile_number;
		this.password = password;
		this.nationality = nationality;
		this.passport_number = passport_number;
		this.permanent_address = permanent_address;
		this.office_address = office_address;
		this.personal_identification_number = personal_identification_number;
	}

	public UserDTO() {
		super();
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public Long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPassport_number() {
		return passport_number;
	}

	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}

	public String getPermanent_address() {
		return permanent_address;
	}

	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}

	public String getOffice_address() {
		return office_address;
	}

	public void setOffice_address(String office_address) {
		this.office_address = office_address;
	}

	public Long getPersonal_identification_number() {
		return personal_identification_number;
	}

	public void setPersonal_identification_number(Long personal_identification_number) {
		this.personal_identification_number = personal_identification_number;
	}

	@Override
	public String toString() {
		return "UserDTO [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email_id="
				+ email_id + ", mobile_number=" + mobile_number + ", password=" + password + ", nationality="
				+ nationality + ", passport_number=" + passport_number + ", permanent_address=" + permanent_address
				+ ", office_address=" + office_address + ", personal_identification_number="
				+ personal_identification_number + "]";
	}
	
}

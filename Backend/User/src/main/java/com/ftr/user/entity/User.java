package com.ftr.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ftr_user")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	@NotEmpty(message = "{user.firstname.must}")
	@Size(min=3, max=20, message= "{user.firstName.invalid}")
	private String first_name;
	
	@NotEmpty(message = "{user.lastname.must}")
	@Size(min=3, max=20, message= "{user.lastName.invalid}")
	private String last_name;
	
	@NotEmpty(message = "{user.email.must}")
	@Email(message="{user.email.invalid}")
	private String email_id;
	
	@NotNull(message="{user.mobile.number.must}")
	private Long mobile_number;
	
	@NotEmpty(message = "{user.password.must}")
//	@Pattern(regexp= "[A-z0-9]*[!@#$%^&*()_+:;><]+[A-z0-9]*", message="{user.password.invalid}")
//	@Size(min=8, max=12, message= "{user.password.length.invalid}")
	private String password;
	
	@NotEmpty(message = "{user.nationality.must}")
	private String nationality;
	
	@NotEmpty(message = "{user.passport.number.must}")
	@Size(min=7, max=12, message= "{user.passportNumber.invalid}")
	private String passport_number;
	
	@NotEmpty(message = "{user.permanent.address.must}")
	@Size(max=200, message= "{user.permanentAddress.invalid}")
	private String permanent_address;
	
	@NotEmpty(message = "{user.office.address.must}")
	@Size(max=200, message= "{user.officeAddress.invalid}")
	private String office_address;
	
	@NotNull(message = "{user.personal.identification.number.must}")
	private Long personal_identification_number;

	public User(Long user_id, String first_name, String last_name, String email_id, Long mobile_number,
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

	public User() {
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
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email_id="
				+ email_id + ", mobile_number=" + mobile_number + ", password=" + password + ", nationality="
				+ nationality + ", passport_number=" + passport_number + ", permanent_address=" + permanent_address
				+ ", office_address=" + office_address + ", personal_identification_number="
				+ personal_identification_number + "]";
	}
	
}

package com.ftr.workitem.dto;

import java.util.Date;

public class WorkitemDTO {

	private String workitem_id;
	
	private Long user_id;
	
	private String item_name;
	
	private String item_type;
	
	private String item_description;
	
	private String message_to_recipient;
	
	private String quantity;
	
	private String source_country;
	
	private String destination_country;
		
	private String selected_harbor_location;
	
	private Date shipping_date;
	
	private Long amount;

	public WorkitemDTO(String workitem_id, Long user_id, String item_name, String item_type, String item_description,
			String message_to_recipient, String quantity, String source_country, String destination_country,
			String selected_harbor_location, Date shipping_date, Long amount) {
		super();
		this.workitem_id = workitem_id;
		this.user_id = user_id;
		this.item_name = item_name;
		this.item_type = item_type;
		this.item_description = item_description;
		this.message_to_recipient = message_to_recipient;
		this.quantity = quantity;
		this.source_country = source_country;
		this.destination_country = destination_country;
		this.selected_harbor_location = selected_harbor_location;
		this.shipping_date = shipping_date;
		this.amount = amount;
	}

	public WorkitemDTO() {
		super();
	}

	public String getWorkitem_id() {
		return workitem_id;
	}

	public void setWorkitem_id(String workitem_id) {
		this.workitem_id = workitem_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_type() {
		return item_type;
	}

	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}

	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public String getMessage_to_recipient() {
		return message_to_recipient;
	}

	public void setMessage_to_recipient(String message_to_recipient) {
		this.message_to_recipient = message_to_recipient;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSource_country() {
		return source_country;
	}

	public void setSource_country(String source_country) {
		this.source_country = source_country;
	}

	public String getDestination_country() {
		return destination_country;
	}

	public void setDestination_country(String destination_country) {
		this.destination_country = destination_country;
	}

	public String getSelected_harbor_location() {
		return selected_harbor_location;
	}

	public void setSelected_harbor_location(String selected_harbor_location) {
		this.selected_harbor_location = selected_harbor_location;
	}

	public Date getShipping_date() {
		return shipping_date;
	}

	public void setShipping_date(Date shipping_date) {
		this.shipping_date = shipping_date;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Workitems [workitem_id=" + workitem_id + ", user_id=" + user_id + ", item_name=" + item_name
				+ ", item_type=" + item_type + ", item_description=" + item_description + ", message_to_recipient="
				+ message_to_recipient + ", quantity=" + quantity + ", source_country=" + source_country
				+ ", destination_country=" + destination_country + ", originharbor_location=" 
				+ ", selected_harbor_location=" + selected_harbor_location + ", shipping_date=" + shipping_date
				+ ", amount=" + amount + "]";
	}
	
}

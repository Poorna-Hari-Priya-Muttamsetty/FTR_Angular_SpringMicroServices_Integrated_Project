package com.ftr.workitem.dto;

public class WorkitemVehicleDTO {

private String workitem_id;
	
	private String vehicle_number;
	
	private String driver_id;
	
	private String assigned_workitem_status;

	public WorkitemVehicleDTO(String workitem_id, String vehicle_number, String driver_id,
			String assigned_workitem_status) {
		super();
		this.workitem_id = workitem_id;
		this.vehicle_number = vehicle_number;
		this.driver_id = driver_id;
		this.assigned_workitem_status = assigned_workitem_status;
	}

	public WorkitemVehicleDTO() {
		super();
	}

	public String getWorkitem_id() {
		return workitem_id;
	}

	public void setWorkitem_id(String workitem_id) {
		this.workitem_id = workitem_id;
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public String getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
	}

	public String getAssigned_workitem_status() {
		return assigned_workitem_status;
	}

	public void setAssigned_workitem_status(String assigned_workitem_status) {
		this.assigned_workitem_status = assigned_workitem_status;
	}

	@Override
	public String toString() {
		return "WorkitemVehicles [workitem_id=" + workitem_id + ", vehicle_number=" + vehicle_number + ", driver_id="
				+ driver_id + ", assigned_workitem_status=" + assigned_workitem_status + "]";
	}
}

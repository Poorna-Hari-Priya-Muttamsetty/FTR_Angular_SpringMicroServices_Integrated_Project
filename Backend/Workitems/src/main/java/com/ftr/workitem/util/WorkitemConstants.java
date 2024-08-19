package com.ftr.workitem.util;

public enum WorkitemConstants {

	WORKITEM_NOT_FOUND("workitem.notFound"),
	HARBOR_NOT_FOUND("harbor.notFound"),
	WORKITEM_GENERAL_EXCEPTION("general.exception"),
	INPUT_PARAMETER_MISSING("input.parameter.missing"),
	WORKITEM_INPUT_DATE_INVALID("input.date.invalid"),
	WORKITEM_ASSIGN_FAIL("workitem.assign.fail"),
	TERMINAL_NOT_AVAILABLE("terminal.notAvailable"),
	WORKITEM_TERMINAL_ALLOCATED("workitem.terminal.allocated"),
	WORKITEM_FUTURE_SHIPPING_DATE("workitem.shippingDate.future"),
	WORKITEM_UPDATE_SUCCESS("workitem.update.success"),
	WORKITEM_FOUND("workitem.found"),
	WORKITEM_ASSIGNED_WITH_VEHICLE("workitem.assigned.withVehicle"),
	WORKITEM_VEHICLE_ALLOCATED("workitem.vehicle.allocated"),
	VEHICLE_NOT_FOUND("vehicle.notFound");
	
	private String message;

	private WorkitemConstants(String message) {
		this.message = message;
	}
	
	public String toString() {
		return this.message;
	}
}

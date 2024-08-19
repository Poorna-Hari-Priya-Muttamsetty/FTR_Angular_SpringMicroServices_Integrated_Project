package com.ftr.vehicle.util;

public enum VehicleConstants {

	VEHICLE_ALREADY_EXISTS("vehicle.alreadyexists"),
	VEHICLE_NOT_FOUND("vehicle.notFound"),
	VEHICLE_GENERAL_EXCEPTION("general.exception"),
	VEHICLE_INPUT_PARAMETER_MISSING("input.parameter.missing"),
	VEHICLE_UPDATE_ALREADY_EXISTS("vehicle.update.alreadyExists"),
	VEHICLE_INVALID_DATA_INPUT("invalid.data"),
	VEHICLE_INVALID_DATE_INPUT("input.date.invalid"),
	VEHICLE_UPDATE_SUCCESS("vehicle.update.success"),
	VEHICLE_DELETE_SUCCESS("vehicle.delete.success"),
	VEHICLE_DETAILS_FOUND("vehicle.found"),
	VEHICLE_CREATE_SUCCESS("vehicle.create.success");
	
	private String message;

	private VehicleConstants(String message) {
		this.message = message;
	}
	
	public String toString() {
		return this.message;
	}
}

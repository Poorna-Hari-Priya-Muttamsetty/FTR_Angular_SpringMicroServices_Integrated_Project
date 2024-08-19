package com.ftr.vehicle.service;

import java.util.List;

import com.ftr.vehicle.dto.VehicleDTO;
import com.ftr.vehicle.exception.VehicleException;

public interface VehicleService {

	 String insertNewVehicle(VehicleDTO vehicleDto) throws VehicleException;
	 List<VehicleDTO> fetchAvailableVehicles() throws VehicleException;
	 List<VehicleDTO> fetchVehicleDetailsByvehicle_name(String vehicle_name) throws VehicleException;
	 VehicleDTO fetchVehicleDetailsByvehicle_number(String vehicle_number) throws VehicleException;
	 String updatevehicle_status(String vehicleNum, VehicleDTO dto) throws VehicleException;
	 String removeVehicle(String vehicleNum) throws VehicleException ;
}

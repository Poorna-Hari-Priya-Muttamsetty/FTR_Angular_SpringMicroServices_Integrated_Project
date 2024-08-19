package com.ftr.vehicle.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.ftr.vehicle.dto.VehicleDTO;
import com.ftr.vehicle.entity.Vehicle;
import com.ftr.vehicle.exception.VehicleException;
import com.ftr.vehicle.repository.VehicleRepository;
import com.ftr.vehicle.util.VehicleConstants;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class VehicleServiceImpl implements VehicleService{

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleService.class);

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private Environment environment;
	
	@Override
	public String insertNewVehicle(VehicleDTO vehicleDto) throws VehicleException {
		LOGGER.info("insertNewVehicle method in service class");
		Vehicle vehicle = vehicleRepository.getVehicleDetailsByvehicle_number(vehicleDto.getVehicle_number());
		if(vehicle != null)
			throw new VehicleException(VehicleConstants.VEHICLE_ALREADY_EXISTS.toString());
		vehicleRepository.saveAndFlush(modelMapper.map(vehicleDto, Vehicle.class));
		return environment.getProperty(VehicleConstants.VEHICLE_CREATE_SUCCESS.toString())+" "+vehicleDto.getVehicle_number();
	}

	@Override
	public List<VehicleDTO> fetchAvailableVehicles() throws VehicleException {
		LOGGER.info("fetchAvailableVehicles method in service class");
		List<Vehicle> vehicles = vehicleRepository.getAllAvailableVehicles();
		if(vehicles.size() == 0)
			throw new VehicleException(VehicleConstants.VEHICLE_NOT_FOUND.toString());
		List<VehicleDTO> vehicleDTOs = new ArrayList<>();
		for(Vehicle vehicle : vehicles)
			vehicleDTOs.add(modelMapper.map(vehicle, VehicleDTO.class));
		LOGGER.info( environment.getProperty(VehicleConstants.VEHICLE_DETAILS_FOUND.toString()));
		return vehicleDTOs;
	}

	@Override
	public List<VehicleDTO> fetchVehicleDetailsByvehicle_name(String vehicle_name) throws VehicleException {
		LOGGER.info("fetchVehicleDetailsByvehicle_name method in service class");
		List<Vehicle> vehicles = vehicleRepository.getAllVehicleDetailsByvehicle_name(vehicle_name);
		if(vehicles.size() == 0)
			throw new VehicleException(environment.getProperty(VehicleConstants.VEHICLE_NOT_FOUND.toString()));
		List<VehicleDTO> vehicleDTOs = new ArrayList<>();
		for(Vehicle vehicle : vehicles)
			vehicleDTOs.add(modelMapper.map(vehicle, VehicleDTO.class));
		LOGGER.info(environment.getProperty(VehicleConstants.VEHICLE_DETAILS_FOUND.toString()));
		return vehicleDTOs;
	}

	@Override
	public VehicleDTO fetchVehicleDetailsByvehicle_number(String vehicle_number) throws VehicleException {
		LOGGER.info("fetchVehicleDetailsByvehicle_number method in service class");
		Vehicle vehicle = vehicleRepository.getVehicleDetailsByvehicle_number(vehicle_number);
		if(vehicle == null)
			throw new VehicleException(VehicleConstants.VEHICLE_NOT_FOUND.toString());
		LOGGER.info(environment.getProperty(VehicleConstants.VEHICLE_DETAILS_FOUND.toString()));
		return modelMapper.map(vehicle, VehicleDTO.class);
	}

	@Override
	public String updatevehicle_status(String vehicleNum, VehicleDTO vehicleDto) throws VehicleException {
		LOGGER.info("updatevehicle_status method in service class");
		Optional<Vehicle> vehicleOp = vehicleRepository.findById(vehicleNum);
		Vehicle existingVehicle = vehicleOp.get();
		if(vehicleOp.isEmpty())
			throw new VehicleException(VehicleConstants.VEHICLE_NOT_FOUND.toString());
		if(existingVehicle.getVehicle_status().equalsIgnoreCase(vehicleDto.getVehicle_status())) {
			String errorMsg = environment.getProperty(VehicleConstants.VEHICLE_UPDATE_ALREADY_EXISTS.toString()) + " " +vehicleDto.getVehicle_status();
			throw new VehicleException(errorMsg);
		}
		existingVehicle.setVehicle_status(vehicleDto.getVehicle_status());
		vehicleRepository.saveAndFlush(modelMapper.map(existingVehicle, Vehicle.class));
		return environment.getProperty(VehicleConstants.VEHICLE_UPDATE_SUCCESS.toString())+ " "+vehicleDto.getVehicle_status();
	}

	@Override
	public String removeVehicle(String vehicleNum) throws VehicleException {
		LOGGER.info("removeVehicle method in service class");
		Optional<Vehicle> vehicleOp = vehicleRepository.findById(vehicleNum);
		if(vehicleOp.isEmpty())
			throw new VehicleException(VehicleConstants.VEHICLE_NOT_FOUND.toString());
		vehicleRepository.deleteById(vehicleNum);
		return environment.getProperty(VehicleConstants.VEHICLE_DELETE_SUCCESS.toString());
	}
}

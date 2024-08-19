package com.ftr.vehicle.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftr.vehicle.dto.VehicleDTO;
import com.ftr.vehicle.exception.VehicleException;
import com.ftr.vehicle.service.VehicleService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin
@Validated
public class VehicleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleController.class);

	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping
	public  ResponseEntity<String> insertNewVehicle(@Valid @RequestBody VehicleDTO vehicleDto) throws VehicleException {
		LOGGER.info("insertNewVehicle method in Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(vehicleService.insertNewVehicle(vehicleDto));
	}
	
	@GetMapping
	public ResponseEntity<List<VehicleDTO>> fetchAvailableVehicles() throws VehicleException{
		LOGGER.info("fetchAvailableVehicles method in Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(vehicleService.fetchAvailableVehicles());
	}
	
	@GetMapping("/managed-name")
	public ResponseEntity<List<VehicleDTO>> fetchVehicleDetailsByvehicle_name(
			@NotEmpty(message="{vehicle.vehicle_name.must}")
			@RequestParam("vehicle_name") String vehicle_name) throws VehicleException{
		LOGGER.info("fetchAvailableVehicles method in Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(vehicleService.fetchVehicleDetailsByvehicle_name(vehicle_name));
	}
	
	@GetMapping("/managed-number")
	public ResponseEntity<VehicleDTO> fetchVehicleDetailsByvehicle_number(
			@NotEmpty(message = "{vehicle.vehicle_number.must}")
			@Pattern( regexp = "^[A-Z]{2}[0-9]{4}$", message = "{vehicle.vehicle_number.invalid}")
			@RequestParam("vehicle_number") String vehicle_number) throws VehicleException{
		LOGGER.info("fetchAvailableVehicles method in Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(vehicleService.fetchVehicleDetailsByvehicle_number(vehicle_number));
	}
	
	
	@PutMapping("/{vehicle_number}")
	public ResponseEntity<String> updatevehicle_status(
			@NotEmpty(message = "{vehicle.vehicle_number.must}")
			@Pattern( regexp = "^[A-Z]{2}[0-9]{4}$", message = "{vehicle.vehicle_number.invalid}")
			@PathVariable("vehicle_number") String vehicleNum, @Valid @RequestBody VehicleDTO vehicleDto) throws VehicleException{
		LOGGER.info("fetchAvailableVehicles method in Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(vehicleService.updatevehicle_status(vehicleNum, vehicleDto));
	}
	
	@DeleteMapping("/{vehicle_number}")
	public ResponseEntity<String> removeVehicle(
			@NotEmpty(message = "{vehicle.vehicle_number.must}")
			@Pattern( regexp = "^[A-Z]{2}[0-9]{4}$", message = "{vehicle.vehicle_number.invalid}")
			@PathVariable("vehicle_number") String vehicleNum) throws VehicleException{
		LOGGER.info("fetchAvailableVehicles method in Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(vehicleService.removeVehicle(vehicleNum));
	}
	
}

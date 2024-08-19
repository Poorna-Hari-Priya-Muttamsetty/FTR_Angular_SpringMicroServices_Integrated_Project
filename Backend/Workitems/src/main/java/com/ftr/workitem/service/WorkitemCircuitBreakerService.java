package com.ftr.workitem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ftr.workitem.dto.TerminalDTO;
import com.ftr.workitem.dto.VehicleDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class WorkitemCircuitBreakerService {
	
	@Autowired
	RestTemplate template;
	
	@CircuitBreaker(name = "workItemService", fallbackMethod = "getTerminalByIdFallback")
	public TerminalDTO getTerminalById(String terminalId){
		return template.getForObject("http://Terminals/FTR/terminals/fetchTerminalByTerminalId/"+ terminalId, TerminalDTO.class);
	}
	
	public TerminalDTO getTerminalByIdFallback(String terminalId, Throwable t){
		return new TerminalDTO();
	}
	
	
	@CircuitBreaker(name = "workItemService", fallbackMethod = "getVehicleByVehicleNumberFallback")
	public VehicleDTO getVehicleByVehicleNumber(String vehicleNumber){
		return template.getForObject("http://Vehicles/FTR/vehicles/managed-number?vehicle_number="+ vehicleNumber, VehicleDTO.class);
	}
	
	public VehicleDTO getVehicleByVehicleNumberFallback(String vehicleNumber, Throwable t){
		return new VehicleDTO();
	}
}
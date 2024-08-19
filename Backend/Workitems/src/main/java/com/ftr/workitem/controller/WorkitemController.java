package com.ftr.workitem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftr.workitem.dto.TerminalDTO;
import com.ftr.workitem.dto.WorkitemDTO;
import com.ftr.workitem.dto.WorkitemVehicleDTO;
import com.ftr.workitem.exception.WorkitemException;
import com.ftr.workitem.service.WorkitemService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/workItems")
@CrossOrigin
@Validated
public class WorkitemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkitemController.class);

	@Autowired
	private WorkitemService workitemService;
	
	@PostMapping
	public ResponseEntity<WorkitemDTO> createWorkitem(@Valid @RequestBody WorkitemDTO newWorkitem){
		LOGGER.info("createWorkitem method from Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(workitemService.createWorkitem(newWorkitem));
	}
	
	@PutMapping
	public ResponseEntity<String> updateWorkItem(@Valid @RequestBody WorkitemDTO workitemDTO) throws WorkitemException {
		LOGGER.info("updateWorkItem method from Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(workitemService.updateWorkitemId(workitemDTO));
	}
	
	@GetMapping
	public 	ResponseEntity<List<WorkitemDTO>> fetchWorkItemDetails() throws WorkitemException {
		LOGGER.info("fetchWorkItemDetails method from Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(workitemService.fetchWorkItemDetails());
	}
	
	@GetMapping("/{fromCountry}")
	public 	ResponseEntity<List<String>> fetchAvailableharbor_locations( @PathVariable("fromCountry") String fromCountry) throws WorkitemException {
		LOGGER.info("fetchAvailableharbor_locations method from Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(workitemService.fetchAvailableharbor_locations(fromCountry));
	}
	
	@GetMapping("/managed-user/{userId}")
	public 	ResponseEntity<List<WorkitemDTO>> trackWorkitemByUser(	
			@NotNull(message = "{workitem.userId.must}")
			@PathVariable("userId") Long userId) throws WorkitemException {
		LOGGER.info("trackWorkitemByUser method from Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(workitemService.trackWorkitemByUser(userId));
	}
	
	@GetMapping("/managed-status/{workItemId}")
	public 	ResponseEntity<String> fetchWorkItemStatus(@PathVariable("workItemId") String workitemId) throws WorkitemException {
		LOGGER.info("fetchWorkItemStatus method from Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(workitemService.fetchWorkItemStatus(workitemId));
	}
	
	@PutMapping("/managed-update/{workItemId}")
	public ResponseEntity<String> updateWorkItemStatus(@PathVariable("workItemId") String workitemId, @Valid @RequestBody TerminalDTO terminalDto) throws WorkitemException {
		LOGGER.info("updateWorkItemStatus method from Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(workitemService.updateWorkItemStatus(workitemId, terminalDto));
	}
	
	@PostMapping("/managed-terminal/{workItemId}/{terminalId}")
	public ResponseEntity<String> assignTerminalForWorkitem(@PathVariable("workItemId") String workitemId, String terminalId) throws WorkitemException {
		LOGGER.info("assignTerminalForWorkitem method from Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(workitemService.assignTerminalForWorkitem(workitemId, terminalId));
	}
	
	@GetMapping("/managed-vehicle/{vehicle_number}")
	public 	ResponseEntity<WorkitemDTO> fetchWorkItemDetailsByvehicle_number(@PathVariable("vehicle_number") String vehicle_number) throws WorkitemException {
		LOGGER.info("fetchWorkItemDetailsByvehicle_number method from Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(workitemService.fetchWorkItemDetailsByvehicle_number(vehicle_number));
	}
	
	@PostMapping("/managed-vehicle/{workItemId}")
	public ResponseEntity<String> allocateVehicle( @PathVariable("workItemId") String workitemId,@Valid @RequestBody List<WorkitemVehicleDTO> vehicleDtos) throws WorkitemException {
		LOGGER.info("allocateVehicle method from Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(workitemService.allocateVehicle(workitemId, vehicleDtos));
	}
}

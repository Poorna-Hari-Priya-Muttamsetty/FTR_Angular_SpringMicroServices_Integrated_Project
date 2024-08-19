package com.ftr.workitem.service;

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

import com.ftr.workitem.dto.TerminalDTO;
import com.ftr.workitem.dto.VehicleDTO;
import com.ftr.workitem.dto.WorkitemDTO;
import com.ftr.workitem.dto.WorkitemTerminalDTO;
import com.ftr.workitem.dto.WorkitemVehicleDTO;
import com.ftr.workitem.entity.Workitem;
import com.ftr.workitem.entity.WorkitemTerminal;
import com.ftr.workitem.entity.WorkitemVehicle;
import com.ftr.workitem.exception.WorkitemException;
import com.ftr.workitem.repository.HarborRepository;
import com.ftr.workitem.repository.WorkitemTerminalRepository;
import com.ftr.workitem.repository.WorkitemVehicleRepository;
import com.ftr.workitem.repository.WorkitemRepository;
import com.ftr.workitem.util.WorkitemConstants;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class WorkitemServiceImpl implements WorkitemService{

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkitemServiceImpl.class);

    @Autowired
	private WorkitemRepository workitemRepository;
	
	@Autowired
	private WorkitemTerminalRepository workitemTerminalRepository;
	
	@Autowired
	private WorkitemVehicleRepository workitemVehicleRepository;
	
	@Autowired
	private HarborRepository harborRepository;
	
	@Autowired
	private WorkitemCircuitBreakerService workitemCircuitBreakerService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private Environment environment;

	@Override
	public WorkitemDTO createWorkitem(WorkitemDTO workitemDto) {
		LOGGER.info("createWorkitem method from Service class");
		workitemRepository.saveAndFlush(modelMapper.map(workitemDto, Workitem.class));
		return workitemDto;
	}

	@Override
	public String updateWorkitemId(WorkitemDTO workitemDTO) throws WorkitemException {
		LOGGER.info("updateWorkitemId method from Service class");
		Optional<Workitem> workItemsOp = workitemRepository.findById(workitemDTO.getWorkitem_id());
		Workitem workItem = new Workitem();
		if(workItemsOp.isEmpty())
			throw new WorkitemException(WorkitemConstants.WORKITEM_NOT_FOUND.toString());
		workItem = workItemsOp.get();
		workItem.setShipping_date(workitemDTO.getShipping_date());
		workItem.setSelected_harbor_location(workitemDTO.getSelected_harbor_location());
		workitemRepository.saveAndFlush(workItem);
		return environment.getProperty(WorkitemConstants.WORKITEM_UPDATE_SUCCESS.toString());
	}

	@Override
	public List<String> fetchAvailableharbor_locations(String country) throws WorkitemException {
		LOGGER.info("fetchAvailableharbor_locations method from Service class");
		List<String> availableHarborLocations = harborRepository.getAllAvailableharbor_locations(country);
		if(availableHarborLocations.size() == 0)
			throw new WorkitemException(WorkitemConstants.HARBOR_NOT_FOUND.toString());
		return availableHarborLocations;
	}

	@Override
	public List<WorkitemDTO> fetchWorkItemDetails() throws WorkitemException {
		LOGGER.info("fetchWorkItemDetails method from Service class");
		List<Workitem> workItems = workitemRepository.findAll();
		if(workItems.size() == 0)
			throw new WorkitemException(WorkitemConstants.WORKITEM_NOT_FOUND.toString());
		List<WorkitemDTO> workitemDTOs = new ArrayList<>();
		for(Workitem workItem : workItems)
			workitemDTOs.add(modelMapper.map(workItem, WorkitemDTO.class));
		return workitemDTOs;
	}

	@Override
	public List<WorkitemDTO> trackWorkitemByUser(Long userId) throws WorkitemException {
		LOGGER.info("trackWorkitemByUser method from Service class");
		List<Workitem> workItems = workitemRepository.getAllWorkitemsByUserId(userId);
		if(workItems.size() == 0)
			throw new WorkitemException(WorkitemConstants.WORKITEM_NOT_FOUND.toString());
		List<WorkitemDTO> workitemDTOs = new ArrayList<>();
		for(Workitem workItem : workItems)
			workitemDTOs.add(modelMapper.map(workItem, WorkitemDTO.class));
		return workitemDTOs;
	}

	@Override
	public String fetchWorkItemStatus(String workitemId) throws WorkitemException {
		LOGGER.info("fetchWorkItemStatus method from Service class");
		WorkitemVehicle vehicle = workitemVehicleRepository.getWorkItemStatus(workitemId);
		if(vehicle == null)
			throw new WorkitemException(WorkitemConstants.VEHICLE_NOT_FOUND.toString());
		return vehicle.getAssigned_workitem_status();
	}

	@Override
	public String updateWorkItemStatus(String workitemId, TerminalDTO terminalDto) throws WorkitemException {
		LOGGER.info("updateWorkItemStatus method from Service class");
		Optional<Workitem> workitemOp = workitemRepository.findById(workitemId);
		Workitem workitem = new Workitem();
		if(workitemOp.isEmpty())
			throw new WorkitemException(WorkitemConstants.WORKITEM_NOT_FOUND.toString());
		workitem = workitemOp.get();
	    Optional<WorkitemVehicle> workitemVehicleOp = workitemVehicleRepository.findById(workitemId);
	    WorkitemVehicle workitemVehicle = new WorkitemVehicle();
		if(workitemVehicleOp.isEmpty())
			throw new WorkitemException(WorkitemConstants.VEHICLE_NOT_FOUND.toString());
		workitemVehicle = workitemVehicleOp.get();
	    workitemVehicle.setAssigned_workitem_status(terminalDto.getStatus());
	    workitemVehicleRepository.saveAndFlush(workitemVehicle);
	    return workitemId +" item status is updated to "+ terminalDto.getStatus();
	}

	@Override
	public WorkitemDTO fetchWorkItemById(String workitemId) throws WorkitemException {
		LOGGER.info("fetchWorkItemById method from Service class");
		Optional<Workitem> workItemsOp = workitemRepository.findById(workitemId);
		if(workItemsOp.isEmpty())
			throw new WorkitemException(WorkitemConstants.WORKITEM_NOT_FOUND.toString());
		return modelMapper.map(workItemsOp.get(), WorkitemDTO.class);
	}
	
	@Override
	public String assignTerminalForWorkitem(String workitemId, String terminalId) throws WorkitemException {
		LOGGER.info("assignTerminalForWorkitem method from Service class");
		Optional<Workitem> workitemOp = workitemRepository.findById(workitemId);
		if(workitemOp.isEmpty())
			throw new WorkitemException(WorkitemConstants.WORKITEM_NOT_FOUND.toString());
		TerminalDTO terminalDetails = workitemCircuitBreakerService.getTerminalById(terminalId);
		if(terminalDetails == null)
			throw new WorkitemException(WorkitemConstants.TERMINAL_NOT_AVAILABLE.toString());
		WorkitemTerminal workitemTerminal = new WorkitemTerminal();
		workitemTerminal.setWorkitem_id(workitemId);
		workitemTerminal.setTerminal_id(terminalId);
		workitemTerminalRepository.saveAndFlush(workitemTerminal);
		return environment.getProperty(WorkitemConstants.WORKITEM_TERMINAL_ALLOCATED.toString());
	}

	@Override
	public WorkitemTerminalDTO fetchTerminalByWorkitem(String workitemId) throws WorkitemException {
		LOGGER.info("fetchTerminalByWorkitem method from Service class");
		Optional<WorkitemTerminal> workitemTerminalOp = workitemTerminalRepository.findById(workitemId);
		WorkitemTerminal workitemTerminal = workitemTerminalOp.get();
		if(workitemTerminalOp.isEmpty())
			throw new WorkitemException(WorkitemConstants.TERMINAL_NOT_AVAILABLE.toString());
		return new WorkitemTerminalDTO(workitemTerminal.getWorkitem_id(), workitemTerminal.getTerminal_id());
	}

	@Override
	public WorkitemDTO fetchWorkItemDetailsByvehicle_number(String vehicle_number) throws WorkitemException {
		LOGGER.info("fetchWorkItemDetailsByvehicle_number method from Service class");
		WorkitemVehicle vehicle = workitemVehicleRepository.getWorkItemByvehicle_number(vehicle_number);
		if(vehicle == null)
			throw new WorkitemException(WorkitemConstants.VEHICLE_NOT_FOUND.toString());
		Optional<Workitem> workitemOp = workitemRepository.findById(vehicle.getWorkitem_id());
		Workitem workitem = workitemOp.get();
		if(workitemOp.isEmpty())
			throw new WorkitemException(WorkitemConstants.WORKITEM_NOT_FOUND.toString());
		return modelMapper.map(workitem, WorkitemDTO.class);
	}

	@Override
	public String allocateVehicle(String workitemId, List<WorkitemVehicleDTO> vehicleDtos) throws WorkitemException {
		LOGGER.info("assignTerminalForWorkitem method from Service class");
		Optional<Workitem> workitemOp = workitemRepository.findById(workitemId);
		if(workitemOp.isEmpty())
			throw new WorkitemException(WorkitemConstants.WORKITEM_NOT_FOUND.toString());
		for(WorkitemVehicleDTO vehicle : vehicleDtos) {
			VehicleDTO vehicleDetails = workitemCircuitBreakerService.getVehicleByVehicleNumber(vehicle.getVehicle_number());
			if(vehicleDetails == null)
				throw new WorkitemException(WorkitemConstants.VEHICLE_NOT_FOUND.toString());
			WorkitemVehicle workitemVehicle = new WorkitemVehicle();
			workitemVehicle.setWorkitem_id(workitemId);
			workitemVehicle.setVehicle_number(vehicle.getVehicle_number());
			workitemVehicle.setDriver_id(vehicle.getDriver_id());
			workitemVehicle.setAssigned_workitem_status(vehicle.getAssigned_workitem_status());
			workitemVehicleRepository.saveAndFlush(workitemVehicle);
		}
		return environment.getProperty(WorkitemConstants.WORKITEM_VEHICLE_ALLOCATED.toString());
	}

}

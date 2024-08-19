package com.ftr.workitem.service;

import java.util.List;

import com.ftr.workitem.dto.TerminalDTO;
import com.ftr.workitem.dto.WorkitemDTO;
import com.ftr.workitem.dto.WorkitemTerminalDTO;
import com.ftr.workitem.dto.WorkitemVehicleDTO;
import com.ftr.workitem.exception.WorkitemException;

public interface WorkitemService {

	WorkitemDTO createWorkitem(WorkitemDTO workitemDto);
	String updateWorkitemId(WorkitemDTO workitemDTO) throws WorkitemException;
	List<String> fetchAvailableharbor_locations(String country) throws WorkitemException;
	List<WorkitemDTO> fetchWorkItemDetails() throws WorkitemException;
	List<WorkitemDTO> trackWorkitemByUser(Long userId) throws WorkitemException;
	String fetchWorkItemStatus(String workitemId) throws WorkitemException;
	String updateWorkItemStatus(String workitemId, TerminalDTO terminalDto) throws WorkitemException;
	WorkitemDTO fetchWorkItemById(String workitemId) throws WorkitemException;
	String assignTerminalForWorkitem(String workitemId, String terminalId) throws WorkitemException;
	WorkitemTerminalDTO fetchTerminalByWorkitem(String workitemId) throws WorkitemException;
	WorkitemDTO fetchWorkItemDetailsByvehicle_number(String vehicle_number) throws WorkitemException;
	String allocateVehicle(String workitemId, List<WorkitemVehicleDTO> vehicleDto) throws WorkitemException;
}

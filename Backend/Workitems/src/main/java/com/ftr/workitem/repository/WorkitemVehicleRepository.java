package com.ftr.workitem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ftr.workitem.entity.WorkitemVehicle;

public interface WorkitemVehicleRepository extends JpaRepository<WorkitemVehicle, String>{

	@Query("select wv from WorkitemVehicle wv where wv.workitem_id = ?1")
	WorkitemVehicle getWorkItemStatus(String workitemId);
	
	@Query("select wv from WorkitemVehicle wv where wv.vehicle_number = ?1")
	WorkitemVehicle getWorkItemByvehicle_number(String vehicleNum);
}

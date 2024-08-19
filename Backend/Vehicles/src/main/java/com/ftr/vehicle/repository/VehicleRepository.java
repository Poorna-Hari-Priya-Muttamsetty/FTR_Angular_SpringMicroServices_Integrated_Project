package com.ftr.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ftr.vehicle.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String>{

	@Query("select v from Vehicle v where v.vehicle_status='Active'")
	List<Vehicle> getAllAvailableVehicles();
	
	@Query("select v from Vehicle v where v.vehicle_name = ?1")
	List<Vehicle> getAllVehicleDetailsByvehicle_name(String vehicle_name);
	
	@Query("select v from Vehicle v where v.vehicle_number = ?1")
	Vehicle getVehicleDetailsByvehicle_number(String vehicle_number);
}

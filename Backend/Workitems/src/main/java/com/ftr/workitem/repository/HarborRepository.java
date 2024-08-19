package com.ftr.workitem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ftr.workitem.entity.Harbor;


public interface HarborRepository extends JpaRepository<Harbor, String>{

	@Query("select h.available_harbor_locations from Harbor h where h.country = ?1")
	List<String> getAllAvailableharbor_locations(String country);
}

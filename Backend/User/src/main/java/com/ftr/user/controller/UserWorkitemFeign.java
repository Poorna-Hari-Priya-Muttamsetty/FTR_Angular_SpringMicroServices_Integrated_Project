package com.ftr.user.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ftr.user.dto.WorkitemDTO;

import jakarta.validation.Valid;

@FeignClient(name = "workitem-service", url = "http://localhost:9994/FTR/workItems")
public interface UserWorkitemFeign {

	@PutMapping("/{workItemId}")
	String updateWorkItem(WorkitemDTO workitemDTO);
	
	@PostMapping
	WorkitemDTO createworkItem(@Valid @RequestBody WorkitemDTO workitemDTO);
	
	@GetMapping("/{fromCountry}")
	List<String> fetchAvailableharbor_locations(@PathVariable("fromCountry") String fromCountry);
}

package com.ftr.workitem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ftr.workitem.entity.Workitem;

public interface WorkitemRepository extends JpaRepository<Workitem,String>{

	@Query("select w from Workitem w where w.user_id = ?1")
	List<Workitem> getAllWorkitemsByUserId(Long userId);
}

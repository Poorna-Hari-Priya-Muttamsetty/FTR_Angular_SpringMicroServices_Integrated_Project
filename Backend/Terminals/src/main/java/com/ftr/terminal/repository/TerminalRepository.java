package com.ftr.terminal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ftr.terminal.entity.Terminal;

public interface TerminalRepository extends JpaRepository<Terminal, String>{

	@Query("select t from Terminal t where t.item_type = ?1 ")
	List<Terminal> getTerminalsByItemType(String itemType);
	
	@Query("select t from Terminal t where t.terminal_id = ?1 ")
	Terminal getTerminalsByTerminalId(String terminalId);
}

package com.ftr.terminal.service;

import java.util.List;

import com.ftr.terminal.dto.TerminalDTO;
import com.ftr.terminal.exception.TerminalException;

public interface TerminalService {

	List<TerminalDTO> fetchFTRTerminals() throws TerminalException;
	List<TerminalDTO> fetchTerminalsByItemType(String itemType) throws TerminalException;
	TerminalDTO  insertNewTerminal(TerminalDTO terminalDTO) throws TerminalException;
	TerminalDTO fetchFTRTerminalByTerminalId(String terminalId) throws TerminalException;
	String updateTerminal(String terminalId, Long newCapacity) throws TerminalException;
	String updateTerminalStatus(String terminalId, String status) throws TerminalException;
	String deleteTerminal(String terminalId) throws TerminalException;
}

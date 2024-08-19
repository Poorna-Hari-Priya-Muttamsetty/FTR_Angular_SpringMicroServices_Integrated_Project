package com.ftr.terminal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftr.terminal.dto.TerminalDTO;
import com.ftr.terminal.exception.TerminalException;
import com.ftr.terminal.service.TerminalService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@RestController
@RequestMapping("/terminals")
@CrossOrigin
@Validated
public class TerminalController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TerminalController.class);

	@Autowired
	private TerminalService terminalService;
	
	@GetMapping
	public ResponseEntity<List<TerminalDTO>> fetchFTRTerminals() throws TerminalException{
		LOGGER.info("fetchFTRTerminals method in Controller class");
		return ResponseEntity.status(HttpStatus.CREATED).body(terminalService.fetchFTRTerminals());
	}
	
	@GetMapping("/fetchTerminalByTerminalId/{terminalId}")
	public ResponseEntity<TerminalDTO> fetchTerminalByTerminalId(@PathVariable("terminalId") String terminalId) throws TerminalException{
		LOGGER.info("fetchTerminalByTerminalId method in Controller class");
		return ResponseEntity.status(HttpStatus.CREATED).body(terminalService.fetchFTRTerminalByTerminalId(terminalId));
	}
	
	@GetMapping("/fetchTerminalsByItemType/{itemType}")
	public ResponseEntity<List<TerminalDTO>> fetchTerminalsByItemType(	
			@NotEmpty(message="{terminal.itemType.must}")
			@Size(min = 4, max = 30, message = "{terminal.itemType.invalid}") 
			@PathVariable("itemType") String itemType) throws TerminalException{
		LOGGER.info("fetchTerminalsByItemType method in Controller class");
		return ResponseEntity.status(HttpStatus.CREATED).body(terminalService.fetchTerminalsByItemType(itemType));
	}
	
	@PostMapping
	public ResponseEntity<TerminalDTO> insertNewTerminal(@Valid @RequestBody TerminalDTO terminalDTO) throws TerminalException {
		LOGGER.info("insertNewTerminal method in Controller class");
		return ResponseEntity.status(HttpStatus.CREATED).body(terminalService.insertNewTerminal(terminalDTO));
	}
	
	@PutMapping("/{terminalId}/{newCapacity}")
	public ResponseEntity<String> updateTerminal( @PathVariable("terminalId") String terminalId, 
			@NotNull(message="{terminal.capacity.must}")
			@Max( value=99999, message = "{terminal.capacity.invalid}")
			@PathVariable("newCapacity") Long newCapacity) throws TerminalException {
		LOGGER.info("updateTerminal method in Controller class");
		return ResponseEntity.status(HttpStatus.CREATED).body(terminalService.updateTerminal(terminalId, newCapacity));
	}
	
	
	@PutMapping("/{terminalId}")
	public ResponseEntity<String> updateTerminalStatus( @PathVariable("terminalId") String terminalId, 
			@NotEmpty(message ="{terminal.status.must}")
    		@Pattern(regexp = "Available|NotAvailable", message = "{terminal.status.invalid}")
			@RequestParam("status") String status) throws TerminalException {
		LOGGER.info("updateTerminalStatus method in Controller class");
		return ResponseEntity.status(HttpStatus.CREATED).body(terminalService.updateTerminalStatus(terminalId, status));
	}
	
	@DeleteMapping("/{terminalId}")
	public ResponseEntity<String> removeTerminal(@PathVariable("terminalId") String terminalId) throws TerminalException {
		LOGGER.info("removeTerminal method in Controller class");
		return ResponseEntity.status(HttpStatus.CREATED).body(terminalService.deleteTerminal(terminalId));
	}
}

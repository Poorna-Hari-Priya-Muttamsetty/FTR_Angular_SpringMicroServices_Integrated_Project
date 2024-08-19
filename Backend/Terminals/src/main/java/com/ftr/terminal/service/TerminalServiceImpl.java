package com.ftr.terminal.service;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.ftr.terminal.dto.TerminalDTO;
import com.ftr.terminal.entity.Terminal;
import com.ftr.terminal.exception.TerminalException;
import com.ftr.terminal.repository.TerminalRepository;
import com.ftr.terminal.util.TerminalConstants;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class TerminalServiceImpl implements TerminalService{

    private static final Logger LOGGER = LoggerFactory.getLogger(TerminalService.class);

    @Autowired
	private TerminalRepository terminalRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private Environment environment;

	@Override
	public List<TerminalDTO> fetchFTRTerminals() throws TerminalException {
		LOGGER.info("fetchFTRTerminals method in Service Class");
		List<Terminal> terminals = terminalRepository.findAll();
		if(terminals.size() == 0)
			throw new TerminalException(TerminalConstants.TERMINAL_EMPTY.toString());
		List<TerminalDTO> terminalDTOs = new ArrayList<>();
		for(Terminal terminal : terminals)
			terminalDTOs.add(modelMapper.map(terminal, TerminalDTO.class));
		return terminalDTOs;
	}

	@Override
	public List<TerminalDTO> fetchTerminalsByItemType(String itemType) throws TerminalException {
		LOGGER.info("fetchTerminalsByItemType method in Service Class");
		List<Terminal> terminals = terminalRepository.getTerminalsByItemType(itemType);
		if(terminals.size() == 0)
			throw new TerminalException(TerminalConstants.TERMINAL_ITEMTYPE_NOT_FOUND.toString());
		List<TerminalDTO> terminalDTOs = new ArrayList<>();
		for(Terminal terminal : terminals)
			terminalDTOs.add(modelMapper.map(terminal, TerminalDTO.class));
		return terminalDTOs;
	}

	@Override
	public TerminalDTO insertNewTerminal(TerminalDTO terminalDTO) throws TerminalException {
		LOGGER.info("insertNewTerminal method in Service Class");
		Terminal terminalDetails = terminalRepository.getTerminalsByTerminalId(terminalDTO.getTerminal_id());
		if(terminalDetails != null )
			throw new TerminalException(TerminalConstants.TERMINAL_ALREADY_EXISTS.toString());
		terminalRepository.saveAndFlush(modelMapper.map(terminalDTO, Terminal.class));
		return terminalDTO;
	}

	@Override
	public String updateTerminal(String terminalId, Long newCapacity) throws TerminalException {
		LOGGER.info("updateTerminal method in Service Class");
		Terminal terminalDetails = terminalRepository.getTerminalsByTerminalId(terminalId);
		if(terminalDetails == null )
			throw new TerminalException(TerminalConstants.TERMINAL_NOT_FOUND.toString());
		if(newCapacity >= terminalDetails.getCapacity())
			throw new TerminalException(TerminalConstants.TERMINAL_CAPACITY_FAILED.toString());
		terminalDetails.setCapacity(newCapacity);
		terminalRepository.saveAndFlush(terminalDetails);
		return environment.getProperty(TerminalConstants.TERMINAL_UPDATE_SUCCESS.toString()) + " "+terminalId;
	}


	@Override
	public String updateTerminalStatus(String terminalId, String status) throws TerminalException {
		LOGGER.info("updateTerminalStatus method in Service Class");
		Terminal terminalDetails = terminalRepository.getTerminalsByTerminalId(terminalId);
		if(terminalDetails == null )
			throw new TerminalException(TerminalConstants.TERMINAL_NOT_FOUND.toString());
		terminalDetails.setStatus(status);
		terminalRepository.saveAndFlush(terminalDetails);
		return environment.getProperty(TerminalConstants.TERMINAL_STATUS_UPDATE_SUCCESS.toString()) + " "+terminalId;
	}
	
	@Override
	public TerminalDTO fetchFTRTerminalByTerminalId(String terminalId) throws TerminalException {
		LOGGER.info("fetchFTRTerminalByTerminalId method in Service Class");
		Terminal terminalDetails = terminalRepository.getTerminalsByTerminalId(terminalId);
		if(terminalDetails == null )
			throw new TerminalException(TerminalConstants.TERMINAL_NOT_FOUND.toString());
		return modelMapper.map(terminalDetails, TerminalDTO.class);
	}

	@Override
	public String deleteTerminal(String terminalId) throws TerminalException {
		LOGGER.info("deleteTerminal method in Service Class");
		Terminal terminalDetails = terminalRepository.getTerminalsByTerminalId(terminalId);
		if(terminalDetails == null )
			throw new TerminalException(TerminalConstants.TERMINAL_NOT_FOUND.toString());
		terminalRepository.deleteById(terminalId);
		return environment.getProperty(TerminalConstants.TERMINAL_DELETE_SUCCESS.toString())+" "+terminalId;
	}

}

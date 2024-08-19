package com.ftr.user.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.ftr.user.dto.LoginDTO;
import com.ftr.user.dto.UpdateUserDTO;
import com.ftr.user.dto.UserDTO;
import com.ftr.user.entity.User;
import com.ftr.user.exception.UserException;
import com.ftr.user.repository.UserRepository;
import com.ftr.user.util.UserConstants;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class UserServiceImpl implements UserService{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private Environment environment;

	@Override
	public String createUser(UserDTO userDto) {
		LOGGER.info("createUser method in Service class");
		userRepository.saveAndFlush(modelMapper.map(userDto, User.class));
		return environment.getProperty(UserConstants.USER_CREATE_SUCCESS.toString());
	}

	@Override
	public String updateUser(Long userId,  UpdateUserDTO updateUserDTO) throws UserException {
		LOGGER.info("updateUser method in Service class");
		Optional<User> userOp = userRepository.findById(userId);
		User user = userOp.get();
		if(userOp.isEmpty())
			throw new UserException(UserConstants.USER_NOT_FOUND.toString());
		user.setMobile_number(updateUserDTO.getMobile_number());
		user.setPermanent_address(updateUserDTO.getPermanent_address());
		user.setOffice_address(updateUserDTO.getOffice_address());
		userRepository.saveAndFlush(userRepository.saveAndFlush(user));
		return environment.getProperty(UserConstants.USER_UPDATE_SUCCESS.toString())+ " "+userId;
	}

	@Override
	public String updateUserByEmailId(String emailId, UpdateUserDTO updateUserDTO) throws UserException {
		LOGGER.info("updateUserByEmailId method in Service class");
		Optional<User> userOp = userRepository.findByEmailId(emailId);
		User user = userOp.get();
		if(userOp.isEmpty())
			throw new UserException(UserConstants.USER_NOT_FOUND.toString());
		user.setMobile_number(updateUserDTO.getMobile_number());
		user.setPermanent_address(updateUserDTO.getPermanent_address());
		user.setOffice_address(updateUserDTO.getOffice_address());
		userRepository.saveAndFlush(userRepository.saveAndFlush(user));
		return environment.getProperty(UserConstants.USER_UPDATE_SUCCESS.toString())+ " "+user.getUser_id();
	}
	
	@Override
	public UserDTO viewUserProfile(Long userId) throws UserException {
		LOGGER.info("viewUserProfile method in Service class");
		Optional<User> userOp = userRepository.findById(userId);
		User user= userOp.get();
		if(userOp.isEmpty())
			throw new UserException(UserConstants.USER_NOT_FOUND.toString());
		return modelMapper.map(user, UserDTO.class);
	}

	@Override
	public String deleteUser(Long userId) throws UserException {
		LOGGER.info("deleteUser method in Service class");
		Optional<User> userOp = userRepository.findById(userId);
		User user= userOp.get();
		if(userOp.isEmpty())
			throw new UserException(UserConstants.USER_NOT_FOUND.toString());
		userRepository.delete(user);
		return environment.getProperty(UserConstants.USER_DELETE_SUCCESS.toString());
	}
	
	@Override
	public String deleteUserByEmailId(String emailId) throws UserException {
		LOGGER.info("deleteUser method in Service class");
		Optional<User> userOp = userRepository.findByEmailId(emailId);
		User user= userOp.get();
		if(userOp.isEmpty())
			throw new UserException(UserConstants.USER_NOT_FOUND.toString());
		userRepository.delete(user);
		return environment.getProperty(UserConstants.USER_DELETE_SUCCESS.toString());
	}

	public String loginUser(LoginDTO loginDTO) throws UserException {
		LOGGER.info("loginUser method in Service class");
		Optional<User> userOp = userRepository.findByEmailId(loginDTO.getUser_name());
		if(userOp.isEmpty()) 
			throw new UserException(environment.getProperty(UserConstants.USER_NOT_FOUND.toString()));

		User user = userOp.get();
		if( ! user.getPassword().equals(loginDTO.getPassword())) 
			throw new UserException(environment.getProperty(UserConstants.USER_LOGIN_FAILED.toString()));
		 return environment.getProperty(UserConstants.USER_LOGIN_SUCCESS.toString());
	}

	@Override
	public UserDTO viewUserProfileByEmailId(String emailId) throws UserException {
		LOGGER.info("viewUserProfileByEmailId method in Service class");
		Optional<User> userOp = userRepository.findByEmailId(emailId);
		if(userOp.isEmpty()) 
			throw new UserException(environment.getProperty(UserConstants.USER_NOT_FOUND.toString()));
		return modelMapper.map(userOp.get(), UserDTO.class);
	}
	
}

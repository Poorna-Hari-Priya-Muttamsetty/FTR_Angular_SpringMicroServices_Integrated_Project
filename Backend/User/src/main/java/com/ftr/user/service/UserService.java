package com.ftr.user.service;

import com.ftr.user.dto.LoginDTO;
import com.ftr.user.dto.UpdateUserDTO;
import com.ftr.user.dto.UserDTO;
import com.ftr.user.exception.UserException;

public interface UserService {

	String createUser(UserDTO userDto);
	String updateUser(Long userId,  UpdateUserDTO updateUserDTO) throws UserException;
	String updateUserByEmailId(String emailId,  UpdateUserDTO updateUserDTO) throws UserException;
	UserDTO viewUserProfile(Long userId) throws UserException;
	String deleteUser(Long userId) throws UserException;
	String deleteUserByEmailId(String emailId) throws UserException;
	String loginUser(LoginDTO loginDto) throws UserException;
	UserDTO viewUserProfileByEmailId(String emailId)  throws UserException;
}

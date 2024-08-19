package com.ftr.user.controller;

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

import com.ftr.user.dto.LoginDTO;
import com.ftr.user.dto.UpdateUserDTO;
import com.ftr.user.dto.UserDTO;
import com.ftr.user.dto.WorkitemDTO;
import com.ftr.user.exception.UserException;
import com.ftr.user.service.UserService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Validated
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserWorkitemFeign userWorkitemFeign;
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO ) throws UserException{
		System.out.println("loginUser method in Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(userService.loginUser(loginDTO));
	}
	
    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDto) {
		LOGGER.info("createUser method in Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(userDto));
    }
    
    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(
    		@NotEmpty(message = "{user.email.must}")
    		@Email(message="{user.email.invalid}")
    		@PathVariable("userId") Long userId, @Valid @RequestBody UpdateUserDTO updateUserDTO) throws UserException {
		LOGGER.info("updateUser method in Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userId, updateUserDTO));
    }
    
    @PutMapping
    public ResponseEntity<String> updateUserByEmailId(	
    		@NotEmpty(message = "{user.email.must}")
    		@Email(message="{user.email.invalid}")
    		@RequestParam("emailId") String emailId, @Valid @RequestBody UpdateUserDTO updateUserDTO) throws UserException {
		LOGGER.info("updateUser method in Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserByEmailId(emailId, updateUserDTO));
    }
    
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> fetchUser(@PathVariable("userId") Long userId) throws UserException {
		LOGGER.info("fetchUser method in Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(userService.viewUserProfile(userId));
    }
    
    @GetMapping
    public ResponseEntity<UserDTO> fetchUserByEmailId(
    		@NotEmpty(message = "{user.email.must}")
    		@Email(message="{user.email.invalid}")
    		@RequestParam("emailId") String emailId) throws UserException {
		LOGGER.info("viewUserProfileByEmailId method in Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(userService.viewUserProfileByEmailId(emailId));
    }
    
    
    @DeleteMapping
    public ResponseEntity<String> deleteUserByEmailId(@NotEmpty(message = "{user.email.must}")
		@Email(message="{user.email.invalid}")
    	@RequestParam("emailId") String emailId) throws UserException {
		LOGGER.info("deleteUser method in Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUserByEmailId(emailId));
    }
    
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) throws UserException {
		LOGGER.info("deleteUser method in Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(userId));
    }
    
    @PostMapping("/createWorkItem")
    public ResponseEntity<WorkitemDTO> createWorkItem(@RequestBody WorkitemDTO newWorkitem) {
		LOGGER.info("createWorkItem method in User Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(userWorkitemFeign.createworkItem(newWorkitem));
    }
    
    @PutMapping("/updateWorkItem")
    public ResponseEntity<String> updateWorkItem(@Valid @RequestBody WorkitemDTO workitemDTO) {
		LOGGER.info("updateWorkItem method in User Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(userWorkitemFeign.updateWorkItem(workitemDTO));
    }
    
    @GetMapping("/fetchAvailableharbor_locations/{fromCountry}")
    public ResponseEntity<List<String>> fetchAvailableharbor_locations(@PathVariable("fromCountry") String fromCountry) {
		LOGGER.info("fetchAvailableharbor_locations method in User Controller class");
		return ResponseEntity.status(HttpStatus.OK).body(userWorkitemFeign.fetchAvailableharbor_locations(fromCountry));
    }
}

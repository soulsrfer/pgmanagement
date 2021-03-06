package com.gopalpg.pgManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopalpg.pgManagement.entity.UserEntity;
import com.gopalpg.pgManagement.model.LoginModel;
import com.gopalpg.pgManagement.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	// build create user REST API

	@PostMapping("/createUser")
	public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
		return new ResponseEntity<UserEntity>(userService.saveUser(user), HttpStatus.CREATED);
	}

	// build get all user REST API
	@GetMapping("/getAllUsers")
	public List<UserEntity> getAllUsers() {
		return userService.getAllUsers();
	}

	// build get user by id REST API
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable(value = "userId") Long UserId) {
		return new ResponseEntity<UserEntity>(userService.getUserById(UserId), HttpStatus.OK);
	}

	// build update User REST API
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable("userId") Long UserId, @RequestBody UserEntity user) {
		return new ResponseEntity<UserEntity>(userService.updateUser(user, UserId), HttpStatus.OK);
	}

	// build delete User REST API
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "userId") Long UserId) {
		userService.deleteUser(UserId);
		return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
	}

	@PostMapping(value = "login")
	public ResponseEntity<UserEntity> login(@RequestBody LoginModel loginModel) {
		return new ResponseEntity<UserEntity>(userService.login(loginModel), HttpStatus.OK);
	}

}

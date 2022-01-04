package com.telecom.pocstartup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.pocstartup.domain.User;
import com.telecom.pocstartup.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	List<User> findAllUsers(){
		return this.userService.findAllUsers();
	}
}

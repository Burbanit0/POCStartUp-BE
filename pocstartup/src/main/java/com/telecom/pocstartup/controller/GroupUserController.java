package com.telecom.pocstartup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.pocstartup.service.GroupUserService;
import com.telecom.pocstartup.service.ProjectService;
import com.telecom.pocstartup.service.UserService;

@RestController
public class GroupUserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private GroupUserService groupuserService;
	
}

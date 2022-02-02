package com.telecom.pocstartup.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.telecom.pocstartup.domain.GroupUser;
import com.telecom.pocstartup.domain.Project;
import com.telecom.pocstartup.domain.User;
import com.telecom.pocstartup.service.GroupUserService;
import com.telecom.pocstartup.service.ProjectService;
import com.telecom.pocstartup.service.UserService;
import com.telecom.pocstartup.utils.ListIds;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private GroupUserService groupuserService;

	@GetMapping("/users")
	List<User> findAllUsers() {
		return this.userService.findAllUsers();
	}

	@GetMapping("/users/{id}")
	User findUserById(@PathVariable Long id) {
		return this.findUserById(id);
	}

	@GetMapping("/users/{id}/projects")
	Set<Project> findProjects(@PathVariable Long id) {
		return this.findUserById(id).getProjects();
	}

	@GetMapping("/users/{idUser}/projects/{idProject}")
	Project findProjectsById(@PathVariable("idUser") Long idUser, @PathVariable("idProject") Long idProject) {
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("apiFilter", SimpleBeanPropertyFilter.serializeAllExcept(""));
		
		Project project = this.projectService.findProjectById(idProject);
		if (project.getUsers().contains(userService.findUserById(idUser))) {
			return project;
		} else {
			return null;
		}
	}

//	@GetMapping("/users/{idUser}/groupusers/{idGroupuser}")
//	Set<User> findUsersByGroupuserId(@PathVariable("idUser") Long idUser,
//			@PathVariable("idGroupuser") Long idGroupuser) {
//
//		Object currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		
//		GroupUser groupuser = groupuserService.findGroupuserById(idGroupuser);
//		if (groupuser.getManager() == userService.findUserById(idUser)) {
//			return groupuser.getUsers();
//		} else {
//			return null;
//		}
//	}

	@GetMapping("/users/{idManager}/groupuser")
	MappingJacksonValue findUsersByGroupuserId(@PathVariable("idManager") Long idManager) {
		if (userService.findUserById(idManager).getManageGroupUser() == null) {
			return null;
		}
		GroupUser groupuser = userService.findUserById(idManager).getManageGroupUser(); 
		
	    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name", "username","email");
	    FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);
	    MappingJacksonValue mapping = new MappingJacksonValue(groupuser.getUsers());
	    mapping.setFilters(filters);

	    return mapping;
		
	}

	@PatchMapping("/users/{idManager}/groupuser/users")
	GroupUser addUsertoGroupById(@PathVariable("idManager") Long idManager,@RequestBody ListIds usersIds) {

		User manager = userService.findUserById(idManager);
		
		if (manager.getManageGroupUser() == null) {
			GroupUser groupuser = new GroupUser();
			groupuserService.createGroupUser(groupuser,manager);
		}
		GroupUser groupuser = manager.getManageGroupUser();
		userService.addUsersToGroup(usersIds, groupuser);
		return groupuser;

	}
	
}

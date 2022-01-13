package com.telecom.pocstartup.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.telecom.pocstartup.domain.Project;
import com.telecom.pocstartup.domain.User;
import com.telecom.pocstartup.service.ProjectService;
import com.telecom.pocstartup.service.UserService;
import com.telecom.pocstartup.utils.ListIds;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/projects")
	List<Project> findAllProjects(){
		return this.projectService.findAllProjects();
	};
	
	@GetMapping("/projects/{id}")
	Project findProjectById(@PathVariable Long id) {
		return this.projectService.findProjectById(id);
	}
	
	@GetMapping("/projects/{id}/users")
	Set<User> findUsersByProjectId(@PathVariable Long id) {
		return this.projectService.findProjectById(id).getUsers();
	}
	
	@PostMapping("/projects")
	Project createProject(@Valid @RequestBody Project project) {
		
		return this.projectService.createProject(project);
	}
	
	@PatchMapping("/projects/{id}/users")
	Project addUsers(@PathVariable Long id,@RequestBody ListIds usersIds) {
		
		Project project = this.projectService.findProjectById(id);
		userService.addUsers(usersIds, project);
		return this.projectService.findProjectById(id);
	}

}

package com.telecom.pocstartup.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.pocstartup.domain.Project;
import com.telecom.pocstartup.domain.User;
import com.telecom.pocstartup.service.ProjectService;
import com.telecom.pocstartup.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;

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
		Project project = this.projectService.findProjectById(idProject);
		if (project.getUsers().contains(userService.findUserById(idUser))) {
			return project;
		} else {
			return null;
		}
	}
	
}

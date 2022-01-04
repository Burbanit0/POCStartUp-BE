package com.telecom.pocstartup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.pocstartup.domain.Project;
import com.telecom.pocstartup.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/projects")
	List<Project> findAllProjects(){
		return this.projectService.findAllProjects();
	};
}

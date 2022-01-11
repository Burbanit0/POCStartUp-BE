package com.telecom.pocstartup.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/projects/{id}")
	Project findProjectById(@PathVariable Long id) {
		return this.projectService.findProjectById(id);
	}
	
	@PostMapping("/projects")
	Project createProject(@Valid @RequestBody Project project) {
		
		return this.projectService.createProject(project);
	}
}

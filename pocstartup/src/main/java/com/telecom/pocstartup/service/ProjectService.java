package com.telecom.pocstartup.service;

import java.util.List;

import com.telecom.pocstartup.domain.Project;
import com.telecom.pocstartup.domain.User;

public interface ProjectService {
	public List<Project> findAllProjects();
	public Project findProjectById(Long id);
	public Project createProject(Project project);
	
}

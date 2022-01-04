package com.telecom.pocstartup.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.pocstartup.domain.Project;
import com.telecom.pocstartup.repository.ProjectRepository;
import com.telecom.pocstartup.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> findAllProjects() {
		return this.projectRepository.findAll();
	}
}
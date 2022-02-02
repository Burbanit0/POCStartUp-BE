package com.telecom.pocstartup.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.telecom.pocstartup.domain.Project;
import com.telecom.pocstartup.domain.User;
import com.telecom.pocstartup.domain.WorkTime;
import com.telecom.pocstartup.service.GroupUserService;
import com.telecom.pocstartup.service.ProjectService;
import com.telecom.pocstartup.service.UserService;
import com.telecom.pocstartup.service.WorkTimeService;

public class WorkTimeController {

	@Autowired
	private WorkTimeService worktimeService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private GroupUserService groupuserService;
	
	@GetMapping("/users/{idUser}/projects/{idProject}/worktimes")
	List<WorkTime> findAllWorktimesByProject(@PathVariable("idUser") Long idUser, @PathVariable("idProject") Long idProject){
		
		User user = userService.findUserById(idUser);
		Project project = projectService.findProjectById(idProject);
		
		List<WorkTime> wtForProject = new ArrayList<WorkTime>();
		Set<WorkTime> userWorktimes = user.getWorkTimes();
		for(WorkTime wt : userWorktimes) {
			if(wt.getProject()==project) {
				wtForProject.add(wt);
			}
		}
		
		return wtForProject;
	}

}

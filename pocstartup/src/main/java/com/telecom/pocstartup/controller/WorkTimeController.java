package com.telecom.pocstartup.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.pocstartup.domain.Project;
import com.telecom.pocstartup.domain.User;
import com.telecom.pocstartup.domain.WorkTime;
import com.telecom.pocstartup.service.GroupUserService;
import com.telecom.pocstartup.service.ProjectService;
import com.telecom.pocstartup.service.UserService;
import com.telecom.pocstartup.service.WorkTimeService;
import com.telecom.pocstartup.utils.WorkTimeData;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
	
	@GetMapping("/users/{id}/worktimes")
	Set<WorkTime> getWorkTimes(@PathVariable("idUser") Long idUser) {
		User user = userService.findUserById(idUser);
		return user.getWorkTimes();
	}
	
	@PostMapping("/users/{idUser}/projects/{idProject}/worktimes")
	WorkTime createWorkTimes(@PathVariable("idUser") Long idUser,@PathVariable("idProject") Long idProject,@Valid @RequestBody WorkTimeData worktimedata) {
		WorkTime worktime = new WorkTime();
		User user = userService.findUserById(idUser);
		Project project = projectService.findProjectById(idProject);
		worktime.setDuration(worktimedata.getDuration());
		worktime.setDate(worktimedata.getDate());
		worktime.setProject(project);
		worktime.setUser(user);
		return worktimeService.createWorkTime(worktime);
	}

}

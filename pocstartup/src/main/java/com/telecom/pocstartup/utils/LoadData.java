package com.telecom.pocstartup.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.telecom.pocstartup.domain.GroupUser;
import com.telecom.pocstartup.domain.Project;
import com.telecom.pocstartup.domain.User;
import com.telecom.pocstartup.domain.WorkTime;
import com.telecom.pocstartup.repository.GroupRepository;
import com.telecom.pocstartup.repository.ProjectRepository;
import com.telecom.pocstartup.repository.UserRepository;
import com.telecom.pocstartup.repository.WorkTimeRepository;

import org.springframework.boot.CommandLineRunner;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadData {

	@Bean
	@Profile("!test")
	CommandLineRunner initDatabase(UserRepository userRepository, 
			ProjectRepository projectRepository,
			WorkTimeRepository workTimeRepository, 
			GroupRepository groupRepository) {
		return args -> {
			initData(userRepository,projectRepository,workTimeRepository,groupRepository);
		};
	}

	private void initData(UserRepository  userRepository, ProjectRepository projectRepository, WorkTimeRepository workTimeRepository, GroupRepository groupRepository) {
		
//		Project project1 = new Project();
//		project1.setName("project1");
//		projectRepository.save(project1);
//		
//		Project project2 = new Project();
//		project2.setName("project2");
//		projectRepository.save(project2);
//		
//		User user1 = new User();
//		user1.setName("admin");
//		user1.setUsername("adminl");
//		user1.setRoles("ADMIN");
//		user1.addProject(project1);
//
//
//		User user2 = new User();
//		user2.setName("manager");
//		user2.setUsername("managerl");
//		user2.setRoles("MANAGER");
//		user2.addProject(project2);
//
//		
//		User user3 = new User();
//		user3.setName("user");
//		user3.setUsername("userl");
//		user3.setRoles("USER");
//		user3.addProject(project2);
//
//		
//		userRepository.save(user1);
//		userRepository.save(user2);
//		userRepository.save(user3);
//		
//		WorkTime worktime1 = new WorkTime();
//		worktime1.setProject(project1);
//		worktime1.setDuration(2L);
//		worktime1.setUser(user1);
//		workTimeRepository.save(worktime1);
//		
//		WorkTime worktime2 = new WorkTime();
//		worktime2.setProject(project2);
//		worktime2.setDuration(1L);
//		worktime2.setUser(user2);
//		workTimeRepository.save(worktime2);
//		
//		GroupUser group = new GroupUser();
//		group.setManager(user1);
//		group.addUser(user2);
//		group.addUser(user3);
//		groupRepository.save(group);
//		
//		userRepository.save(user1);
//		userRepository.save(user2);
//		userRepository.save(user3);
//		
	};
	
}

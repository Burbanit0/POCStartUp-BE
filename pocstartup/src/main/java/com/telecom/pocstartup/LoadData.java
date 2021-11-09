package com.telecom.pocstartup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import domain.User;

import org.springframework.boot.CommandLineRunner;

import lombok.extern.slf4j.Slf4j;
import repository.CredentialRepository;
import repository.ProjectRepository;
import repository.UserRepository;
import repository.WorkTimeRepository;

@Configuration
@Slf4j
public class LoadData {

	@Bean
	@Profile("!test")
	CommandLineRunner initDatabase(UserRepository userRepository, ProjectRepository projectRepository,
			WorkTimeRepository workTimeRepository, CredentialRepository credentialRepository) {
		return args -> {
			initUsers(userRepository);
			initProjects(projectRepository);
		};
	}
	
	private void initProjects(ProjectRepository projectRepository) {
		
		
	}

	private void initUsers(UserRepository userRepository) {
		User user1 = new User();
		user1.setFirstname("user1");
		
	};
	
}

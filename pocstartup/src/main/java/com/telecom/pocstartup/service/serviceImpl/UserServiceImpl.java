package com.telecom.pocstartup.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.pocstartup.domain.Project;
import com.telecom.pocstartup.domain.User;
import com.telecom.pocstartup.repository.UserRepository;
import com.telecom.pocstartup.service.UserService;
import com.telecom.pocstartup.utils.ListIds;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAllUsers() {
		
		return this.userRepository.findAll();
	}

	@Override
	public User findUserById(Long id) {
		return this.userRepository.findById(id).orElse(null);
	}

	@Override
	public List<User> addUsers(ListIds ids, Project project) {
		
		List<User> users = new ArrayList<User>();
		
		for (Long userId : ids.getIds()) {
			User user = findUserById(userId);
			if (user != null) {
				user.addProject(project);
				users.add(user);
				userRepository.save(user);
			}
		}
		return users;
	}
	
	
		
}

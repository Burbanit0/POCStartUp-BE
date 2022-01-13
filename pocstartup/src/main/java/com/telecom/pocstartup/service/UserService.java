package com.telecom.pocstartup.service;

import java.util.List;

import com.telecom.pocstartup.domain.Project;
import com.telecom.pocstartup.domain.User;
import com.telecom.pocstartup.utils.ListIds;

public interface UserService {
	public List<User> findAllUsers();
	public User findUserById(Long id);
	public List<User> addUsers(ListIds ids, Project project);
	
}

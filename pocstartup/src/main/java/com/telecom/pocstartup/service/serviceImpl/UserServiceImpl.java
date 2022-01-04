package com.telecom.pocstartup.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.pocstartup.domain.User;
import com.telecom.pocstartup.repository.UserRepository;
import com.telecom.pocstartup.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAllUsers() {
		
		return this.userRepository.findAll();
	}
		
}

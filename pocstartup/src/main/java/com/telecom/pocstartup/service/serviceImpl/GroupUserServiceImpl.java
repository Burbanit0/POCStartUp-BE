package com.telecom.pocstartup.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.pocstartup.domain.GroupUser;
import com.telecom.pocstartup.domain.User;
import com.telecom.pocstartup.repository.GroupRepository;
import com.telecom.pocstartup.repository.UserRepository;
import com.telecom.pocstartup.service.GroupUserService;

@Service
public class GroupUserServiceImpl implements GroupUserService {

	@Autowired
	GroupRepository groupRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public GroupUser findGroupuserById(Long id) {
		return this.groupRepository.findById(id).orElse(null);
	}

	@Override
	public GroupUser createGroupUser(GroupUser group,User manager) {
		group.setManager(manager);
		return this.groupRepository.save(group);
	}


}

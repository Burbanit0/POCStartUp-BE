package com.telecom.pocstartup.service;

import com.telecom.pocstartup.domain.GroupUser;
import com.telecom.pocstartup.domain.User;

public interface GroupUserService {
	public GroupUser findGroupuserById(Long id);
	public GroupUser createGroupUser(GroupUser group,User manager);
}

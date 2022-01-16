package com.telecom.pocstartup.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.pocstartup.domain.GroupUser;
import com.telecom.pocstartup.domain.Project;
import com.telecom.pocstartup.domain.User;
import com.telecom.pocstartup.repository.GroupRepository;
import com.telecom.pocstartup.repository.UserRepository;
import com.telecom.pocstartup.service.UserService;
import com.telecom.pocstartup.utils.ListIds;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	GroupRepository groupRepository;

	public List<User> findAllUsers() {

		return this.userRepository.findAll();
	}

	@Override
	public User findUserById(Long id) {
		return this.userRepository.findById(id).orElse(null);
	}

	@Override
	public Project addUsersToProject(ListIds ids, Project project) {

		for (Long userId : ids.getIds()) {
			User user = findUserById(userId);
			if (user != null) {
				user.addProject(project);
				userRepository.save(user);
			}
		}
		return project;
	}

	@Override
	public GroupUser addUsersToGroup(ListIds ids, GroupUser group) {

		for (Long userId : ids.getIds()) {
			User user = userRepository.findById(userId).orElse(null);
			if (user != null) {
				group.addUser(user);
				groupRepository.save(group);

			}
		}
		return group;

	}

	@Override
	public Project deleteUserFromProject(Project project, User user) {
		project.getUsers().remove(user);
		user.getProjects().remove(project);
		userRepository.save(user);
		return null;
	}

}

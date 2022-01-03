package com.telecom.pocstartup.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class GroupUser {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private User manager;
	
	@OneToMany(mappedBy="groupUser")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<User> users;
	
	public GroupUser() {
		this.users = new HashSet<>();	
	}
	
	public void addUser(User user) {
		
		user.setGroupUser(this);
		
		this.users.add(user);
	}
}

package com.telecom.pocstartup.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Project {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String description;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "projects",fetch=FetchType.EAGER)
	@JsonIgnoreProperties({"groupUser","password","roles","workTimes","projects","manageGroupUser"})
	private Set<User> users;
	
	public Project() {
		this.users = new HashSet<>();
	}
	
	public void addUser(User user) {
		user.getProjects().add(this);
		this.users.add(user);
	}
}

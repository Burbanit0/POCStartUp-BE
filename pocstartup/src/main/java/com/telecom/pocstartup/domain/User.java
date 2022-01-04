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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String firstname;
	private String lastname;
	private String role;
	
	@OneToOne
	private Credential credential;
	
	@OneToMany(mappedBy="user")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties("user")
	private Set<WorkTime> workTimes;
	
	@ManyToOne
	@JsonIgnoreProperties("users")
	private GroupUser groupUser;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties("users")
	private Set<Project> projects;

	public User() {
		this.workTimes = new HashSet<>();
		this.projects = new HashSet<>();
	}
	
	public void addProject(Project project) {
		project.getUsers().add(this);
		this.projects.add(project);
	}
	
	public void addWorkTime(WorkTime workTime) {
		workTime.setUser(this);
		this.workTimes.add(workTime);
	}
}

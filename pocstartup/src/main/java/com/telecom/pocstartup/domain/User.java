package com.telecom.pocstartup.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	private Set<WorkTime> workTimes;
	
	@ManyToOne
	private GroupUser groupUser;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany(fetch=FetchType.EAGER)
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

package com.telecom.pocstartup.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@JsonFilter("UserFilter")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@NotBlank
	@Size(min = 3, max = 50)
	private String name;

	@NotBlank
	@Size(min = 3, max = 50)
	private String username;

	@NaturalId
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(min = 6, max = 100)
	private String password;

	@ManyToMany
	private Set<Role> roles = new HashSet<>();

	@OneToMany(mappedBy = "user",cascade={CascadeType.ALL})
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties("user")
	private Set<WorkTime> workTimes;

	@ManyToOne(cascade={CascadeType.ALL})
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties("users")
	private GroupUser groupUser;
	
	@OneToOne(mappedBy="manager")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties({"users","manager"})
	private GroupUser manageGroupUser;

	@ManyToMany(fetch = FetchType.EAGER)
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

	public User(String name, String username, String email, String password) {
		this.username = username;
		this.name = name;
		this.email = email;
		this.password = password;
	}
}

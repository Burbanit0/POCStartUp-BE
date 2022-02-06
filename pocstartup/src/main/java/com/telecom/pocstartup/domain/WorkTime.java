package com.telecom.pocstartup.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class WorkTime {
	@Id
	@GeneratedValue
	private Long id;
	
	private String date;
	
	private float duration;
	
	@ManyToOne
	@JsonIgnoreProperties("users")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Project project;
	
	@ManyToOne
	@JsonIgnoreProperties({"groupUser","password","roles","workTimes","projects"})
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private User user;
}

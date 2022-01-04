package com.telecom.pocstartup.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class WorkTime {
	@Id
	@GeneratedValue
	private Long id;
	
	private Long duration;
	
	@ManyToOne
	@JsonIgnoreProperties("workTimes")
	private Project project;
	
	@ManyToOne
	@JsonIgnoreProperties("workTimes")
	private User user;
}

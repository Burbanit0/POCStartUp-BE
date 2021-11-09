package domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	
	@ManyToMany(mappedBy="user",fetch=FetchType.EAGER)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<WorkTime> workTimes;
	
	@ManyToMany(mappedBy="user",fetch=FetchType.EAGER)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<Project> projects;
}

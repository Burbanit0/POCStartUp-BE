package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Credential {
	@Id
	@GeneratedValue
	private Long id;
	
	private String password;
	
	@OneToOne
	private User user;
	
	
}

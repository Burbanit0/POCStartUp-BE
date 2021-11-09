package domain;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Credential {
	private Long id_user;
	private String password;
	
}

package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class WorkTime {
	@Id
	@GeneratedValue
	private Long id;
}

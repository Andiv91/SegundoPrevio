package co.edu.ufps.SegundoPrevio.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="visit")
public class Visit {

		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int department_id;
	private int employee_id;
}

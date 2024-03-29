package nl.luuk.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="SPECIALTY")
public class Specialty {

	
	@Id
	@GeneratedValue
	private long id; 
	
	@Column(name="specialtyname")
	private String specialtyName;

	//Constructors
	public Specialty() {}
	
	public Specialty(String specialtyName) {
		this.specialtyName = specialtyName;
	}
	
	
	//Getter and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSpecialtyName() {
		return specialtyName;
	}

	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}
	
	
	
}

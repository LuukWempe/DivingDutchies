package nl.luuk.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="Specialty")
public class Specialty {

	
	@Id
	@GeneratedValue
	private long id; 
	
	@Column(name="specialtyname")
	private String specialtyname;

	//Constructors
	public Specialty() {}
	
	public Specialty(String specialtyName) {
		this.specialtyname = specialtyName;
	}
	
	
	//Getter and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSpecialtyname() {
		return specialtyname;
	}

	public void setSpecialtyname(String specialtyname) {
		this.specialtyname = specialtyname;
	}
	
	
	
}

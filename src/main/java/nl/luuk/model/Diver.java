package nl.luuk.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="divers")
public class Diver {
	
	@Id
	@GeneratedValue
	private long id; 
	
	@Column(name="username")
	private String username;
	
	@Column(name="role")
	private String role;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;

	@Column(name="street")
	private String street;

	@Column(name="streetNr")
	private String streetNr;

	@Column(name="country")
	private String country;

	@Column(name="city")
	private String city;

	@Column(name="zipcode")
	private String zipcode;

	@Column(name="enabled")
	private boolean enabled;

	@Column(name="activated")
	private boolean activated;

	@Column(name="dateofbirth")
	private Date dateofbirth;

	@Column(name="telephonenumber")
	private String telephonenumber;
	
	public Diver() {
		
	}
	
	public Diver(String username, String role, String firstName, String lastName, String password) {
		this.username = username;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		
		
	}
	
	

	public Diver(String username, String role, String firstName, String lastName, String password,
			String email, String street, String streetNr, String country, String city, String zipcode, boolean enabled,
			boolean activated, Date dateofbirth, String telephonenumber) {
		this.username = username;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.street = street;
		this.streetNr = streetNr;
		this.country = country;
		this.city = city;
		this.zipcode = zipcode;
		this.enabled = enabled;
		this.activated = activated;
		this.dateofbirth = dateofbirth;
		this.telephonenumber = telephonenumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNr() {
		return streetNr;
	}

	public void setStreetNr(String streetNr) {
		this.streetNr = streetNr;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getTelephonenumber() {
		return telephonenumber;
	}

	public void setTelephonenumber(String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}
	
	
	
}

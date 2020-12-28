package nl.luuk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import nl.luuk.model.Diver;
import nl.luuk.database.DiverRepository;

import java.sql.Date;
import java.util.List;

@Service
public class DiverService implements UserDetailsService {

	@Autowired
	private DiverRepository diverRepository;

	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Diver diver = diverRepository.findByUsername(username);
		UserDetails userDetails =
				org.springframework.security.core.userdetails.User
						.builder()
						.username(username)
						.password(diver.getPassword())
						.roles(diver.getRole())
						.build();

		return userDetails;
	}

	public void registerDiver(
			String username,
			String role,
			String firstName,
			String lastName,
			String password,
			String email,
			boolean enabled,
			boolean activated) {
		Diver diver = diverRepository.findByUsername(username);
		if (diver == null){
			switch (role) {
				
				case "ADMIN":
					Diver newDiver = new Diver (username, role, firstName, lastName, password);
					diverRepository.save (newDiver);
					break;
					
				case "DIVER":
					newDiver = new Diver (username, role, firstName, lastName, password);
					diverRepository.save (newDiver);
					break;
			}
		} else {
			System.out.print("username already taken");
		}
	}

	

	public Diver getDiver(String userName) {
		return diverRepository.findByUsername(userName);
	}

	public Diver getActiveUser() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		UserDetails details = (UserDetails) authentication.getPrincipal();
		Diver diver = getDiver(details.getUsername());
		return diver;
	}

	public List<Diver> getDiversByRole(String role) {
		List<Diver> listDiversByRole = diverRepository.findByRole(role);
		return listDiversByRole;
	}


	//Changes the current user's password to a new given password
	public void changePassword(String new_password) {

		//Password encoder
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		//Get current user entity
		String username = getActiveUser().getUsername();
		Diver updated_Diver = diverRepository.findByUsername(username);

		//Update current user's password
		updated_Diver.setPassword(encoder.encode(new_password));

		//Save to repository
		diverRepository.save(updated_Diver);
	}

	public void updateDiver(String username,
							  String firstname,
							  String lastname,
							  String email,
							  String password,
							  boolean enabled,
							  boolean activated,
							  Date dateofbirth,
							  String zipcode,
							  String street,
							  String streetNr,
							  String city,
							  String country,
							  String telephonenr,
							  String bootcamp) {
		
		Diver updateDiver = diverRepository.findByUsername(username);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		if (updateDiver.getPassword()!=null && !updateDiver.getPassword().equals(password)){
			updateDiver.setPassword(encoder.encode(password));
		}

		updateDiver.setFirstName(firstname);
		updateDiver.setLastName(lastname);
		updateDiver.setEmail(email);
		updateDiver.setDateofbirth(dateofbirth);
		updateDiver.setStreet(street);
		updateDiver.setStreetNr(streetNr);
		updateDiver.setZipcode(zipcode);
		updateDiver.setCity(city);
		updateDiver.setCountry(country);
		updateDiver.setTelephonenumber(telephonenr);
		updateDiver.setEnabled(enabled);
		updateDiver.setActivated(activated);
		
		diverRepository.save(updateDiver);
	}

}
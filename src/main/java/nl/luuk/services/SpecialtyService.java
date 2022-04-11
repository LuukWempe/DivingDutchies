package nl.luuk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import nl.luuk.database.SpecialtyRepository;
import nl.luuk.model.Specialty;

@Service
public class SpecialtyService {
	
	@Autowired
	private SpecialtyRepository specialtyRepository;

	@Autowired
	public void setSpecialtyRepository(SpecialtyRepository specialtyRepository) {
		this.specialtyRepository = specialtyRepository;
	}
	
	public void addSpecialty(String specialtyName) {
		Specialty specialty = new Specialty(specialtyName);
		specialtyRepository.save(specialty);
	}
	
	public List<Specialty> getAllSpecialties(){
		return specialtyRepository.findAll();
	}
}

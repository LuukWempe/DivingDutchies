package nl.luuk.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.luuk.model.Specialty;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
	Specialty findById(int specialtyId);
	Specialty findBySpecialtyname(String specialtyname);
}

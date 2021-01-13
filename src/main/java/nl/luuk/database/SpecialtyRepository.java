package nl.luuk.database;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.luuk.model.Specialty;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
	Specialty findById(long specialtyId);
	Specialty findBySpecialtyname(String specialtyname);
	Page<Specialty> findAll(Pageable pageable);
}

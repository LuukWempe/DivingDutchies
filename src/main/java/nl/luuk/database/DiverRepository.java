package nl.luuk.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.luuk.model.Diver;

@Repository
public interface DiverRepository extends JpaRepository<Diver, Long> {
	Diver findByUsername(String username);
	Diver findByFirstName(String firstname);
	List<Diver> findByRole(String role);
	Diver findById(String Id);
}

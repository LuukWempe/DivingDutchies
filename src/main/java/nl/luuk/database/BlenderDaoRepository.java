package nl.luuk.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.luuk.model.gasblender.BlenderDao;

@Repository
public interface BlenderDaoRepository extends JpaRepository<BlenderDao, Long> {
	BlenderDao findByBlenderId(long blenderId);
}

package ifapme.be.garage.demo.repository;

import ifapme.be.garage.demo.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, String> {
}

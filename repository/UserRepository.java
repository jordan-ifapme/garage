package ifapme.be.garage.demo.repository;

import ifapme.be.garage.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  List<User> findByFirstname(String firstname);
}

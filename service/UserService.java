package ifapme.be.garage.demo.service;

import ifapme.be.garage.demo.exception.BusinessException;
import ifapme.be.garage.demo.model.User;

import java.util.List;

public interface UserService {
  User findById(Integer id);
  List<User> findAll();
  User createUser(User user) throws BusinessException;
  User updateUser(User user) throws BusinessException;
  void deleteUser(Integer userId) throws BusinessException;
  List<User> findByFirstname(String firstname);
}

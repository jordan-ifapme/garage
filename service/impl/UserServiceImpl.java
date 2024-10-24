package ifapme.be.garage.demo.service.impl;

import ifapme.be.garage.demo.exception.BusinessException;
import ifapme.be.garage.demo.exception.UserAlreadyExistException;
import ifapme.be.garage.demo.exception.UserNotFoundException;
import ifapme.be.garage.demo.model.User;
import ifapme.be.garage.demo.repository.UserRepository;
import ifapme.be.garage.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User findById(Integer id) {
    return userRepository
      .findById(id)
      .orElse(null);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User createUser(User user) throws BusinessException {
    if (this.findById(user.getId()) == null) {
      return userRepository.save(user);
    } else {
      throw new UserAlreadyExistException();
    }
  }

  @Override
  public User updateUser(User user) throws BusinessException {
    if (this.findById(user.getId()) == null) {
      throw new UserNotFoundException(user.getId());
    }
    return userRepository.save(user);
  }

  @Override
  public void deleteUser(Integer userId) throws BusinessException {
    User userToDelete = this.findById(userId);
    if (userToDelete == null) {
      throw new UserNotFoundException(userId);
    }
    userRepository.delete(userToDelete);
  }

  @Override
  public List<User> findByFirstname(String firstname) {
    return userRepository.findByFirstnameIgnoreCaseContaining(firstname);
  }
}

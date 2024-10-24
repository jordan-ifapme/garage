package ifapme.be.garage.demo.controller;

import ifapme.be.garage.demo.exception.BusinessException;
import ifapme.be.garage.demo.model.User;
import ifapme.be.garage.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "all")
  public List<User> getAll() {
    return userService.findAll();
  }

  @PostMapping
  public User createUser(@RequestBody User user) throws BusinessException {
    return userService.createUser(user);
  }

  @PutMapping
  public User updateUser(@RequestBody User user) throws BusinessException {
    return userService.updateUser(user);
  }

  @DeleteMapping("{id}")
  public void deleteUser(@PathVariable(value = "id") Integer userId) throws BusinessException {
    userService.deleteUser(userId);
  }

  @GetMapping("/firstname/{firstname}")
  public List<User> getByFirstname(@PathVariable String firstname) {
    return userService.findByFirstname(firstname);
  }
}

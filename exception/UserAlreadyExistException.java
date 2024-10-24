package ifapme.be.garage.demo.exception;

public class UserAlreadyExistException extends BusinessException {
  public UserAlreadyExistException() {
    super("L'utilisateur existe déjà");
  }
}

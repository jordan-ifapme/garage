package ifapme.be.garage.demo.exception;

public class UserNotFoundException extends BusinessException{
  public UserNotFoundException(Integer userId) {
    super("L'utilisateur est avec l'id suivante n'a pas été trouvé : " + userId);
  }
}

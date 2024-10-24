package ifapme.be.garage.demo.exception;

import java.util.List;

public class UserHasVoitureException extends BusinessException {
  public UserHasVoitureException(Integer userId, List<String> plaques) {
    super("L'utilisateur avec l'id : " + userId +
      " posséde les voitures : "
      + String.join(",", plaques));
  }
}

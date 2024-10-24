package ifapme.be.garage.demo.exception;

public class VoitureAlreadyExistsException extends BusinessException {
  public VoitureAlreadyExistsException(String numeroDePlaque) {
    super("Le numero de plaque est déjà présent : " + numeroDePlaque);
  }
}

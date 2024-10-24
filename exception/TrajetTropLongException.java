package ifapme.be.garage.demo.exception;

public class TrajetTropLongException extends BusinessException {
  public TrajetTropLongException() {
    super("Trajet trop long");
  }
}

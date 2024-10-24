package ifapme.be.garage.demo.exception;

public class VoitureNotFoundException extends BusinessException {
  public VoitureNotFoundException(String plaque) {
    super("Voiture avec la plaque : " + plaque + " introuvable");
  }
}

package ifapme.be.garage.demo.exception;

public class EntretientAFaireException extends BusinessException {
  public EntretientAFaireException(Integer totalKm, Integer entretientKm) {
    super("L'entretient doit etre fait tout les 15 000 vous avez au total : " + totalKm + " le dernier entretient a été fait a : " + entretientKm);
  }
}

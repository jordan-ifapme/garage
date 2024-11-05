package ifapme.be.garage.demo.command;

import ifapme.be.garage.demo.model.Couleur;
import lombok.Getter;

@Getter
public class VoitureBaseCommand {
  private String numeroDePlaque;
  private String couleur;
  private Integer userId;
}

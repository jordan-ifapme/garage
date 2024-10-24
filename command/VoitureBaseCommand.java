package ifapme.be.garage.demo.command;

import lombok.Getter;

@Getter
public class VoitureBaseCommand {
  private String numeroDePlaque;
  private String couleur;
  private Integer userId;
}

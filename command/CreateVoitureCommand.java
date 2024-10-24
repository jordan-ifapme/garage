package ifapme.be.garage.demo.command;

import lombok.Getter;

@Getter
public class CreateVoitureCommand extends VoitureBaseCommand {
  private String marque;
  private String modele;
}

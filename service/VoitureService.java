package ifapme.be.garage.demo.service;

import ifapme.be.garage.demo.command.CreateVoitureCommand;
import ifapme.be.garage.demo.command.VoitureEntretientCommand;
import ifapme.be.garage.demo.command.VoitureRouleCommand;
import ifapme.be.garage.demo.exception.BusinessException;
import ifapme.be.garage.demo.model.Voiture;

import java.util.List;

public interface VoitureService {
  List<Voiture> findAll();

  Voiture findById(String id);

  Voiture createVoiture(CreateVoitureCommand command) throws BusinessException;

  void roule(VoitureRouleCommand command) throws BusinessException;

  void entretient(VoitureEntretientCommand command) throws BusinessException;
}

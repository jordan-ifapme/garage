package ifapme.be.garage.demo.service.impl;

import ifapme.be.garage.demo.command.CreateVoitureCommand;
import ifapme.be.garage.demo.command.VoitureEntretientCommand;
import ifapme.be.garage.demo.command.VoitureRouleCommand;
import ifapme.be.garage.demo.exception.*;
import ifapme.be.garage.demo.model.User;
import ifapme.be.garage.demo.model.Voiture;
import ifapme.be.garage.demo.repository.VoitureRepository;
import ifapme.be.garage.demo.service.UserService;
import ifapme.be.garage.demo.service.VoitureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureServiceImpl implements VoitureService {

  private static final Integer MAX_TRAJET = 2500;
  private static final Integer LIMITE_ENTRETIENT = 15000;

  private final VoitureRepository voitureRepository;
  private final UserService userService;

  public VoitureServiceImpl(VoitureRepository voitureRepository, UserService userService) {
    this.voitureRepository = voitureRepository;
    this.userService = userService;
  }

  @Override
  public List<Voiture> findAll() {
    return voitureRepository.findAll();
  }

  @Override
  public Voiture findById(String id) {
    return voitureRepository.findById(id).orElse(null);
  }

  @Override
  public Voiture createVoiture(CreateVoitureCommand command) throws BusinessException {
    User user = userService.findById(command.getUserId());
    if (user == null) {
      throw new UserNotFoundException(command.getUserId());
    }
    if (this.findById(command.getNumeroDePlaque()) != null) {
      throw new VoitureAlreadyExistsException(command.getNumeroDePlaque());
    }
    Voiture voitureToCreate = new Voiture(
      command.getNumeroDePlaque(),
      command.getCouleur(),
      command.getMarque(),
      command.getModele(),
      user
    );
    return voitureRepository.save(voitureToCreate);
  }

  @Override
  public void roule(VoitureRouleCommand command) throws BusinessException {
    if (command.getKilometre() > MAX_TRAJET) {
      throw new TrajetTropLongException();
    }
    Voiture voiture = this.findById(command.getPlaque());
    if (voiture == null) {
      throw new VoitureNotFoundException(command.getPlaque());
    }
    Integer totalKm = voiture.getKilometre() + command.getKilometre();
    Integer kmDepuisDernierEntretient = totalKm - voiture.getKilometreEntretient();
    if (kmDepuisDernierEntretient > LIMITE_ENTRETIENT) {
      throw new EntretientAFaireException(totalKm, voiture.getKilometreEntretient());
    }
    voiture.setKilometre(totalKm);
    voitureRepository.save(voiture);
  }

  @Override
  public void entretient(VoitureEntretientCommand command) throws BusinessException {
    Voiture voitureToUpdate = this.findById(command.getNumPlaque());
    if (voitureToUpdate == null) {
      throw new VoitureNotFoundException(command.getNumPlaque());
    }
    voitureToUpdate.setKilometreEntretient(voitureToUpdate.getKilometre());
    voitureRepository.save(voitureToUpdate);
  }
}

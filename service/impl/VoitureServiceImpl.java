package ifapme.be.garage.demo.service.impl;

import ifapme.be.garage.demo.command.CreateVoitureCommand;
import ifapme.be.garage.demo.exception.BusinessException;
import ifapme.be.garage.demo.exception.UserNotFoundException;
import ifapme.be.garage.demo.exception.VoitureAlreadyExistsException;
import ifapme.be.garage.demo.model.User;
import ifapme.be.garage.demo.model.Voiture;
import ifapme.be.garage.demo.repository.VoitureRepository;
import ifapme.be.garage.demo.service.UserService;
import ifapme.be.garage.demo.service.VoitureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureServiceImpl implements VoitureService {

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
}

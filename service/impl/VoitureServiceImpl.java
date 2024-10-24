package ifapme.be.garage.demo.service.impl;

import ifapme.be.garage.demo.model.Voiture;
import ifapme.be.garage.demo.repository.VoitureRepository;
import ifapme.be.garage.demo.service.VoitureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureServiceImpl implements VoitureService {

  private final VoitureRepository voitureRepository;

  public VoitureServiceImpl(VoitureRepository voitureRepository) {
    this.voitureRepository = voitureRepository;
  }

  @Override
  public List<Voiture> findAll() {
    return voitureRepository.findAll();
  }
}

package ifapme.be.garage.demo.service;

import ifapme.be.garage.demo.model.Voiture;

import java.util.List;

public interface VoitureService {
  List<Voiture> findAll();
}

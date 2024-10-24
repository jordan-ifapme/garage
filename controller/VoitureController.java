package ifapme.be.garage.demo.controller;

import ifapme.be.garage.demo.model.Voiture;
import ifapme.be.garage.demo.service.UserService;
import ifapme.be.garage.demo.service.VoitureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class VoitureController {

  private final VoitureService voitureService;
  public VoitureController(VoitureService voitureService) {
    this.voitureService = voitureService;
  }

  @GetMapping(value = "/voitures")
  public List<Voiture> test() {
    return voitureService.findAll();
  }
}

package ifapme.be.garage.demo.controller;

import ifapme.be.garage.demo.command.CreateVoitureCommand;
import ifapme.be.garage.demo.command.VoitureEntretientCommand;
import ifapme.be.garage.demo.command.VoitureRouleCommand;
import ifapme.be.garage.demo.exception.BusinessException;
import ifapme.be.garage.demo.model.Voiture;
import ifapme.be.garage.demo.service.VoitureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/voiture")
public class VoitureController {

  private final VoitureService voitureService;

  public VoitureController(VoitureService voitureService) {
    this.voitureService = voitureService;
  }

  @GetMapping(value = "/all")
  public List<Voiture> getAll() {
    return voitureService.findAll();
  }

  @GetMapping("{id}")
  public Voiture getById(@PathVariable String id) {
    return voitureService.findById(id);
  }

  @PostMapping
  public Voiture createVoiture(@RequestBody CreateVoitureCommand command) throws BusinessException {
    return voitureService.createVoiture(command);
  }

  @PostMapping("roule")
  public void roule(@RequestBody VoitureRouleCommand command) throws BusinessException {
    voitureService.roule(command);
  }

  @PostMapping("entretient")
  public void entretient(@RequestBody VoitureEntretientCommand command) throws BusinessException {

  }
}

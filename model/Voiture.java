package ifapme.be.garage.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Voiture {
  @Id
  @Column(name = "numero_plaque", nullable = false)
  private String numeroDePLaque;

  private String couleur;

  private String marque;

  private String modele;

  private Integer kilometre = 0;

  @Column(name = "kilometre_entretient")
  private Integer kilometreEntretient = 0;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public Voiture(String numeroDePLaque, String couleur, String marque, String modele, User user) {
    this.numeroDePLaque = numeroDePLaque;
    this.couleur = couleur;
    this.marque = marque;
    this.modele = modele;
    this.user = user;
  }
}

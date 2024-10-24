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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "numero_plaque", nullable = false)
  private String numeroDePLaque;

  private String couleur;

  private String marque;

  private String modele;

  private Integer kilometre;

  @Column(name = "kilometre_entretient")
  private Integer kilometreEntretient;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}

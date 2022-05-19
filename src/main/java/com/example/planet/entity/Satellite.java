package com.example.planet.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "satellite")
public class Satellite {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "satellite_seq")
  @SequenceGenerator(name = "satellite_seq", allocationSize = 1)
  @Column(name = "id")
  private Long id;

  @NotNull
  @Column(name = "name")
  private String name;

  @NotNull
  @Column(name = "surface_area")
  private Long surfaceArea;

  @NotNull
  @Column(name = "mass")
  private Long mass;

  @Column(name = "natural_satellite")
  private Boolean naturalSatellite;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "planet_id")
  private Planet planet;
}

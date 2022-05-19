package com.example.planet.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "planet")
public class Planet {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "planet_seq")
  @SequenceGenerator(name = "planet_seq", allocationSize = 1)
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

  @NotNull
  @Column(name = "distance_from_sun")
  private Long distanceFromSun;

  @Column(name = "average_surface_temperature")
  private Integer averageSurfaceTemperature;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "planet_id")
  private List<Satellite> satellites;
}

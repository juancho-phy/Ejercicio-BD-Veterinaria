package com.example.BDVeterinaria.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mascota")
@Setter
@Getter
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;
    private Double peso;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "historia_clinica_id", referencedColumnName = "id")
    private HistoriaClinica historiaClinica;

    @ManyToMany
    @JoinTable(
            name = "mascota_veterinaio",
            joinColumns = @JoinColumn(name = "mascota_id"),
            inverseJoinColumns = @JoinColumn(name = "veterinario_id")
    )
    private List<Veterinario> veterinarios;

}

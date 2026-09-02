package com.example.BDVeterinaria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "veterinario")
public class Veterinario {

    private Long id;

    private String nombre;
    private String tarjetaProfesional;
    private String especialidad;
    private String correo;

    @ManyToMany(mappedBy = "veterinarios")
    private List<Mascota> mascotas;

}

package com.example.BDVeterinaria.service;

import com.example.BDVeterinaria.entity.Mascota;

import java.util.List;

public interface MascotaService {

    List<Mascota> listarTodos();

    Mascota buscarPorId(Long id);

    Mascota guardar(Mascota mascota);

    Mascota actualizar(Long id, Mascota mascota);

    void eliminar(Long id);
}

package com.example.BDVeterinaria.service;

import com.example.BDVeterinaria.entity.Mascota;
import com.example.BDVeterinaria.exception.ResourceNotFoundException;
import com.example.BDVeterinaria.repository.MascotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService{

    private final MascotaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Mascota> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Mascota buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Mascota no encontrada: " + id));
    }

    @Override
    @Transactional
    public Mascota guardar(Mascota mascota) {
        return repository.save(mascota);
    }

    @Override
    @Transactional
    public Mascota actualizar(Long id, Mascota mascota) {
        Mascota actual = buscarPorId(id);

        actual.setNombre(mascota.getNombre());
        actual.setEspecie(mascota.getEspecie());
        actual.setRaza(mascota.getRaza());
        actual.setEdad(mascota.getEdad());
        actual.setPeso(mascota.getPeso());
        actual.setPropietario(mascota.getPropietario());
        actual.setHistoriaClinica(mascota.getHistoriaClinica());
        actual.setVeterinarios(mascota.getVeterinarios());

        return repository.save(actual);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Mascota mascota = buscarPorId(id);
        repository.delete(mascota);
    }
}

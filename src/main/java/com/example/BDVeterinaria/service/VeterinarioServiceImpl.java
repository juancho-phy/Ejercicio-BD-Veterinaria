package com.example.BDVeterinaria.service;

import com.example.BDVeterinaria.entity.Veterinario;
import com.example.BDVeterinaria.exception.ResourceNotFoundException;
import com.example.BDVeterinaria.repository.VeterinarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Veterinario> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Veterinario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Veterinario no encontrado: " + id));
    }

    @Override
    @Transactional
    public Veterinario guardar(Veterinario veterinario) {
        return repository.save(veterinario);
    }

    @Override
    @Transactional
    public Veterinario actualizar(Long id, Veterinario veterinario) {
        Veterinario actual = buscarPorId(id);

        actual.setNombre(veterinario.getNombre());
        actual.setTarjetaProfesional(veterinario.getTarjetaProfesional());
        actual.setEspecialidad(veterinario.getEspecialidad());
        actual.setCorreo(veterinario.getCorreo());

        return repository.save(actual);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Veterinario veterinario = buscarPorId(id);
        repository.delete(veterinario);
    }
}
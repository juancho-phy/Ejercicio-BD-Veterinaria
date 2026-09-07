package com.example.BDVeterinaria.service;

import com.example.BDVeterinaria.entity.Propietario;
import com.example.BDVeterinaria.exception.ResourceNotFoundException;
import com.example.BDVeterinaria.repository.PropietarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropietarioServiceImp implements PropietarioService {

    private final PropietarioRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<Propietario> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Propietario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Propietario no encontrado: " + id));
    }

    @Override
    @Transactional
    public Propietario guardar(Propietario propietario) {
        return repository.save(propietario);
    }

    @Override
    @Transactional
    public Propietario actualizar(Long id, Propietario propietario) {
        Propietario actual = buscarPorId(id);

        actual.setNombre(propietario.getNombre());
        actual.setDocumento(propietario.getDocumento());
        actual.setTelefono(propietario.getTelefono());
        actual.setCorreo(propietario.getCorreo());

        return repository.save(actual);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Propietario propietario =
                buscarPorId(id);

        repository.delete(propietario);

    }
}

package com.example.BDVeterinaria.service;

import com.example.BDVeterinaria.entity.HistoriaClinica;
import com.example.BDVeterinaria.exception.ResourceNotFoundException;
import com.example.BDVeterinaria.repository.HistoriaClinicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<HistoriaClinica> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public HistoriaClinica buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Historia no encontrada: " + id));
    }

    @Override
    @Transactional
    public HistoriaClinica guardar(HistoriaClinica historiaClinica) {
        return repository.save(historiaClinica);
    }

    @Override
    @Transactional
    public HistoriaClinica actualizar(Long id, HistoriaClinica historiaClinica) {
        HistoriaClinica actual = buscarPorId(id);

        actual.setFechaApertura(historiaClinica.getFechaApertura());
        actual.setAntecedentes(historiaClinica.getAntecedentes());
        actual.setObservaciones(historiaClinica.getObservaciones());

        return repository.save(actual);
    }


    @Override
    public void eliminar(Long id) {
        HistoriaClinica historiaClinica =
                buscarPorId(id);

        repository.delete(historiaClinica);
    }
}

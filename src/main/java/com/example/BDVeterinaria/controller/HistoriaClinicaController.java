package com.example.BDVeterinaria.controller;

import com.example.BDVeterinaria.entity.HistoriaClinica;
import com.example.BDVeterinaria.service.HistoriaClinicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historiaClinica")
@RequiredArgsConstructor
public class HistoriaClinicaController {

    private final HistoriaClinicaService service;

    @GetMapping("/listar")
    public List<HistoriaClinica> listar(){
        return service.listarTodos();
    }

    @GetMapping("/buscar/{id}")
    public HistoriaClinica buscar(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping("/guardar")
    public ResponseEntity<HistoriaClinica> guardar(@Valid @RequestBody HistoriaClinica historiaClinica){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(historiaClinica));
    }

    @PutMapping("/actualizar")
    public HistoriaClinica actualizar(@PathVariable Long id, @Valid @RequestBody HistoriaClinica historiaClinica){
        return service.actualizar(id, historiaClinica);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> eliminar (@PathVariable Long id){
        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }

}

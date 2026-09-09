package com.example.BDVeterinaria.controller;

import com.example.BDVeterinaria.entity.Veterinario;
import com.example.BDVeterinaria.service.VeterinarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinario")
@RequiredArgsConstructor
public class VeterinarioController {

    private final VeterinarioService service;

    @GetMapping("/listar")
    public List<Veterinario> listar() {
        return service.listarTodos();
    }

    @GetMapping("/buscar/{id}")
    public Veterinario buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Veterinario> guardar(@Valid @RequestBody Veterinario veterinario) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(veterinario));
    }

    @PutMapping("/actualizar/{id}")
    public Veterinario actualizar(@PathVariable Long id, @Valid @RequestBody Veterinario veterinario) {
        return service.actualizar(id, veterinario);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
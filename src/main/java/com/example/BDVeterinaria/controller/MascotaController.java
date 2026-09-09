package com.example.BDVeterinaria.controller;

import com.example.BDVeterinaria.entity.Mascota;
import com.example.BDVeterinaria.service.MascotaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascota")
@RequiredArgsConstructor
public class MascotaController {
    private final MascotaService service;

    @GetMapping("/listar")
    public List<Mascota> listar() {
        return service.listarTodos();
    }

    @GetMapping("/buscar/{id}")
    public Mascota buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Mascota> guardar(@Valid @RequestBody Mascota mascota) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(mascota));
    }

    @PutMapping("/actualizar/{id}")
    public Mascota actualizar(@PathVariable Long id, @Valid @RequestBody Mascota mascota) {
        return service.actualizar(id, mascota);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

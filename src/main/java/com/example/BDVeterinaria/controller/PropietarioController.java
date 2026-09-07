package com.example.BDVeterinaria.controller;

import com.example.BDVeterinaria.entity.Propietario;
import com.example.BDVeterinaria.service.PropietarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietario")
@RequiredArgsConstructor
public class PropietarioController {

    private final PropietarioService service;

    @GetMapping("/listar")
    public List<Propietario> listar() {
        return service.listarTodos();
    }

    @GetMapping("/buscar/{id]")
    public Propietario buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Propietario> guardar(@Valid @RequestBody Propietario propietario) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(propietario));
    }

    @PutMapping("/actualizar/{id}")
    public Propietario actualizar(@PathVariable Long id, @Valid @RequestBody Propietario propietario) {
        return service.actualizar(id, propietario);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar (@PathVariable Long id){
        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }

}

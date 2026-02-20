package com.kevin.microservices.producto_microservice.controller;

import com.kevin.microservices.producto_microservice.dto.CategoriaDto;
import com.kevin.microservices.producto_microservice.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping("/create")
    public ResponseEntity<String> crear(@Valid @RequestBody CategoriaDto dto) {
        service.crear(dto);
        return ResponseEntity.ok("Categoria Creada");
    }

    @GetMapping("/list")
    public List<CategoriaDto> lista() {
        return service.lista();
    }

    @GetMapping("/list/{id}")
    public CategoriaDto listaIdDto(@PathVariable long id) {
        return service.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizar(@Valid @PathVariable long id,
                                             @RequestBody CategoriaDto dto) {
        service.editar(id, dto);
        return ResponseEntity.ok("Categoria Actualizada");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable long id) {
        service.borrar(id);
        return ResponseEntity.ok("Categoria Eliminada");
    }
}
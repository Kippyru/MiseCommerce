package com.kevin.microservices.producto_microservice.controller;

import com.kevin.microservices.producto_microservice.dto.ProductoDto;
import com.kevin.microservices.producto_microservice.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @PostMapping("/create")
    public ResponseEntity<String> crear(@RequestBody ProductoDto dto) {
        service.crear(dto);
        return ResponseEntity.ok("Producto Creado");
    }

    @GetMapping("/list")
    public List<ProductoDto> lista() {
        return service.lista();
    }

    @GetMapping("/list/{id}")
    public ProductoDto listaIdDto(@PathVariable long id) {
        return service.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizar(@PathVariable long id,
                                             @RequestBody ProductoDto dto) {
        service.editar(id, dto);
        return ResponseEntity.ok("Producto Actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable long id) {
        service.borrar(id);
        return ResponseEntity.ok("Producto Eliminado");
    }
}
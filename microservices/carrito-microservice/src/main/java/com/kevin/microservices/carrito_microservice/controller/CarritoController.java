package com.kevin.microservices.carrito_microservice.controller;

import com.kevin.microservices.carrito_microservice.dto.CarritoDto;
import com.kevin.microservices.carrito_microservice.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito/{clienteId}/cart")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;

    @GetMapping()
    public CarritoDto listaId(@PathVariable("clienteId") String clienteId) {
        return carritoService.listaId(Long.parseLong(clienteId));
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<String> borrar(@PathVariable("clienteId") String clienteId) {
        carritoService.borrar(clienteId);
        return ResponseEntity.noContent().build();
    }
}

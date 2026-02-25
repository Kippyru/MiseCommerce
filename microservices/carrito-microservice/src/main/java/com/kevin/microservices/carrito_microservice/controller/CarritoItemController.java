package com.kevin.microservices.carrito_microservice.controller;

import com.kevin.microservices.carrito_microservice.dto.CarritoItemDto;
import com.kevin.microservices.carrito_microservice.service.CarritoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito/{clienteId}/items")
public class CarritoItemController {
    @Autowired
    private CarritoItemService carritoItemService;

    @PostMapping()
    public ResponseEntity<String> addItem(@PathVariable("clienteId") String clienteId, @Valid @RequestBody CarritoItemDto Item) {
        return ResponseEntity.ok(carritoItemService.addItem(clienteId, Item));
    }


}

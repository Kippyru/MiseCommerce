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

    @PutMapping()
    public ResponseEntity<Void> updateItem(@PathVariable("clienteId") String clienteId, @Valid @RequestBody CarritoItemDto item) {
        carritoItemService.updateItem(clienteId, item);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteItem(@PathVariable("clienteId") String clienteId, @PathVariable("productId") Long productId) {
        carritoItemService.deleteItem(clienteId, productId);
        return ResponseEntity.accepted().build();
    }

}

package com.kevin.microservices.cliente_microservice.controller;

import com.kevin.microservices.cliente_microservice.dto.ClienteDto;
import com.kevin.microservices.cliente_microservice.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody ClienteDto dto) {
        clienteService.crear(dto);
        return ResponseEntity.ok("Cliente Creado");
    }

    @GetMapping("/list")
    public List<ClienteDto> lista() {
        return clienteService.lista();
    }

    @GetMapping("/list/{id}")
    public ClienteDto listaIdDto(@PathVariable int id) {
        return clienteService.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizar(@PathVariable int id,
                                             @RequestBody ClienteDto dto) {
        clienteService.editar(id, dto);
        return ResponseEntity.ok("Cliente Actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        clienteService.borrar(id);
        return ResponseEntity.ok("Cliente Eliminado");
    }
}
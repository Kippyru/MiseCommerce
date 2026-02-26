package com.kevin.microservices.carrito_microservice.service;

import com.kevin.microservices.carrito_microservice.dto.CarritoDto;
import com.kevin.microservices.carrito_microservice.mapper.CarritoMapper;
import com.kevin.microservices.carrito_microservice.model.Carrito;
import com.kevin.microservices.carrito_microservice.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {

    @Autowired
    private CarritoMapper carritoMapper;
    @Autowired
    private CarritoRepository repo;

    public CarritoDto listaId(Long clienteId) {
        Carrito carrito = repo.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("No se encontro el carrito"));
        return carritoMapper.toDto(carrito);
    }

    public void borrar(String clienteId) {
        if (clienteId == null) {
            throw new RuntimeException("Se necesita un id");
        }else if (!repo.existsById(Long.parseLong(clienteId))) {
            throw new RuntimeException(String.format("No se pudo borrar el carrito del cliente id: {}", clienteId));
        }
        repo.deleteById(Long.parseLong(clienteId));
    }
}

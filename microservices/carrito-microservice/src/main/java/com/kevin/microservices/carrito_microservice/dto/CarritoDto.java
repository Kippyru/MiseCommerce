package com.kevin.microservices.carrito_microservice.dto;

import java.util.List;

public class CarritoDto {
    private Long id;
    private String clienteId;
    private List<CarritoItemDto> carritoItems;
}

package com.kevin.microservices.carrito_microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarritoDto {
    private Long id;
    private String clienteId;
    private List<CarritoItemResponse> carritoItems;
}

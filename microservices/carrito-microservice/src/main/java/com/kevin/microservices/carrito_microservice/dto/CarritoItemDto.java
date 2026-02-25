package com.kevin.microservices.carrito_microservice.dto;

import com.kevin.microservices.carrito_microservice.model.Carrito;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CarritoItemDto(
        Long id,
        Long carrito,
        @NotNull(message = "El id del producto es necesario")
        Long productId,
        @NotNull(message = "Especifique cantidad")
        @Min(value = 1, message = "Ingrese al menos 1 item")
        Integer cantidad
) {

}

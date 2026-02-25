package com.kevin.microservices.carrito_microservice.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteDto(
        Long id,
        String nombre,
        String apellido,
        String email,
        String telefono,
        String direccion,
        String ciudad
) {

}

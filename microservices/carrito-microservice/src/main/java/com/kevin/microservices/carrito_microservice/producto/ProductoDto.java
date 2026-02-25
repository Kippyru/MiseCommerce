package com.kevin.microservices.carrito_microservice.producto;

import jakarta.validation.constraints.NotNull;

public record ProductoDto (
         Long id,
         String nombre,
         String descripcion,
         Double precio,
         Integer stock,
         String imagenUrl,
         Long categoria
) {
}

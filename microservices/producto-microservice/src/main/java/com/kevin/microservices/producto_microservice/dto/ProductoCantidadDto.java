package com.kevin.microservices.producto_microservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoCantidadDto{
    @NotNull(message = "El ID de Producto no puede estar vacio")
    private Long productoId;
    @NotNull(message = "La cantidad no puede ser nulo")
    private Integer cantidad;
}


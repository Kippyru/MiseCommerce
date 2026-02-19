package com.kevin.microservices.producto_microservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {
    private Long id;
    @NotNull(message = "El nombre de la categoria es obligatorio")
    private String nombre;
    private String descripcion;
}

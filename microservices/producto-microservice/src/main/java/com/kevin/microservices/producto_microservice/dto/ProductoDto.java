package com.kevin.microservices.producto_microservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private Long id;
    @NotNull(message = "El nombre del producto no puede estar vacio")
    private String nombre;
    private String descripcion;
    @NotNull(message = "El precio del producto no puede estar vacio")
    private Double precio;
    private Integer stock;
    private String imagenUrl;
    @NotNull(message = "La categoria del producto es obligatoria")
    private Long categoria;

}

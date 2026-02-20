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
    @NotNull(message = "El nombre del producto no puede estar vacio")   //todos estos notnull no siven
    private String nombre;                                              //por como estoy haciendo el servicio y el mapper
    private String descripcion;                                         //pero bueno los dejo ahi
    @NotNull(message = "El precio del producto no puede estar vacio")   //y no solo en este caso, en los demas dto tmb
    private Double precio;
    private Integer stock;
    private String imagenUrl;
    @NotNull(message = "La categoria del producto es obligatoria")
    private Long categoria;
}

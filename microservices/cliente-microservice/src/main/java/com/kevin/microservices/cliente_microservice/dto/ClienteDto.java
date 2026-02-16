package com.kevin.microservices.cliente_microservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    private Long id;
    @NotNull(message = "El nombre es requerido")
    @NotBlank(message =  "El campo nombre no puede estar vacio")
    private String nombre;
    @NotNull(message = "El apellido es requerido")
    @NotBlank(message =  "El campo apellido no puede estar vacio")
    private String apellido;
    @NotNull(message = "El email es requerido")
    @NotBlank(message =  "El campo email no puede estar vacio")
    @Email(message = "Email is not valid")
    private String email;
    private String telefono;
    private String direccion;
    private String ciudad;

}

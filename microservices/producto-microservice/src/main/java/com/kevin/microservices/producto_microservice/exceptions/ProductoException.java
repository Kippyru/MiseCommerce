package com.kevin.microservices.producto_microservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductoException extends RuntimeException{
    private final String message;
}

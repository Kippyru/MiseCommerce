package com.kevin.microservices.carrito_microservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CarritoException extends RuntimeException {
    private final String message;
}

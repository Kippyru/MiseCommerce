package com.kevin.microservices.cliente_microservice.handlers;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClienteNotFoundException extends RuntimeException{
    private final String message;
}

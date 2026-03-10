package com.kevin.microservices.carrito_microservice.dto;
//si quiero hacer 1 solo dto me da error en el mapper, asi hice este especificamente
public record CarritoItemResponse(
        Long productId,
        Integer cantidad
) {

}

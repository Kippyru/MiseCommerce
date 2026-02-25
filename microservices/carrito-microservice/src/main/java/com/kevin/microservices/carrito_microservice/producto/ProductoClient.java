package com.kevin.microservices.carrito_microservice.producto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "PRODUCTO-MICROSERVICE")
public interface ProductoClient {
    @GetMapping("/producto/list/{id}")
    Optional<ProductoDto> listaIdDto(@PathVariable Long id);
}

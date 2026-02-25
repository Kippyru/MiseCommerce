package com.kevin.microservices.carrito_microservice.cliente;
//la verdad ahora que lo pienso cliente client no es un buen nombre...

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@FeignClient(name="CLIENTE-MICROSERVICE") //si o si en mayusculas porq asi lo usa eureka
public interface ClienteClient {

    @RequestMapping("/cliente/list/{id}")
    Optional<ClienteDto> listaIdDto(@PathVariable Long id);

}

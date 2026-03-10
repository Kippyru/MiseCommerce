package com.kevin.microservices.carrito_microservice.mapper;

import com.kevin.microservices.carrito_microservice.dto.CarritoDto;
import com.kevin.microservices.carrito_microservice.dto.CarritoItemResponse;
import com.kevin.microservices.carrito_microservice.model.Carrito;
import com.kevin.microservices.carrito_microservice.model.CarritoItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//el mapper manual en este caso es mas facil y corto que con la dependencia
@Service
public class CarritoMapper {

    public CarritoDto toCartResponse(Carrito cart) {

        List<CarritoItemResponse> cartItemResponses = new ArrayList<>();

        for (CarritoItem item : cart.getItems()) {
            cartItemResponses.add(new CarritoItemResponse(
                    item.getProductId(),
                    item.getCantidad()
            ));
        }
        return new CarritoDto( cart.getId() , cart.getClienteId(), cartItemResponses);
    }
}
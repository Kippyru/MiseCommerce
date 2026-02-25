package com.kevin.microservices.carrito_microservice.mapper;

import com.kevin.microservices.carrito_microservice.dto.CarritoDto;
import com.kevin.microservices.carrito_microservice.model.Carrito;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface CarritoMapper {

    Carrito toEntity(CarritoDto carritoDto);

    CarritoDto toDto(Carrito carrito);

    List<CarritoDto> toList(List<Carrito> carritos);

    void updateCarrito(CarritoDto carritoDto, @MappingTarget Carrito carrito);
}

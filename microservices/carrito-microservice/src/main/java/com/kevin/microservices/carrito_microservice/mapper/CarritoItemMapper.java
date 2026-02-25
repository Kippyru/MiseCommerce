package com.kevin.microservices.carrito_microservice.mapper;

import com.kevin.microservices.carrito_microservice.dto.CarritoItemDto;
import com.kevin.microservices.carrito_microservice.model.CarritoItem;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface CarritoItemMapper {

    CarritoItem toEntity(CarritoItemDto carritoItemDto);

    CarritoItemDto toDto(CarritoItem carritoItem);

    List<CarritoItemDto> toList(List<CarritoItem> carritoItems);

    void updateCarritoItem(CarritoItemDto carritoItemDto, @MappingTarget CarritoItem carritoItem);
}

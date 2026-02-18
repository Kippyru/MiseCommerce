package com.kevin.microservices.producto_microservice.mapper;

import com.kevin.microservices.producto_microservice.dto.CategoriaDto;
import com.kevin.microservices.producto_microservice.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    Categoria toEntity(CategoriaDto categoriaDto);

    CategoriaDto toDto(Categoria categoria);

    List<CategoriaDto> toList(List<Categoria> categorias);

    void updateCategoria(CategoriaDto categoriaDto, @MappingTarget Categoria categoria);
}

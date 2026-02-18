package com.kevin.microservices.producto_microservice.mapper;

import com.kevin.microservices.producto_microservice.dto.ProductoDto;
import com.kevin.microservices.producto_microservice.model.Categoria;
import com.kevin.microservices.producto_microservice.model.Producto;
import com.kevin.microservices.producto_microservice.repository.CategoriaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductoMapper {
    @Autowired
    protected CategoriaRepository categoriaRepository;

    @Mapping(target = "categoria", source = "categoria", qualifiedByName = "mapIdToCategoria")
    public abstract Producto toEntity(ProductoDto productoDto);

    @Mapping(target = "categoria", source = "categoria.id")
    public abstract ProductoDto toDto(Producto producto);

    public abstract List<ProductoDto> toList(List<Producto> productos);

    @Mapping(target = "categoria", source = "categoria", qualifiedByName = "mapIdToCategoria")
    public abstract void updateProducto(ProductoDto productoDto, @MappingTarget Producto producto);

    @Named("mapIdToCategoria")
    protected Categoria mapIdToCategoria(Long categoria) {
        if (categoria == null) return null;
        return categoriaRepository.findById(categoria)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }
}

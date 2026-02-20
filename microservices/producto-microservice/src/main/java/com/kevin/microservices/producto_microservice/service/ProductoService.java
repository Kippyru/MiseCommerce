package com.kevin.microservices.producto_microservice.service;

import com.kevin.microservices.producto_microservice.dto.ProductoCantidadDto;
import com.kevin.microservices.producto_microservice.dto.ProductoDto;
import com.kevin.microservices.producto_microservice.exceptions.CategoriaException;
import com.kevin.microservices.producto_microservice.exceptions.ProductoException;
import com.kevin.microservices.producto_microservice.mapper.ProductoMapper;
import com.kevin.microservices.producto_microservice.model.Producto;
import com.kevin.microservices.producto_microservice.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repo;
    @Autowired
    private ProductoMapper mapper;

    public void crear(ProductoDto productoDto) {
        Producto producto = mapper.toEntity(productoDto);
        repo.save(producto);
    }
    public List<ProductoDto> lista() {
        List<Producto> clienteList = repo.findAll();
        return mapper.toList(clienteList);
    }
    public ProductoDto listaId(Long id) {
        Producto producto = repo.findById(id)
                .orElseThrow(() -> new ProductoException(String.format("Fallo al buscar Producto: producto %d no encontrado", id)));
        return mapper.toDto(producto);
    }
    public ProductoDto editar(Long id, ProductoDto dto) {
        Producto producto = repo.findById(id)
                .orElseThrow(() -> new ProductoException(String.format("Fallo al editar Producto: producto %d no encontrado", id)));
        mapper.updateProducto(dto, producto);
        Producto update = repo.save(producto);
        return mapper.toDto(update);
    }
    public void borrar(Long id) {
        if (id == null) {
            throw new ProductoException("Se necesita un ID");
        }else if(!repo.existsById(id)) {
            throw new ProductoException(String.format("Fallo al borrar Producto: producto &d no encontrado", id));
        }
        repo.deleteById(id);
    }
    @Transactional
    public void comprarProducto(List<ProductoCantidadDto> items) {

        for (ProductoCantidadDto item : items) {

            Producto producto = repo.findById(item.getProductoId())
                    .orElseThrow(() -> new ProductoException(
                            "Producto no encontrado: " + item.getProductoId()
                    ));

            int stockActual = producto.getStock();
            int cantidad = item.getCantidad();

            if (cantidad <= 0) {
                throw new ProductoException("Cantidad inválida para el producto " + producto.getId());
            }

            if (stockActual < cantidad) {
                throw new ProductoException(
                        "Stock insuficiente para el producto " + producto.getNombre()
                );
            }

            producto.setStock(stockActual - cantidad);
        }
    }

    @Transactional
    public void actualizarStockProducto(List<ProductoCantidadDto> items) {
        for (ProductoCantidadDto item : items) {

            Producto producto = repo.findById(item.getProductoId())
                    .orElseThrow(() -> new ProductoException(
                            "Producto no encontrado: " + item.getProductoId()
                    ));

            int cantidad = item.getCantidad();

            if (cantidad <= 0) {
                throw new ProductoException("Cantidad inválida para restock");
            }

            producto.setStock(producto.getStock() + cantidad);
        }
    }
}

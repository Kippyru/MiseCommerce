package com.kevin.microservices.carrito_microservice.service;

import com.kevin.microservices.carrito_microservice.cliente.ClienteClient;
import com.kevin.microservices.carrito_microservice.cliente.ClienteDto;
import com.kevin.microservices.carrito_microservice.dto.CarritoItemDto;
import com.kevin.microservices.carrito_microservice.model.Carrito;
import com.kevin.microservices.carrito_microservice.model.CarritoItem;
import com.kevin.microservices.carrito_microservice.producto.ProductoClient;
import com.kevin.microservices.carrito_microservice.producto.ProductoDto;
import com.kevin.microservices.carrito_microservice.repository.CarritoItemRepository;
import com.kevin.microservices.carrito_microservice.repository.CarritoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarritoItemService {
    private final ClienteClient clienteClient;
    private final ProductoClient productoClient;
    private final CarritoRepository carritoRepository;
    private final CarritoItemRepository carritoItemRepository;

    public String addItem(String clienteId, @Valid CarritoItemDto item) {
      ClienteDto clienteDto = clienteClient.listaIdDto(Long.parseLong(clienteId))
             .orElseThrow(() -> new RuntimeException("El cliente no existe"));

       ProductoDto productoDto = productoClient.listaIdDto(item.productId())
               .orElseThrow(() -> new RuntimeException("El producto no existe"));

       if (productoDto.stock() < item.cantidad()) {
            throw new RuntimeException("Stock insuficiente");
       }

       Carrito carrito = carritoRepository.findByClienteId(clienteId)
                .orElseGet(() -> {
                    Carrito newCarrito = new Carrito();
                    newCarrito.setClienteId(clienteId);
                    return carritoRepository.save(newCarrito);
                });

        CarritoItem carritoItem = carritoItemRepository
                .findByCarritoIdAndProductId(carrito.getId(), item.productId())
                .orElse(null);

        if (carritoItem != null) {
            carritoItem.setCantidad(carritoItem.getCantidad() + item.cantidad());
        } else {
            carritoItem = new CarritoItem();
            carritoItem.setProductId(item.productId());
            carritoItem.setCantidad(item.cantidad());
            carritoItem.setCarrito(carrito);
        }

        carritoItemRepository.save(carritoItem);

        return "Item agregado al carrito";
    }

    public void updateItem(String clienteId, @Valid CarritoItemDto itemDto) {
        Carrito carrito = carritoRepository.findByClienteId(clienteId)
                .orElseThrow(() -> new RuntimeException(String.format("No se encontro el carrito del cliente id: {}", clienteId)));

        CarritoItem itemUpdate = carrito.getItems().stream()
                .filter(item -> item.getProductId() == itemDto.productId())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("El producto no se encuentra en el carrito"));

        if (productoClient.listaIdDto(itemDto.productId()).get().stock() < itemDto.cantidad()) {
            throw new RuntimeException("No hay suficiente stock del producto seleccionado");
        }

        itemUpdate.setCantidad(itemDto.cantidad());

        carritoRepository.save(carrito);
    }

    public void deleteItem(String clienteId, Long productId) {
        Carrito carrito = carritoRepository.findByClienteId(clienteId)
                .orElseThrow(() -> new RuntimeException(String.format("No se encontro el carrito del cliente id: {}", clienteId)));

        CarritoItem removeItem = carrito.getItems().stream()
                .filter(item -> item.getProductId() == productId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No existe stock del producto seleccionado"));

        carrito.getItems().remove(removeItem);
        carritoRepository.save(carrito);
    }
}
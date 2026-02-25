package com.kevin.microservices.carrito_microservice.repository;

import com.kevin.microservices.carrito_microservice.model.CarritoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarritoItemRepository extends JpaRepository<CarritoItem, Long> {
    Optional<CarritoItem> findByCarritoIdAndProductId(Long carrito, Long productId);
}
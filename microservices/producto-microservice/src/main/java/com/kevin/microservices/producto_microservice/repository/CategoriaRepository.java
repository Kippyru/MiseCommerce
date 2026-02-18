package com.kevin.microservices.producto_microservice.repository;

import com.kevin.microservices.producto_microservice.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
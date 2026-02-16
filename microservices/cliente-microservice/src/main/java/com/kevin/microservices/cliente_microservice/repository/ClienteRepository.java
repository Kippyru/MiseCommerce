package com.kevin.microservices.cliente_microservice.repository;

import com.kevin.microservices.cliente_microservice.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
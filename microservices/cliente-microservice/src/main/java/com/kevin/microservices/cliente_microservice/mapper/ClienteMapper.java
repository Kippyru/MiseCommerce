package com.kevin.microservices.cliente_microservice.mapper;

import com.kevin.microservices.cliente_microservice.dto.ClienteDto;
import com.kevin.microservices.cliente_microservice.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteDto clienteDto);

    ClienteDto toDto(Cliente cliente);

    List<ClienteDto> toList(List<Cliente> clientes);

    void updateCliente(ClienteDto clienteDto, @MappingTarget Cliente cliente);
}

package com.kevin.microservices.cliente_microservice.service;

import com.kevin.microservices.cliente_microservice.dto.ClienteDto;
import com.kevin.microservices.cliente_microservice.mapper.ClienteMapper;
import com.kevin.microservices.cliente_microservice.model.Cliente;
import com.kevin.microservices.cliente_microservice.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;

    public void crear(ClienteDto clienteDto) {
        Cliente cliente = clienteMapper.toEntity(clienteDto);
        clienteRepository.save(cliente);
    }
    public List<ClienteDto> lista() {
        List<Cliente> clienteList = clienteRepository.findAll();
        return clienteMapper.toList(clienteList);
    }
    public ClienteDto listaId(long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fallo al buscar cliente: cliente no encontrado"));
        return clienteMapper.toDto(cliente);
    }
    public ClienteDto editar(long id, ClienteDto dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fallo al editar cliente: cliente no encontrado"));
        clienteMapper.updateCliente(dto, cliente);
        Cliente update = clienteRepository.save(cliente);
        return clienteMapper.toDto(update);
    }
    public void borrar(long id) {
        if(!clienteRepository.existsById(id)) {
            throw new RuntimeException("Fallo al borrar cliente: cliente no encontrado");
        }
        clienteRepository.deleteById(id);
    }
}

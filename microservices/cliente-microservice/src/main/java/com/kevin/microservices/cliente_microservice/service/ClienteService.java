package com.kevin.microservices.cliente_microservice.service;

import com.kevin.microservices.cliente_microservice.dto.ClienteDto;
import com.kevin.microservices.cliente_microservice.handlers.ClienteNotFoundException;
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
    public ClienteDto listaId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(String.format("Fallo al buscar cliente: cliente %d no encontrado", id)));
        return clienteMapper.toDto(cliente);
    }
    public ClienteDto editar(Long id, ClienteDto dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(String.format("Fallo al editar cliente: cliente %d no encontrado", id)));
        clienteMapper.updateCliente(dto, cliente);
        Cliente update = clienteRepository.save(cliente);
        return clienteMapper.toDto(update);
    }
    public void borrar(Long id) {
        if (id == null) {
            throw new ClienteNotFoundException("Se necesita un ID");
        }else if(!clienteRepository.existsById(id)) {
            throw new ClienteNotFoundException(String.format("Fallo al borrar cliente: cliente &d no encontrado", id));
        }
        clienteRepository.deleteById(id);
    }
}

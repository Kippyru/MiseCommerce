package com.kevin.microservices.producto_microservice.service;

import com.kevin.microservices.producto_microservice.dto.CategoriaDto;
import com.kevin.microservices.producto_microservice.mapper.CategoriaMapper;
import com.kevin.microservices.producto_microservice.model.Categoria;
import com.kevin.microservices.producto_microservice.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;
    @Autowired
    private CategoriaMapper mapper;

    public void crear(CategoriaDto categoriaDto) {
        Categoria categoria = mapper.toEntity(categoriaDto);
        repo.save(categoria);
    }

    public List<CategoriaDto> lista() {
        List<Categoria> categoriaList = repo.findAll();
        return mapper.toList(categoriaList);
    }

    public CategoriaDto listaId(long id) {
        Categoria categoria = repo.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Fallo al buscar Categoria: categoria %d no encontrado", id)));
        return mapper.toDto(categoria);
    }

    public CategoriaDto editar(long id, CategoriaDto dto) {
        Categoria categoria = repo.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Fallo al editar Categoria: categoria %d no encontrado", id)));
        mapper.updateCategoria(dto, categoria);
        Categoria update = repo.save(categoria);
        return mapper.toDto(update);
    }
    public void borrar(long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException(String.format("Fallo al borrar Categoria: categoria &d no encontrado", id));
        }
        repo.deleteById(id);
    }

}

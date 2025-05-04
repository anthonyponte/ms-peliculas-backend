package com.anthonyponte.peliculas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anthonyponte.peliculas.dto.GeneroDTO;
import com.anthonyponte.peliculas.entity.Genero;
import com.anthonyponte.peliculas.repository.GeneroRepository;

@Component
public class GeneroServiceImpl implements GeneroService {
    @Autowired
    private GeneroRepository repository;

    @Override
    public List<GeneroDTO> listarGeneros() {
        List<Genero> listGeneros = repository.findAll();
        return listGeneros.stream()
                .map(this::convertirAGeneroDTO)
                .collect(Collectors.toList());
    }

    public GeneroDTO convertirAGeneroDTO(Genero genero) {
        GeneroDTO dto = new GeneroDTO();
        dto.setId(genero.getId());
        dto.setDescripcion(genero.getDescripcion());
        return dto;
    }
}

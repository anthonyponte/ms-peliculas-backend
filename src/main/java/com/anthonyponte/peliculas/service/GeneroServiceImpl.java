package com.anthonyponte.peliculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.anthonyponte.peliculas.entity.Genero;
import com.anthonyponte.peliculas.repository.GeneroRepository;

@Component
public class GeneroServiceImpl implements GeneroService {
    @Autowired
    private GeneroRepository repository;

    @Override
    public List<Genero> listarGeneros() {
        return repository.findAll();
    }

    @Override
    public Genero obtenerGeneroPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Género no encontrado"));
    }

    @Override
    public Genero crearGenero(Genero genero) {
        return repository.save(genero);
    }

    @Override
    public Genero actualizarGenero(Long id, Genero genero) {
        Genero g = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Género no encontrado"));

        g.setDescripcion(genero.getDescripcion());

        return repository.save(g);
    }

    @Override
    public void eliminarGeneroPorId(Long id) {
        Genero genero = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Género no encontrado"));

        repository.delete(genero);
    }
}

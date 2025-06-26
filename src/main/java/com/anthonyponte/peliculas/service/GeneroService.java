package com.anthonyponte.peliculas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anthonyponte.peliculas.entity.Genero;

@Service
public interface GeneroService {
    public List<Genero> listarGeneros();

    public Genero obtenerGeneroPorId(Long id);

    public Genero crearGenero(Genero genero);

    public Genero actualizarGenero(Long id, Genero genero);

    public void eliminarGeneroPorId(Long id);
}

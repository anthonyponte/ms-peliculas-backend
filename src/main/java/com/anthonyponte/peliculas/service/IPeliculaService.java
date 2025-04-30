package com.anthonyponte.peliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anthonyponte.peliculas.model.Pelicula;

@Service
public interface IPeliculaService {
    public List<Pelicula> listarTodos();

    public Optional<Pelicula> obtenerPorId(Long id);

    public Pelicula guardar(Pelicula pelicula);

    public Pelicula actualizar(Long id, Pelicula pelicula);

    public void eliminar(Long id);

    public Optional<Pelicula> obtenerPorTituloYGenero(String titulo, String genero);
}

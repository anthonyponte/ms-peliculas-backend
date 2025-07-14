package com.anthonyponte.peliculas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anthonyponte.peliculas.entity.Pelicula;

@Service
public interface PeliculaService {
    public List<Pelicula> listarPeliculas();

    public Pelicula obtenerPeliculaPorId(Long id);

    public Pelicula crearPelicula(Pelicula pelicula);

    public Pelicula actualizarPelicula(Long id, Pelicula pelicula);

    public void eliminarPeliculaPorId(Long id);

    public boolean existePeliculaPorId(Long id);
}

package com.anthonyponte.peliculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.anthonyponte.peliculas.entity.Genero;
import com.anthonyponte.peliculas.entity.Pelicula;
import com.anthonyponte.peliculas.repository.GeneroRepository;
import com.anthonyponte.peliculas.repository.PeliculaRepository;

@Component
public class PeliculaServiceImpl implements PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula obtenerPeliculaPorId(Long id) {
        return peliculaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Película no encontrada"));
    }

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        generoRepository.findById(pelicula.getGenero().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Género no encontrado"));

        return peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula actualizarPelicula(Long id, Pelicula pelicula) {
        Pelicula p = peliculaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Película no encontrada"));

        Genero genero = generoRepository.findById(pelicula.getGenero().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Género no encontrado"));

        p.setTitulo(pelicula.getTitulo());
        p.setDirector(pelicula.getDirector());
        p.setGenero(genero);
        p.setDuracion(pelicula.getDuracion());
        p.setFechaEstreno(pelicula.getFechaEstreno());

        return peliculaRepository.save(p);
    }

    @Override
    public void eliminarPeliculaPorId(Long id) {
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Película no encontrada"));

        peliculaRepository.delete(pelicula);
    }

    @Override
    public boolean existePeliculaPorId(Long id) {
        return peliculaRepository.existsById(id);
    }
}

package com.anthonyponte.peliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anthonyponte.peliculas.model.Pelicula;
import com.anthonyponte.peliculas.repository.PeliculaRepository;

@Component
public class PeliculaServiceImpl implements IPeliculaService {
    @Autowired
    private PeliculaRepository repository;

    @Override
    public List<Pelicula> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Pelicula> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Pelicula guardar(Pelicula pelicula) {
        return repository.save(pelicula);
    }

    @Override
    public Pelicula actualizar(Long id, Pelicula pelicula) {
        return repository.findById(id).map(p -> {
            p.setTitulo(pelicula.getTitulo());
            p.setDirector(pelicula.getDirector());
            p.setGenero(pelicula.getGenero());
            p.setDuracion(pelicula.getDuracion());
            p.setFechaEstreno(pelicula.getFechaEstreno());
            return repository.save(pelicula);
        }).orElseThrow(() -> new IllegalArgumentException("Pelicula no encontrada"));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Pelicula> obtenerPorTituloYGenero(String titulo, String genero) {
        return repository.findByTituloAndGenero(titulo, genero);
    }
}

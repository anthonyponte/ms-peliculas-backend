package com.anthonyponte.mspeliculas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anthonyponte.mspeliculas.model.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    Optional<Pelicula> findByTituloAndGenero(String titulo, String genero);
}

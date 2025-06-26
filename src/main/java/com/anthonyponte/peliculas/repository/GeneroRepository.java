package com.anthonyponte.peliculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anthonyponte.peliculas.entity.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
}

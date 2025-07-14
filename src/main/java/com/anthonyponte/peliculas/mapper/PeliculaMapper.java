package com.anthonyponte.peliculas.mapper;

import java.time.LocalDate;

import com.anthonyponte.peliculas.dto.PeliculaDTO;
import com.anthonyponte.peliculas.entity.Genero;
import com.anthonyponte.peliculas.entity.Pelicula;

public class PeliculaMapper {
    public static PeliculaDTO toDTO(Pelicula pelicula) {
        PeliculaDTO dto = new PeliculaDTO();
        dto.setId(pelicula.getId());
        dto.setTitulo(pelicula.getTitulo());
        dto.setDirector(pelicula.getDirector());
        dto.setIdGenero(pelicula.getGenero().getId());
        dto.setGeneroDescripcion(pelicula.getGenero().getDescripcion());
        dto.setDuracion(pelicula.getDuracion());
        dto.setFechaEstreno(pelicula.getFechaEstreno().toString());

        return dto;
    }

    public static Pelicula toEntity(PeliculaDTO dto) {
        Pelicula pelicula = new Pelicula();
        pelicula.setId(dto.getId());
        pelicula.setTitulo(dto.getTitulo());
        pelicula.setDirector(dto.getDirector());

        Genero genero = new Genero();
        genero.setId(dto.getIdGenero());
        genero.setDescripcion(dto.getGeneroDescripcion());
        pelicula.setGenero(genero);

        pelicula.setDuracion(dto.getDuracion());
        pelicula.setFechaEstreno(LocalDate.parse(dto.getFechaEstreno()));

        return pelicula;
    }
}

package com.anthonyponte.peliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anthonyponte.peliculas.dto.PeliculaDTO;

@Service
public interface IPeliculaService {
    public List<PeliculaDTO> listarPeliculas();

    public Optional<PeliculaDTO> obtenerPeliculaPorId(Long id);

    public PeliculaDTO guardarPelicula(PeliculaDTO dto);

    public void eliminarPelicula(Long id);
}

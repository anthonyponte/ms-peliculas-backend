package com.anthonyponte.peliculas.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anthonyponte.peliculas.dto.PeliculaDTO;
import com.anthonyponte.peliculas.entity.Genero;
import com.anthonyponte.peliculas.entity.Pelicula;
import com.anthonyponte.peliculas.repository.PeliculaRepository;

@Component
public class PeliculaServiceImpl implements IPeliculaService {
    @Autowired
    private PeliculaRepository repository;

    @Override
    public List<PeliculaDTO> listarPeliculas() {
        List<Pelicula> listPeliculas = repository.findAll();
        return listPeliculas.stream()
                .map(this::convertirAPeliculaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PeliculaDTO> obtenerPeliculaPorId(Long id) {
        return repository.findById(id)
                .map(this::convertirAPeliculaDTO);
    }

    @Override
    public PeliculaDTO guardarPelicula(PeliculaDTO dto) {
        Pelicula p = convertirAPelicula(dto);
        Pelicula pelicula = repository.save(p);
        return convertirAPeliculaDTO(pelicula);
    }

    @Override
    public void eliminarPelicula(Long id) {
        repository.deleteById(id);
    }

    private PeliculaDTO convertirAPeliculaDTO(Pelicula pelicula) {
        PeliculaDTO dto = new PeliculaDTO();
        dto.setId(pelicula.getId());
        dto.setTitulo(pelicula.getTitulo());
        dto.setDirector(pelicula.getDirector());
        dto.setGeneroId(pelicula.getGenero().getId());
        dto.setGeneroDescripcion(pelicula.getGenero().getDescripcion());
        dto.setDuracion(pelicula.getDuracion());
        dto.setFechaEstreno(pelicula.getFechaEstreno().toString());
        dto.setFavorito(pelicula.isFavorito());
        return dto;
    }

    private Pelicula convertirAPelicula(PeliculaDTO dto) {
        Pelicula pelicula = new Pelicula();
        pelicula.setId(dto.getId());
        pelicula.setTitulo(dto.getTitulo());
        pelicula.setDirector(dto.getDirector());

        Genero genero = new Genero();
        genero.setId(dto.getGeneroId());
        pelicula.setGenero(genero);

        pelicula.setDuracion(dto.getDuracion());
        pelicula.setFechaEstreno(LocalDate.parse(dto.getFechaEstreno()));
        pelicula.setFavorito(dto.isFavorito());
        return pelicula;
    }
}

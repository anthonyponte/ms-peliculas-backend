package com.anthonyponte.peliculas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anthonyponte.peliculas.dto.PeliculaDTO;
import com.anthonyponte.peliculas.entity.Pelicula;
import com.anthonyponte.peliculas.mapper.PeliculaMapper;
import com.anthonyponte.peliculas.service.PeliculaService;

@RestController
@RequestMapping("/api/v1/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService service;

    @GetMapping
    public List<PeliculaDTO> listarPeliculas() {
        return service.listarPeliculas()
                .stream()
                .map(PeliculaMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> obtenerPeliculaPorId(@PathVariable Long id) {
        Pelicula pelicula = service.obtenerPeliculaPorId(id);
        PeliculaDTO dto = PeliculaMapper.toDTO(pelicula);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<?> crearPelicula(@RequestBody PeliculaDTO peliculaDTO) {
        Pelicula pelicula = PeliculaMapper.toEntity(peliculaDTO);
        Pelicula p = service.crearPelicula(pelicula);
        PeliculaDTO dto = PeliculaMapper.toDTO(p);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .build(p.getId());

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDTO> actualizarPelicula(@PathVariable Long id, @RequestBody PeliculaDTO peliculaDTO) {
        Pelicula pelicula = PeliculaMapper.toEntity(peliculaDTO);
        Pelicula p = service.actualizarPelicula(id, pelicula);
        PeliculaDTO dto = PeliculaMapper.toDTO(p);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarPeliculaPorId(@PathVariable Long id) {
        service.eliminarPeliculaPorId(id);
    }

    @PatchMapping("/{id}/favoritos")
    public ResponseEntity<PeliculaDTO> actualizarPeliculaFavorito(@PathVariable Long id,
            @RequestParam boolean esFavorito) {
        Pelicula pelicula = service.actualizarPeliculaFavorito(id, esFavorito);
        PeliculaDTO dto = PeliculaMapper.toDTO(pelicula);

        return ResponseEntity.ok(dto);
    }
}

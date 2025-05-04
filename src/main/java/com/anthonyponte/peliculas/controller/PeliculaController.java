package com.anthonyponte.peliculas.controller;

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

import com.anthonyponte.peliculas.dto.GeneroDTO;
import com.anthonyponte.peliculas.dto.PeliculaDTO;
import com.anthonyponte.peliculas.service.GeneroService;
import com.anthonyponte.peliculas.service.PeliculaService;

@RestController
@RequestMapping("/api/v1/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<PeliculaDTO>> listarPeliculas() {
        return ResponseEntity.ok(peliculaService.listarPeliculas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> obtenerPeliculaPorId(@PathVariable Long id) {
        return peliculaService.obtenerPeliculaPorId(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PeliculaDTO> crearPelicula(@RequestBody PeliculaDTO dto) {
        return ResponseEntity.ok(peliculaService.guardarPelicula(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDTO> actualizarPelicula(@PathVariable Long id, @RequestBody PeliculaDTO dto) {
        return ResponseEntity.ok(peliculaService.guardarPelicula(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPelicula(@PathVariable Long id) {
        peliculaService.eliminarPelicula(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/favoritos")
    public ResponseEntity<Void> actualizarPeliculaFavorito(@PathVariable Long id,
            @RequestParam boolean esFavorito) {
        peliculaService.actualizarPeliculaFavorito(id, esFavorito);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/generos")
    public ResponseEntity<List<GeneroDTO>> listarGeneros() {
        return ResponseEntity.ok(generoService.listarGeneros());
    }
}

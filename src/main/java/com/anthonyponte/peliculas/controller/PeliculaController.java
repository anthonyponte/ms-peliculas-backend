package com.anthonyponte.peliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anthonyponte.peliculas.dto.GeneroDTO;
import com.anthonyponte.peliculas.dto.PeliculaDTO;
import com.anthonyponte.peliculas.service.IGeneroService;
import com.anthonyponte.peliculas.service.IPeliculaService;

@RestController
@RequestMapping("/api/v1/peliculas")
public class PeliculaController {
    @Autowired
    private IPeliculaService peliculaService;

    @Autowired
    private IGeneroService generoService;

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

    @GetMapping("/generos")
    public ResponseEntity<List<GeneroDTO>> listarGeneros() {
        return ResponseEntity.ok(generoService.listarGeneros());
    }
}

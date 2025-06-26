package com.anthonyponte.peliculas.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anthonyponte.peliculas.dto.GeneroDTO;
import com.anthonyponte.peliculas.entity.Genero;
import com.anthonyponte.peliculas.mapper.GeneroMapper;
import com.anthonyponte.peliculas.service.GeneroService;

@RestController
@RequestMapping("/api/v1/generos")
public class GeneroController {
    @Autowired
    private GeneroService service;

    @GetMapping
    public List<GeneroDTO> listarGeneros() {
        return service.listarGeneros()
                .stream()
                .map(GeneroMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneroDTO> obtenerGeneroPorId(@PathVariable Long id) {
        Genero genero = service.obtenerGeneroPorId(id);
        GeneroDTO dto = GeneroMapper.toDTO(genero);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<?> crearGenero(@RequestBody GeneroDTO generoDTO) {
        Genero genero = GeneroMapper.toEntity(generoDTO);
        Genero g = service.crearGenero(genero);
        GeneroDTO dto = GeneroMapper.toDTO(g);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .build(g.getId());

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneroDTO> actualizarGenero(@PathVariable Long id, @RequestBody GeneroDTO generoDTO) {
        Genero genero = GeneroMapper.toEntity(generoDTO);
        Genero g = service.actualizarGenero(id, genero);
        GeneroDTO dto = GeneroMapper.toDTO(g);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarGeneroPorId(@PathVariable Long id) {
        service.eliminarGeneroPorId(id);
    }
}

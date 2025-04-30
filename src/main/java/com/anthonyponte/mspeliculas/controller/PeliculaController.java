package com.anthonyponte.mspeliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anthonyponte.mspeliculas.model.Pelicula;
import com.anthonyponte.mspeliculas.service.IPeliculaService;

@RestController
@RequestMapping("/api/v1/peliculas")
public class PeliculaController {
    @Autowired
    private IPeliculaService service;

    @GetMapping
    public ResponseEntity<List<Pelicula>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pelicula> crear(@RequestBody Pelicula pelicula) {
        return ResponseEntity.ok(service.guardar(pelicula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizar(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        return ResponseEntity.ok(service.actualizar(id, pelicula));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(params = { "titulo", "genero" })
    public ResponseEntity<Pelicula> obtenerPorTituloYGenero(@RequestAttribute String titulo,
            @RequestAttribute String genero) {
        return service.obtenerPorTituloYGenero(titulo, genero).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

package com.anthonyponte.peliculas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anthonyponte.peliculas.dto.GeneroDTO;

@Service
public interface GeneroService {
    public List<GeneroDTO> listarGeneros();
}

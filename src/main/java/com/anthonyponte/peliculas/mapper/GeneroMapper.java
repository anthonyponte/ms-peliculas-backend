package com.anthonyponte.peliculas.mapper;

import com.anthonyponte.peliculas.dto.GeneroDTO;
import com.anthonyponte.peliculas.entity.Genero;

public class GeneroMapper {
    public static GeneroDTO toDTO(Genero genero) {
        GeneroDTO dto = new GeneroDTO();
        dto.setId(genero.getId());
        dto.setDescripcion(genero.getDescripcion());

        return dto;
    }

    public static Genero toEntity(GeneroDTO dto) {
        Genero genero = new Genero();
        genero.setId(dto.getId());
        genero.setDescripcion(dto.getDescripcion());

        return genero;
    }
}

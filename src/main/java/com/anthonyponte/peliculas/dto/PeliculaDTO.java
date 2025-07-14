package com.anthonyponte.peliculas.dto;

public class PeliculaDTO {
    private Long id;
    private String titulo;
    private String director;
    private Long idGenero;
    private String generoDescripcion;
    private Integer duracion;
    private String fechaEstreno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public String getGeneroDescripcion() {
        return generoDescripcion;
    }

    public void setGeneroDescripcion(String generoDescripcion) {
        this.generoDescripcion = generoDescripcion;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }
}

package com.example.curso_service.model;

import java.util.List;

public class Material {

    private Long id;

    private String titulo;
    private String tipo;
    private String url;


    private List<CursoMaterial> cursoMateriales;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<CursoMaterial> getCursoMateriales() {
        return cursoMateriales;
    }

    public void setCursoMateriales(List<CursoMaterial> cursoMateriales) {
        this.cursoMateriales = cursoMateriales;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    // Getters, Setters, Constructors
}
package com.example.curso_service.data;

import lombok.Data;

@Data
public class MaterialDTO {
    private Long id;
    private String titulo;
    private String tipo;
    private String url;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUrl() {
        return url;
    }
}
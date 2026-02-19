package com.codecrafters.urbanalertgt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Estado")
public class Estado {

    @Id
    private Long id;
    private String nombreEstado;
    private String descripcionEstado;
    private int activo;

    public Estado (){
    }

    public Estado(Long id, String nombreEstado, String descripcionEstado, int activo) {
        this.id = id;
        this.nombreEstado = nombreEstado;
        this.descripcionEstado = descripcionEstado;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public void setIdEstado(Long id) {
    }
}

package com.Portfolio.AdrOnores.Dto;

import jakarta.validation.constraints.NotBlank;


public class dtoHyS {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
    
    @NotBlank
    private String img;
    
    public dtoHyS() {
    }

    public dtoHyS(String nombre, int porcentaje, String img) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}

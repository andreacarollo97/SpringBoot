package com.angularSpring.demoAngSpring.dto;


import com.angularSpring.demoAngSpring.models.ParcoAuto;

public class AutoDto {

    private Long id;

    private String marca;

    private String modello;

    private String targa;

    private ParcoAuto parcoAuto;

    public ParcoAuto getParcoAuto() {
        return parcoAuto;
    }

    public void setParcoAuto(ParcoAuto parcoAuto) {
        this.parcoAuto = parcoAuto;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }
}

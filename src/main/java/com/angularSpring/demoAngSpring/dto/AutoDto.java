package com.angularSpring.demoAngSpring.dto;




public class AutoDto {

    private Long id;

    private String marca;

    private String modello;

    private String targa;

    private String nomeParcoAuto;

    public String getNomeParcoAuto() {
        return nomeParcoAuto;
    }

    public void setNomeParcoAuto(String nomeParcoAuto) {
        this.nomeParcoAuto = nomeParcoAuto;
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

package com.angularSpring.demoAngSpring.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "auto")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String marca;

    @Column
    private String modello;

    @Column
    private String targa;


    @OneToMany(mappedBy = "auto", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

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

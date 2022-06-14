package com.angularSpring.demoAngSpring.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "parcoAuto")
public class ParcoAuto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String nome;
    @Column
    private String cittadina;
    @Column
    private String indirizzo;

    @OneToMany(mappedBy = "parcoAuto")
    private List<Auto> autoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCittadina() {
        return cittadina;
    }

    public void setCittadina(String cittadina) {
        this.cittadina = cittadina;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }


}

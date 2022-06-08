package com.angularSpring.demoAngSpring.dto;

import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.models.User;

import java.time.LocalDate;

public class PrenotazioneDto {

    private Long id;

    private LocalDate dataInizio;

    private LocalDate dataFine;

    private int stato;

    private Auto auto;

    private User user;

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public int getStato() {
        return stato;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }




}

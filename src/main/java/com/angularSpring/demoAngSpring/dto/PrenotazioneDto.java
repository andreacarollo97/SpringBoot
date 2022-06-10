package com.angularSpring.demoAngSpring.dto;

import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.models.User;
import com.angularSpring.demoAngSpring.repository.AutoRepository;

import java.time.LocalDate;

public class PrenotazioneDto {

    private Long id;

    private LocalDate dataInizio;

    private LocalDate dataFine;

    private int stato;

    private AutoDto autoDto;

    private UserDto userDto;

    public AutoDto getAutoDto() {
        return autoDto;
    }

    public void setAutoDto(AutoDto autoDto) {
        this.autoDto = autoDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
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

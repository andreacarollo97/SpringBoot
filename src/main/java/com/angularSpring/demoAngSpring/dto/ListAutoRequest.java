package com.angularSpring.demoAngSpring.dto;


import java.time.LocalDate;

public class ListAutoRequest {

    private String dataInizio;
    private String dataFine;

    public ListAutoRequest(String dataInizio, String dataFine) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }

    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
    }
}

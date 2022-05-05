package com.angularSpring.demoAngSpring.mapper;


import com.angularSpring.demoAngSpring.dto.PrenotazioneResponse;
import com.angularSpring.demoAngSpring.models.Prenotazione;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrenotazioneConverter {
    public PrenotazioneResponse convertEntityToDto(Prenotazione prenotazione){
        PrenotazioneResponse prenotazioneResponse = new PrenotazioneResponse();
        prenotazioneResponse.setId(prenotazione.getId());
        prenotazioneResponse.setDataInizio(prenotazione.getDataInizio());
        prenotazioneResponse.setDataFine(prenotazione.getDataFine());
        prenotazioneResponse.setAuto(prenotazione.getAuto());
        prenotazioneResponse.setUser(prenotazione.getUser());
        return prenotazioneResponse;
    }

    public Prenotazione convertDtoToEntity(PrenotazioneResponse prenotazioneResponse){
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setId(prenotazioneResponse.getId());
        prenotazione.setDataInizio(prenotazioneResponse.getDataInizio());
        prenotazione.setDataFine(prenotazioneResponse.getDataFine());
        prenotazione.setAuto(prenotazioneResponse.getAuto());
        prenotazione.setUser(prenotazioneResponse.getUser());
        return prenotazione;
    }

    public List<PrenotazioneResponse> entityToDto(List<Prenotazione> prenotazioni) {
        List<PrenotazioneResponse> prenotazioneResponses = new ArrayList<>();
        for (Prenotazione prenotazione : prenotazioni) {
            PrenotazioneResponse response = new PrenotazioneResponse();
            response.setId(prenotazione.getId());
            response.setDataInizio(prenotazione.getDataInizio());
            response.setDataFine(prenotazione.getDataFine());
            response.setAuto(prenotazione.getAuto());
            response.setUser(prenotazione.getUser());
            prenotazioneResponses.add(response);
        }
        return prenotazioneResponses;
    }
}

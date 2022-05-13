package com.angularSpring.demoAngSpring.mapper;


import com.angularSpring.demoAngSpring.dto.PrenotazioneRequest;
import com.angularSpring.demoAngSpring.dto.PrenotazioneResponse;
import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.models.Prenotazione;
import com.angularSpring.demoAngSpring.models.User;
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
        prenotazioneResponse.setStato(prenotazione.getStato());
        return prenotazioneResponse;
    }

    public Prenotazione convertDtoToEntity(PrenotazioneResponse prenotazioneResponse){
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setId(prenotazioneResponse.getId());
        prenotazione.setDataInizio(prenotazioneResponse.getDataInizio());
        prenotazione.setDataFine(prenotazioneResponse.getDataFine());
        prenotazione.setAuto(prenotazioneResponse.getAuto());
        prenotazione.setUser(prenotazioneResponse.getUser());
        prenotazione.setStato(prenotazioneResponse.getStato());
        return prenotazione;
    }

    public Prenotazione convertRequestToEntity(PrenotazioneRequest prenotazioneRequest, Auto auto, User user){
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setId(prenotazioneRequest.getId());
        prenotazione.setDataInizio(prenotazioneRequest.getDataInizio());
        prenotazione.setDataFine(prenotazioneRequest.getDataFine());
        prenotazione.setStato(prenotazioneRequest.getStato());
        prenotazione.setAuto(auto);
        prenotazione.setUser(user);
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
            response.setStato(prenotazione.getStato());
            prenotazioneResponses.add(response);
        }
        return prenotazioneResponses;
    }
}

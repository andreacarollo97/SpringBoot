package com.angularSpring.demoAngSpring.mapper;


import com.angularSpring.demoAngSpring.dto.PrenotaDto;
import com.angularSpring.demoAngSpring.dto.PrenotazioneDto;
import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.models.Prenotazione;
import com.angularSpring.demoAngSpring.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrenotazioneConverter {
    public PrenotazioneDto convertEntityToDto(Prenotazione prenotazione){
        PrenotazioneDto prenotazioneDto = new PrenotazioneDto();
        prenotazioneDto.setId(prenotazione.getId());
        prenotazioneDto.setDataInizio(prenotazione.getDataInizio());
        prenotazioneDto.setDataFine(prenotazione.getDataFine());
        prenotazioneDto.setAuto(prenotazione.getAuto());
        prenotazioneDto.setUser(prenotazione.getUser());
        prenotazioneDto.setStato(prenotazione.getStato());
        return prenotazioneDto;
    }



    public Prenotazione convertRequestToEntity(PrenotaDto prenotaDto, Auto auto, User user){
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setId(prenotaDto.getId());
        prenotazione.setDataInizio(prenotaDto.getDataInizio());
        prenotazione.setDataFine(prenotaDto.getDataFine());
        prenotazione.setStato(prenotaDto.getStato());
        prenotazione.setAuto(auto);
        prenotazione.setUser(user);
        return prenotazione;
    }

    public List<PrenotazioneDto> entityToDto(List<Prenotazione> prenotazioni) {
        List<PrenotazioneDto> prenotazioneResponse = new ArrayList<>();
        for (Prenotazione prenotazione : prenotazioni) {
            PrenotazioneDto response = new PrenotazioneDto();
            response.setId(prenotazione.getId());
            response.setDataInizio(prenotazione.getDataInizio());
            response.setDataFine(prenotazione.getDataFine());
            response.setAuto(prenotazione.getAuto());
            response.setUser(prenotazione.getUser());
            response.setStato(prenotazione.getStato());
            prenotazioneResponse.add(response);
        }
        return prenotazioneResponse;
    }
}

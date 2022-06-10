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
        prenotazioneDto.setAutoDto(prenotazioneDto.getAutoDto());
        prenotazioneDto.setUserDto(prenotazioneDto.getUserDto());
        prenotazioneDto.setStato(prenotazione.getStato());
        return prenotazioneDto;
    }



    public Prenotazione convertDtoToEntity(PrenotaDto prenotaDto, Auto auto, User user){
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setId(prenotaDto.getId());
        prenotazione.setDataInizio(prenotaDto.getDataInizio());
        prenotazione.setDataFine(prenotaDto.getDataFine());
        prenotazione.setStato(prenotaDto.getStato());
        prenotazione.setAuto(auto);
        prenotazione.setUser(user);
        return prenotazione;
    }


    public List<PrenotazioneDto> convertListOfEntityToDto(List<Prenotazione> prenotazioni) {
        List<PrenotazioneDto> prenotazioneResponse = new ArrayList<>();
        for (Prenotazione prenotazione : prenotazioni) {
            prenotazioneResponse.add(convertEntityToDto(prenotazione));
        }
        return prenotazioneResponse;
    }



}

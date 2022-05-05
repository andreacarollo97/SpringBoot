package com.angularSpring.demoAngSpring.services;


import com.angularSpring.demoAngSpring.dto.AutoResponse;
import com.angularSpring.demoAngSpring.dto.PrenotazioneResponse;
import com.angularSpring.demoAngSpring.mapper.PrenotazioneConverter;
import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.repository.AutoRepository;
import com.angularSpring.demoAngSpring.repository.PrenotazioneRepository;
import com.angularSpring.demoAngSpring.models.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private PrenotazioneConverter prenotazioneConverter;

    @Autowired
    private AutoRepository autoRepository;


    @Override
    public PrenotazioneResponse save(PrenotazioneResponse prenotazioneResponse) {
        Prenotazione prenotazione = prenotazioneConverter.convertDtoToEntity(prenotazioneResponse);
        prenotazione = prenotazioneRepository.save(prenotazione);
        return prenotazioneConverter.convertEntityToDto(prenotazione);
    }

    @Override
    public PrenotazioneResponse findById(Long id) {
        Prenotazione prenotazione = prenotazioneRepository.getPrenotazioneById(id);
        return prenotazioneConverter.convertEntityToDto(prenotazione);
    }

    @Override
    public List<PrenotazioneResponse> findAll() {
        List<Prenotazione> prenotazioni = prenotazioneRepository.getAllBy();
        return prenotazioneConverter.entityToDto(prenotazioni);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Auto> autoDisponibili(LocalDate dataInizio, LocalDate dataFine) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.getPrenotazionesByDataInizioLessThanAndDataFineGreaterThan(dataFine,dataInizio);
        List<Long> idAutoPrenotate = new ArrayList<>();

        for (Prenotazione prenotazione : prenotazioni){
            Long autoId = prenotazione.getAuto().getId();
            idAutoPrenotate.add(autoId);
        }
        if (idAutoPrenotate.size() == 0){
            List<Auto> autos = autoRepository.findAll();
            return autos;
        }
        else {
            List<Auto> autoDisponibili = autoRepository.getAutoByIdNotIn(idAutoPrenotate);
            return autoDisponibili;
        }
    }

}

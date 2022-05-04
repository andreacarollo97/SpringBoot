package com.angularSpring.demoAngSpring.services;


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
    private AutoRepository autoRepository;



    @Override
    public Prenotazione save(Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    @Override
    public Prenotazione findById(Long id) {
        return prenotazioneRepository.findById(id).orElse(null);
    }

    @Override
    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        prenotazioneRepository.deleteById(id);
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

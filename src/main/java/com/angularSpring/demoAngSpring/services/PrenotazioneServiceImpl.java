package com.angularSpring.demoAngSpring.services;

import com.angularSpring.demoAngSpring.dto.AutoResponse;
import com.angularSpring.demoAngSpring.dto.PrenotazioneRequest;
import com.angularSpring.demoAngSpring.dto.PrenotazioneResponse;
import com.angularSpring.demoAngSpring.mapper.PrenotazioneConverter;
import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.models.User;
import com.angularSpring.demoAngSpring.repository.AutoRepository;
import com.angularSpring.demoAngSpring.repository.PrenotazioneRepository;
import com.angularSpring.demoAngSpring.models.Prenotazione;
import com.angularSpring.demoAngSpring.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;


    @Override
    public void save(PrenotazioneRequest prenotazioneRequest) {
        Auto auto = autoRepository.getAutoById(prenotazioneRequest.getAutoId());
        User user = userRepository.getUserById(prenotazioneRequest.getUserId());
        Prenotazione prenotazione = prenotazioneConverter.convertRequestToEntity(prenotazioneRequest,auto,user);
        prenotazioneRepository.save(prenotazione);
    }


    @Override
    public void validate(Long id) {
        Prenotazione prenotazione = prenotazioneRepository.getPrenotazioneById(id);
        prenotazione.setStato(1);
        prenotazioneRepository.save(prenotazione);
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

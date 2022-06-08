package com.angularSpring.demoAngSpring.services;

import com.angularSpring.demoAngSpring.dto.PrenotaDto;
import com.angularSpring.demoAngSpring.dto.PrenotazioneDto;
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


    private final PrenotazioneRepository prenotazioneRepository;
    private final PrenotazioneConverter prenotazioneConverter;
    private final AutoRepository autoRepository;
    private final UserRepository userRepository;

    public PrenotazioneServiceImpl(PrenotazioneRepository prenotazioneRepository, PrenotazioneConverter prenotazioneConverter, AutoRepository autoRepository, UserRepository userRepository){
        this.prenotazioneRepository = prenotazioneRepository;
        this.prenotazioneConverter = prenotazioneConverter;
        this.autoRepository = autoRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void save(PrenotaDto prenotaDto) {
        Auto auto = autoRepository.getAutoById(prenotaDto.getAutoId());
        User user = userRepository.getUserById(prenotaDto.getUserId());
        Prenotazione prenotazione = prenotazioneConverter.convertRequestToEntity(prenotaDto,auto,user);
        prenotazioneRepository.save(prenotazione);
    }


    @Override
    public void validate(Long id) {
        Prenotazione prenotazione = prenotazioneRepository.getPrenotazioneById(id);
        prenotazione.setStato(1);
        prenotazioneRepository.save(prenotazione);
    }


    @Override
    public PrenotazioneDto findById(Long id) {
        Prenotazione prenotazione = prenotazioneRepository.getPrenotazioneById(id);
        return prenotazioneConverter.convertEntityToDto(prenotazione);
    }

    @Override
    public List<PrenotazioneDto> findAll() {
        List<Prenotazione> prenotazioni = prenotazioneRepository.getAllBy();
        return prenotazioneConverter.entityToDto(prenotazioni);
    }

    @Override
    public List<PrenotazioneDto> findAllbyUser(User user) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.getAllByUser(user);
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

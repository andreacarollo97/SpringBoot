package com.angularSpring.demoAngSpring.services;





import com.angularSpring.demoAngSpring.dto.PrenotaDto;
import com.angularSpring.demoAngSpring.dto.PrenotazioneDto;
import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.models.User;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneService {

    void save(PrenotaDto prenotaDto);

    void validate(Long id);

    PrenotazioneDto findById(Long id);

    List<PrenotazioneDto> findAll();

    void delete(Long id);

    List<Auto> autoDisponibili(LocalDate dataInizio, LocalDate dataFine);

    List<PrenotazioneDto> findAllbyUser(User user);
}

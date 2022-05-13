package com.angularSpring.demoAngSpring.services;





import com.angularSpring.demoAngSpring.dto.PrenotazioneRequest;
import com.angularSpring.demoAngSpring.dto.PrenotazioneResponse;
import com.angularSpring.demoAngSpring.models.Auto;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneService {

    void save(PrenotazioneRequest prenotazioneRequest);

    void validate(Long id);

    PrenotazioneResponse findById(Long id);

    List<PrenotazioneResponse> findAll();

    void delete(Long id);

    List<Auto> autoDisponibili(LocalDate dataInizio, LocalDate dataFine);
}

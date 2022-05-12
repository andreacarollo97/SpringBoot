package com.angularSpring.demoAngSpring.services;





import com.angularSpring.demoAngSpring.dto.AutoResponse;
import com.angularSpring.demoAngSpring.dto.PrenotazioneResponse;
import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.models.Prenotazione;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneService {

    PrenotazioneResponse save(PrenotazioneResponse prenotazioneResponse);

    PrenotazioneResponse validate(Long id);

    PrenotazioneResponse findById(Long id);

    List<PrenotazioneResponse> findAll();

    void delete(Long id);

    List<Auto> autoDisponibili(LocalDate dataInizio, LocalDate dataFine);
}

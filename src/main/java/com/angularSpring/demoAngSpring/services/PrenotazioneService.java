package com.angularSpring.demoAngSpring.services;





import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.models.Prenotazione;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneService {

    Prenotazione save(Prenotazione prenotazione);

    Prenotazione findById(Long id);

    List<Prenotazione> findAll();

    void delete(Long id);

    List<Auto> autoDisponibili(LocalDate dataInizio, LocalDate dataFine);
}

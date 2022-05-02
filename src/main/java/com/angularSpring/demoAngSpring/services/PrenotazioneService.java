package com.angularSpring.demoAngSpring.services;





import com.angularSpring.demoAngSpring.models.Prenotazione;

import java.util.List;

public interface PrenotazioneService {

    Prenotazione save(Prenotazione prenotazione);

    Prenotazione findById(Long id);

    List<Prenotazione> findAll();

    void delete(Long id);
}

package com.angularSpring.demoAngSpring.repository;

import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.models.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    List<Prenotazione> getPrenotazionesByDataInizioLessThanAndDataFineGreaterThan(LocalDate dataFine,LocalDate dataInizio);

}

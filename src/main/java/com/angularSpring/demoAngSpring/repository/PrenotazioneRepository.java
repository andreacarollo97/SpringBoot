package com.angularSpring.demoAngSpring.repository;

import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.models.ParcoAuto;
import com.angularSpring.demoAngSpring.models.Prenotazione;
import com.angularSpring.demoAngSpring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    List<Prenotazione> getPrenotazionesByDataInizioLessThanAndDataFineGreaterThan(LocalDate dataFine,LocalDate dataInizio);

    List<Prenotazione> getAllBy();

    Prenotazione getPrenotazioneById (Long prenotazioneId);

    List<Prenotazione> getAllByUser(User user);



}

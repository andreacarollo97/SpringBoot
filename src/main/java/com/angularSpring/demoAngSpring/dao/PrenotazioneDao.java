package com.angularSpring.demoAngSpring.dao;

import com.angularSpring.demoAngSpring.models.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneDao extends JpaRepository<Prenotazione, Long> {
}

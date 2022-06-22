package com.angularSpring.demoAngSpring.repository;

import com.angularSpring.demoAngSpring.models.ParcoAuto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParcoAutoRepository extends JpaRepository<ParcoAuto, Long> {

    ParcoAuto getParcoAutoById(Long id);
    List<ParcoAuto> getAllBy();
    ParcoAuto getParcoAutoByNome(String nome);
}

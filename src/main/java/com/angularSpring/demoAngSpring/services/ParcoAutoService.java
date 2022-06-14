package com.angularSpring.demoAngSpring.services;

import com.angularSpring.demoAngSpring.dto.AutoDto;
import com.angularSpring.demoAngSpring.dto.ParcoAutoDto;
import com.angularSpring.demoAngSpring.models.Auto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ParcoAutoService {

    void save(ParcoAutoDto parcoAutoDto);

    List<AutoDto> autoLibere();

    void associate(Long parcoId, Long autoId);

    ParcoAutoDto findById(Long id);

    List<ParcoAutoDto> findAll();

    void delete(Long id);

    List<AutoDto> listAutoByIdParco(Long id);



}

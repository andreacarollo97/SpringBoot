package com.angularSpring.demoAngSpring.services;

import com.angularSpring.demoAngSpring.dto.AutoDto;
import com.angularSpring.demoAngSpring.dto.ParcoAutoDto;

import java.util.List;


public interface ParcoAutoService {

    void save(ParcoAutoDto parcoAutoDto);

    List<AutoDto> autoLibere();

    void associate(Long parcoId, Long autoId);

    void multiAssociate(List<Long> idAuto, Long idParco);


    ParcoAutoDto findById(Long id);

    List<ParcoAutoDto> findAll();

    void delete(Long id);

    List<AutoDto> listAutoByIdParco(Long id);



}

package com.angularSpring.demoAngSpring.services;

import com.angularSpring.demoAngSpring.dto.AutoDto;
import com.angularSpring.demoAngSpring.dto.ParcoAutoDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ParcoAutoService {

    void save(ParcoAutoDto parcoAutoDto);

    void associate(Long id);

    ParcoAutoDto findById(Long id);

    List<ParcoAutoDto> findAll();

    void delete(Long id);

    List<AutoDto> listAutoByIdParco (Long id);

}

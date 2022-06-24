package com.angularSpring.demoAngSpring.services;



import com.angularSpring.demoAngSpring.dto.AutoDto;
import com.angularSpring.demoAngSpring.dto.EditAutoDto;

import java.util.List;

public interface AutoService {


    void salva(EditAutoDto editAutoDto);

    AutoDto findById(Long id);

    List<AutoDto> findAll();

    List<AutoDto> listAutoNonLibere();

    void delete(Long id);

}

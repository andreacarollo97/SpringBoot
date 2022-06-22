package com.angularSpring.demoAngSpring.services;



import com.angularSpring.demoAngSpring.dto.AutoDto;
import com.angularSpring.demoAngSpring.dto.EditAutoDto;

import java.util.List;

public interface AutoService {

    void save(AutoDto autoDto);

    void edit(EditAutoDto editAutoDto);

    AutoDto findById(Long id);

    List<AutoDto> findAll();

    void delete(Long id);

}

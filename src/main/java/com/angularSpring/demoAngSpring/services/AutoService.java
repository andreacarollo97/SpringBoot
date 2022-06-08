package com.angularSpring.demoAngSpring.services;



import com.angularSpring.demoAngSpring.dto.AutoDto;

import java.util.List;

public interface AutoService {

    AutoDto save(AutoDto autoDto);

    AutoDto findById(Long id);

    List<AutoDto> findAll();

    void delete(Long id);

}

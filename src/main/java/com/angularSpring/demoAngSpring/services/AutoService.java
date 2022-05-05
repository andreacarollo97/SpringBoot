package com.angularSpring.demoAngSpring.services;



import com.angularSpring.demoAngSpring.dto.AutoResponse;
import com.angularSpring.demoAngSpring.models.Auto;

import java.util.List;

public interface AutoService {

    AutoResponse save(AutoResponse autoResponse);

    AutoResponse findById(Long id);

    List<AutoResponse> findAll();

    void delete(Long id);

}

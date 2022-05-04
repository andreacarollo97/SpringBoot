package com.angularSpring.demoAngSpring.services;



import com.angularSpring.demoAngSpring.models.Auto;

import java.util.List;

public interface AutoService {

    Auto save(Auto auto);

    Auto findById(Long id);

    void setAuto(Auto auto, Auto autoAttuale);

    List<Auto> findAll();

    void delete(Long id);
}

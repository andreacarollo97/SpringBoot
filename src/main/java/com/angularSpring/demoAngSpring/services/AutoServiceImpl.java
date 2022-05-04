package com.angularSpring.demoAngSpring.services;


import com.angularSpring.demoAngSpring.repository.AutoRepository;
import com.angularSpring.demoAngSpring.models.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoRepository autoRepository;


    @Override
    public Auto save(Auto auto) {
        return autoRepository.save(auto);
    }

    @Override
    public Auto findById(Long id) {
        return autoRepository.findById(id).orElse(null);
    }

    @Override
    public void setAuto(Auto auto, Auto autoAttuale) {
        autoAttuale.setMarca(auto.getMarca());
        autoAttuale.setModello(auto.getModello());
        autoAttuale.setTarga(auto.getTarga());
    }

    @Override
    public List<Auto> findAll() {
        return autoRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        autoRepository.deleteById(id);
    }
}

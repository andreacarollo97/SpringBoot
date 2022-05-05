package com.angularSpring.demoAngSpring.services;


import com.angularSpring.demoAngSpring.dto.AutoResponse;
import com.angularSpring.demoAngSpring.mapper.AutoConverter;
import com.angularSpring.demoAngSpring.repository.AutoRepository;
import com.angularSpring.demoAngSpring.models.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoRepository autoRepository;

    @Autowired
    private AutoConverter autoConverter;


    @Override
    public AutoResponse save(AutoResponse autoResponse) {
        Auto auto = autoConverter.convertDtoToEntity(autoResponse);
        auto = autoRepository.save(auto);
        return autoConverter.convertEntityToDto(auto);
    }

    @Override
    public AutoResponse findById(Long id) {
        Auto auto = autoRepository.getAutoById(id);
        return autoConverter.convertEntityToDto(auto);
    }

    @Override
    public List<AutoResponse> findAll() {
        List<Auto> autos = autoRepository.getAllBy();
        return autoConverter.entityToDto(autos);
    }

    @Override
    public void delete(Long id) {
        autoRepository.deleteById(id);
    }

}

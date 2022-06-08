package com.angularSpring.demoAngSpring.services;


import com.angularSpring.demoAngSpring.dto.AutoDto;
import com.angularSpring.demoAngSpring.mapper.AutoConverter;
import com.angularSpring.demoAngSpring.repository.AutoRepository;
import com.angularSpring.demoAngSpring.models.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AutoServiceImpl implements AutoService {


    private final AutoRepository autoRepository;
    private final AutoConverter autoConverter;

    @Autowired
    public AutoServiceImpl(AutoRepository autoRepository,AutoConverter autoConverter){
        this.autoConverter = autoConverter;
        this.autoRepository = autoRepository;
    }


    @Override
    public AutoDto save(AutoDto autoDto) {
        Auto auto = autoConverter.convertDtoToEntity(autoDto);
        auto = autoRepository.save(auto);
        return autoConverter.convertEntityToDto(auto);
    }

    @Override
    public AutoDto findById(Long id) {
        Auto auto = autoRepository.getAutoById(id);
        return autoConverter.convertEntityToDto(auto);
    }

    @Override
    public List<AutoDto> findAll() {
        List<Auto> autos = autoRepository.getAllBy();
        return autoConverter.entityToDto(autos);
    }

    @Override
    public void delete(Long id) {
        autoRepository.deleteById(id);
    }

}

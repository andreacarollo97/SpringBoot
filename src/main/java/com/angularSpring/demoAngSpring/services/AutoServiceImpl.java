package com.angularSpring.demoAngSpring.services;


import com.angularSpring.demoAngSpring.dto.AutoDto;
import com.angularSpring.demoAngSpring.dto.EditAutoDto;
import com.angularSpring.demoAngSpring.mapper.AutoConverter;
import com.angularSpring.demoAngSpring.repository.AutoRepository;
import com.angularSpring.demoAngSpring.models.Auto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AutoServiceImpl implements AutoService {

    private final AutoRepository autoRepository;
    private final AutoConverter autoConverter;

    public AutoServiceImpl(AutoRepository autoRepository, AutoConverter autoConverter){
        this.autoConverter = autoConverter;
        this.autoRepository = autoRepository;
    }
    @Override
    public void save(AutoDto autoDto) {
        Auto auto = autoConverter.convertDtoToEntity(autoDto);
        autoRepository.save(auto);
    }

    @Override
    public void edit(EditAutoDto editAutoDto) {
        Auto auto;
        if (editAutoDto.getId() != null) {
            auto = autoRepository.getAutoById(editAutoDto.getId());
            autoConverter.updateAutoByEditAuto(auto, editAutoDto);
        }
        else {
            auto = autoConverter.convertEditAutoToAuto(editAutoDto);
        }
        autoRepository.save(auto);
    }

    @Override
    public AutoDto findById(Long id) {
        Auto auto = autoRepository.getAutoById(id);
        return autoConverter.convertEntityToDto(auto);
    }


    @Override
    public List<AutoDto> findAll() {
        List<Auto> autos = autoRepository.getAllBy();
        return autoConverter.convertListOfEntityToDto(autos);
    }

    @Override
    public void delete(Long id) {
        autoRepository.deleteById(id);
    }

}

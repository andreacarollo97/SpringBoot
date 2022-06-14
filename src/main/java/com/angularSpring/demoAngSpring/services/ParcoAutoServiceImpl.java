package com.angularSpring.demoAngSpring.services;

import com.angularSpring.demoAngSpring.dto.AutoDto;
import com.angularSpring.demoAngSpring.dto.ParcoAutoDto;
import com.angularSpring.demoAngSpring.mapper.AutoConverter;
import com.angularSpring.demoAngSpring.mapper.ParcoAutoConverter;
import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.models.ParcoAuto;
import com.angularSpring.demoAngSpring.repository.AutoRepository;
import com.angularSpring.demoAngSpring.repository.ParcoAutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcoAutoServiceImpl implements ParcoAutoService {

    private final ParcoAutoConverter parcoAutoConverter;
    private final ParcoAutoRepository parcoAutoRepository;
    private final AutoRepository autoRepository;

    private final AutoConverter autoConverter;


    public ParcoAutoServiceImpl(ParcoAutoConverter parcoAutoConverter, ParcoAutoRepository parcoAutoRepository, AutoRepository autoRepository, AutoConverter autoConverter){
        this.parcoAutoConverter = parcoAutoConverter;
        this.parcoAutoRepository = parcoAutoRepository;
        this.autoRepository = autoRepository;
        this.autoConverter = autoConverter;
    }

    @Override
    public void save(ParcoAutoDto parcoAutoDto) {
          List<Auto> autoList = autoRepository.getAllByParcoAutoId(parcoAutoDto.getId());
          ParcoAuto parcoAuto = parcoAutoConverter.convertDtoToEntity(parcoAutoDto,autoList);
          parcoAutoRepository.save(parcoAuto);
    }

    @Override
    public void associate(Long idParcoAuto) {
    }

    @Override
    public ParcoAutoDto findById(Long id) {
        ParcoAuto parcoAuto = parcoAutoRepository.getParcoAutoById(id);
        return parcoAutoConverter.convertEntityToDto(parcoAuto);
    }

    @Override
    public List<ParcoAutoDto> findAll() {
        List<ParcoAuto> parchiAuto = parcoAutoRepository.getAllBy();
        return parcoAutoConverter.convertListOfEntityToDto(parchiAuto);
    }

    @Override
    public void delete(Long id) {
        parcoAutoRepository.deleteById(id);
    }

    @Override
    public List<AutoDto> listAutoByIdParco(Long id) {
        List<Auto> autoParco = autoRepository.getAllByParcoAutoId(id);
        return autoConverter.convertListOfEntityToDto(autoParco);
    }
}

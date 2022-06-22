package com.angularSpring.demoAngSpring.mapper;

import com.angularSpring.demoAngSpring.dto.AutoDto;
import com.angularSpring.demoAngSpring.dto.EditAutoDto;
import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.repository.ParcoAutoRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AutoConverter {

    private final ParcoAutoRepository parcoAutoRepository;

    public AutoConverter(ParcoAutoRepository parcoAutoRepository) {
        this.parcoAutoRepository = parcoAutoRepository;

    }

    public AutoDto convertEntityToDto(Auto auto){
        AutoDto autoDto = new AutoDto();
        autoDto.setId(auto.getId());
        autoDto.setMarca(auto.getMarca());
        autoDto.setModello(auto.getModello());
        autoDto.setTarga(auto.getTarga());
        if(auto.getParcoAuto() == null){
            autoDto.setNomeParcoAuto("Non Assegnato!");
        }
        else {
            autoDto.setNomeParcoAuto(auto.getParcoAuto().getNome());
        }
        return autoDto;
    }

    public Auto convertDtoToEntity(AutoDto autoDto){
        Auto auto = new Auto();
        auto.setId(autoDto.getId());
        auto.setMarca(autoDto.getMarca());
        auto.setModello(autoDto.getModello());
        auto.setTarga(autoDto.getTarga());
        auto.setParcoAuto(parcoAutoRepository.getParcoAutoByNome(autoDto.getNomeParcoAuto()));
        return auto;
    }

    public List<AutoDto> convertListOfEntityToDto(List<Auto> autos) {
        List<AutoDto> autoResponse = new ArrayList<>();
        for (Auto auto : autos) {
            autoResponse.add(convertEntityToDto(auto));
        }
        return autoResponse;
    }

    public void updateAutoByEditAuto(Auto auto,EditAutoDto editAutoDto){
        auto.setMarca(editAutoDto.getMarca());
        auto.setTarga(editAutoDto.getTarga());
        auto.setModello(editAutoDto.getModello());
    }

    public Auto convertEditAutoToAuto(EditAutoDto editAutoDto){
        Auto auto = new Auto();
        auto.setMarca(editAutoDto.getMarca());
        auto.setModello(editAutoDto.getModello());
        auto.setTarga(editAutoDto.getTarga());
        return auto;
    }
}

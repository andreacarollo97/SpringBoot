package com.angularSpring.demoAngSpring.mapper;

import com.angularSpring.demoAngSpring.dto.AutoDto;
import com.angularSpring.demoAngSpring.models.Auto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AutoConverter {
    public AutoDto convertEntityToDto(Auto auto){
        AutoDto autoDto = new AutoDto();
        autoDto.setId(auto.getId());
        autoDto.setMarca(auto.getMarca());
        autoDto.setModello(auto.getModello());
        autoDto.setTarga(auto.getTarga());
        return autoDto;
    }

    public Auto convertDtoToEntity(AutoDto autoDto){
        Auto auto = new Auto();
        auto.setId(autoDto.getId());
        auto.setMarca(autoDto.getMarca());
        auto.setModello(autoDto.getModello());
        auto.setTarga(autoDto.getTarga());
        return auto;
    }

    public List<AutoDto> entityToDto(List<Auto> autos) {
        List<AutoDto> autoRespons = new ArrayList<>();
        for (Auto auto : autos) {
            AutoDto response = new AutoDto();
            response.setId(auto.getId());
            response.setMarca(auto.getMarca());
            response.setModello(auto.getModello());
            response.setTarga(auto.getTarga());
            autoRespons.add(response);
        }
        return autoRespons;
    }
}

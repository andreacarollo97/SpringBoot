package com.angularSpring.demoAngSpring.mapper;

import com.angularSpring.demoAngSpring.dto.AutoResponse;
import com.angularSpring.demoAngSpring.models.Auto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AutoConverter {
    public AutoResponse convertEntityToDto(Auto auto){
        AutoResponse autoResponse = new AutoResponse();
        autoResponse.setId(auto.getId());
        autoResponse.setMarca(auto.getMarca());
        autoResponse.setModello(auto.getModello());
        autoResponse.setTarga(auto.getTarga());
        return autoResponse;
    }

    public Auto convertDtoToEntity(AutoResponse autoResponse){
        Auto auto = new Auto();
        auto.setId(autoResponse.getId());
        auto.setMarca(autoResponse.getMarca());
        auto.setModello(autoResponse.getModello());
        auto.setTarga(autoResponse.getTarga());
        return auto;
    }

    public List<AutoResponse> entityToDto(List<Auto> autos) {
        List<AutoResponse> autoResponses = new ArrayList<>();
        for (Auto auto : autos) {
            AutoResponse response = new AutoResponse();
            response.setId(auto.getId());
            response.setMarca(auto.getMarca());
            response.setModello(auto.getModello());
            response.setTarga(auto.getTarga());
            autoResponses.add(response);
        }
        return autoResponses;
    }
}

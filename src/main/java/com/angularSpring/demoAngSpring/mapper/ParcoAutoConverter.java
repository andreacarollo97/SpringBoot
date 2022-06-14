package com.angularSpring.demoAngSpring.mapper;


import com.angularSpring.demoAngSpring.dto.ParcoAutoDto;
import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.models.ParcoAuto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ParcoAutoConverter {

    public ParcoAutoDto convertEntityToDto(ParcoAuto parcoAuto){
        ParcoAutoDto parcoAutoDto = new ParcoAutoDto();
        parcoAutoDto.setId(parcoAuto.getId());
        parcoAutoDto.setNome(parcoAuto.getNome());
        parcoAutoDto.setCittadina(parcoAuto.getCittadina());
        parcoAutoDto.setIndirizzo(parcoAuto.getIndirizzo());
        return parcoAutoDto;
    }

    public ParcoAuto convertDtoToEntity(ParcoAutoDto parcoAutoDto, List<Auto> autoList){
        ParcoAuto parcoAuto = new ParcoAuto();
        parcoAuto.setId(parcoAutoDto.getId());
        parcoAuto.setNome(parcoAutoDto.getNome());
        parcoAuto.setCittadina(parcoAutoDto.getCittadina());
        parcoAuto.setIndirizzo(parcoAutoDto.getIndirizzo());
        return parcoAuto;
    }

    public List<ParcoAutoDto> convertListOfEntityToDto(List<ParcoAuto> parchiAuto) {
        List<ParcoAutoDto> parcoAutoResponse = new ArrayList<>();
        for (ParcoAuto parcoAuto : parchiAuto) {
            parcoAutoResponse.add(convertEntityToDto(parcoAuto));
        }
        return parcoAutoResponse;
    }


}


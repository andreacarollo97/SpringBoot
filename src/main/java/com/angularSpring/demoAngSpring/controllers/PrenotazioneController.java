package com.angularSpring.demoAngSpring.controllers;


import com.angularSpring.demoAngSpring.dto.PrenotaDto;
import com.angularSpring.demoAngSpring.dto.PrenotazioneDto;
import com.angularSpring.demoAngSpring.mapper.UserConverter;
import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.services.PrenotazioneService;
import com.angularSpring.demoAngSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;



@RestController
@RequestMapping("/api/prenotazione")
public class PrenotazioneController {


    private final PrenotazioneService prenotazioneService;
    private final UserService userService;
    private final UserConverter userConverter;


    public PrenotazioneController(PrenotazioneService prenotazioneService, UserService userService, UserConverter userConverter){
        this.prenotazioneService = prenotazioneService;
        this.userService = userService;
        this.userConverter = userConverter;
    }



    @GetMapping("/elenco")
    public ResponseEntity<List<PrenotazioneDto>> elencoPrenotazioni() {
        return new ResponseEntity<>(prenotazioneService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/prenotazioni/{userId}")
    public ResponseEntity<List<PrenotazioneDto>> elencoMiePrenotazioni(@PathVariable Long userId) {
        return new ResponseEntity<>(
                prenotazioneService.findAllbyUser(
                        userConverter.convertDtoToEntity(userService.findById(userId))),
                HttpStatus.OK);
    }

    @GetMapping("/listauto")
    public ResponseEntity<List<Auto>> listaAutoDisponibili(@RequestParam("dataInizio") String dataIniz,@RequestParam("dataFine") String dataFin) {
        LocalDate dataInizio = LocalDate.parse(dataIniz);
        LocalDate dataFine = LocalDate.parse(dataFin);
        return new ResponseEntity<>(prenotazioneService.autoDisponibili(dataInizio,dataFine), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PrenotazioneDto> ottieniPrenotazione(@PathVariable Long id){
        return new ResponseEntity<>(prenotazioneService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/salva")
    public ResponseEntity<?> salvaPrenotazione(@RequestBody PrenotaDto prenotaDto) {
        prenotazioneService.save(prenotaDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

   @PutMapping("/edit/{id}")
   public ResponseEntity<PrenotazioneDto> editPrenotazione(@RequestBody PrenotaDto prenotaDto) {
       prenotazioneService.save(prenotaDto);
       return new ResponseEntity<>(HttpStatus.OK);
   }

    @PostMapping("/validate/{id}")
    public ResponseEntity<?> validatePrenotazione(@PathVariable Long id) {
        prenotazioneService.validate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


   @DeleteMapping("/elimina/{id}")
    public ResponseEntity<?> eliminaPrenotazione(@PathVariable Long id) {
       prenotazioneService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
   }

}

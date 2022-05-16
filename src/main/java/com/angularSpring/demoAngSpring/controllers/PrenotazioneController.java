package com.angularSpring.demoAngSpring.controllers;



import com.angularSpring.demoAngSpring.dto.PrenotazioneRequest;
import com.angularSpring.demoAngSpring.dto.PrenotazioneResponse;
import com.angularSpring.demoAngSpring.mapper.UserConverter;
import com.angularSpring.demoAngSpring.models.Auto;

import com.angularSpring.demoAngSpring.models.User;
import com.angularSpring.demoAngSpring.services.AutoService;
import com.angularSpring.demoAngSpring.services.PrenotazioneService;
import com.angularSpring.demoAngSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.LinkOption;
import java.time.LocalDate;
import java.util.List;


@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/prenotazione")
public class PrenotazioneController {


    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @GetMapping("/elenco")
    public ResponseEntity<List<PrenotazioneResponse>> elencoPrenotazioni() {
        return new ResponseEntity<>(prenotazioneService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/prenotazioni/{userId}")
    public ResponseEntity<List<PrenotazioneResponse>> elencoMiePrenotazioni(@PathVariable Long userId) {
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
    public ResponseEntity<PrenotazioneResponse> ottieniPrenotazione(@PathVariable Long id){
        return new ResponseEntity<>(prenotazioneService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/salva")
    public ResponseEntity<?> salvaPrenotazione(@RequestBody PrenotazioneRequest prenotazioneRequest) {
        prenotazioneService.save(prenotazioneRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

   @PutMapping("/edit/{id}")
   public ResponseEntity<PrenotazioneResponse> editPrenotazione(@RequestBody PrenotazioneRequest prenotazioneRequest) {
       prenotazioneService.save(prenotazioneRequest);
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

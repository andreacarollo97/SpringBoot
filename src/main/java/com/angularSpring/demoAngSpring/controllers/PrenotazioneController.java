package com.angularSpring.demoAngSpring.controllers;



import com.angularSpring.demoAngSpring.dto.PrenotazioneRequest;
import com.angularSpring.demoAngSpring.dto.PrenotazioneResponse;
import com.angularSpring.demoAngSpring.models.Auto;

import com.angularSpring.demoAngSpring.services.PrenotazioneService;
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

    @GetMapping("/elenco")
    public ResponseEntity<List<PrenotazioneResponse>> elencoPrenotazioni() {
        return new ResponseEntity<>(prenotazioneService.findAll(), HttpStatus.OK);
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

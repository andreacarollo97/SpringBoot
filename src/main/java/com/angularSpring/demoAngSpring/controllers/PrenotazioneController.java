package com.angularSpring.demoAngSpring.controllers;


import com.angularSpring.demoAngSpring.models.Prenotazione;

import com.angularSpring.demoAngSpring.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/prenotazione")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;


    @GetMapping("/elenco")
    public ResponseEntity<List<Prenotazione>> elencoPrenotazioni() {
        return new ResponseEntity<>(prenotazioneService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Prenotazione> ottieniPrenotazione(@PathVariable Long id){
        return new ResponseEntity<>(prenotazioneService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/salva")
    public ResponseEntity<Prenotazione> salvaPrenotazione(@RequestBody Prenotazione prenotazione) {
        return new ResponseEntity<>(prenotazioneService.save(prenotazione), HttpStatus.CREATED);
    }

   @PutMapping("/edit/{id}")
    public ResponseEntity<Prenotazione> editPrenotazione(@PathVariable Long id, @RequestBody Prenotazione prenotazione) {
       Prenotazione prenotazioneAttuale = prenotazioneService.findById(id);

        if(prenotazioneAttuale == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            prenotazioneAttuale.setDataInizio(prenotazione.getDataInizio());
            prenotazioneAttuale.setDataFine(prenotazione.getDataFine());
            prenotazioneAttuale.setStato(prenotazione.getStato());
            prenotazioneAttuale.setUser(prenotazione.getUser());
            prenotazioneAttuale.setAuto(prenotazione.getAuto());
            return new ResponseEntity<>(prenotazioneService.save(prenotazioneAttuale), HttpStatus.CREATED);
        } catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }

   @DeleteMapping("/elimina/{id}")
    public ResponseEntity<?> eliminaPrenotazione(@PathVariable Long id) {
       prenotazioneService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
   }
}

package com.angularSpring.demoAngSpring.controllers;


import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/auto")
public class AutoController {

    @Autowired
    private AutoService autoService;


    @GetMapping("/elenco")
    public ResponseEntity<List<Auto>> elencoAuto() {
        return new ResponseEntity<>(autoService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<Auto> ottieniAuto(@PathVariable Long id){
        return new ResponseEntity<>(autoService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/salva")
    public ResponseEntity<Auto> salvaAuto(@RequestBody Auto auto) {
        return new ResponseEntity<>(autoService.save(auto), HttpStatus.CREATED);
    }

   @PutMapping("/edit/{id}")
    public ResponseEntity<Auto> editAuto(@PathVariable Long id, @RequestBody Auto auto) {
        Auto autoAttuale = autoService.findById(id);

        if(autoAttuale == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            autoAttuale.setMarca(auto.getMarca());
            autoAttuale.setModello(auto.getModello());
            autoAttuale.setTarga(auto.getTarga());
            return new ResponseEntity<>(autoService.save(autoAttuale), HttpStatus.CREATED);
        } catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }

   @DeleteMapping("/elimina/{id}")
    public ResponseEntity<?> eliminaAuto(@PathVariable Long id) {
        autoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
   }
}

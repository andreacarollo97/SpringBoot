package com.angularSpring.demoAngSpring.controllers;


import com.angularSpring.demoAngSpring.dto.AutoResponse;
import com.angularSpring.demoAngSpring.mapper.AutoConverter;
import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.repository.AutoRepository;
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
    public ResponseEntity<List<AutoResponse>> elencoAuto() {
        return new ResponseEntity<>(autoService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<AutoResponse> ottieniAuto(@PathVariable Long id){
        return new ResponseEntity<>(autoService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/salva")
    public ResponseEntity<AutoResponse> salvaAuto(@RequestBody AutoResponse autoResponse) {
        return new ResponseEntity<>(autoService.save(autoResponse), HttpStatus.CREATED);
    }

   @PutMapping("/edit/{id}")
    public ResponseEntity<AutoResponse> editAuto(@RequestBody AutoResponse autoResponse) {
       return new ResponseEntity<>(autoService.save(autoResponse), HttpStatus.OK);
   }

   @DeleteMapping("/elimina/{id}")
    public ResponseEntity<?> eliminaAuto(@PathVariable Long id) {
        autoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
   }
}

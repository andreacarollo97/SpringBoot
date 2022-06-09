package com.angularSpring.demoAngSpring.controllers;


import com.angularSpring.demoAngSpring.dto.AutoDto;
import com.angularSpring.demoAngSpring.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/auto")
public class AutoController {


    private final AutoService autoService;


    public AutoController(AutoService autoService){
        this.autoService = autoService;
    }

    @GetMapping("/elenco")
    public ResponseEntity<List<AutoDto>> elencoAuto() {
        return new ResponseEntity<>(autoService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<AutoDto> ottieniAuto(@PathVariable Long id){
        return new ResponseEntity<>(autoService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/salva")
    public ResponseEntity<AutoDto> salvaAuto(@RequestBody AutoDto autoDto) {
        return new ResponseEntity<>(autoService.save(autoDto), HttpStatus.CREATED);
    }

   @PutMapping("/edit/{id}")
    public ResponseEntity<AutoDto> editAuto(@RequestBody AutoDto autoDto) {
       return new ResponseEntity<>(autoService.save(autoDto), HttpStatus.OK);
   }

   @DeleteMapping("/elimina/{id}")
    public ResponseEntity<?> eliminaAuto(@PathVariable Long id) {
        autoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
   }
}

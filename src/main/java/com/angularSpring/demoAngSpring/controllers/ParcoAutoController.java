package com.angularSpring.demoAngSpring.controllers;

import com.angularSpring.demoAngSpring.dto.AutoDto;
import com.angularSpring.demoAngSpring.dto.ParcoAutoDto;
import com.angularSpring.demoAngSpring.services.ParcoAutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/parcoAuto")
public class ParcoAutoController {

    private final ParcoAutoService parcoAutoService;

    public ParcoAutoController(ParcoAutoService parcoAutoService) {
        this.parcoAutoService = parcoAutoService;
    }


    @GetMapping("/elenco")
    public ResponseEntity<List<ParcoAutoDto>> elencoParchiAuto() {
        return new ResponseEntity<>(parcoAutoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/elencoAutoLibere")
    public ResponseEntity<List<AutoDto>> elencoAutoLibere() {
        return new ResponseEntity<>(parcoAutoService.autoLibere(), HttpStatus.OK);
    }

    @GetMapping("/listaAutoParco/{id}")
    public ResponseEntity<List<AutoDto>> listaAutoParco(@PathVariable Long id) {
        return new ResponseEntity<>(parcoAutoService.listAutoByIdParco(id), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ParcoAutoDto> ottieniParco(@PathVariable Long id){
        return new ResponseEntity<>(parcoAutoService.findById(id),HttpStatus.OK);
    }


    @PostMapping("/salva")
    public ResponseEntity<?> salvaParco(@RequestBody ParcoAutoDto parcoAutoDto) {
        parcoAutoService.save(parcoAutoDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/associate")
    public ResponseEntity<?> validatePrenotazione(@RequestParam("idAuto") Long idAuto, @RequestParam("idParcoAuto") Long idParcoAuto) {
        parcoAutoService.associate(idParcoAuto,idAuto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<ParcoAutoDto> editParco(@RequestBody ParcoAutoDto parcoAutoDto) {
        parcoAutoService.save(parcoAutoDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/elimina/{id}")
    public ResponseEntity<?> eliminaParco(@PathVariable Long id) {
        parcoAutoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

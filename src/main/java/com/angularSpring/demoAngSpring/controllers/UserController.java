package com.angularSpring.demoAngSpring.controllers;


import com.angularSpring.demoAngSpring.dto.UserDetailDto;
import com.angularSpring.demoAngSpring.dto.UserDto;
import com.angularSpring.demoAngSpring.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/api/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/elenco")
    public ResponseEntity<List<UserDto>> elencoUser() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/elencoFiltered/{ruolo}")
    public ResponseEntity<List<UserDto>> elencoUser(@PathVariable String ruolo) {
        return new ResponseEntity<>(userService.findAllByRuoloNot(ruolo), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> ottieniUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/salva")
    public ResponseEntity<?> salvaUser(@RequestBody UserDetailDto userDetailDto) {
        userService.save(userDetailDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


   @DeleteMapping("/elimina/{id}")
    public ResponseEntity<?> eliminaUser(@PathVariable Long id) {
       userService.delete(id);
       return new ResponseEntity<>(HttpStatus.OK);
   }
}

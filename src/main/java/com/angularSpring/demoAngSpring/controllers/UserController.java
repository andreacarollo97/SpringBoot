package com.angularSpring.demoAngSpring.controllers;


import com.angularSpring.demoAngSpring.dto.UserDetailResponse;
import com.angularSpring.demoAngSpring.dto.UserResponse;
import com.angularSpring.demoAngSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/elenco")
    public ResponseEntity<List<UserResponse>> elencoUser() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDetailResponse> ottieniUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/salva")
    public ResponseEntity<UserDetailResponse> salvaUser(@RequestBody UserDetailResponse userDetailResponse) {
        return new ResponseEntity<>(userService.save(userDetailResponse), HttpStatus.CREATED);
    }




   @DeleteMapping("/elimina/{id}")
    public ResponseEntity<?> eliminaUser(@PathVariable Long id) {
       userService.delete(id);
       return new ResponseEntity<>(HttpStatus.OK);
   }
}

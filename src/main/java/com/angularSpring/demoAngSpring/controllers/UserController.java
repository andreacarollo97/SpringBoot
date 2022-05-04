package com.angularSpring.demoAngSpring.controllers;



import com.angularSpring.demoAngSpring.models.User;
import com.angularSpring.demoAngSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/elenco")
    public ResponseEntity<List<User>> elencoUser() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> ottieniUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/salva")
    public ResponseEntity<User> salvaUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> editUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

   @DeleteMapping("/elimina/{id}")
    public ResponseEntity<?> eliminaUser(@PathVariable Long id) {
       userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
   }
}

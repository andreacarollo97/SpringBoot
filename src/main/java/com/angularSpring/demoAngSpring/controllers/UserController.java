package com.angularSpring.demoAngSpring.controllers;



import com.angularSpring.demoAngSpring.models.User;
import com.angularSpring.demoAngSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    public ResponseEntity<User> editUser(@PathVariable Long id, @RequestBody User user) {
       User userAttuale = userService.findById(id);

        if(userAttuale == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            userAttuale.setNome(user.getNome());
            userAttuale.setCognome(user.getCognome());
            userAttuale.setEmail(user.getEmail());
            userAttuale.setPassword(user.getPassword());
            return new ResponseEntity<>(userService.save(userAttuale), HttpStatus.CREATED);
        } catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }

   @DeleteMapping("/elimina/{id}")
    public ResponseEntity<?> eliminaUser(@PathVariable Long id) {
       userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
   }
}

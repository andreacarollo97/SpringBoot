package com.angularSpring.demoAngSpring.controllers;

import com.angularSpring.demoAngSpring.dto.LoginDto;
import com.angularSpring.demoAngSpring.dto.TokenDto;
import com.angularSpring.demoAngSpring.jwt.JwtProvider;
import com.angularSpring.demoAngSpring.security.UserLogged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        UserLogged userLogged = (UserLogged) authentication.getPrincipal();
        TokenDto tokenDto = new TokenDto(token, userLogged.getRuolo());
        return new ResponseEntity(tokenDto, HttpStatus.OK);
    }


}

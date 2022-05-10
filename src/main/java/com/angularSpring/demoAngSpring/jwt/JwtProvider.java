package com.angularSpring.demoAngSpring.jwt;


import com.angularSpring.demoAngSpring.security.UserLogged;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.Date;

@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
        UserLogged userLogged = (UserLogged) authentication.getPrincipal();
        return Jwts.builder().setSubject(userLogged.getEmail())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000L))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getEmailFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
         try {
             Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
             return true;
         } catch (MalformedJwtException e) {
             logger.error("token in formato non valido");
         } catch (ExpiredJwtException e) {
             logger.error("token scaduto");
         }
         return false;
    }
}

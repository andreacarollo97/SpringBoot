package com.angularSpring.demoAngSpring.dto;

public class TokenDto {

    private String token;
    private String ruolo;


    public TokenDto(String token, String ruolo) {
        this.token = token;
        this.ruolo = ruolo;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

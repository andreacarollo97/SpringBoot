package com.angularSpring.demoAngSpring.dto;

public class TokenDto {

    private String token;
    private String ruolo;
    private Long id;


    public TokenDto(String token, String ruolo, Long id) {
        this.token = token;
        this.ruolo = ruolo;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

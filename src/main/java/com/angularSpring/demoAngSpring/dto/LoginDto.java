package com.angularSpring.demoAngSpring.dto;

public class LoginDto {

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}

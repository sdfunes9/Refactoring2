package com.universidad;
import lombok.Getter;
import lombok.Setter;


public class CuentasUsuarios {
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String contrasena;

    public CuentasUsuarios(String username, String contrasena) {
        this.username = username;
        this.contrasena = contrasena;
    }
}
package com.universidad;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;


public class Login {

    @Getter @Setter
    private boolean ingreso = false;

    public Login(){
    }

    public void loguear() {

        ArrayList<CuentasUsuarios> usuario = new ArrayList();

        CuentasUsuarios usuario1 = new CuentasUsuarios("Kevin", "est123");
        CuentasUsuarios usuario2 = new CuentasUsuarios("Gabriela", "hast123");
        CuentasUsuarios usuario3 = new CuentasUsuarios("Sergio", "for123");
        CuentasUsuarios usuario4 = new CuentasUsuarios("Marvin", "alk123");
        CuentasUsuarios usuario5 = new CuentasUsuarios("Ernesto", "lol123");

        usuario.add(usuario1);
        usuario.add(usuario2);
        usuario.add(usuario3);
        usuario.add(usuario4);
        usuario.add(usuario5);

        String ingresarNombre = JOptionPane.showInputDialog(null, "Ingresar usuario");
        String contrasenas = JOptionPane.showInputDialog(null, "Ingresar contraseña");

        for (CuentasUsuarios cuentasUsuarios : usuario) {
            if (ingresarNombre.equals(cuentasUsuarios.getUsername()) && contrasenas.equals(cuentasUsuarios.getContrasena())) {
                JOptionPane.showMessageDialog(null, "Bienvenido/a: " + " " + cuentasUsuarios.getUsername());
                setIngreso(true);
            }
        }
    }
}


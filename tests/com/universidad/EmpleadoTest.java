package com.universidad;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {

    @Test
    public void registrarUsuario() {

        Empleado empleado = new Empleado();
       assertNotNull(empleado.registrarUsuario(1,"Kevin","Mayorga","MAS","11-09-1995","Activo",1000,"Administrativo","kk1000","Ingeniero"),"El campo es nulo");

    }
}
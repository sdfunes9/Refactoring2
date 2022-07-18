package com.universidad;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {
    Empleado empleado = new Empleado();
    public void registrarUsuario() {
        assertNotNull(empleado.registrarUsuario(1,"Kevin","Mayorga","MAS","11-09-1995","Activo",1000,"Administrativo","kk1000","Ingeniero"),"El campo es nulo");
    }
    @Test
    public void testAtributos(){
        registrarUsuario();
        assertEquals("Kevin", empleado.getEmpleadosList().get(0).nombre, "Prueba no superada");
        assertEquals("Mayorga", empleado.getEmpleadosList().get(0).apellido, "Prueba no superada");
        assertEquals("MAS", empleado.getEmpleadosList().get(0).sexo, "Prueba no superada");
        assertEquals("11-09-1995", empleado.getEmpleadosList().get(0).fechaNacimiento, "Prueba no superada");
        assertEquals("Activo", empleado.getEmpleadosList().get(0).statusUsuario, "Prueba no superada");
        assertEquals(1000, empleado.getEmpleadosList().get(0).salario, "Prueba no superada");
        assertEquals("Administrativo", empleado.getEmpleadosList().get(0).rol, "Prueba no superada");
        assertEquals("kk1000", empleado.getEmpleadosList().get(0).cuentaBancaria, "Prueba no superada");
        assertEquals("Ingeniero", empleado.getEmpleadosList().get(0).profesion, "Prueba no superada");

    }
}
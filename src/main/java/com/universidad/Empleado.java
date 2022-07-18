package com.universidad;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.*;

public class Empleado extends Usuario {
    @Setter
    @Getter
    double salario;
    @Setter
    @Getter
    String rol;
    @Setter
    @Getter
    String cuentaBancaria;
    @Setter
    @Getter
    String profesion;

    public Empleado(int idUsuario, String nombre, String apellido, String sexo, String fechaNacimiento,
                    String statusUsuario, double salario, String rol, String cuentaBancaria, String profesion) {
        super(idUsuario, nombre, apellido, sexo, fechaNacimiento, statusUsuario);
        this.salario = salario;
        this.rol = rol;
        this.cuentaBancaria = cuentaBancaria;
        this.profesion = profesion;
    }

    public Empleado() {
    }

    public Empleado(List<Empleado> empleadosList) {
        this.empleadosList = empleadosList;
    }

    @Override
    public String toString() {
        return "Empleado:" + '\n' +
                "ID Usuario: 00" + idUsuario + '\n' +
                "Nombre: " + nombre + '\n' +
                "Apellido: " + apellido + '\n' +
                "Sexo: " + sexo + '\n' +
                "Fecha de nacimiento: " + fechaNacimiento + '\n' +
                "Status: " + statusUsuario + '\n' +
                "salario: " + salario + '\n' +
                "Rol: " + rol + '\n' +
                "Cuenta Bancaria: " + cuentaBancaria + '\n' +
                "Profesion: " + profesion + '\n';
    }
    @Setter
    @Getter
    private List<Empleado> empleadosList = new ArrayList<>();

    public void capturarDatos() {
        int id;
        int listSize = empleadosList.size();
        String nombre;
        String apellido;
        String sexo;
        String fechaNacimiento;
        double salario;
        String rol;
        String status;
        String cuentaBancaria;
        String profesion;
        String[] sexo1= {"FEMENINO", "MASCULINO"};
        String[] rolEmpleado = {"Maestro", "Administrativo"};
        String[] estadoUsuario = {"Activo", "Inactivo", "Suspendido"};
        String regexNombreApellido = "^([a-zA-Z_]+[ ]?){1,2}$";
        String regexFechaNacimiento = "^[0-3]?[0-9].[0-3]?[0-9].(?:[0-9]{2})?[0-9]{2}$";

        try {
            listSize = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Cantidad de empleados a registrar", "Registro de empleado", JOptionPane.PLAIN_MESSAGE));
            for (int i = 0; i < listSize; i++) {
                id = (i + 1);

                do {//VALIDACION DE PARAMETRO NOMBRE
                    nombre = JOptionPane.showInputDialog(null, "Nombre del emplado");
                } while (!nombre.matches(regexNombreApellido));

                do {//VALIDACION DE PARAMETRO APELLIDO
                    apellido = JOptionPane.showInputDialog(null, "Apellido del empleado");
                } while (!apellido.matches(regexNombreApellido));

                do {//VALIDACION DE PARAMETRO SEXO
                    sexo = (String) JOptionPane.showInputDialog(null,
                            "Ingresar sexo del empleado", "FEMENINO O MASCULINO",
                            JOptionPane.DEFAULT_OPTION, null, sexo1, sexo1[0]);
                } while (!((sexo.compareTo("FEMENINO") == 0) || (sexo.compareTo("MASCULINO") == 0)));

                do {//VALIDACION PARAMETRO FECHA
                    fechaNacimiento = JOptionPane.showInputDialog(null, "Fecha de nacimiento (DD-MM-YYYY)");
                } while (!fechaNacimiento.matches(regexFechaNacimiento));

                status = (String) JOptionPane.showInputDialog(null, "Status del empleado",
                        "Status del empleado", JOptionPane.DEFAULT_OPTION, null, estadoUsuario, estadoUsuario[0]);//entrada.nextLine();

                salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el salario del empleado",
                        "Salario de empleado", JOptionPane.PLAIN_MESSAGE));

                rol = (String) JOptionPane.showInputDialog(null, "Seleccione el rol del empleado",
                        "Rol del empleado", JOptionPane.DEFAULT_OPTION, null, rolEmpleado, rolEmpleado[0]);

                cuentaBancaria = JOptionPane.showInputDialog(null, "Ingrese el número de cuenta del empleado"
                        , "Numero de cuenta", JOptionPane.PLAIN_MESSAGE);

                profesion = JOptionPane.showInputDialog(null, "Ingrese la profesion del empleado"
                        , "Profesión empleado", JOptionPane.PLAIN_MESSAGE);

                registrarUsuario(id, nombre, apellido, sexo, fechaNacimiento, status, salario, rol,
                        cuentaBancaria, profesion);
            }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Ingrese la informacion requerida");
        }
    }
    public List<Empleado> registrarUsuario(int id, String nombre, String apellido, String sexo, String fechaNacimiento,
                                           String status, double salario, String rol, String cuentaBancaria, String profesion) {

        Empleado empleadoNuevo = new Empleado(id, nombre, apellido, sexo, fechaNacimiento, status, salario, rol,
                cuentaBancaria, profesion);
        empleadosList.add(empleadoNuevo);
        JOptionPane.showMessageDialog(null,"Se registro correctamente","Message",JOptionPane.PLAIN_MESSAGE);
        return empleadosList;
}
    @Override
    public ArrayList listarUsuario() {
        if (empleadosList.size() == 0) {
            JOptionPane.showMessageDialog(null,"Lista de empleados vacia");
        } else {
            for (int i = 0; i < empleadosList.size(); i++) {
                JOptionPane.showMessageDialog(null,empleadosList.get(i),
                        "Empleado "+(i+1),JOptionPane.PLAIN_MESSAGE);
            }
        }
        return (ArrayList) empleadosList;
    }
    @Override
    public void eliminarUsuario() {
        int indice;
        if (empleadosList.size() == 0) {
            JOptionPane.showMessageDialog(null,"Lista vacia, imposible eliminar empleado");
        } else {
            indice =Integer.parseInt(JOptionPane.showInputDialog(null,"Indique el ID del empleado a eliminar"));
            empleadosList.remove(indice - 1);
            Iterator iterador = empleadosList.iterator();
            while (iterador.hasNext()) {
                JOptionPane.showMessageDialog(null,iterador.next());
            }
        }
    }
}

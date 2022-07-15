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
        return "Empleado{" + '\n' +
                "ID Usuario= " + idUsuario + '\n' +
                "nombre= " + nombre + '\n' +
                "apellido= " + apellido + '\n' +
                "sexo= " + sexo + '\n' +
                "Fecha de nacimiento= " + fechaNacimiento + '\n' +
                "Status= " + statusUsuario + '\n' +
                "salario= " + salario + '\n' +
                "rol= " + rol + '\n' +
                "cuenta Bancaria= " + cuentaBancaria + '\n' +
                "Profesion= " + profesion + '\n' +
                '}';
    }

    Scanner entrada = new Scanner(System.in);

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
        String[] sexo1= {"FEM", "MAS"};
        String[] rolEmpleado = {"Maestro", "Administrativo"};
        String[] estadoUsuario = {"Activo", "Inactivo", "Suspendido"};


        listSize = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Cantidad de empleados a registrar", "Registro de empleado", JOptionPane.PLAIN_MESSAGE));
        for (int i = 0; i < listSize; i++) {
            id = (i+1);

            do {//VALIDACION DE PARAMETRO NOMBRE
                nombre = JOptionPane.showInputDialog(null, "Nombre del emplado");
            } while (!(nombre.matches("^([a-zA-Z_]+[ ]?){1,2}$")));

            do {//VALIDACION DE PARAMETRO APELLIDO
                apellido = JOptionPane.showInputDialog(null,"Apellido del empleado");
            } while (!(apellido.matches("^([a-zA-Z_]+[ ]?){1,2}$")));

            do {//VALIDACION DE PARAMETRO SEXO
                sexo = (String) JOptionPane.showInputDialog(null,
                        "Ingresar sexo del empleado(FEM o MAS)", "FEM O MAS",
                        JOptionPane.DEFAULT_OPTION,null,sexo1,sexo1[0]);
            } while (!((sexo.compareTo("FEM") == 0) || (sexo.compareTo("MAS") == 0)));

            do {//VALIDACION PARAMETRO FECHA
                fechaNacimiento = JOptionPane.showInputDialog(null, "Fecha de nacimiento (DD-MM-YYY)");
            } while (!(fechaNacimiento.matches("^[0-3]?[0-9].[0-3]?[0-9].(?:[0-9]{2})?[0-9]{2}$")));

            status = (String) JOptionPane.showInputDialog(null,"Status del empleado",
                    "Status del empleado", JOptionPane.DEFAULT_OPTION,null,estadoUsuario,estadoUsuario[0]);//entrada.nextLine();

            salario = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el salario del empleado",
                    "Salario de empleado",JOptionPane.PLAIN_MESSAGE));

            rol = (String) JOptionPane.showInputDialog(null,"Seleccione el rol del empleado",
                    "Rol del empleado", JOptionPane.DEFAULT_OPTION,null,rolEmpleado, rolEmpleado[0]);

            cuentaBancaria = JOptionPane.showInputDialog(null,"Ingrese el número de cuenta del empleado"
            ,"Numero de cuenta",JOptionPane.PLAIN_MESSAGE);

            profesion = JOptionPane.showInputDialog(null,"Ingrese la profesion del empleado"
            ,"Profesión empleado",JOptionPane.PLAIN_MESSAGE);

            registrarUsuario(id, nombre, apellido, sexo, fechaNacimiento, status, salario, rol,
                    cuentaBancaria, profesion);
        }
    }

    public List<Empleado> registrarUsuario(int id, String nombre, String apellido, String sexo, String fechaNacimiento,
                                           String status, double salario, String rol, String cuentaBancaria, String profesion) {

        Empleado empleadoNuevo = new Empleado(id, nombre, apellido, sexo, fechaNacimiento, status, salario, rol,
                cuentaBancaria, profesion);
        empleadosList.add(empleadoNuevo);
        System.out.println("Se registro correctamente");

        return empleadosList;

}

    @Override
    public ArrayList listarUsuario() {

        if (empleadosList.size() == 0) {
            System.out.println("Lista de empleados vacia");
        } else {
            for (int i = 0; i < empleadosList.size(); i++) {
                System.out.println(i + 1);
                System.out.println(empleadosList.get(i));
            }
        }
        return (ArrayList) empleadosList;
    }

    @Override
    public void eliminarUsuario() {
        if (empleadosList.size() == 0) {
            System.out.println("Lista vacia, imposible eliminar empleado");
        } else {
            System.out.println("Indique el indice del empleado a eliminar");
            int indice = entrada.nextInt();
            empleadosList.remove(indice - 1);
            Iterator iterador = empleadosList.iterator();
            while (iterador.hasNext()) {
                System.out.println(iterador.next());
            }
        }

    }

}

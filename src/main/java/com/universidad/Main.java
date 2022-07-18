package com.universidad;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean salir = false;
        int opcion1;
        int opcion2;
        int opcion3;
        Empleado empleado1 = new Empleado();
        Estudiante estudiante1 = new Estudiante();
        Materia materia1 = new Materia();
        Notas notas1 = new Notas();
        PagoCuota pago1 = new PagoCuota();
        Maestro maestro = new Maestro();
        Login login1 = new Login();

        login1.loguear();

        do{
            if(login1.isIngreso()) {

                JOptionPane.showMessageDialog(null, "Credenciales correctas");

            }else {

                JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
                login1.loguear();

            }

        }while(!login1.isIngreso());

        while (!salir) {
            try {
                opcion1 = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Seleccione una de las siguientes opciones\n"
                                + "1. Registrar/Listar/Eliminar Empleado\n"
                                + "2. Registrar/Listar/Eliminar/Pagar Estudiante\n"
                                + "3. Listar Maestros\n"
                                + "4. Generar reporte por materia\n"
                                + "5. Registrar alumnos por materia y notas\n"
                                + "6. Listar alumnos por materia y notas\n"
                                + "7. Salir\n\n", "Menú Principal", JOptionPane.PLAIN_MESSAGE));

                switch (opcion1) {
                    case 1 -> {
                        opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "1. Registrar Empleado\n"
                                        + "2. Listar Empleado\n"
                                        + "3. Eliminar Empleado\n",
                                "Menú empleados", JOptionPane.PLAIN_MESSAGE));
                        switch (opcion2) {
                            case 1 -> empleado1.capturarDatos();
                            case 2 -> empleado1.listarUsuario();
                            case 3 -> empleado1.eliminarUsuario();
                        }
                    }
                    case 2 -> {
                        opcion3 = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "1. Registrar Estudiante\n"
                                        + "2. Listar Estudiante\n"
                                        + "3. Eliminar Estudiante\n"
                                        + "4. Procesar Pago de Cuota\n", "Menú Estudiantes",
                                JOptionPane.PLAIN_MESSAGE));
                        switch (opcion3) {
                            case 1 -> estudiante1.registrarUsuario();
                            case 2 -> {
                                estudiante1.listarUsuario();
                                ArrayList<Estudiante> estudiantes = BdEstudiantes.listarEstudiantes();
                                for (Estudiante estudiante : estudiantes) {
                                    JOptionPane.showMessageDialog(null, estudiante.toString(),
                                            "Estudiantes registrados", JOptionPane.PLAIN_MESSAGE);
                                }
                            }
                            case 3 -> estudiante1.eliminarUsuario();
                            case 4 -> pago1.gestionarPagos();
                        }
                    }
                    case 3 -> {
                        System.out.println("Lista de Maestros");
                        maestro.identificarmaestros();
                        boolean check = empleado1.getEmpleadosList().isEmpty();
                        if (!check) {
                            for (int j = 0; j < empleado1.getEmpleadosList().size(); j++) {
                                if (empleado1.getEmpleadosList().get(j).rol.equals("MAESTRO")) {
                                    System.out.println(empleado1.getEmpleadosList().get(j));
                                }
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("Generar reporte");
                        materia1.mostrarmaterias();
                        materia1.guardarEnviar();
                    }
                    case 5 -> {
                        System.out.println("Registrar notas de alumno");
                        notas1.registrarNotasAlumnos();
                    }
                    case 6 -> {
                        System.out.println("Listar alumnos por materia y notas");
                        notas1.listarNotasAlumnos();
                    }
                    case 7 -> {
                        System.out.println("Saliendo del sistema");
                        salir = true;
                    }
                    default -> JOptionPane.showMessageDialog(null, "Solo numeros entre 1 y 7");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un numero");
            }
        }


    }
}


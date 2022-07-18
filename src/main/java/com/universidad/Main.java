package com.universidad;
import javax.swing.*;
import java.util.ArrayList;

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
                        """
                                Seleccione una de las siguientes opciones
                                1. Registrar/Listar/Eliminar Empleado
                                2. Registrar/Listar/Eliminar/Pagar Estudiante
                                3. Listar Maestros
                                4. Generar reporte por materia
                                5. Registrar alumnos por materia y notas
                                6. Listar alumnos por materia y notas
                                7. Salir""", "Menú Principal", JOptionPane.PLAIN_MESSAGE));

                switch (opcion1) {
                    case 1 -> {
                        opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                                """
                                        1. Registrar Empleado
                                        2. Listar Empleado
                                        3. Eliminar Empleado""",
                                "Menú empleados", JOptionPane.PLAIN_MESSAGE));
                        switch (opcion2) {
                            case 1 -> empleado1.capturarDatos();
                            case 2 -> empleado1.listarUsuario();
                            case 3 -> empleado1.eliminarUsuario();
                            default -> JOptionPane.showMessageDialog(null, "Opción invalida");
                        }
                    }
                    case 2 -> {
                        opcion3 = Integer.parseInt(JOptionPane.showInputDialog(null,
                                """
                                         1. Registrar Estudiante
                                         2. Listar Estudiante
                                         3. Eliminar Estudiante
                                         4. Procesar Pago de Cuota""", "Menú Estudiantes",
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
                            default -> JOptionPane.showMessageDialog(null, "Opción invalida");
                        }
                    }
                    case 3 -> {
                        maestro.identificarmaestros();
                        boolean check = empleado1.getEmpleadosList().isEmpty();
                        if (check == false) {
                            for (int j = 0; j < empleado1.getEmpleadosList().size(); j++) {
                                if (empleado1.getEmpleadosList().get(j).rol.equals("Maestro")) {
                                    JOptionPane.showMessageDialog(null, empleado1.getEmpleadosList().get(j),
                                            "Maestro" + (j + 1), JOptionPane.PLAIN_MESSAGE);
                                }
                            }
                        }
                    }
                    case 4 -> {
                        materia1.guardarEnviar();
                    }
                    case 5 -> notas1.registrarNotasAlumnos();
                    case 6 -> notas1.listarNotasAlumnos();
                    case 7 -> {
                        JOptionPane.showMessageDialog(null,"Saliendo del sistema","Saliendo",JOptionPane.PLAIN_MESSAGE);
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


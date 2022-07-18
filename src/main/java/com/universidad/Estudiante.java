package com.universidad;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Estudiante extends Usuario{

    @Setter @Getter
    private double promedio;
    @Setter @Getter
    private String idCarrera;

    @Setter @Getter
    private String idMateria;
    @Setter @Getter
    private ArrayList<Materia> materiasList;

    @Setter @Getter
    private int pagosProcesados;
    public Estudiante() {
        super();
    }

    public Estudiante(int idUsuario, String nombre, String apellido, String sexo, String fechaNacimiento, String statusUsuario, double promedio, String idCarrera,
                      String idMateria, ArrayList<Materia> materiasList, int pagosProcesados) {
        super(idUsuario, nombre, apellido, sexo, fechaNacimiento, statusUsuario);
        this.promedio = promedio;
        this.idCarrera = idCarrera;
        this.idMateria = idMateria;
        this.materiasList = materiasList;
        this.pagosProcesados = pagosProcesados;
    }

    @Setter @Getter
    private List<Estudiante> estudiantesList = new ArrayList<>();
   // BdEstudiantes bdEstudiantes = new BdEstudiantes();

    @Override
    public String registrarUsuario() {
            int id;
            String nombre;
            String apellido;
            String sexo;
            String fechaNacimiento;
            String status;
            String carrera;
            String idMateria;
            int numeroCuotas;
            int listSize = estudiantesList.size();
            String[] sexo1= {"FEMENINO", "MASCULINO"};
            String[] estadoUsuario = {"Activo", "Inactivo", "Suspendido"};
            String[] carreras = {"Arquitectura","Contaduria Publica","Filosofia", "Astrologia"};
            String[] nombreMateria = {"FIS1", "FIS2","FIS3", "PROG1", "QUIM1", "QUIM2", "QUIM3"};
            String regexNombreApellido = "^([a-zA-Z_]+[ ]?){1,2}$";
            String regexFechaNacimiento = "^[0-3]?[0-9].[0-3]?[0-9].(?:[0-9]{2})?[0-9]{2}$";

        try {
            listSize = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Cantidad de estudiantes a registrar", "Registro de estudiante", JOptionPane.PLAIN_MESSAGE));
            for (int i = 0; i < listSize; i++) {
                id = (i + 1);

                do {//VALIDACION DE PARAMETRO NOMBRE
                    nombre = JOptionPane.showInputDialog(null, "Nombre del estudiante");
                } while (!nombre.matches(regexNombreApellido));

                do {//VALIDACION DE PARAMETRO APELLIDO
                    apellido = JOptionPane.showInputDialog(null, "Apellido del estudiante");
                } while (!apellido.matches(regexNombreApellido));

                do {//VALIDACION DE PARAMETRO SEXO
                    sexo = (String) JOptionPane.showInputDialog(null,
                            "Ingresar sexo del estudiante", "FEMENINO O MASCULINO",
                            JOptionPane.DEFAULT_OPTION, null, sexo1, sexo1[0]);
                } while (!((sexo.compareTo("FEMENINO") == 0) || (sexo.compareTo("MASCULINO") == 0)));

                do {//VALIDACION PARAMETRO FECHA
                    fechaNacimiento = JOptionPane.showInputDialog(null, "Fecha de nacimiento (DD-MM-YYY)");
                } while (!fechaNacimiento.matches(regexFechaNacimiento));

                status = (String) JOptionPane.showInputDialog(null, "Status del estudiante",
                        "Status del estudiante", JOptionPane.DEFAULT_OPTION, null, estadoUsuario, estadoUsuario[0]);

                carrera = (String) JOptionPane.showInputDialog(null, "Seleccione una carrera",
                        "Carrera", JOptionPane.DEFAULT_OPTION, null, carreras, carreras[0]);

                idMateria = (String) JOptionPane.showInputDialog(null, "Seleccione una materia",
                        "Materia", JOptionPane.DEFAULT_OPTION, null, nombreMateria, nombreMateria[0]);

                numeroCuotas = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Ingrese la cantidad de cuotas pagadas", "Cuotas pagadas", JOptionPane.PLAIN_MESSAGE));

                Estudiante estudianteNuevo = new Estudiante(id, nombre, apellido, sexo, fechaNacimiento, status, 0.0, carrera, idMateria, new ArrayList<>(), numeroCuotas);
                estudiantesList.add(estudianteNuevo);
            }
        }catch (NullPointerException e){
            JOptionPane.showMessageDialog(null, "Ingrese la informacion requerida");
        }
        return "registro exitoso";
    }
    public ArrayList listarUsuario(){
        if (estudiantesList.size() == 0) {
            JOptionPane.showMessageDialog(null,"Lista de estudiantes nuevos vacia");
        } else {
            for (int i = 0; i < estudiantesList.size(); i++) {
                JOptionPane.showMessageDialog(null,estudiantesList.get(i),
                        "Estudiante "+(i+1),JOptionPane.PLAIN_MESSAGE);
            }
        }
        return (ArrayList) estudiantesList;
    }

    @Override
    public void eliminarUsuario() {
        int indice;
        if (estudiantesList.size() == 0) {
            JOptionPane.showMessageDialog(null,"Lista vacia, imposible eliminar estudiante");
        } else {
            indice =Integer.parseInt(JOptionPane.showInputDialog(null,"Indique el ID del estudiante a eliminar"));
            estudiantesList.remove(indice - 1);
            Iterator iterador = estudiantesList.iterator();
            while (iterador.hasNext()) {
                JOptionPane.showMessageDialog(null,iterador.next());
            }
        }
    }


    @Override
    public String toString() {
        return "Estudiante:" +'\n' +
                " ID Usuario: 00" + idUsuario + '\n' +
                " Nombre: '" + nombre + '\n' +
                " Apellido: '" + apellido + '\n' +
                " Sexo: '" + sexo + '\n' +
                " Fecha de Nacimiento: '" + fechaNacimiento + '\n' +
                " Status Usuario: '" + statusUsuario + '\n' +
                " Promedio: " + promedio + '\n' +
                " ID Carrera: '" + idCarrera + '\n' +
                " ID Materia: '" + idMateria + '\n' +
                " Materias List: " + materiasList + '\n' +
                " Pagos Procesados: " + pagosProcesados +'\n';
    }
}



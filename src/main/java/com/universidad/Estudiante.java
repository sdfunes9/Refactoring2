package com.universidad;

import lombok.Getter;
import lombok.Setter;

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
    Scanner entrada = new Scanner(System.in);

    @Override
    public String registrarUsuario() {
            String nombre;
            String apellido;
            String sexo;
            String fechaNacimiento;


        int listSize = estudiantesList.size();
        System.out.println("Cantidad de estudiantes a inscribir");
            listSize = entrada.nextInt();
        for (int i = 0; i < listSize; i++) {
            System.out.println(i + 1);
            System.out.println("ID asignado");
            int id = (int) (Math.random() * 1000);
            System.out.println(id);
            entrada.nextLine();

            do{//VALIDACION DE PARAMETRO NOMBRE
                System.out.println("Nombre del estudiante");
                nombre = entrada.nextLine();
            }while(!(nombre.matches("^([a-zA-Z_]+[ ]?){1,2}$")));

            do {//VALIDACION DE PARAMETRO APELLIDO
                System.out.println("Apellido del estudiante");
                apellido = entrada.nextLine();
            }while(!(apellido.matches("^([a-zA-Z_]+[ ]?){1,2}$")));

            do {//VALIDACION DE PARAMETRO SEXO
                System.out.println("Ingresar sexo del alumno(FEM o MAS)");
                sexo = entrada.nextLine();
                System.out.println(sexo);
            }while (!((sexo.compareTo("FEM")==0)||(sexo.compareTo("MAS")==0)));

            do {//VALIDACION PARAMETRO FECHA
                System.out.println("Fecha de nacimiento (DD-MM-YYY)");
                fechaNacimiento = entrada.nextLine();
            }while(!(fechaNacimiento.matches("^[0-3]?[0-9].[0-3]?[0-9].(?:[0-9]{2})?[0-9]{2}$")));

            System.out.println("Status del Alumno");
            String status = entrada.nextLine();
            System.out.println("Id Carrera");
            String carrera = entrada.nextLine();
            System.out.println("Id Materia");
            String idMateria = entrada.nextLine();
            System.out.println("Cuotas pagadas");
            int numeroCuotas = entrada.nextInt();
            entrada.nextLine();
            Estudiante estudianteNuevo = new Estudiante(id,nombre,apellido,sexo,fechaNacimiento,status,0.0,carrera,idMateria,new ArrayList<>(),numeroCuotas);
            estudiantesList.add(estudianteNuevo);
        }
        return "registro exitoso";
    }
    public ArrayList listarUsuario(){
        if (estudiantesList.size() == 0) {
            System.out.println("Lista de estudiantes vacia");
        } else {
            for (int i = 0; i < estudiantesList.size(); i++) {
                System.out.println(i + 1);
                System.out.println(estudiantesList.get(i));
            }
        }
        return (ArrayList) estudiantesList;
    }

    @Override
    public void eliminarUsuario() {
        if (estudiantesList.size() == 0) {
            System.out.println("Lista vacia, imposible eliminar estudiante");
        } else {
            System.out.println("Indique el indice del estudiante a eliminar");
            int indice = entrada.nextInt();
            estudiantesList.remove(indice - 1);
            Iterator iterador = estudiantesList.iterator();
            while (iterador.hasNext()) {
                System.out.println(iterador.next());
            }
        }
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                ", idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", sexo='" + sexo + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", statusUsuario='" + statusUsuario + '\'' +
                ", promedio=" + promedio +
                ", idCarrera='" + idCarrera + '\'' +
                ", idMateria='" + idMateria + '\'' +
                ", materiasList=" + materiasList +
                ", pagosProcesados=" + pagosProcesados+
                '}';
    }
}



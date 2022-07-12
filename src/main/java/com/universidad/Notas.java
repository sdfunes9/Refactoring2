package com.universidad;
import java.util.ArrayList;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;

public class Notas implements listarNotasMaterias{
    @Getter
    @Setter
    ArrayList<ArrayList<String>> notasFinales = new ArrayList<>();
    @Getter
    @Setter
    ArrayList<Integer> nota = new ArrayList<>();

    @Getter
    @Setter
    private double promedio;

    @Override
    public void registrarNotasAlumnos() { //metodo para registrar las notas del alumno segun la materia que cursa

        int i;
        int notas;
        Materia materia1 = new Materia();
        materia1.mostrarmaterias();

        System.out.println("Seleccionar CODIGO materia");
        Scanner entrada = new Scanner(System.in);
        String buscar = entrada.next();
        String toUper = buscar.toUpperCase();
        if(toUper.isEmpty()){
            System.out.println("Por favor ingresar un codigo de materia");
        }else {
            for (i = 0; i < BdMaterias.listarMaterias().size(); i++) {
                String compare = BdEstudiantes.listarEstudiantes().get(i).getIdMateria();
                if (compare.contains(toUper)) {
                    for (int y = 0; y < BdEstudiantes.listarEstudiantes().size(); y++) {
                        if (y == i) {
                            System.out.println("Cantidad de notas a ingresar al alumno en: " + BdEstudiantes.listarEstudiantes().get(y).getIdMateria());
                            int cantNotas = entrada.nextInt();
                            System.out.println("Ingresar notas a estudiante: " + BdEstudiantes.listarEstudiantes().get(y).nombre + " " + BdEstudiantes.listarEstudiantes().get(y).apellido);
                            for (int j = 0; j < cantNotas; j++) {
                                notas = entrada.nextInt();
                                nota.add(notas);
                                promedio += notas;
                            }
                            promedio = promedio / cantNotas;
                            String listadoNotas = String.valueOf(nota);
                            String listadoPromedios = String.valueOf(promedio);
                            ArrayList<String> listadoFinal = new ArrayList<>();
                            listadoFinal.add(BdEstudiantes.listarEstudiantes().get(y).getIdMateria());
                            listadoFinal.add(BdEstudiantes.listarEstudiantes().get(y).nombre);
                            listadoFinal.add(BdEstudiantes.listarEstudiantes().get(y).apellido);
                            listadoFinal.add(listadoNotas);
                            listadoFinal.add(listadoPromedios);
                            notasFinales.add(listadoFinal);
                            System.out.println("Alumno/a" + " " + listadoFinal);
                            promedio = 0;
                            nota.clear();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void listarNotasAlumnos() {
        System.out.println("Materia: | Nombre: | Apellido: | Notas: | Promedio:");
        for(int i = 0; i < notasFinales.size(); i++){
            System.out.println(notasFinales.get(i));
        }
    }
}

package com.universidad;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;

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
    public void registrarNotasAlumnos() {
        int i;
        int notas;
        String buscar = JOptionPane.showInputDialog(null, """
                Ingresa el codigo de la materia:\s
                Materias:\s
                QUIM1\s
                QUIM2\s
                QUIM3\s
                PROG1\s
                FIS1\s
                FIS2\s
                ING1\s
                ING2""");
        String toUper = buscar.toUpperCase();
        if(toUper.isEmpty()){
            JOptionPane.showMessageDialog(null,"Por favor ingresar una materia");
        }else {
            for (i = 0; i < BdMaterias.listarMaterias().size(); i++) {
                String compare = BdEstudiantes.listarEstudiantes().get(i).getIdMateria();
                if (compare.contains(toUper)) {
                    for (int y = 0; y < BdEstudiantes.listarEstudiantes().size(); y++) {
                        if (y == i) {
                            int cantNotas = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de notas a ingresar al alumno "
                                    + BdEstudiantes.listarEstudiantes().get(y).nombre + " "
                                    + BdEstudiantes.listarEstudiantes().get(y).apellido + " " + " en: "
                                    +  BdEstudiantes.listarEstudiantes().get(y).getIdMateria()));

                            for (int j = 0; j < cantNotas; j++) {
                                int countN = 1;
                                notas = Integer.parseInt(JOptionPane.showInputDialog("Ingresar nota: " + countN + " a estudiante: "
                                        + BdEstudiantes.listarEstudiantes().get(y).nombre + " "
                                        + BdEstudiantes.listarEstudiantes().get(y).apellido));
                                countN++;
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

                            JOptionPane.showMessageDialog(null, "Alumno/a" + listadoFinal);
                            promedio = 0;
                            nota.clear();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void listarNotasAlumnos() {  //muestra la info de todos los alumnos
        for (ArrayList<String> notasFinale : notasFinales) {
            JOptionPane.showMessageDialog(null, "Materia: | Nombre: | Apellido: | Notas: | Promedio: " + notasFinale);
        }
    }
}

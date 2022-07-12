package com.universidad;
import java.util.ArrayList;

public class BdMaterias {
    public static ArrayList<Materia> listarMaterias(){
        ArrayList<Materia> listMateria = new ArrayList();

        Materia materia1 = new Materia ("QUIM1","QUIMICA 1","TURNO1","11-06-2021","01-12-2022");
        Materia materia2 = new Materia ("QUIM2","QUIMICA 2","TURNO2","11-06-2021","01-12-2022");
        Materia materia3 = new Materia ("QUIM3","QUIMICA 3","TURNO3","11-06-2021","01-12-2022");
        Materia materia4 = new Materia ("PROG1","PROGRAMACION 1","TURNO1","11-06-2021","01-12-2022");
        Materia materia5 = new Materia ("FIS1","FISICA 1","TURNO1","11-06-2021","01-12-2022");
        Materia materia6 = new Materia ("FIS2","FISICA 2","TURNO2","11-06-2021","01-12-2022");
        Materia materia7 = new Materia ("ING1","INGENIERIA 1","TURNO3","11-06-2021","01-12-2022");
        Materia materia8 = new Materia ("ING2","INGENIERIA 2","TURNO1","11-06-2021","01-12-2022");

        listMateria.add(materia1);
        listMateria.add(materia2);
        listMateria.add(materia3);
        listMateria.add(materia4);
        listMateria.add(materia5);
        listMateria.add(materia6);
        listMateria.add(materia7);
        listMateria.add(materia8);

        return listMateria;
    }
}

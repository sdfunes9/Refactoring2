package com.universidad;

import java.util.ArrayList;
import java.util.List;

public class Maestro {
    List<Empleado> Maestros = new ArrayList<>();
    List<String> maestromateria = new ArrayList<>();

    public void identificarmaestros() {
        for (int i = 0; i < BdEmpleados.listarEmpleados().size(); i++ ){
            if (BdEmpleados.listarEmpleados().get(i).rol .equals("MAESTRO")){
                Maestros.add(BdEmpleados.listarEmpleados().get(i));
            }
        }
        for(Empleado maestro : Maestros){
            System.out.println(maestro);
        }
    }

    public ArrayList<String> asignarmateriaimpartida() {

        maestromateria.add("Miriam Mendez");
        maestromateria.add("Miriam Mendez");
        maestromateria.add("Miriam Mendez");
        maestromateria.add("Mario Rodriguez");
        maestromateria.add("Dimitri Mendez");
        maestromateria.add("Dimitri Mendez");
        maestromateria.add("Israel Mendez");
        maestromateria.add("Israel Mendez");
        return (ArrayList<String>) maestromateria;
    }
}

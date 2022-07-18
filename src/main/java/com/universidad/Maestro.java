package com.universidad;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Maestro {
    List<Empleado> Maestros = new ArrayList<>();
    List<String> maestromateria = new ArrayList<>();

    public void identificarmaestros() {
        for (int i = 0; i < BdEmpleados.listarEmpleados().size(); i++ ){
            if (BdEmpleados.listarEmpleados().get(i).rol .equals("Maestro")){
                Maestros.add(BdEmpleados.listarEmpleados().get(i));
            }
        }
        for(Empleado maestro : Maestros){
            JOptionPane.showMessageDialog(null,maestro,"Maestro",JOptionPane.PLAIN_MESSAGE);
        }
    }

    public ArrayList<String> asignarmateriaimpartida() {


        String[] temp = new String[] {"Miriam Mendez","Miriam Mendez","Miriam Mendez","Mario Rodriguez","Dimitri Mendez","Dimitri Mendez","Israel Mendez","Israel Mendez"};

        Collections.addAll(maestromateria,temp);

        return (ArrayList<String>) maestromateria;
    }
}

package com.universidad;
import java.util.ArrayList;
import java.util.List;

public class BdEmpleados {

    public static List<Empleado> listarEmpleados (){

        ArrayList<Empleado> empleadosList = new ArrayList();

        Empleado empleado1 = new Empleado(159,"Mario","Rodriguez","mas","18-05-1993","activo",45,"BIBLIOTECARIO","PO4581485","Historiador");
        Empleado empleado2 = new Empleado(159,"Mario","Rodriguez","mas","18-05-1993","activo",15,"MAESTRO","PO4581485","Ingeniero Informatico");
        Empleado empleado3 = new Empleado (160,"Martha","Mendez","fem","4-03-1875","inactivo",26,"Analista compras","ASDRF4584","Administración");
        Empleado empleado4 = new Empleado (161,"Francisco","Mendez","fem","4-03-1875","inactivo",55,"Analista compras","ASDRF4584","Administración");
        Empleado empleado5 = new Empleado (162,"Israel","Mendez","fem","4-03-1875","activo",25,"MAESTRO","ASDRF4584","Ingeniero Industrial");
        Empleado empleado6 = new Empleado (163,"Monica","Mendez","fem","4-03-1875","inactivo",26,"Analista compras","ASDRF4584","Administración");
        Empleado empleado7 = new Empleado (164,"Miriam","Mendez","fem","4-03-1875","activo",27,"MAESTRO","ASDRF4584","Ingeniero Quimico");
        Empleado empleado8 = new Empleado (165,"Fernanda","Mendez","fem","4-03-1875","inactivo",28,"Analista compras","ASDRF4584","Administración");
        Empleado empleado9 = new Empleado (166,"Dimitri","Mendez","fem","4-03-1875","activo",29,"MAESTRO","ASDRF4584","Ingeniero Civil");
        Empleado empleado10 = new Empleado (167,"Renzo","Mendez","fem","4-03-1875","inactivo",30,"Analista compras","ASDRF4584","Administración");

        empleadosList.add(empleado1);
        empleadosList.add(empleado2);
        empleadosList.add(empleado3);
        empleadosList.add(empleado4);
        empleadosList.add(empleado5);
        empleadosList.add(empleado6);
        empleadosList.add(empleado7);
        empleadosList.add(empleado8);
        empleadosList.add(empleado9);
        empleadosList.add(empleado10);

        return empleadosList;
    }
}

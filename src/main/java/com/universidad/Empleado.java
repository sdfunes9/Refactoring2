package com.universidad;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class Empleado extends Usuario{
    @Setter @Getter
    double salario;
    @Setter @Getter
    String rol;
    @Setter @Getter
    String cuentaBancaria;
    @Setter @Getter
    String profesion;

    public Empleado(int idUsuario, String nombre, String apellido, String sexo, String fechaNacimiento,
                    String statusUsuario, double salario, String rol, String cuentaBancaria, String profesion) {
        super(idUsuario, nombre, apellido, sexo, fechaNacimiento, statusUsuario);
        this.salario = salario;
        this.rol = rol;
        this.cuentaBancaria = cuentaBancaria;
        this.profesion = profesion;
    }
    public Empleado() {
    }

    public Empleado(List<Empleado> empleadosList) {
        this.empleadosList = empleadosList;
    }
    @Override
    public String toString() {
        return "Empleado{" + '\n' +
                "ID Usuario= " + idUsuario + '\n' +
                "nombre= " + nombre + '\n' +
                "apellido= " + apellido + '\n' +
                "sexo= " + sexo + '\n' +
                "Fecha de nacimiento= " + fechaNacimiento + '\n' +
                "Status= " + statusUsuario + '\n' +
                "salario= " + salario + '\n' +
                "rol= " + rol + '\n' +
                "cuenta Bancaria= " + cuentaBancaria + '\n' +
                "Profesion= " + profesion + '\n' +
                '}';
    }

    Scanner entrada = new Scanner(System.in);

    @Setter
    @Getter
    private List<Empleado> empleadosList = new ArrayList<>();

    @Override
    public String registrarUsuario() {
        String nombre;
        String apellido;
        String sexo;
        String fechaNacimiento;

        int listSize = empleadosList.size();
        System.out.println("Cantidad de empleados a registrar");
        listSize = entrada.nextInt();
        for (int i = 0; i < listSize; i++) {
            System.out.println(i + 1);
            System.out.println("ID asignado");
            int id = (int) (Math.random() * 10000);
            System.out.println(id);
            entrada.nextLine();

            do{//VALIDACION DE PARAMETRO NOMBRE
                System.out.println("Nombre del empleado");
                nombre = entrada.nextLine();
            }while(!(nombre.matches("^([a-zA-Z_]+[ ]?){1,2}$")));

            do {//VALIDACION DE PARAMETRO APELLIDO
                System.out.println("Apellido del empleado");
                apellido = entrada.nextLine();
            }while(!(apellido.matches("^([a-zA-Z_]+[ ]?){1,2}$")));

            do {//VALIDACION DE PARAMETRO SEXO
                System.out.println("Ingresar sexo del empleado(FEM o MAS)");
                sexo = entrada.nextLine();
                System.out.println(sexo);
            }while (!((sexo.compareTo("FEM")==0)||(sexo.compareTo("MAS")==0)));

            do {//VALIDACION PARAMETRO FECHA
                System.out.println("Fecha de nacimiento (DD-MM-YYY)");
                fechaNacimiento = entrada.nextLine();
            }while(!(fechaNacimiento.matches("^[0-3]?[0-9].[0-3]?[0-9].(?:[0-9]{2})?[0-9]{2}$")));

            System.out.println("Status del empleado");
            String status = entrada.nextLine();
            System.out.println("Salario del empleado");
            double salario = entrada.nextDouble();
            entrada.nextLine();
            System.out.println("Rol del empleado");
            String rol = entrada.nextLine();
            System.out.println("Cuenta Bancaria del empleado");
            String cuentaBancaria = entrada.nextLine();
            System.out.println("Profesion del empleado");
            String profesion = entrada.nextLine();
            entrada.nextLine();

            Empleado empleadoNuevo = new Empleado(id, nombre, apellido, sexo, fechaNacimiento, status, salario, rol,
                    cuentaBancaria, profesion);
            empleadosList.add(empleadoNuevo);
        }
        return "se registró correctamente";
    }

    @Override
    public ArrayList listarUsuario() {

        if (empleadosList.size() == 0) {
            System.out.println("Lista de empleados vacia");
        } else {
            for (int i = 0; i < empleadosList.size(); i++) {
                System.out.println(i + 1);
                System.out.println(empleadosList.get(i));
            }
        }
        return (ArrayList) empleadosList;
    }

    @Override
    public void eliminarUsuario() {
        if (empleadosList.size() == 0) {
            System.out.println("Lista vacia, imposible eliminar empleado");
        } else {
            System.out.println("Indique el indice del empleado a eliminar");
            int indice = entrada.nextInt();
            empleadosList.remove(indice - 1);
            Iterator iterador = empleadosList.iterator();
            while (iterador.hasNext()) {
                System.out.println(iterador.next());
            }
        }

    }

}

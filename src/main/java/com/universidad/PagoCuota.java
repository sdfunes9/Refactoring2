package com.universidad;

import java.util.ArrayList;
import java.util.Scanner;

public class PagoCuota implements Pagos{

Estudiante estudianteTemporal = new Estudiante();
    public void gestionarPagos() {
        int numeroCuotas = 10;
        System.out.print("Ingresa el id del estudiante que pagara su cuota\n");
        Scanner entrada2 = new Scanner(System.in); //se usa variable Scanner entrada en otra funcion en Estudiantes
        int idEstudiante = entrada2.nextInt();
        LogicaPagos(idEstudiante, numeroCuotas);
            }
    public int LogicaPagos(int idEstudiante, int numeroCuotas) {
        BdEstudiantes baseDatos = new BdEstudiantes();
        ArrayList<Estudiante> estudiantes = baseDatos.listarEstudiantes();

        int pagosProcesados = 0;
        int pagoEnProceso =0;
        int pagosRestantes=0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getIdUsuario() == idEstudiante && estudiante.getPagosProcesados() <= 10) {
                System.out.println("ID: " + estudiante.getIdUsuario() + "\n" + estudiante.getNombre() + " " + estudiante.getApellido());
                pagosProcesados = estudiante.getPagosProcesados();
                 pagoEnProceso = pagosProcesados + 1;
                 pagosRestantes = numeroCuotas - pagoEnProceso;
               System.out.println("Se proceso el pago numero " + pagoEnProceso + ", quedan " + pagosRestantes + " pago(s) pendiente(s).");
                System.out.println("Gracias por procesar el pago.");
            }
        }
        return pagosRestantes;
    }
}
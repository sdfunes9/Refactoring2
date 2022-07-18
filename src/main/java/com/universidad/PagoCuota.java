package com.universidad;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PagoCuota implements Pagos{
    public void gestionarPagos() {
        int numeroCuotas = 10;
        int idEstudiante = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el id del estudiante " +
                "que pagará su cuota\n"));
        LogicaPagos(idEstudiante, numeroCuotas);
            }
    public int LogicaPagos(int idEstudiante, int numeroCuotas) {
        BdEstudiantes baseDatos = new BdEstudiantes();
        ArrayList<Estudiante> estudiantes = baseDatos.listarEstudiantes();
        int pagosProcesados = 0;
        int pagoEnProceso =0;
        int pagosRestantes=0;
        Estudiante estudiantePorPagar = null;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getIdUsuario() == idEstudiante ) {
                estudiantePorPagar = estudiante;
            }}
        if(estudiantePorPagar.getPagosProcesados() < 10) {
                    JOptionPane.showMessageDialog(null,"ID: " + estudiantePorPagar.getIdUsuario() +
                            "\n" + estudiantePorPagar.getNombre() + " " + estudiantePorPagar.getApellido());
                    pagosProcesados = estudiantePorPagar.getPagosProcesados();
                    pagoEnProceso = pagosProcesados + 1;
                    pagosRestantes = numeroCuotas - pagoEnProceso;
                    JOptionPane.showMessageDialog(null,"Se proceso el pago numero " + pagoEnProceso +
                            ", quedan " + pagosRestantes + " pago(s) pendiente(s).\nGracias por procesar el pago.");

        }else {
           JOptionPane.showMessageDialog(null,"No se proceso ningun pago, vuelve a intentarlo o revisa " +
                   "tu numero de pagos");
        }
        return pagosRestantes;
    }}
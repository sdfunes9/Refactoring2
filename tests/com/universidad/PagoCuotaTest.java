package com.universidad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagoCuotaTest {

    @Test
    void logicaPagos() {

        int idEstudiante = 6;
        int numeroCuotas = 10;
        PagoCuota pagocuota = new PagoCuota();
        assertEquals(3, pagocuota.LogicaPagos(idEstudiante, numeroCuotas));
    }
}
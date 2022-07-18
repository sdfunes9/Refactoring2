package com.universidad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagoCuotaTest {

    @Test
    void logicaPagos() {

        int idEstudiante = 7;
        int numeroCuotas = 10;
        PagoCuota pagocuota = new PagoCuota();
        assertEquals(8, pagocuota.logicaPagos(idEstudiante, numeroCuotas));
    }
}
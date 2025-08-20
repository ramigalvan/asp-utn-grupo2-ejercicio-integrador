package org.rami;

import org.rami.util.Fecha;

public class TransferenciaBancaria extends MedioPago {
    private String cbu;
    private static final double RECARGO_BASE = 0.05;
    private static final double RECARGO_ADICIONAL = 0.05;
    private static final int DIAS_RETRASADOS = 10;

    public TransferenciaBancaria(Fecha fechaPago, String cbu) {
        super(fechaPago);
        this.cbu = cbu;
    }

    @Override
    public double totalConReglas(double precioBruto, Fecha fechaCompra) {
        int dias = Fecha.diasTranscurridosEntreFechas(fechaCompra, getFechaPago());
        double recargo = RECARGO_BASE + (dias > DIAS_RETRASADOS ? RECARGO_ADICIONAL : 0.0);
        return precioBruto * (1 + recargo);
    }
}

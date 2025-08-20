package org.rami;

import org.rami.util.Fecha;

public abstract class MedioPago {
    private Fecha fechaPago;

    public MedioPago(Fecha fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Fecha getFechaPago() {
        return fechaPago;
    }

    public abstract double totalConReglas(double precioBruto, Fecha fechaCompra);
}
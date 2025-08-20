package org.rami;

import org.rami.util.Fecha;

public abstract class MedioPago {
    protected Fecha fechaPago;

    public MedioPago(Fecha fechaPago) {
        this.fechaPago = fechaPago;
    }

    public abstract double totalConReglas(double precioBruto, Fecha fechaCompra);
}
package org.rami;
import org.rami.util.Fecha;

public class TarjetaDeCredito extends MedioPago {
    private int cantidadCuotas;
    private static final double RECARGO_POR_CUOTA = 0.15;

    public TarjetaDeCredito(Fecha fechaPago, int cantidadCuotas) {
        super(fechaPago);
        this.cantidadCuotas = cantidadCuotas;
    }

    @Override
    public double totalConReglas(double precioBruto, Fecha fechaCompra) {
        return precioBruto * (1 + RECARGO_POR_CUOTA * cantidadCuotas);
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }
}
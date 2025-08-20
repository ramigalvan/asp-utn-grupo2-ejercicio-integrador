package org.rami;
import org.rami.util.Fecha;

public class Efectivo extends MedioPago {
    private boolean esConsumidorFinal;
    private static final double DESCUENTO_GENERAL = 0.10;
    private static final double DESCUENTO_CONSUMIDOR = 0.15;

    public Efectivo(Fecha fechaPago, boolean esConsumidorFinal) {
        super(fechaPago);
        this.esConsumidorFinal = esConsumidorFinal;
    }

    @Override
    public double totalConReglas(double precioBruto, Fecha fechaCompra) {
        double desc = esConsumidorFinal ? DESCUENTO_CONSUMIDOR : DESCUENTO_GENERAL;
        return precioBruto * (1 - desc);
    }
}

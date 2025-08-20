package org.rami;

import java.util.List;
import org.rami.util.Fecha;

public class CarritoDeCompra {

    private String id;
    private List<Item> items;
    private MedioPago medioPago;
    private Fecha fechaCompra;

    public CarritoDeCompra(String id, List<Item> items, MedioPago medioPago, Fecha fechaCompra) {
        this.id = id;
        this.items = items;
        this.medioPago = medioPago;
        this.fechaCompra = fechaCompra;
    }

    public String getId() {
        return id;
    }

    public double precioBruto() {
        double total = 0;
        for (Item item : items) {
            total += item.subtotal();
        }
        return total;
    }

    public double precioFinal() {
        return medioPago.totalConReglas(precioBruto(), fechaCompra);
    }

    public int getCuotasSiTarjeta() {
        if (medioPago instanceof TarjetaDeCredito) {
            TarjetaDeCredito tc = (TarjetaDeCredito) medioPago;
            return tc.getCantidadCuotas();
        }
        return 0;
    }
}

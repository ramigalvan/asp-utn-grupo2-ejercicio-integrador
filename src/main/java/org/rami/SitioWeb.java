package org.rami;

import java.util.ArrayList;
import java.util.List;

public class SitioWeb {
    private List<CarritoDeCompra> carritos;

    public SitioWeb() {
        this.carritos = new ArrayList<>();
    }

    public void agregarCarritoVendido(CarritoDeCompra cdc){
        this.carritos.add(cdc);
    }

    public void mostrarPreciosDeCarritosVendidos(){
        for(CarritoDeCompra cdc : carritos){
           System.out.println("\tCarrito " + cdc.getId() + ": $" + String.format("%.2f", cdc.precioFinal()));
        }
    }
    public String idDelCarritoMasCaro() {
        if (carritos.isEmpty()) {
            return null;
        }

        CarritoDeCompra masCaro = carritos.get(0);
        for (int i = 1; i < carritos.size(); i++) {
            CarritoDeCompra actual = carritos.get(i);
            if (actual.precioFinal() > masCaro.precioFinal()) {
                masCaro = actual;
            }
        }
        return masCaro.getId();
    }


    public double nroCuotasPromedio() {
        int suma = 0;
        int cant = 0;

        for (CarritoDeCompra c : carritos) {
            int cuotas = c.getCuotasSiTarjeta();
            if (cuotas > 0) {
                suma += cuotas;
                cant++;
            }
        }

        if (cant == 0) {
            return 0.0;
        }
        return (double) suma / cant;
    }
}

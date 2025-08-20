package org.rami;

public class Item {
    private int cantidad;
    private Producto producto;

    public Item(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public double subtotal() {
        return cantidad * producto.getPrecio();
    }
}

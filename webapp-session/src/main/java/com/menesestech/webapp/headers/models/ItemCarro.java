
package com.menesestech.webapp.headers.models;

import java.util.Objects;

public class ItemCarro {
    private int cantidad;
    private Producto producto;
    
    // Constructor de la clase ItemCarro
    public ItemCarro(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }
    //Metodos Get y Set
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    //Metodo para calcular el importe total del item
    public int getImporte(){
        return cantidad*producto.getPrecio();
    }
    
    //Método equals para comparar ítems por su producto y cantidad
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemCarro itemCarro = (ItemCarro) obj;
        return Objects.equals(this.producto.getId(), itemCarro.producto.getId())
                && Objects.equals(this.producto.getNombre(), itemCarro.producto.getNombre());
    }
    
}

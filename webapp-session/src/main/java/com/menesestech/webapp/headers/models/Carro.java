
package com.menesestech.webapp.headers.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carro {
    private List<ItemCarro> items;
    //Constructor
    public Carro() {
        this.items = new ArrayList<>();
    }
    // Método para agregar un ítem al carro
    public void addItemCarro(ItemCarro itemCarro){
        if (items.contains(itemCarro)) {
            // Verifica si el ítem ya existe en el carro
            Optional<ItemCarro> optionalItemCarro = items.stream()
                    .filter(i -> i.equals(itemCarro))
                    .findAny();
            if (optionalItemCarro.isPresent()) {
                ItemCarro i = optionalItemCarro.get();
                i.setCantidad(i.getCantidad()+1);// Si ya existe, incrementa la cantidad del ítem
            }
        }else{
            this.items.add(itemCarro);// Si no existe, agrega el ítem al carro
        }
    }
    
    // Método para obtener la lista de ítems del carro
    public List<ItemCarro> getItems() {
        return items;
    }
    
    // Método para calcular el total del carro
    public int getTotal(){
        return items.stream().mapToInt(ItemCarro::getImporte).sum();
    }
}

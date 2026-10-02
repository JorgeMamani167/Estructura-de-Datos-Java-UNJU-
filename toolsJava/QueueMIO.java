package luka.proyectointegrador;

import java.util.ArrayList;

/**
 * @author lucas
 */
public class Queue<ELEMENT> {
    
    private ArrayList<ELEMENT> datos;
    private int tamaño;
    
    // Constructor por defecto
    public Queue() {
        this.datos = new ArrayList<>();
        this.tamaño = 10;
    }
    
    // Constructor con dimensión personalizada
    public Queue(int dimension) {
        if (dimension <= 0) {
            throw new RuntimeException("La cantidad de elementos en la cola debe ser positiva");
        }
        this.datos = new ArrayList<>(dimension);
        this.tamaño = dimension;
    }
    
    public boolean isFull() {
        return this.datos.size() == this.tamaño;
    }
    
    public boolean isEmpty() {
        return this.datos.isEmpty();
    }
    
    public void add(ELEMENT elemento) {
        if (this.isFull()) {
            throw new IllegalStateException("Cola llena...");
        }
        this.datos.add(elemento); // Agrega al final de la cola (tail)
    }

    public ELEMENT remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cola vacía...");
        }
        // Remueve y retorna el primer elemento de la lista (head)
        return this.datos.remove(0);
    }
    
    public ELEMENT peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.datos.get(0); // Devuelve el primer elemento sin removerlo
    }

    public ELEMENT element() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cola vacía...");
        }
        return this.datos.get(0);
    }
    
    public int size() {
        return this.datos.size();
    }
    
    @Override
    public String toString() {
        return "Queue " + this.datos.toString();
    }
    
}
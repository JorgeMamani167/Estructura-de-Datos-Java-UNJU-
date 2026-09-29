package luka.proyectointegrador;
import java.util.ArrayList;

/**
 * @author lucas
 */

/*
Esta clase es una plantilla (un molde). Va a utilizar un tipo de dato que todavía no conozco, pero que lo llamaré temporalmente ELEMENT
*/
//¿Por qué usar ELEMENT en lugar de Object?
//hay una gran diferencia entre ArrayList<Object> y ArrayList<ELEMENT>:
/*
Con Object (Sin seguridad de tipos):
Tu ArrayList<Object> aceptaría cualquier cosa mezclada. Podrías meter un String, luego un número Integer, y luego un objeto de tipo Persona en la misma pila. El problema viene cuando sacas el dato (pop): Java solo sabe que te está devolviendo un Object, por lo que te obligaría a hacer un casting manual todo el tiempo para saber qué es:

Java
String texto = (String) miPila.pop()
*/
/*
Con ELEMENT (Genéricos - Con seguridad de tipos):
Cuando creas tu pila diciendo StackGenerica<String>, le dices a Java: "Esta pila es exclusivamente de Strings".

Java te protege: si intentas meter un número entero, te tira un error antes de ejecutar el programa (en la compilación).

Cuando haces un pop(), Java ya sabe que te va a devolver un String automáticamente, sin necesidad de hacer casts manuales.
*/
//Estrictamente hablando, solo almacena objetos (wrappers)
public class Stack<ELEMENT> {
    
    private ArrayList<ELEMENT> datos ;
    private int tamaño;
    
    //Creo este constructor por si las moscas
    public Stack() {
        this.datos = new ArrayList<>();
        this.tamaño = 10;
    }
    
    public Stack(int dimension) {
        if (dimension <= 0) {
            throw new RuntimeException("La cantidad de elementos en la pila debe ser positiva");
        }
        this.datos = new ArrayList<>(dimension);
        this.tamaño = dimension;
    }
    
    public boolean isFull() {
        if(this.datos.size() == this.tamaño){// == ver
            return true;
        }else{
            return false;
        }
        //return this.datos.size() >= this.tamaño; NOSE SI ES ASI
    }
    
    public boolean isEmpty() {
        return this.datos.isEmpty();//basicamente el mismo metodo que arraylist
    }
    
    public void push(ELEMENT elemento) {
        if (this.isFull()) {
            throw new RuntimeException("Pila llena...");
        }
        this.datos.add(elemento); // Agrega el elemento al final (la cima de la pila)
    }

    public ELEMENT pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Pila vacia...");
        }
        // Remueve y retorna el último elemento de la lista (la cima)
        return this.datos.remove(this.datos.size() - 1);
    }
    
    public ELEMENT peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("Pila vacia...");
        }
        return this.datos.get(this.datos.size() - 1);//get viene de la clase arraylist?
    }
    
    public int size() {
        return this.datos.size();
    }
    
    @Override
    public String toString() {
        return "Stack " + this.datos.toString();
    }
    
}


package luka.punto7_tp5;

import java.util.Random;
/**
 * @author lucas
 */
public class Punto7_tp5 {
    //RECORDA EN EL PUNTO NOSE PIDE UN TOSTRING
    public static void main(String[] args) {
        Random random = new Random();
        int n = Helper.getIntPositivo("Escribir el valor de la dimencion: ");
        //QueueMio<Integer> cola = new QueueMio<>(n);
        //no pienso cargar yo todos los valores
        QueueMio<Integer> cola = new QueueMio<>(n);
        for (int i = 0; i < n; i++){
            int aux = random.nextInt(0,51);
            cola.add(aux);
        }
        
        //procesar cola
        QueueMio<Integer> colaAux = new QueueMio<>(cola.size());
        int auxCantidad = 0;
        int dimencion = cola.size();;//podria usar n pero para tener claro donde empiezo
        //QueueMio<Integer> colaAux = new QueueMio<>(cola.size());
        for(int i = 0; i<dimencion; i++){
            int aux = cola.remove();
            if(aux != 0){
                colaAux.add(aux);
                auxCantidad = auxCantidad + aux;
            }
        }
        dimencion = colaAux.size();
        if (dimencion > 0) {
            System.out.println("Este es el promedio: " + ((double) auxCantidad / (double) dimencion));
        } else {
            System.out.println("No quedaron pedidos validos.");
        }
        for(int i = 0; i<dimencion;i++){
            int aux = colaAux.remove();
            System.out.print(aux + ",");
            cola.add(aux);
        }   
    }   
}

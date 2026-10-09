package luka.punto6_tp5;

/**
 * @author lucas
 */
import java.util.Random;
//Estos son solo para ordenar sin array y sin set o get
import java.util.ArrayList;
import java.util.Collections;

public class Punto6_tp5 {

    public static void main(String[] args) {
        Random aleatorio = new Random();
        DoubleLinkedList<Integer> listaInicial = new DoubleLinkedList<>();
        int n = Helper.getIntPositivo("Ingrese la cantidad N de numeros a generar: ");
        
        for (int i = 0; i < n; i++) {
            // Genera numeros aleatorios entre -50 y 50
            listaInicial.addLast(aleatorio.nextInt(101) - 50);
        }

        System.out.println("\n--- LISTA ORIGINAL (N = " + n + ") ---");
        System.out.println(listaInicial);

        
        DoubleLinkedList<Integer> listaSeparada = separador(listaInicial);
        System.out.println("\n--- PUNTO A: Negativos al principio, positivos al final ---");
        System.out.println(listaSeparada);

        System.out.println("\n--- PUNTO B: Suma entre rangos [A, B] ---");
        int suma = sumaEntreRangos(listaInicial);
        System.out.println("Resultado total de la suma: " + suma);

        // Punto C: Ordenamiento ascendente usando Queue (PriorityQueue)
        // Forma 1: Bubble sort con Arreglo clasico
        DoubleLinkedList<Integer> ord1 = listaOrdenada(listaInicial);
        System.out.println("Forma 1 (Bubble Sort con Arreglo):");
        System.out.println(ord1);

        // Forma 2: Con ArrayList y Collections.sort
        DoubleLinkedList<Integer> ord2 = listaOrdenada2(listaInicial);
        System.out.println("Forma 2 (Con ArrayList y Collections.sort):");
        System.out.println(ord2);

        // Forma 3: Con getItem y setItem directamente sobre la lista
        DoubleLinkedList<Integer> ord3 = listaOrdenada3(listaInicial);
        System.out.println("Forma 3 (Bubble Sort con getItem y setItem):");
        System.out.println(ord3);
    }
    
    public static DoubleLinkedList<Integer> separador(DoubleLinkedList<Integer> lista){
        if(lista == null || lista.isEmpty()){
            throw new RuntimeException("Lista vacia");
        }
        DoubleLinkedList<Integer> auxList = new DoubleLinkedList<>();
        for(Integer num : lista){
            if(num < 0){
                auxList.addFirst(num);
            } else {
                auxList.addLast(num);  
            }
        }
        return auxList;
    }
    
    public static int sumaEntreRangos(DoubleLinkedList<Integer> lista){
        //verificar antes los numeros de entrada pero no queiro
        if(lista == null || lista.isEmpty()){
            throw new RuntimeException("Lista vacia");
        }
        int a = Helper.getInt("Ingrese numero incial del rango: ");
        int b = Helper.getInt("Ingrese numero final del rango: ");
        int suma = 0;
        for(Integer numero : lista){
            if(numero >= a && numero <= b){
                suma = suma + numero;
            }
        }
        return suma;
    }
    
    
    //el punto c es claramente un buble sort
    //hay 3 formas
    //1 usando un array para enonctrar
    //Esta es la mas complicada
    public static DoubleLinkedList<Integer> listaOrdenada(DoubleLinkedList<Integer> lista){
        if(lista == null || lista.isEmpty()){
            throw new RuntimeException("Lista vacia");
        }
        int longitud = lista.size();
        Integer[] auxArr = new Integer[longitud];
        int contador = 0;
        for(Integer numero : lista){
            auxArr[contador++] = numero;
        }
        
        for(int i = 0; i<longitud-1; i++){
            for(int j = 0; j<longitud -1 -i; j++){
                Integer actual = auxArr[j];
                Integer siguiente = auxArr[j+1];
                if(actual > siguiente){
                    Integer aux = auxArr[j];
                    auxArr[j] = auxArr[j + 1];
                    auxArr[j + 1] = aux;
                }
            }
        }
        DoubleLinkedList<Integer> listaRes = new DoubleLinkedList<>();
        for(Integer num : auxArr){
            listaRes.addLast(num);
        }
        return listaRes;
    }
    
    
    
    //2 con importaciones y arraylist
    public static DoubleLinkedList<Integer> listaOrdenada2(DoubleLinkedList<Integer> lista){
        if(lista == null || lista.isEmpty()){
            throw new RuntimeException("Lista vacia");
        }
        //hay dos formas de ordenar y en esta hago un bublesort sin tener get item
        
        ArrayList<Integer> auxArr = new ArrayList<Integer>();
        for(Integer numero : lista){
            auxArr.add(numero);
        }
        
        Collections.sort(auxArr);
        
        DoubleLinkedList<Integer> listaSort = new DoubleLinkedList<Integer>();
        for(Integer numero : auxArr){
            listaSort.addLast(numero);
        }
        return listaSort;
    }
    //3 con un getitem y setitem
    public static DoubleLinkedList<Integer> listaOrdenada3(DoubleLinkedList<Integer> lista){
        if(lista == null || lista.isEmpty()){
            throw new RuntimeException("Lista vacia");
        }
        DoubleLinkedList<Integer> listaRes = new DoubleLinkedList<>();
        for (Integer numero : lista) {
            listaRes.addLast(numero);
        }
        int n = listaRes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                Integer actual = listaRes.getItem(j);
                Integer siguiente = listaRes.getItem(j + 1);
                if (actual > siguiente) {
                    listaRes.setItem(j, siguiente);
                    listaRes.setItem(j + 1, actual);
                }
            }
        }

        return listaRes;
        
    }
}

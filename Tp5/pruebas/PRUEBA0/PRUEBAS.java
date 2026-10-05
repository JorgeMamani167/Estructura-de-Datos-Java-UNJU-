//ver que pasa si imprimo lista vacia xd
package luka.pruebas;

public class PRUEBAS {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> listaProductos = new SimpleLinkedList<>();//nombre de ejemplo
        System.out.print(listaProductos);
        listaProductos.addFirst(2);
        System.out.println(listaProductos);
        listaProductos.addFirst(9);
        listaProductos.addFirst(3);
        listaProductos.addLast(8);
        listaProductos.addLast(20);
        System.out.println(listaProductos);
        //for normal
        for (int i = 0; i < listaProductos.size(); i++) {
            Integer elemento = listaProductos.getItem(i);//usando el getItem mejorado que hice
            System.out.println("Elemento en índice " + i + ": " + elemento);
        }
        
        //for each
        for (Integer producto : listaProductos) {
            System.out.println("Producto: " + producto);
        }
    }
}
//ver que pasa si imprimo lista vacia xd
package luka.pruebas;

public class PRUEBAS {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> listaProductos = new DoubleLinkedList<>();//nombre de ejemplo
        System.out.print(listaProductos);
        listaProductos.addFirst(2);
        System.out.println(listaProductos);
        listaProductos.addFirst(9);
        listaProductos.addFirst(3);
        listaProductos.addLast(8);
        listaProductos.addLast(20);
        System.out.println(listaProductos);
        
        //for each
        for (Integer producto : listaProductos) {
            System.out.println("Producto: " + producto);
        }
    }
}
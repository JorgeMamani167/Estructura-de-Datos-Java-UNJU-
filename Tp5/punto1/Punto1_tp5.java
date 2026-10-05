package luka.punto1_tp5;

/**
 * @author lucas
 * github: JorgeMamani167
 */

/*
esto para un double linked list y simple linked list
a) Agregar un elemento en una posición ingresada por el usuario.
b) Eliminar un elemento ubicado en una posición ingresada por el usuario.
De manera que, estos dos nuevos métodos deberán quedar incluidos en la clase SimpleLinkedList. Controlar
los casos en donde la lista está vacía o el valor ingresado está fuera de los límites de la misma.
*/



public class Punto1_tp5 {
    public static void main(String[] args) {
        SimpleLinkedList<Producto> listaProductos = new SimpleLinkedList<>();

        // Cargar la lista con varios productos iniciales
        listaProductos.addLast(new Producto("A01", "Notebook", 10, 850000.0));
        listaProductos.addLast(new Producto("A02", "Mouse Inalámbrico", 50, 15000.0));
        listaProductos.addLast(new Producto("A03", "Teclado Mecánico", 25, 45000.0));
        listaProductos.addLast(new Producto("A04", "Monitor 24 pulgadas", 15, 120000.0));

        // Llamada al método que gestiona la interacción
        gestionarMenu(listaProductos);
    }

    /**
     * Muestra las opciones del menú por consola.
     */
    public static void mostrarMenu() {
        System.out.println("\n====== MENÚ DE GESTIÓN DE PRODUCTOS ======");
        System.out.println("1. Agregar producto en una posición específica");
        System.out.println("2. Eliminar producto en una posición específica");
        System.out.println("3. Mostrar lista de productos");
        System.out.println("0. Salir");
    }

    /**
     * Método que contiene la lógica del menú interactivo.
     */
    public static void gestionarMenu(SimpleLinkedList<Producto> listaProductos) {
        int opcion;

        do {
            mostrarMenu();
            opcion = Helper.getOpcion("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Lista ANTES de la inserción ---");
                    System.out.println(listaProductos);

                    int indiceAgregar = Helper.getOpcion("\nIngrese la posicion (indice desde 0) donde desea agregar: ");//uso el mismo que opcion por que no siento que es necesario tener otro metodo
                    String codigo = Helper.getStringObligatorio("Ingrese el codigo del producto: ");
                    String nombre = Helper.getStringObligatorio("Ingrese el nombre del producto: ");
                    int stock = Helper.getIntPositivo("Ingrese el stock: ");
                    double precio = Helper.getDoublePositivo("Ingrese el precio: "); 

                    Producto nuevoProducto = new Producto(codigo, nombre, stock, precio);

                    try {
                        listaProductos.addIndex(indiceAgregar, nuevoProducto);
                        System.out.println("\nProducto agregado con exito");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("\nError: " + e.getMessage());
                    }

                    System.out.println("\n--- Lista DESPUÉS de la insercion ---");
                    System.out.println(listaProductos);
                    break;

                case 2:
                    System.out.println("\n--- Lista ANTES de la eliminacion ---");
                    System.out.println(listaProductos);

                    int indiceEliminar = Helper.getOpcion("\nIngrese la posición (índice desde 0) del producto a eliminar: ");

                    try {
                        Producto eliminado = listaProductos.removeAt(indiceEliminar);
                        System.out.println("\n¡Producto eliminado exitosamente: " + eliminado.getNombre());
                    } catch (RuntimeException e) {
                        System.out.println("\nError: " + e.getMessage());
                    }

                    System.out.println("\n--- Lista post eliminacion ---");
                    System.out.println(listaProductos);
                    break;

                case 3:
                    System.out.println("\n--- Lista Actual de Productos ---");
                    if (listaProductos.isEmpty()) {
                        System.out.println("La lista está vacia.");
                    } else {
                        System.out.println(listaProductos);
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
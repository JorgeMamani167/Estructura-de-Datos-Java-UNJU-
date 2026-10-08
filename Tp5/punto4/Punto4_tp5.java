package luka.punto4_tp5;

/**
 * @author lucas
 */

import java.time.LocalDate;

public class Punto4_tp5 {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();

        // a) Cargar al menos 5 tareas iniciales
        gestor.agregarTarea(new Tarea(1, "Disenar base de datos", "Lucas", LocalDate.now().plusDays(2), false));
        gestor.agregarTarea(new Tarea(2, "Implementar login", "Ana", LocalDate.now().plusDays(5), false));
        gestor.agregarTarea(new Tarea(3, "Escribir pruebas unitarias", "Lucas", LocalDate.now().minusDays(1), true));
        gestor.agregarTarea(new Tarea(4, "Desplegar en servidor", "Carlos", LocalDate.now().plusDays(10), false));
        gestor.agregarTarea(new Tarea(5, "Revisar documentacion", "Ana", LocalDate.now().plusDays(1), false));

        System.out.println("=== ¡5 Tareas cargadas exitosamente al sistema! ===");

        int opcion;
        do {
            System.out.println("\n==================================");
            System.out.println("      MENU GESTOR DE TAREAS       ");
            System.out.println("==================================");
            System.out.println("1. Agregar nueva tarea");
            System.out.println("2. Completar tarea por ID");
            System.out.println("3. Ver tareas por responsable");
            System.out.println("4. Mostrar tareas pendientes");
            System.out.println("5. Eliminar tarea por ID");
            System.out.println("6. Ver tareas proximas por responsable");
            System.out.println("7. Verificar si la lista esta vacia");
            System.out.println("0. Salir");

            opcion = Helper.getOpcion("Elige una opcion: ");

            switch (opcion) {
                case 1:
                    int id = Helper.getIntPositivo("Ingrese ID de la tarea: ");
                    String titulo = Helper.getStringObligatorio("Ingrese titulo: ");
                    String responsable = Helper.getStringObligatorio("Ingrese responsable: ");
                    LocalDate fecha = Helper.getLocalDate("Ingrese fecha limite (YYYY-MM-DD): ");
                    boolean completada = Helper.getBoolean("¿Esta completada?");
                    
                    Tarea nueva = new Tarea(id, titulo, responsable, fecha, completada);
                    gestor.agregarTarea(nueva);
                    System.out.println("¡Tarea agregada con exito!");
                    break;

                case 2:
                    if (gestor.isEmpty()) {
                        System.out.println("Error: La lista esta vacia.");
                        break;
                    }
                    int idCompletar = Helper.getIntPositivo("Ingrese el ID de la tarea a completar: ");
                    gestor.completarTarea(idCompletar);
                    break;

                case 3:
                    if (gestor.isEmpty()) {
                        System.out.println("Error: La lista esta vacia.");
                        break;
                    }
                    String respBuscado = Helper.getStringObligatorio("Ingrese el nombre del responsable: ");
                    SimpleLinkedList<Tarea> tareasResp = gestor.tareasPorResponsable(respBuscado);
                    if (tareasResp.isEmpty()) {
                        System.out.println("No se encontraron tareas para " + respBuscado);
                    } else {
                        System.out.println("Tareas de " + respBuscado + ":\n" + tareasResp);
                    }
                    break;

                case 4:
                    if (gestor.isEmpty()) {
                        System.out.println("Error: La lista esta vacia.");
                        break;
                    }
                    System.out.println("--- TAREAS PENDIENTES ---");
                    gestor.tareasPendientes();
                    break;

                case 5:
                    if (gestor.isEmpty()) {
                        System.out.println("Error: La lista esta vacia.");
                        break;
                    }
                    int idEliminar = Helper.getIntPositivo("Ingrese el ID de la tarea a eliminar: ");
                    gestor.eliminarTarea(idEliminar);
                    break;

                case 6:
                    if (gestor.isEmpty()) {
                        System.out.println("Error: La lista esta vacia.");
                        break;
                    }
                    String respProx = Helper.getStringObligatorio("Ingrese el nombre del responsable: ");
                    SimpleLinkedList<Tarea> proximas = gestor.tareasProximas(respProx);
                    if (proximas != null) {
                        if (proximas.isEmpty()) {
                            System.out.println("No hay tareas futuras para este responsable.");
                        } else {
                            System.out.println("Tareas futuras:\n" + proximas);
                        }
                    }
                    break;

                case 7:
                    if (gestor.isEmpty()) {
                        System.out.println("La lista de tareas esta VACIA.");
                    } else {
                        System.out.println("La lista de tareas NO esta vacia.");
                    }
                    break;

                case 0:
                    System.out.println("¡Saliendo del programa. Adios!");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
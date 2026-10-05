package luka.punto3_tp5;

/**
 * @author lucas
 */
import java.time.LocalDate;
public class Punto3_tp5 {

    public static void main(String[] args) {
        SimpleLinkedList<Suscripcion> lista1 =
                new SimpleLinkedList<Suscripcion>();

        SimpleLinkedList<Suscripcion> lista2 =
                new SimpleLinkedList<Suscripcion>();

        // Cargar lista 1
        lista1.addLast(new Suscripcion(
                "S001",
                "Juan",
                "Premium",
                LocalDate.of(2026, 10, 20)
        ));

        lista1.addLast(new Suscripcion(
                "S002",
                "Pedro",
                "Basico",
                LocalDate.of(2026, 10, 5)
        ));

        lista1.addLast(new Suscripcion(
                "S003",
                "Maria",
                "Premium",
                LocalDate.of(2026, 10, 15)
        ));

        // Cargar lista 2
        lista2.addLast(new Suscripcion(
                "S004",
                "Juan",
                "Basico",
                LocalDate.of(2026, 9, 25)
        ));

        lista2.addLast(new Suscripcion(
                "S005",
                "Carlos",
                "Premium",
                LocalDate.of(2026, 10, 1)
        ));

        lista2.addLast(new Suscripcion(
                "S006",
                "Lucia",
                "Basico",
                LocalDate.of(2026, 10, 30)
        ));

        System.out.println("LISTA 1");
        System.out.println(lista1);

        System.out.println("\nLISTA 2");
        System.out.println(lista2);

        // b) Buscar usuario
        String usuarioBuscar =
                Helper.getStringObligatorio(
                        "\nIngrese el nombre de usuario a buscar: "
                );

        contadorUsuario(lista1, lista2, usuarioBuscar);

        // c) Intersección
        SimpleLinkedList<Suscripcion> interseccion =
                listaIterseccion(lista1, lista2);

        System.out.println("\nLISTA INTERSECCION");
        System.out.println(interseccion);

        // Unión ordenada
        SimpleLinkedList<Suscripcion> union =
                unionSuscripcion(lista1, lista2);

        System.out.println("\nLISTA UNION ORDENADA POR FECHA");
        System.out.println(union);
    }
    
    public static SimpleLinkedList<Suscripcion> listaIterseccion(SimpleLinkedList<Suscripcion> lista1, SimpleLinkedList<Suscripcion> lista2){
        if(lista1 == null || lista1.isEmpty() || lista2 == null || lista2.isEmpty()){//si una pasa debe hacer retornar null o una lista vacia
            return null;
        }
        SimpleLinkedList<Suscripcion> listaJunta = new SimpleLinkedList<Suscripcion>();
        for(Suscripcion susc1 : lista1){
            boolean encontrado = false;
            for(Suscripcion susc2 : lista2){//podria ir susc1.getUsuario() != null pero no lo veo necesario
                if(susc1.getUsuario().equalsIgnoreCase(susc2.getUsuario())){
                    encontrado = true;
                    break;
                }
            }
            if (encontrado){
                listaJunta.addLast(susc1);
            }
        }
        return listaJunta;
    }
    
    public static void contadorUsuario(SimpleLinkedList<Suscripcion> lista1,SimpleLinkedList<Suscripcion> lista2, String usuarioBuscar){
        int contador = 0;
        if(lista1 == null || lista1.isEmpty() || lista2 == null || lista2.isEmpty()){
            System.out.println("No hay nodos");
            return;
        }
        //podemos saltarnos la verificacion de antes y directamente hacer esto en cada lista if (lista1 != null) { y recorrer
        for(Suscripcion susc : lista1){
            if(susc.getUsuario().equalsIgnoreCase(usuarioBuscar)){
                ++contador;
            }
        }
        for(Suscripcion susc : lista2){
            if(susc.getUsuario().equalsIgnoreCase(usuarioBuscar)){
                ++contador;
            }
        }
        if(contador == 0){
            System.out.println("No se encontro ocurrencias");
        }
        System.out.println("Esta es la cantidad de ocurencias del usuario: " + contador);
    }
    
    public static SimpleLinkedList<Suscripcion> unionSuscripcion(SimpleLinkedList<Suscripcion> lista1,SimpleLinkedList<Suscripcion> lista2){
        SimpleLinkedList<Suscripcion> listaAux = new SimpleLinkedList<Suscripcion>();
        if(lista1 == null || lista1.isEmpty() || lista2 == null || lista2.isEmpty()){
            System.out.println("No hay nodos");
            return null;
        }
        for(Suscripcion susc1 : lista1){
            listaAux.addLast(susc1);
        }
        for(Suscripcion susc1 : lista2){
            listaAux.addLast(susc1);
        }
        //System.out.print(listaAux);
        for (int i = 0; i < listaAux.size() - 1; i++) {
            for (int j = 0; j < listaAux.size() - 1 - i; j++) {
                Suscripcion actual = listaAux.getItem(j);
                Suscripcion siguiente = listaAux.getItem(j + 1);
                if (actual.getFechaInicio().isAfter(siguiente.getFechaInicio())) {//tal fecha despues de otra
                    Suscripcion aux = actual;
                    listaAux.setItem(j, siguiente);
                    listaAux.setItem(j + 1, aux);
                }
            }
        }
        return listaAux;
    }
}

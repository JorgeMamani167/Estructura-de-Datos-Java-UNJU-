package luka.proyectointegrador;

/**
 * @author lucas
 */
import java.util.Random;
import java.util.Arrays;

public class ProyectoIntegrador {
    private static final Integer cantidadDeJugadores = 4;
	
    public static void main(String[] args) {
        Carta[][] baraja = new Carta[4][13];
        Queue<Jugador> jugadores = new Queue<Jugador>(cantidadDeJugadores);
        Stack<Carta> barajaAletoria = new Stack<>(52);
        cargarMazo(baraja);
        //hacer stack mazo aletorio
        
        menu(barajaAletoria, jugadores, baraja);
    }   

    private static void cargarMazo(Carta[][] baraja) {
        Palo[] palos = Palo.values(); // Obtenemos los 4 palos del enum

        // Llenamos la matriz instanciando el objeto Carta en cada posición
        for (int fila = 0; fila < 4; fila++) {
            for (int columna = 0; columna < 13; columna++) {
                // columna+1 porque el rango va de 1 a 13, pero los índices de columna van de 0 a 12
                baraja[fila][columna] = new Carta(columna + 1, palos[fila]); 
            }
        }
    }

    // Inicia metodo: menu
    
    private static void verOpciones(int numeroRonda) {
            System.out.println("***** JUEGO DE CARTAS *****");
            System.out.println("#MENU:");
            System.out.println(" 1) Cargar jugadores.");
            System.out.println(" 2) Mezclar cartas.");
            System.out.println(" 3) Jugar.");
            System.out.println(" 4) Las cartas que quedan en el mazo principal.");
            if (numeroRonda >= 3) {
                System.out.println(" 0) Finalizar juego.");
            }
            System.out.println("****************************");		
    }
    
    private static void menu(Stack<Carta> barajaAletoria, Queue<Jugador> jugadores, Carta[][] baraja) {
        int numeroRonda = 0;
        int opcion;
        boolean barajaMezclada = false;
        do {
            verOpciones(numeroRonda);
            opcion =  Helper.getOpcion("Escriba la opcion que quiere: ");
            if (opcion == 0 && numeroRonda < 3) {
                System.out.println("Error: Esta opción aún no está disponible (requiere al menos 3 rondas).");
                continue; // Vuelve a mostrar el menú
            }
            switch (opcion){
                case 1:
                    cargarJugadores(jugadores);
                    System.out.println(jugadores.toString());
                    break;
                case 2:
                    if (barajaMezclada) {
                        System.out.println("Error La baraja ya fue mezclada anteriormente.");
                    } else if (barajaAletoria.isFull()) {
                        System.out.println("Error: La baraja ya esta llena.");
                    } else {
                        CargarAletorioStack(barajaAletoria, baraja);
                        barajaMezclada = true; // Marcamos que ya se usoS una vez
                        System.out.println(barajaAletoria.toString());
                    }
                case 3:
                    ++numeroRonda;
                    System.out.println("Esta es la ronda: " + numeroRonda);
                    jugar(jugadores, barajaAletoria);
                    if (numeroRonda == 3) {
                        String respuesta = Helper.getString("¿Desea terminar el juego ahora? (s/n): ");
                        if (respuesta.equalsIgnoreCase("s")) {
                            System.out.println("Finalizando el juego...");
                            opcion = 0; // Forzamos la salida del bucle
                        }
                    }
                    break;
                case 4:
                    if(barajaAletoria == null || barajaAletoria.isEmpty()){
                        System.out.println("La baraja esta vacia");
                    }else{
                        System.out.println(barajaAletoria.toString());
                    }
                    break;
                case 0:
                    System.out.println("Finalizando juego...");
                    break;
                default:
                    System.out.println("Error: El numero ingresado es invalido. Vuelva a ingresar.");          
            }
        } while (opcion != 0);
    }

    // Finaliza metodo: menu

    // Inicia metodo: cargar jugadores
    private static void cargarJugadores(Queue<Jugador> jugadores) {
        if(jugadores.isFull()){
            System.out.println("YA se cargaron los jugadores");
            return;
        }
        if(jugadores == null || jugadores.isEmpty()){
            System.out.println("No se cargaron los jugadores");
        }
        for (int i=0;i<cantidadDeJugadores;i++) {
            System.out.println("#Jugador "+(i+1)+": ");
            String nombre = Helper.getString(".Inserte nombre del jugador: "); 
            String apellido = Helper.getString(".Inserte apellido del jugador: "); 
            int edad = Helper.getIntRango(".Inserte años del jugador: ",5,99);
            Jugador bot = new Jugador(nombre,apellido,edad);
            jugadores.add(bot);
        }	
    }
    // Finaliza metodo: cargar jugadores
    
    private static void CargarAletorioStack(Stack<Carta> barajaAletoria, Carta[][] baraja){
        if (barajaAletoria == null || barajaAletoria.isFull()){
            System.out.println("Esta llena la baraja");
            return;
        }
        while(!barajaAletoria.isFull()){
            Random random = new Random();
            int randomPalo = random.nextInt(4); 
            int randomValor = random.nextInt(13);
            Carta cartaAleatoria = baraja[randomPalo][randomValor];
            if(cartaAleatoria.isDisponible()){
                barajaAletoria.push(cartaAleatoria);
                cartaAleatoria.setDisponible(false);
            }
        }
    }
    
    private static void repartirCartas(Stack<Carta> barajaAletoria, Queue<Jugador> jugadores){
        if(barajaAletoria == null || barajaAletoria.isEmpty()){
            System.out.println("La baraja esta vacia :C");
            return;
        }
        Jugador jugadorAux = null;
        for (int jugador = 0; jugador<cantidadDeJugadores; jugador++){
            jugadorAux = jugadores.remove();
            jugadorAux.getPilaPersonal().push(barajaAletoria.pop());
            jugadores.add(jugadorAux);
        }
        
    }
    
    public static void jugar(Queue<Jugador> jugadores, Stack<Carta> barajaAletoria){
        if(jugadores == null || jugadores.isEmpty()){
            System.out.println("YA NO HAY JUGADORES");
            return;
        }
        if(barajaAletoria == null || barajaAletoria.isEmpty()){
            System.out.println("YA NO HAY CARTAS EN EL MAZO");
            return;
        }
        repartirCartas(barajaAletoria, jugadores);
        Jugador[] jugadoresAux = new Jugador[cantidadDeJugadores];
        Jugador jugadorAux = null;
        for (int jugador = 0; jugador < cantidadDeJugadores; jugador++){
            jugadorAux = jugadores.remove();
            jugadoresAux[jugador] = jugadorAux;
            jugadores.add(jugadorAux);
        }

        // MOSTRAR LA CARTA QUE LE TOCO A CADA UNO AL REPARTIR
        System.out.println("\n--- CARTAS REPARTIDAS PARA ESTA RONDA ---");
        for (int i = 0; i < cantidadDeJugadores; i++) {
            System.out.println("Jugador " + i+1 + ": " + jugadoresAux[i].getNombre() + " " + jugadoresAux[i].getApellido());
            System.out.println("Le tocó la carta:\n" + jugadoresAux[i].getPilaPersonal().peek().toString());
        }
        System.out.println("-----------------------------------------\n");

        // Obtenemos los rangos de cada uno (la carta de arriba de su pila)
        int r0 = jugadoresAux[0].getPilaPersonal().peek().getRango();
        int r1 = jugadoresAux[1].getPilaPersonal().peek().getRango();
        int r2 = jugadoresAux[2].getPilaPersonal().peek().getRango();
        int r3 = jugadoresAux[3].getPilaPersonal().peek().getRango();

        // 1. ¿Gana el Jugador 0 en solitario?
        if (r0 > r1 && r0 > r2 && r0 > r3) {
            procesarResultadoRonda(jugadoresAux, 0);
        } 
        // 2. ¿Gana el Jugador 1 en solitario?
        else if (r1 > r0 && r1 > r2 && r1 > r3) {
            procesarResultadoRonda(jugadoresAux, 1);
        } 
        // 3. ¿Gana el Jugador 2 en solitario?
        else if (r2 > r0 && r2 > r1 && r2 > r3) {
            procesarResultadoRonda(jugadoresAux, 2);
        } 
        // 4. ¿Gana el Jugador 3 en solitario?
        else if (r3 > r0 && r3 > r1 && r3 > r2) {
            procesarResultadoRonda(jugadoresAux, 3);
        } 
        // 5. EN CUALQUIER OTRO CASO (Si hay un empate)
        else {
            System.out.println("Empate Como es empate, cada jugador conserva unicamente su carta actual y no se llevan puntos extra.");
            // En caso de empate, si quieres que se queden solo con su carta y no acumulen las de los demás,
            // puedes decidir qué hacer con las cartas. Como ya están en su pila personal por el reparto, 
            // simplemente se quedan ahí como su única carta de esta mano.
        }
        ganador(jugadores);
    }
    
    private static void procesarResultadoRonda(Jugador[] jugadoresAux, int indiceGanador) {
        int segundo = -1;
        int sumaPuntosPerdedores = 0;

        for (int i = 0; i < cantidadDeJugadores; i++) {
            int rangoActual = jugadoresAux[i].getPilaPersonal().peek().getRango();
            if (i != indiceGanador) {
                sumaPuntosPerdedores += rangoActual;
                if (rangoActual > segundo) {
                    segundo = rangoActual;
                }
            }
        }

        int rangoGanador = jugadoresAux[indiceGanador].getPilaPersonal().peek().getRango();
        int diferencia = rangoGanador - segundo;

        System.out.println("Gano el jugador " + indiceGanador + ": " + jugadoresAux[indiceGanador].getNombre());
        System.out.println("Gano por " + diferencia + " punto(s) de diferencia.");
        System.out.println("Puntos obtenidos en esta ronda: " + sumaPuntosPerdedores);

        // Se transfieren las cartas de los perdedores a la pila personal del ganador
        // De esta forma se acumulan en su stack para sumar al total general en las siguientes rondas.
        for (int i = 0; i < cantidadDeJugadores; i++) {
            if (i != indiceGanador) {
                jugadoresAux[indiceGanador].getPilaPersonal().push(jugadoresAux[i].getPilaPersonal().pop());
            }
        }
    }

    public static void ganador(Queue<Jugador> jugadores) {
        if (jugadores == null || jugadores.isEmpty()) {
            System.out.println("No hay jugadores en la cola.");
            return;
        }
        
        Jugador[] jugadoresAux = new Jugador[cantidadDeJugadores];
        int[] puntosTotales = new int[cantidadDeJugadores];

        // 1. Extraer jugadores y calcular el puntaje total de sus pilas personales
        for (int i = 0; i < cantidadDeJugadores; i++) {
            Jugador jugadorActual = jugadores.remove();
            jugadoresAux[i] = jugadorActual;

            Stack<Carta> pilaPersonal = jugadorActual.getPilaPersonal();
            int sumaPuntos = 0;

            // Creamos una pila auxiliar para no perder las cartas
            // Usamos el tamaño actual de la pila para dimensionarla bien
            //Si la pila esta vacia (por ejemplo, al inicio de la partida), le asigna un tamaño por defecto de 10 para evitar errores al instanciarla.
            Stack<Carta> pilaAuxiliar = new Stack<>(pilaPersonal.size() > 0 ? pilaPersonal.size() : 10);

            // Vaciamos la pila original sumando los puntos y guardando en la auxiliar
            while (!pilaPersonal.isEmpty()) {
                Carta cartaActual = pilaPersonal.pop();
                sumaPuntos += cartaActual.getRango();
                pilaAuxiliar.push(cartaActual);
            }

            // Restauramos la pila original devolviendo las cartas desde la auxiliar
            while (!pilaAuxiliar.isEmpty()) {
                pilaPersonal.push(pilaAuxiliar.pop());
            }

            puntosTotales[i] = sumaPuntos;
            jugadores.add(jugadorActual); // Devolvemos el jugador a la cola original
        }

        // 2. Ordenar de mayor a menor (Bubble Sort) para armar el podio
        for (int i = 0; i < cantidadDeJugadores - 1; i++) {
            for (int j = 0; j < cantidadDeJugadores - 1 - i; j++) {
                if (puntosTotales[j] < puntosTotales[j + 1]) {
                    // Intercambiar puntos
                    int tempPuntos = puntosTotales[j];
                    puntosTotales[j] = puntosTotales[j + 1];
                    puntosTotales[j + 1] = tempPuntos;

                    // Intercambiar jugadores para que vayan alineados con sus puntos
                    Jugador tempJugador = jugadoresAux[j];
                    jugadoresAux[j] = jugadoresAux[j + 1];
                    jugadoresAux[j + 1] = tempJugador;
                }
            }
        }

        // 3. Mostrar el podio del mayor al menor
        System.out.println("\n=================================");
        System.out.println("          top FINAL            ");
        System.out.println("=================================");
        for (int i = 0; i < cantidadDeJugadores; i++) {
            System.out.println((i + 1) + "Lugar: " + jugadoresAux[i].getNombre() + " " + jugadoresAux[i].getApellido() + " -> Puntuacion total: " + puntosTotales[i] + " puntos");
        }
        System.out.println("=================================");
    }
    
}

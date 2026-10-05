package luka.punto2_tp5;

/**
 * @author lucas
 */
public class Punto2_tp5 {

    public static void main(String[] args) {
        DoubleLinkedList<Cancion> listaCanciones = new DoubleLinkedList<>();
        Cancion masAntigua = devolverCancion(listaCanciones);
        System.out.println(masAntigua);
        listaCanciones.addLast(new Cancion("Bohemian Rhapsody", "Queen", 1975, 354));
        listaCanciones.addLast(new Cancion("Hotel California", "Eagles", 1976, 391));
        listaCanciones.addLast(new Cancion("Billie Jean", "Michael Jackson", 1982, 454));
        listaCanciones.addLast(new Cancion("Smells Like Teen Spirit", "Nirvana", 1991, 301));
        listaCanciones.addLast(new Cancion("Stairway to Heaven", "Led Zeppelin", 1971, 482));
        listaCanciones.addLast(new Cancion("Thriller", "Michael Jackson", 1982, 357)); 
        listaCanciones.addLast(new Cancion("Imagine", "John Lennon", 1971, 183));
        listaCanciones.addLast(new Cancion("Hey Jude", "The Beatles", 1968, 431));      
        listaCanciones.addLast(new Cancion("Purple Rain", "Prince", 1984, 520));
        listaCanciones.addLast(new Cancion("Let It Be", "The Beatles", 1970, 243));     
        System.out.println(listaCanciones);
        masAntigua = devolverCancion(listaCanciones);
        System.out.println(masAntigua);
        String artista = Helper.getStringObligatorio("Ingrese el nombre del artista que desea buscar (ej. The Beatles, Michael Jackson): ");
        DoubleLinkedList<Cancion> cancionesFiltradas = devolverCancionCouencidencias(listaCanciones, artista);
        System.out.println(cancionesFiltradas);//si no ingresa nada sale literal nada xd
        DoubleLinkedList<EstadisticaArtista> estadisticas = listaEstadisticaArtista(listaCanciones);
        //esto para que de uno por uno y no una lista asi todo junta
        for (EstadisticaArtista est : estadisticas) {
            System.out.println(est);
        }
    }
    
    public static Cancion devolverCancion(DoubleLinkedList<Cancion> listaCanciones){
        if (listaCanciones == null || listaCanciones.isEmpty()){
            return null;
        }
        
        Cancion cancionMasAntigua = null; 
        
        for(Cancion item : listaCanciones){
            if (cancionMasAntigua == null || (item.getAnioLanzamiento() < cancionMasAntigua.getAnioLanzamiento())){// cancionMasAntigua == null por que lo primero es null xd
                cancionMasAntigua = item;
            }   
        }
        return cancionMasAntigua;
    }
    
    public static DoubleLinkedList<Cancion> devolverCancionCouencidencias(DoubleLinkedList<Cancion> listaCanciones, String Artista){
        if (listaCanciones == null ||listaCanciones.isEmpty()){
            return null;
        }
        DoubleLinkedList<Cancion> aux = new DoubleLinkedList<Cancion>();//sin parametros
        for(Cancion item : listaCanciones){
            if(item.getArtista().equalsIgnoreCase(Artista)){
                aux.addLast(item);
            }
        }
        return aux;
    }
    
    public static DoubleLinkedList<EstadisticaArtista> listaEstadisticaArtista(DoubleLinkedList<Cancion> listaCanciones){
        if (listaCanciones == null ||listaCanciones.isEmpty()){
            return null;
        }
        DoubleLinkedList<EstadisticaArtista> estadisticas = new DoubleLinkedList<>();
        
        for (Cancion cancion : listaCanciones) {
            boolean encontrado = false;

            for (EstadisticaArtista estadistica : estadisticas) {//si la lista esta vacia se salta el for each
                if (estadistica.getNombreArtista().equalsIgnoreCase(cancion.getArtista())) {
                    int sumaActualizada = estadistica.getTotalReproducciones() + cancion.getDuracionegundos();
                    estadistica.setTotalReproducciones(sumaActualizada);
                    encontrado = true;
                    break; // Ya lo encontramos salimos del bucle interno
                }
            }

            if (!encontrado) {
                estadisticas.addLast(new EstadisticaArtista(cancion.getArtista(), cancion.getDuracionegundos()));
            }
        }
    //nananan no podia hacer un buble sort me marie y la ia hizo el resto bien yo lo hice mal
    int n = estadisticas.size();
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - 1 - i; j++) {
            EstadisticaArtista actual = estadisticas.getItem(j);
            EstadisticaArtista siguiente = estadisticas.getItem(j + 1);

            if (actual.getTotalReproducciones() < siguiente.getTotalReproducciones()) {
                String auxNombre = actual.getNombreArtista();
                int auxTotal = actual.getTotalReproducciones();

                actual.setNombreArtista(siguiente.getNombreArtista());
                actual.setTotalReproducciones(siguiente.getTotalReproducciones());

                siguiente.setNombreArtista(auxNombre);
                siguiente.setTotalReproducciones(auxTotal);
            }
        }
    }
    return estadisticas;
    }
}

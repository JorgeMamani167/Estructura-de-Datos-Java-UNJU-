package luka.punto5_tp5;

/**
 * @author lucas
 */
public class Punto5_tp5 {

    public static void main(String[] args) {
        DoubleLinkedList<Aspirante> lista = new DoubleLinkedList<>();
        lista.addLast(new Aspirante(1, "Lucas", "Gomez", 8, 9, 10)); // Promedio: 9.0
        lista.addLast(new Aspirante(2, "Maria", "Perez", 6, 6, 6));  // Promedio: 6.0
        lista.addLast(new Aspirante(3, "Juan", "Lopez", 7, 7, 8));   // Promedio: 7.33
        
        System.out.println("--- A) PROMEDIOS ---");
        calcularPromedio(lista);
        
        System.out.println("\n--- B) MEJOR PROMEDIO ---");
        Aspirante mejor = promedioMasAlto(lista);
        System.out.println("El mejor es: " + mejor.getNombre());
        
        System.out.println("\n--- C) APROBADOS (>= 7) ---");
        DoubleLinkedList<Aspirante> aprobados = listaPromedioAlto(lista);
        for(Aspirante a : aprobados){
            System.out.println("Aprobado: " + a.getNombre());
        }
    }
    
    public static void calcularPromedio(DoubleLinkedList<Aspirante> listaAspirantes){
        if(listaAspirantes == null || listaAspirantes.isEmpty()){
            throw new RuntimeException("Lista vacia");
        }
        for(Aspirante aspirante : listaAspirantes){
            double promedio = (aspirante.getNotaEscrito()+aspirante.getNotaOra()+aspirante.getNotaPractico())/3.0;
            System.out.println("La nota promedio del aspirante: " + aspirante.getNombre() + "es " + promedio);
        }
    }
    
    public static Aspirante promedioMasAlto(DoubleLinkedList<Aspirante> listaAspirantes){
        if(listaAspirantes == null || listaAspirantes.isEmpty()){
            throw new RuntimeException("Lista vacia");
        }
        double promedioAlto = 0;
        Aspirante aux = new Aspirante();
        for (Aspirante aspirante : listaAspirantes){
            double promedioAspirante = (aspirante.getNotaEscrito()+aspirante.getNotaOra()+aspirante.getNotaPractico())/3.0;
            if(promedioAlto<promedioAspirante){
                promedioAlto = promedioAspirante;
                aux = aspirante;
            }
        }
        
        return aux;
    }
    
    public static DoubleLinkedList<Aspirante> listaPromedioAlto(DoubleLinkedList<Aspirante> listaAspirantes){
        if(listaAspirantes == null || listaAspirantes.isEmpty()){
            throw new RuntimeException("Lista vacia");
        }
        
        DoubleLinkedList<Aspirante> mayor7 = new DoubleLinkedList<Aspirante>();
        for (Aspirante aspirante : listaAspirantes){
            double promedioAspirante = (aspirante.getNotaEscrito()+aspirante.getNotaOra()+aspirante.getNotaPractico())/3.0;
            if(promedioAspirante>=7.0){
                mayor7.addLast(aspirante);
            }
        }
        return mayor7;
    }
}

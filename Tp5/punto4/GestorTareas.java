package luka.punto4_tp5;
import java.time.LocalDate;
/**
 * @author lucas
 */

//CUANDO SE TRATA DE BORRAR SIEMPRE SE RETORNA EL ELEMENTO VORRADO Y ADEMAS PUEDE SER BOLEAN
public class GestorTareas {
    private SimpleLinkedList<Tarea> listaTareas;//constructor
    
    public GestorTareas(){//me olvide que tiene que tener el mismo nombre es un contructor predetirmanado
        this.listaTareas = new SimpleLinkedList<Tarea>();
    }
   
    public void agregarTarea(Tarea tarea){
        this.listaTareas.addLast(tarea);
    }
    
    public void completarTarea(int idTarea){
        if(this.listaTareas == null || this.listaTareas.isEmpty()){
            throw new RuntimeException("Lista vacia");
        }
        for(Tarea tarea : this.listaTareas){
            if(tarea.getIdTarea() == idTarea){
                tarea.setCompletada(true);
                System.out.println("Si se marco completa la tarea: " + idTarea);
                return;
            }
        }
        System.out.println("No se encontro");
    }
    
    public SimpleLinkedList<Tarea> tareasPorResponsable(String responsable){
        if(this.listaTareas == null || this.listaTareas.isEmpty()){
            throw new RuntimeException("Lista vacia");
        }
        SimpleLinkedList<Tarea> auxList = new SimpleLinkedList<Tarea>();
        for(Tarea tarea : this.listaTareas){
            if(tarea.getResponsable().equalsIgnoreCase(responsable)){
                auxList.addLast(tarea);
            }
        }
        return auxList;
    }
    
    public void tareasPendientes(){
        if(this.listaTareas == null || this.listaTareas.isEmpty()){
            throw new RuntimeException("Lista vacia");
        }
        for(Tarea tarea : this.listaTareas){
            if(!(tarea.isCompletada())){
                System.out.println("Esta tarea no fue completadas: " + tarea.getTitulo());
            }
        }
    }
    
    //ESTE PUNTO E ES COMPLICADO Y FACIL Y LO RESOLVERE SIN MIS METODOS 
    // RECORDAR QUE PUEDE DE VOLVER BOOLEAN PARA VER SI SE BORRO PERO EL ENUNCIADO NO LO PIDE ASI QUE OMITO ESO
    public void eliminarTarea(int idTarea){//el id viene del enunciado para resolver pero es obvio xd
        if(this.listaTareas == null || this.listaTareas.isEmpty()){
            throw new RuntimeException("Lista vacia");
        }
        //creo una lista para que sea la lista nueva si se encuentra
        //recorremos la lista y guardamos los elementos si no esta se salta y esto lo hare con un boolean
        boolean encontrado = false;
        SimpleLinkedList<Tarea> auxList = new SimpleLinkedList<Tarea>();
        for (Tarea tarea : this.listaTareas){
            if(tarea.getIdTarea() != idTarea){
                auxList.addLast(tarea);
            }else{
                encontrado = true;
            }
        }
        
        //El boolean es para imprimir si lo iliminamos y si asiganmos un puntero a listas tareas
        if(encontrado){
            this.listaTareas = auxList;
            System.out.println("Si se encontro");
        }else{
            System.out.println("No se encontro");
        }
    }
    
    public SimpleLinkedList<Tarea> tareasProximas(String responsable){
        if(this.listaTareas == null || this.listaTareas.isEmpty()){
            throw new RuntimeException("Lista vacia");
        }
        //primero buscar el responsable
        boolean encontrado = false;
        String responsableAux = "";
        for(Tarea tarea : this.listaTareas){
            if(tarea.getResponsable().equalsIgnoreCase(responsable)){
                encontrado = true;
                responsableAux = tarea.getResponsable();
                break;
            }
        }
        LocalDate hoy = LocalDate.now();
        if(encontrado){
            SimpleLinkedList<Tarea> tareasFuturas = new SimpleLinkedList<Tarea>();
            for(Tarea tarea : this.listaTareas){
                //isAfter(hoy) que es equivalente a hoy.isBefore(...), cualquiera de los dos
                if(tarea.getResponsable().equalsIgnoreCase(responsableAux) && hoy.isBefore(tarea.getFechaLimite())){
                    tareasFuturas.addLast(tarea);
                }
            }
            return tareasFuturas;
        }else{
            System.out.println("No se encontro");
            return null;
        }
    }
    public boolean isEmpty() {
        return this.listaTareas == null || this.listaTareas.isEmpty();
    }
}

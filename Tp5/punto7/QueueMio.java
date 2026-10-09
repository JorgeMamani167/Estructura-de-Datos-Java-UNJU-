package luka.punto7_tp5;

/**
 * @author lucas
 */
//aqui hay dos opciones una queue dinamica o no pero hare dinamica siento que es mas facil
public class QueueMio<ELEMENT> implements QueueInterface<ELEMENT>{
    private SimpleLinkedList<ELEMENT> data;
    private Class<?> elementClass;
    //permite pasar varios elementos individualmente, y Java los agrupa en un arreglo dentro del constructor
    private int dimencion; // Guarda la capacidad definida

    public QueueMio() {
        this.data = new SimpleLinkedList<>();
        this.elementClass = null;
        this.dimencion = -1; // Ilimitada
    }

    @SafeVarargs
    public QueueMio(int dimension, ELEMENT... items) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Dimension invalida");
        }

        this.data = new SimpleLinkedList<>();
        this.dimencion = dimension;

        if (items != null && items.length > 0) {
            if (items.length > dimension) {
                throw new IllegalArgumentException("La cola supera su capacidad");
            }
            this.elementClass = items[0].getClass();
            for (ELEMENT item : items) {
                this.data.addLast(item);
            }
        }
    }
     
    //voy a tratar de hacerlo sin mis metodos
    /*
    public boolean isEmpty(){
        return this.data.isEmpty();
    }
    */
    public boolean isEmpty(){
        return this.data.size() == 0;
    }
    
    public int size(){
        return this.data.size();
    }
    
    
    
    
    
}

package luka.punto7_tp5;

/**
 * @author lucas
 */
//aqui hay dos opciones una queue dinamica o no pero hare dinamica siento que es mas facil
public class QueueMio<ELEMENT> implements QueueInterface<ELEMENT>{//se puede agregar mas de una iterfas pero no de clase
    private SimpleLinkedList<ELEMENT> data;
    private Class<?> elementClass;//esto esta aqui por que el profe especifica que este ahi
    //permite pasar varios elementos individualmente, y Java los agrupa en un arreglo dentro del constructor
    private int dimencion; // Guarda la capacidad definida

    
    public QueueMio() {
        this.data = new SimpleLinkedList<>();
        this.elementClass = null;
        this.dimencion = 10; 
    }
    
    public QueueMio(int dimension, ELEMENT... items) {//ELEMENT... items es para que agrege en fila como un arreglo
        if (dimension <= 0) {//vemos si la dimencion es valida osea si no es menor a cero o cero
            throw new RuntimeException("Dimension invalida");
        }

        this.data = new SimpleLinkedList<>();
        this.dimencion = dimension;

        if (items != null && items.length > 0) {//vemos si item no es nulo y el array de elementos genericos no es 0
            if (items.length > dimension) {//vemos si la dimencion es menor a los elementos del array de elementos
                throw new RuntimeException("La cola supera su capacidad");
            }
            //difinimos que los elementos de la clase son igual a tipo de elemento del primer item de el array de elementos
            this.elementClass = items[0].getClass();
            //recorre los elementos del array de elementos y los agrega al final de la lista
            for (ELEMENT item : items) {
                this.data.addLast(item);
            }
        }
    }
    
    @Override
    public boolean offer(ELEMENT item){
        //verificamos que no este vacia
        if(this.data.size() >= this.dimencion){
            return false;//retorna un false por ser offer
        }
        //en la primera interacion se le asigna el tipo de elemento a elementClalss
        if(this.elementClass == null && item != null){
            this.elementClass = item.getClass();
        }
        this.data.addLast(item);//agrega element
        return true;
    }
    
    @Override
    public boolean add(ELEMENT item){
        //verificamos que no este vacia
        if(this.data.size() >= this.dimencion){
            throw new RuntimeException("Esta llena");//retorna exeption por ser add
        }
        //en la primera interacion se le asigna el tipo de elemento a elementClalss
        if(this.elementClass == null && item != null){
            this.elementClass = item.getClass();
        }
        this.data.addLast(item);//agrega element
        return true;
    }
    
    @Override
    public ELEMENT element(){
        if(this.data.isEmpty()){
            throw new RuntimeException("Esta vacia");
        }
        ELEMENT item = this.data.removeFirst();
        this.data.addFirst(item);
        return item;
    }
    
    @Override
    public ELEMENT peek(){
        if(this.data.isEmpty()){
            return null;
        }
        ELEMENT item = this.data.removeFirst();
        this.data.addFirst(item);
        return item;
    } 
    
    @Override
    public ELEMENT pool(){
        if(this.data.isEmpty()){
            return null;
        }
        ELEMENT item = this.data.removeFirst();
        return item;
    }
    
    @Override
    public ELEMENT remove(){
        if(this.data.isEmpty()){
            throw new RuntimeException("Esta vacia");
        }
        ELEMENT item = this.data.removeFirst();
        return item;
    }
    //voy a tratar de hacerlo sin mis metodos
    /*
    public boolean isEmpty(){
        return this.data.isEmpty();
    }
    */
    @Override
    public boolean isEmpty(){
        return this.data.size() == 0;
    }
    @Override
    public int size(){
        return this.data.size();
    }
    
    @Override
    public ELEMENT[] toArray(){
        int dimencionArray = this.data.size();
        ELEMENT[] arr = (ELEMENT[]) new Object[dimencionArray];//un arreblo de elementos es igual al parseo de un array de objetos
        
        for(int i = 0; i<dimencionArray; i++){
            ELEMENT item = this.data.removeFirst();
            arr[i] = item;
            this.data.addLast(item);
        }
        return arr;
    }
}

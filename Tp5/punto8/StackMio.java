package luka.punto7_tp5;

/**
 * @author lucas
 */

public class StackMio<ELEMENT> implements StackInterface<ELEMENT>{
    private DoubleLinkedList<ELEMENT> data;
    private Class<?> elementClass;
    private int dimencion;
    
    public StackMio(){
        this.data = new DoubleLinkedList<>();
        this.elementClass = null;//por que aun no sabemos que guardamos en el primer elemento
        this.dimencion = 10; //dimencion por defecto           
    }
    
    public StackMio(int dimencion, ELEMENT... items){ {//ELEMENT... items es para que agrege en fila como un arreglo
        if(dimencion <= 0){
            throw new RuntimeException("dimencion invaida");//es para ver si la dimencion es valida
        }
        this.data = new DoubleLinkedList<>();
        this.dimencion = dimencion;
        if(items != null && items.length > 0){ //vemos que no sea null y tampoco sea la dimencion 0
            if(items.length > dimencion){ //si el arreglo que entra es mayor a la dimencion que queremos hacer tira exeption
                throw new RuntimeException("La dimencion es mayor que la capacidad del arreglo");//TENGOQUE VER SI CUANDO CREAMOS EL STACK Y CARGAMOS MAS ELEMENTOS QUE SOPORTA LA DIMENCION DEBERIA LANZAR ESTA EXECEPTION en el contrcutor *
            }
            this.elementClass = items[0].getClass();//para obtener la primera clase
            //remoremos los elementos del array
            for(ELEMENT item : items){
                this.data.addLast(item);
            }
        }
    }
    }//por que hay dos llaves?
    
    @Override
    public boolean push(ELEMENT item){
        //vemos si esta vacia
        if(this.data.size() >= this.dimencion){
            throw new RuntimeException("La stack esta llena");
        }
        //si creamos un stack vacia al primer elemento agregado hay que ver si lleno
        if(this.elementClass == null && item != null){
            this.elementClass = item.getClass();
        }
        this.data.addLast(item);
        return true;
    }
    @Override
    //mejor uso isEmpty
    public ELEMENT pop(){
        if(this.data.isEmpty()){
            throw new RuntimeException("La cola esta vacia");
        }
        ELEMENT item = this.data.removeFirst();
        return item;
    }
    @Override
    public boolean isEmpty(){
        return this.data.size() == 0;
    }
    @Override
    public ELEMENT peek(){
        if(this.data.isEmpty()){
            throw new RuntimeException("La cola esta vacia");
        }
        ELEMENT item = this.data.removeLast();
        this.data.addLast(item);
        return item;
    }
    @Override
    public boolean isFull(){
        return this.dimencion >= this.data.size();
    }
    @Override
    public int size(){
        return this.data.size();
    }
    @Override
    public String toString(){
        return this.data.toString();
    }
    
    //por algo es element
    public ELEMENT element(){
        if(this.data.isEmpty()){
            throw new RuntimeException("Esta vacia");
        }
        ELEMENT item = this.data.removeFirst();
        this.data.addFirst(item);
        return item;
    }
}

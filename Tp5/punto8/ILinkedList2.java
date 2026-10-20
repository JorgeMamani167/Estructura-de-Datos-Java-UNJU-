package luka.punto8_tp5;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
// MIS CoDIGOS AGREGADOS por github: jorgemamanil167
//

// from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/LinkedList.html
public interface ILinkedList2<ELEMENT> extends Iterable<ELEMENT> {

    // Returns the number of elements in this list.
    public int size();

    // Inserts the specified element at the beginning of this list.
    public void addFirst(ELEMENT item);
    // Appends the specified element to the end of this list.
    public void addLast(ELEMENT item);
    // Removes and returns the first element from this list.
    public ELEMENT removeFirst();
    // Removes and returns the last element from this list.
    public ELEMENT removeLast();
    //MI parte
    
    //pa ver si esta vacia
    public boolean isEmpty();
    
    //ver nodo o el item
    public ELEMENT getItem(int index);
    
    //modificar un nodo
    public void setItem(int index, ELEMENT item);
}
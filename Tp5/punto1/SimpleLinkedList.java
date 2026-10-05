package luka.punto1_tp5;

import java.util.Iterator;


public class SimpleLinkedList<ELEMENT> implements ILinkedList<ELEMENT> {

    //region Node Class

    private class Node<ELEMENT> {
        public ELEMENT item;
        public Node<ELEMENT> next;

        public Node() {
            this(null, null);
        }
        public Node(ELEMENT item) {
            this(item, null);
        }
        public Node(ELEMENT item, Node<ELEMENT> next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            return this.item.toString();
        }
    }
    //endregion

    //region Attributes

    protected Node<ELEMENT> head;
    protected int count;
    protected Node<ELEMENT> tail;
    //endregion

    //region Constructors

    public SimpleLinkedList() {
        this.head = null;
        this.count = 0;
        this.tail = null;
    }
    //endregion

    //region Linked List Methods

    // Returns the number of elements in this list.
    public int size() {
        return this.count;
    }

    public void addFirstRookieVersion(ELEMENT item) {
        if (this.count == 0) {
            this.head = this.tail = new Node<ELEMENT>(item, null);
            ++this.count;
        } else {
            Node<ELEMENT> temp = new Node<ELEMENT>(item, null);
            temp.next = this.head;
            this.head = temp;
            ++this.count;
        }
    }
    // Inserts the specified element at the beginning of this list.
    public void addFirst(ELEMENT item) {
        Node<ELEMENT> temp = new Node<ELEMENT>(item, this.head);
        if (this.count == 0) {
            this.tail = temp;
        }
        this.head = temp;
        ++this.count;
    }

    public void addLastRookieVersion(ELEMENT item) {
        if (this.count == 0) {
            this.head = this.tail = new Node<ELEMENT>(item, null);
            ++this.count;
        } else {
            Node<ELEMENT> temp = new Node<ELEMENT>(item, null);
            this.tail.next = temp;
            this.tail = temp;
            ++this.count;
        }
    }
    // Appends the specified element to the end of this list.
    public void addLast(ELEMENT item) {
        Node<ELEMENT> temp = new Node<ELEMENT>(item, null);
        if (this.count == 0) {
            this.head = temp;
        } else {
            this.tail.next = temp;
        }
        this.tail = temp;
        ++this.count;
    }

    // Removes and returns the first element from this list.
    public ELEMENT removeFirst() {
        if (this.count == 0) {
            throw new RuntimeException("La lista está vacía...");
        }
        ELEMENT item = this.head.item;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        --this.count;
        return item;
    }

    // Removes and returns the last element from this list.
    public ELEMENT removeLast() {
        if (this.count == 0) {
            throw new RuntimeException("La lista está vacía...");
        }
        ELEMENT item = this.tail.item;
        if (this.head.next == null) {
            this.head = this.tail = null;
        } else {
            Node<ELEMENT> skip = this.head;
            while (skip.next.next != null) {
                skip = skip.next;
            }
            this.tail = skip;
            this.tail.next = null;
        }
        --this.count;
        return item;
    }
    //endregion

    //region Object Methods

    @Override
    public String toString() {

        if (this.size() <=0) {
            return "";
        }

        // from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/StringBuilder.html
        StringBuilder sb = new StringBuilder();

        sb.append("[" + this.head.item.toString());
        for (Node<ELEMENT> skip = this.head.next; skip != null; skip = skip.next) {
            sb.append(",\n" + skip.item.toString());
        }
        sb.append("]");

        return sb.toString();
    }
    //endregion


    //region Iterable Methods
    @Override
    public Iterator<ELEMENT> iterator() {
        return new SimpleLinkedListIterator(this.head);
    }

    private class SimpleLinkedListIterator implements Iterator<ELEMENT> {
        private Node<ELEMENT> current;

        public SimpleLinkedListIterator(Node<ELEMENT> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public ELEMENT next() {
            if (!this.hasNext()) {
                throw new RuntimeException("La lista esta vacia...");
            }
            ELEMENT item = this.current.item;
            this.current = this.current.next;
            return item;
        }
    }
    
    //endregion
    
    //mis metodos
      
    public boolean isEmpty(){
        if(this.count == 0){
            return true;
        }else{
            return false;
        }
    }
    
    public ELEMENT getItem(int index){
        if(index < 0 || index >= this.count){
            return null;
        }
        
        Node<ELEMENT> temp = this.head;
        
        for(int i = 0; i<index; i++){
            temp = temp.next;
        }
        return temp.item;
    }
    // remueve la primera ocurencia
    public boolean remove(ELEMENT item){
        if(this.count == 0){
            throw new RuntimeException("La lista esta vacia...");
        }
        Node<ELEMENT> skipPrev = null;
        Node<ELEMENT> skip = this.head;
        while(skip != null && !(skip.item.equals(item))){
            skipPrev = skip;
            skip = skip.next;
        }
        if(skip == null){
            return false;
        }
        //if(this.head.item.equals(skip.item)){
        if(skip == this.head){
            this.removeFirst();
        //}else if(this.tail.item.equals(skip.item)){
        }else if(skip == this.tail){
            this.removeLast();
        }else{
            skipPrev.next = skip.next;
            --this.count;
        }
        return true;
    }
    
    public ELEMENT removeAt(int index){
        if(index < 0 || index >= this.count){
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + index);
        }
        if(index == 0){
            return removeFirst();
        }
        if(index == this.count-1){
            return removeLast();
        }
        
        Node<ELEMENT> temp= this.head;
        Node<ELEMENT> tempPrev= null;
        
        for(int i = 0; i<index; i++){
            tempPrev = temp;
            temp = temp.next;
        }
        tempPrev.next = temp.next;
        --this.count;
        
        return temp.item;
    }
    
    public void addIndex(int index, ELEMENT item){
        if(index < 0 || index >= this.count){
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + index);
        }
        if(index == 0){
            addFirst(item);
            return;// para que no se ejecute el programa mas adelante
        }
        
        if(index == this.count){
            addLast(item);
            return;// para que no se ejecute el programa mas adelante
        }
        
        
        Node<ELEMENT> skip = this.head;
        Node<ELEMENT> skipPrev = null;
        
        for(int i = 0; i<index; i++){
            skipPrev = skip;
            skip = skip.next;
        }
        Node<ELEMENT> itemAdd = new Node<ELEMENT>(item,skip);
        skipPrev.next = itemAdd;
        ++this.count;
        
        
    }
}

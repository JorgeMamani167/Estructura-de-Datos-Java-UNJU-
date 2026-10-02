//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//
package tools;

import java.util.Iterator;

public class DoubleLinkedList<ELEMENT> implements ILinkedList<ELEMENT> {

    //region Node Class

    protected class Node<ELEMENT> {
        protected ELEMENT item;
        protected Node<ELEMENT> next;
        protected Node<ELEMENT> prev;

        protected Node() {
            this(null, null, null);
        }
        protected Node(ELEMENT item) {
            this(item, null, null);
        }
        protected Node(ELEMENT item, Node<ELEMENT> next) {
            this(item, next, null);
        }
        protected Node(ELEMENT item, Node<ELEMENT> next, Node<ELEMENT> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
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

    public DoubleLinkedList() {
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
        if (this.size() <= 0) {
            this.head = this.tail = new Node<ELEMENT>(item, null, null);
            ++this.count;
        }
        else {
            Node<ELEMENT> temp = new Node<ELEMENT>(item, null, null);
            temp.next = this.head;
            this.head.prev = temp;
            this.head = temp;
            ++this.count;
        }
    }
    // Inserts the specified element at the beginning of this list.
    public void addFirst(ELEMENT item) {
        Node<ELEMENT> temp = new Node<ELEMENT>(item, this.head, null);
        if (this.size() <= 0) {
            this.tail = temp;
        }
        else {
            this.head.prev = temp;
        }
        this.head = temp;
        ++this.count;
    }

    public void addLastRookieVersion(ELEMENT item) {
        if (this.size() <= 0) {
            this.head = this.tail = new Node<ELEMENT>(item, null, null);
            ++this.count;
        }
        else {
            Node<ELEMENT> temp = new Node<ELEMENT>(item, null, null);
            temp.prev = this.tail;
            this.tail.next = temp;
            this.tail = temp;
            ++this.count;
        }
    }
    // Appends the specified element to the end of this list.
    public void addLast(ELEMENT item) {
        Node<ELEMENT> temp = new Node<ELEMENT>(item, null, this.tail);
        if (this.size() <= 0) {
            this.head = temp;
        }
        else {
            this.tail.next = temp;
        }
        this.tail = temp;
        ++this.count;
    }

    // Removes and returns the first element from this list.
    public ELEMENT removeFirst() {
        if (this.size() <= 0) {
            throw new RuntimeException("La lista está vacía...");
        }
        ELEMENT item = this.head.item;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        else {
            this.head.prev = null;
        }
        --this.count;
        return item;
    }

    // Removes and returns the last element from this list.
    public ELEMENT removeLast() {
        if (this.size() <= 0) {
            throw new RuntimeException("La lista está vacía...");
        }
        ELEMENT item = this.tail.item;
        if (this.head.next == null) {
            this.head = this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        --this.count;
        return item;
    }
    //endregion

    //region Object Methods

    @Override
    public String toString() {

        if (this.size() <= 0) {
            return "";
        }

        // from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/StringBuilder.html
        StringBuilder sb = new StringBuilder();

        sb.append("[" + this.head.item.toString());
        for (Node<ELEMENT> skip = this.head.next; skip != null; skip = skip.next) {
            sb.append(", " + skip.item.toString());
        }
        sb.append("]");

        return sb.toString();
    }
    //endregion

    //region Iterable Methods
    @Override
    public Iterator<ELEMENT> iterator() {
        return new DoubleLinkedListIterator(this.head);
    }

    public class DoubleLinkedListIterator implements Iterator<ELEMENT> {
        private Node<ELEMENT> current;

        public DoubleLinkedListIterator(Node<ELEMENT> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public ELEMENT next() {
            if (!this.hasNext()) {
                throw new RuntimeException("La lista está vacía...");
            }
            ELEMENT item = this.current.item;
            this.current = this.current.next;
            return item;
        }
    }

    public Iterator<ELEMENT> iteratorBack() {
        return new DoubleLinkedListIteratorBack(this.tail);
    }

    public class DoubleLinkedListIteratorBack implements Iterator<ELEMENT> {
        private Node<ELEMENT> current;

        public DoubleLinkedListIteratorBack(Node<ELEMENT> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public ELEMENT next() {
            if (!this.hasNext()) {
                throw new RuntimeException("La lista está vacía...");
            }
            ELEMENT item = this.current.item;
            this.current = this.current.prev;
            return item;
        }

    }

    //endregion

}
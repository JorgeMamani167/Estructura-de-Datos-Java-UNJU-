//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//
package tools;

public class DoubleLinkedOrderedList<ELEMENT extends Comparable<ELEMENT>>
        extends DoubleLinkedList<ELEMENT> implements ILinkedOrderedList<ELEMENT> {


    //region Constructors

    public DoubleLinkedOrderedList() {
        super();
    }
    //endregion

    //region Ordered List Methods

    public void addInOrder(ELEMENT item) {
        if (this.size() == 0) {
            this.head = this.tail = new Node<ELEMENT>(item, null, null);
            ++this.count;
        }
        else {
            if (item.compareTo(this.head.item) <= 0) {
                this.addFirst(item);
            }
            else {
                if (item.compareTo(this.tail.item) > 0) {
                    this.addLast(item);
                }
                else {
                    Node<ELEMENT> skip = this.head;
                    while ((skip != null) && (item.compareTo(skip.item) > 0)) {
                        skip = skip.next;
                    }
                    if (skip == null) {
                        throw new RuntimeException("Algo está mal en el orden de los elementos de la lista...");
                    }
                    else {
                        Node<ELEMENT> temp = new Node<ELEMENT>(item, skip, skip.prev);
                        skip.prev.next = temp;
                        skip.prev = temp;
                        ++this.count;
                    }
                }
            }
        }

    }

    public boolean findAndRemove(ELEMENT item) {
        if (this.size() == 0) {
            return false;
        }

        Node<ELEMENT> skip = this.head;
        while ((skip != null) && !(item.compareTo(skip.item) == 0)) {
            skip = skip.next;
        }
        if (skip == null) {
            return false;
        }
        else {
            if (skip.prev == null) {
                this.removeFirst();
                return true;
            }
            else {
                if (skip.next == null) {
                    this.removeLast();
                    return true;
                }
                else {
                    skip.prev.next = skip.next;
                    skip.next.prev = skip.prev;
                    skip.prev = skip.next = null;
                    return true;
                }
            }
        }
    }

    //endregion

}
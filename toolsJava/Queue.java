package luka.punto4_tp4;


import java.util.Arrays;

public class Queue<ELEMENT> {

    private final static Integer defaulDimension = 10;

    private ELEMENT [] data;
    private int head;
    private int tail;
    private int count;

    public Queue() {
        this(Queue.defaulDimension);
    }
    public Queue(int dimension) {
        this.data = (ELEMENT[]) new Object[dimension];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    private int next(int pos) {
        if (++pos >= this.data.length) {
            pos = 0;
        }
        return pos;
    }

    public boolean add(ELEMENT element) {

        if (this.size() >= this.data.length) {
            throw new IllegalStateException("Cola llena ...");
        }

        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;

        return true;
    }

    public ELEMENT element() {

        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }

        return this.data[this.head];
    }

    public boolean offer(ELEMENT element) {

        if (this.size() >= this.data.length) {
            return false;
        }

        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;

        return true;
    }

    public ELEMENT peek() {
        if (this.size() <= 0) {
            return null;
        }

        return this.data[this.head];
    }

    public ELEMENT pool() {
        if (this.size() <= 0) {
            return null;
        }

        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;

        return result;
    }

    public ELEMENT remove() {
        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }

        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;

        return result;
    }

    @Override
    public String toString() {

        if (this.size() <=0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[" + this.data[this.head].toString());

        for (int cta = 1, pos = this.next(this.head); cta < this.size(); ++cta, pos = this.next(pos)) {
            sb.append(",\n" + this.data[pos].toString());
        }

        sb.append("]");
        return sb.toString();
    }

    public boolean isEmpty() {
        return this.count <= 0;
    }

    public int size() {
        return this.count;
    }

    public Object[] toArray() {
        Object[] result = new Object[this.count];
        for(int i = 0, pos = this.head, cta = this.size(); cta > 0; ++i, pos = this.next(pos), --cta) {
            result[i] = this.data[pos];
        }
        return result;
    }

    public static Queue<Object> union(Queue<?> stack1, Queue<?> stack2) {

        Queue<Object> result = new Queue<Object>(stack1.size() + stack2.size());

        for(int pos = stack1.head, cta = stack1.size(); cta > 0; pos = stack1.next(pos), --cta) {
            result.offer( stack1.data[pos] );
        }
        for(int pos = stack2.head, cta = stack2.size(); cta > 0; pos = stack2.next(pos), --cta) {
            result.offer( stack2.data[pos] );
        }

        return result;
    }

    public Queue<Object> union(Queue<?> stack2) {
        return Queue.union(this, stack2);
    }

}

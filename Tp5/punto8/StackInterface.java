package luka.punto8_tp5;

/**
 * @author lucas
 */
public interface StackInterface<ELEMENT> {
    public boolean push(ELEMENT item);
    public ELEMENT pop();
    public boolean isEmpty();
    public ELEMENT peek();
    public boolean isFull();
    public int size();
    public String toString();
}

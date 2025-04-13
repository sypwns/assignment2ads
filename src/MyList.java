public interface MyList<E> {
    void add(E element);
    void add(int index, E element);
    E get(int index);
    E remove(int index);
    boolean remove(E element);
    int size();
    boolean isEmpty();
    java.util.Iterator<E> iterator();
}

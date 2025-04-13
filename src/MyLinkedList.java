import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E> {

    private class MyNode {
        E data;
        MyNode next, prev;

        MyNode(E data) {
            this.data = data;
        }
    }

    private MyNode head, tail;
    private int size = 0;

    public void add(E element) {
        MyNode newNode = new MyNode(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        MyNode newNode = new MyNode(element);
        if (index == 0) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            if (size == 0) tail = head;
        } else if (index == size) {
            add(element);
            return;
        } else {
            MyNode current = getNode(index);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    public E get(int index) {
        return getNode(index).data;
    }

    public E remove(int index) {
        MyNode current = getNode(index);
        if (current.prev != null) current.prev.next = current.next;
        else head = current.next;

        if (current.next != null) current.next.prev = current.prev;
        else tail = current.prev;

        size--;
        return current.data;
    }

    public boolean remove(E element) {
        MyNode current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                if (current.prev != null) current.prev.next = current.next;
                else head = current.next;

                if (current.next != null) current.next.prev = current.prev;
                else tail = current.prev;

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private MyNode current = head;

            public boolean hasNext() {
                return current != null;
            }

            public E next() {
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}

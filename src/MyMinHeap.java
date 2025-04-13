public class MyMinHeap<E extends Comparable<E>> {
    private MyArrayList<E> heap = new MyArrayList<>();

    public void add(E element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    public E peek() {
        if (heap.isEmpty()) throw new RuntimeException("Heap is empty");
        return heap.get(0);
    }

    public E removeMin() {
        if (heap.isEmpty()) throw new RuntimeException("Heap is empty");
        E min = heap.get(0);
        E last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.add(0, last);
            heapifyDown(0);
        }
        return min;
    }

    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i).compareTo(heap.get(parent)) < 0) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int i) {
        int size = heap.size();
        while (i < size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0)
                smallest = left;
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0)
                smallest = right;

            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        E temp = heap.get(i);
        // Переставляем элементы (удаляем старые позиции и вставляем новые)
        heap.remove(i);
        heap.add(i, heap.get(j - (i < j ? 1 : 0))); // коридор перестановки
        heap.remove(j);
        heap.add(j, temp);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }
}

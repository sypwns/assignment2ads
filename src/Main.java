public class Main {
    public static void main(String[] args) {
        // === MyArrayList Test ===
        System.out.println("=== MyArrayList Test ===");
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println("List: " + arrayList);
        System.out.println("Size: " + arrayList.size());
        System.out.println("Element at index 1: " + arrayList.get(1));
        arrayList.remove(1);
        System.out.println("After removing index 1: " + arrayList);
        System.out.println();

        // === MyLinkedList Test ===
        System.out.println("=== MyLinkedList Test ===");
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        System.out.println("List: " + linkedList);
        System.out.println("Size: " + linkedList.size());
        System.out.println("Element at index 2: " + linkedList.get(2));
        linkedList.remove(1);
        System.out.println("After removing index 1: " + linkedList);
        System.out.println();

        // === MyStack Test ===
        System.out.println("=== MyStack Test ===");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(5);
        System.out.println("Pushed: 5");
        stack.push(10);
        System.out.println("Pushed: 10");
        System.out.println("Stack pop: " + stack.pop());
        System.out.println("Stack peek: " + stack.peek());
        System.out.println();

        // === MyQueue Test ===
        System.out.println("=== MyQueue Test ===");
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        System.out.println("Enqueued: A");
        queue.enqueue("B");
        System.out.println("Enqueued: B");
        System.out.println("Queue dequeue: " + queue.dequeue());
        System.out.println("Queue peek: " + queue.peek());
        System.out.println();

        // === MyMinHeap Test ===
        System.out.println("=== MyMinHeap Test ===");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(7);
        heap.add(3);
        heap.add(5);
        heap.add(1);
        heap.add(6);
        System.out.println("Added: 7, 3, 5, 1, 6");
        System.out.println("Min: " + heap.peek());
        System.out.println("Removed min: " + heap.removeMin());
        System.out.println("New min: " + heap.peek());
    }
}

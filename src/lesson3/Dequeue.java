package lesson3;

/**
 * Создать класс для реализации дека.
 */
public class Dequeue extends Queue{
    public Dequeue() {
        super(10);
    }

    public Dequeue(int capacity) {
        super(capacity);
    }

    public int getLast() {
        if (isEmpty()) throw new ArrayStoreException("storage is empty");
        int last = (head + --tail) % capacity;
        int elem = arr[last];
        arr[last] = 0;

        return elem;
    }

    public void putLast(int element) {
        super.put(element);
    }

    public int getFirst() {
        return super.get();
    }

    public void putFirst(int element) {
        if (isFull()) increaseCapacity();
        head = (head == 0)? arr.length - 1: --head;
        arr[head] = element;
        tail++;
    }
}
